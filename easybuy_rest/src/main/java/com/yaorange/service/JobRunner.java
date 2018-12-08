package com.yaorange.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yaorange.mapper.TSkuMapper;
import com.yaorange.pojo.TSku;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.alibaba.dubbo.config.annotation.Service;
import com.yaorange.consts.bis.SeckillStateConsts;
import com.yaorange.mapper.TSeckillMapper;
import com.yaorange.mapper.TSeckillSkuMapper;
import com.yaorange.pojo.TSeckill;
import com.yaorange.pojo.TSeckillSku;
import com.yaorange.pojo.TSeckillSkuExample;
import com.yaorange.service.impl.ActiveMQService;
import com.yaorange.util.RedisUtils;
import com.yaorange.util.StrUtils;
import com.yaorange.utils.MQBinding;

/**
 * 秒杀定时任务
 */
@Service
public class JobRunner {

    private static TSeckillSkuMapper seckillSkuMapper;
    private static TSeckillMapper seckillMapper;
    private static ActiveMQService activeMqService;
    private static TSkuMapper skuMapper;
    private static Logger logger = LoggerFactory.getLogger(JobRunner.class);

    @Autowired
    public  void setSkuMapper(TSkuMapper skuMapper) {
        JobRunner.skuMapper = skuMapper;
    }

    @Autowired
    public void setSeckillSkuMapper(TSeckillSkuMapper seckillSkuMapper) {
        JobRunner.seckillSkuMapper = seckillSkuMapper;
    }

    @Autowired
    public void setSeckillMapper(TSeckillMapper seckillMapper) {
        JobRunner.seckillMapper = seckillMapper;
    }

    @Autowired
    public void setActiveMqService(ActiveMQService activeMqService) {
        JobRunner.activeMqService = activeMqService;
    }

    private static Map<String, MQBinding> bindings = new HashMap<>();

    /**
     * 通过秒杀活动ID查找秒杀单品
     */
    public static List<TSeckillSku> getSeckillSkus(long secKillId) {
        TSeckillSkuExample example = new TSeckillSkuExample();
        TSeckillSkuExample.Criteria criteria = example.createCriteria();
        criteria.andSeckillIdEqualTo(secKillId);
        return seckillSkuMapper.selectByExample(example);
    }

    /**
     * 第一件事情 为每一个单品创建秒杀队列
     *
     * @param secKillId
     */
    public static void preHandle(long secKillId) {
        List<TSeckillSku> seckillSkus = getSeckillSkus(secKillId);
        for (TSeckillSku seckillSku : seckillSkus) {
            String queueName = "seckillQueueName-" + seckillSku.getId();
            MQBinding mqBinding = activeMqService.createMQBinding(queueName);
            bindings.put(queueName, mqBinding);
            logger.debug("消息队列已创建完成："+queueName);
        }
    }

    /**
     * 第二件事情 给秒杀单品一个抢购码
     */

    public static void beginHandle(long secKillId) {
        TSeckill seckill = seckillMapper.selectByPrimaryKey(secKillId);
        // 抢购码过期时间
        int expireTime = (int) ((seckill.getEndTime() - seckill.getBeginTime()) * 0.001);
        // 设置抢购码在redis当中
        RedisUtils.setex("seckill-code" + secKillId, expireTime, StrUtils.getRandomString(32));
        List<TSeckillSku> seckillSkus = getSeckillSkus(secKillId);
        // 把每个单品库存放到redis当中
        for (TSeckillSku seckillSku : seckillSkus) {
            Integer totalCount = seckillSku.getTotalCount();
            //在redis设置秒杀单品的过期时间 -》秒杀时间+2分钟
            RedisUtils.setex("seckill-skuLeftNum-" + seckillSku.getId(), expireTime + 2 * 60, totalCount + "");
        }
        seckill.setState(SeckillStateConsts.DOING);
        seckillMapper.updateByPrimaryKeySelective(seckill);
        logger.debug("抢购码已生成");
    }

    /**
     * 第三件事 秒杀活动结束 解冻秒杀单品库存 设置状态
     * 删除抢购码
     * 删除单品秒杀队列
     * 解冻未抢单品库存
     */
    public static void endHandle(Long secKillId) {
        logger.debug("活动已结束");
        TSeckill seckill = seckillMapper.selectByPrimaryKey(secKillId);
        //设置秒杀活动状态为结束
        seckill.setState(SeckillStateConsts.END);
        seckillMapper.updateByPrimaryKeySelective(seckill);
        List<TSeckillSku> seckillSkus = getSeckillSkus(secKillId);
        for (TSeckillSku seckillSku : seckillSkus) {
            //获取秒杀单品的redis库存
            String s = RedisUtils.get("seckill-skuLeftNum-" + seckillSku.getId());
            int leftNumber = Integer.parseInt(s);
            //秒杀结束还有库存就归还sku库存
            if (leftNumber > 0) {
                TSku sku = skuMapper.selectByPrimaryKey(seckillSku.getSkuId());
                sku.setAvailableStock(sku.getAvailableStock() + leftNumber);
                sku.setFrozenStock(sku.getFrozenStock() - leftNumber);
                skuMapper.updateByPrimaryKeySelective(sku);
            }
            //从redis删除
            RedisUtils.del("seckill-skuLeftNum-" + seckillSku.getId());
            //删除秒杀单品队列
            //获取单品sku队列名
            String queueName = "seckillQueueName-" + seckillSku.getId();
            activeMqService.releaseBinding(queueName);
        }
    }
}
