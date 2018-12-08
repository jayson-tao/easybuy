package com.yaorange.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yaorange.consts.bis.JobTypeConsts;
import com.yaorange.query.QuartzJobInfo;
import com.yaorange.service.QuartzService;
import com.yaorange.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.consts.bis.SeckillStateConsts;
import com.yaorange.exception.BisException;
import com.yaorange.mapper.TSeckillMapper;
import com.yaorange.mapper.TSeckillSkuMapper;
import com.yaorange.mapper.TSkuMapper;
import com.yaorange.pojo.TSeckill;
import com.yaorange.pojo.TSeckillExample;
import com.yaorange.pojo.TSeckillExample.Criteria;
import com.yaorange.pojo.TSeckillSku;
import com.yaorange.pojo.TSeckillSkuExample;
import com.yaorange.pojo.TSku;
import com.yaorange.service.QiNiuService;
import com.yaorange.service.SecKillService;
import com.yaorange.util.RedisUtils;
import com.yaorange.util.StrUtils;

@Service
public class SecKillServiceImpl implements SecKillService {
    @Autowired
    private TSeckillMapper seckillMapper;
    @Autowired
    private TSeckillSkuMapper seckillSkuMapper;
    @Autowired
    private TSkuMapper skuMapper;
    @Autowired
    private QiNiuService qiNiuService;
    @Autowired
    private QuartzService quartzService;


    /**
     * 分页
     */
    @Override
    public Page<TSeckill> getSeckillPage(Integer page, Integer rows) {
        Page<TSeckill> result = new Page<>();
        TSeckillExample example = new TSeckillExample();
        PageHelper.startPage(page, rows);
        List<TSeckill> list = seckillMapper.selectByExample(example);
        PageInfo<TSeckill> pageInfo = new PageInfo<>(list);
        result.setTotal((int) pageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    /**
     * 编辑或者保存
     *
     * @param seckill
     */
    @Override
    public void saveSecKill(TSeckill seckill) {
        seckill.setUpdateTime(System.currentTimeMillis());
        // 回显之后的修改
        if (seckill.getId() != null) {
            seckillMapper.updateByPrimaryKeySelective(seckill);
        } else {
            // 保存秒杀活动
            seckill.setCreateTime(System.currentTimeMillis());
            seckill.setState(SeckillStateConsts.WAIT_PUBLSH);
            seckillMapper.insert(seckill);
        }
        // 如果是修改先删除原有的秒杀单品
        TSeckillSkuExample example = new TSeckillSkuExample();
        TSeckillSkuExample.Criteria criteria = example.createCriteria();
        criteria.andSeckillIdEqualTo(seckill.getId());
        seckillSkuMapper.deleteByExample(example);

        // 保存秒杀单品
        List<TSeckillSku> skuList = seckill.getSkuList();
        for (TSeckillSku seckillSku : skuList) {
            seckillSku.setSeckillId(seckill.getId());
            seckillSkuMapper.insert(seckillSku);
        }

    }

    /**
     * 显示秒杀活动
     * @param id
     * @param model
     */
    @Override
    public void echo(Long id, Model model) {
        TSeckill seckill = seckillMapper.selectByPrimaryKey(id);
        if (seckill.getState() != SeckillStateConsts.WAIT_PUBLSH) {
            throw BisException.me().setInfo("不允许修改已发布的活动");
        }
        model.addAttribute("seckill", seckill);
        List<TSeckillSku> seckillSkus = getSeckillSkus(id);
        StringBuffer skuDatas = new StringBuffer();
        for (TSeckillSku seckillSku : seckillSkus) {
            skuDatas.append(":::").append(seckillSku.getSkuId()).append("::").append(seckillSku.getProductId()).append("::").append(seckillSku.getSkuPic()).append("::").append(seckillSku.getSkuName())
                    .append("::").append(seckillSku.getPrice()).append("::").append(seckillSku.getTotalCount());
        }
        if (skuDatas.length() > 3) {
            model.addAttribute("skuDatas", skuDatas.substring(3));
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("beginTimeFormat", dateFormat.format(new Date(seckill.getBeginTime())));
        model.addAttribute("endTimeFormat", dateFormat.format(new Date(seckill.getEndTime())));

    }


    /**
     * 通过秒杀活动ID查找秒杀单品
     */
    public List<TSeckillSku> getSeckillSkus(long secKillId) {
        TSeckillSkuExample example = new TSeckillSkuExample();
        TSeckillSkuExample.Criteria criteria = example.createCriteria();
        criteria.andSeckillIdEqualTo(secKillId);
        return seckillSkuMapper.selectByExample(example);
    }

    /**
     * 发布秒杀活动-》
     * 1.修改sku库存
     * 2.更新秒杀活动状态
     * 3.设置抢购码 放入redis
     * 4.把抢购数量方进redis
     * 5.把秒杀活动信息方进七牛云 缓存
     * 6.为每个秒杀单品设置消息队列
     */
    @Override
    public void updateSecKill(long secKillId) {
        //通过秒杀活动ID查找秒杀单品
        List<TSeckillSku> seckillSkus = getSeckillSkus(secKillId);
        //根据sku修改库存
        for (TSeckillSku seckillSku : seckillSkus) {
            TSku sku = skuMapper.selectByPrimaryKey(seckillSku.getSkuId());
            sku.setAvailableStock(sku.getAvailableStock() - seckillSku.getTotalCount());
            sku.setFrozenStock(sku.getFrozenStock() + seckillSku.getTotalCount());
            skuMapper.updateByPrimaryKeySelective(sku);
        }
        //更新秒杀活动状态 为待开启
        TSeckill seckill = seckillMapper.selectByPrimaryKey(secKillId);
        seckill.setState(SeckillStateConsts.WAIT_BEGIN);
        seckillMapper.updateByPrimaryKeySelective(seckill);
        //第一件事情 为每一个单品创建秒杀队列
        // preHandle(secKillId);
        // //为秒杀活动生成一个抢购码
        // beginHandle(secKillId);
        //调用远程接口处理定时任务
        addJob2SecKill(secKillId,seckill);
        //把秒杀活动信息方进七牛云
        putInfoToQiniuyun();

    }

    /**
     * 使用定时任务系统处理定时任务
     * @param secKillId
     * @param seckill
     */
    public void addJob2SecKill(long secKillId,TSeckill seckill){
        //第一件事
        QuartzJobInfo preHandleInfo = new QuartzJobInfo();
        HashMap<String,Long> hashMap = new HashMap<>();
        hashMap.put("secKillId", secKillId);
        //job执行需要的参数
        preHandleInfo.setParams(hashMap);
        //job类型 用于标识是哪个任务
        preHandleInfo.setType(JobTypeConsts.SECKILL_PRE_JOB);
        //job名称
        preHandleInfo.setJobName("SECKILL_PRE_JOB_"+secKillId);
        //活动前的10秒钟
        preHandleInfo.setFireDate(new Date(seckill.getBeginTime()-1*10*1000));
        quartzService.addJob(preHandleInfo);
        //第二件事
        QuartzJobInfo beginHandleInfo = new QuartzJobInfo();
        //job执行需要的参数
        beginHandleInfo.setParams(hashMap);
        //job类型 用于标识是哪个任务
        beginHandleInfo.setType(JobTypeConsts.SECKILL_BEGIN_JOB);
        //job名称
        beginHandleInfo.setJobName("SECKILL_BEGIN_JOB"+secKillId);
        //活动前的1秒
        beginHandleInfo.setFireDate(new Date(seckill.getBeginTime()-1000));
        quartzService.addJob(beginHandleInfo);

        //删除抢购码 删除单品秒杀队列 解冻未抢单品库存
        //秒杀结束之后你要的做的事情 如果秒杀单品还有库存 要解冻库存
        QuartzJobInfo endHandleInfo = new QuartzJobInfo();
        endHandleInfo.setParams(hashMap);
        endHandleInfo.setType(JobTypeConsts.SECKILL_END_JOB);
        endHandleInfo.setJobName("SECKILL_END_JOB"+secKillId);
        //秒杀一结束就执行
        endHandleInfo.setFireDate(new Date(seckill.getEndTime()));
        quartzService.addJob(endHandleInfo);
    }


    /*	*//**
     * 第一件事情 为每一个单品创建秒杀队列
     * ：因为秒杀并发很大 创建队列  进行排队 先到先得
     *//*
	private void preHandle(long secKillId) {
		List<TSeckillSku> seckillSkus = getSeckillSkus(secKillId);
		for (TSeckillSku seckillSku : seckillSkus) {
			String queueName="seckillQueueName-"+seckillSku.getId();
			//创建一个队列
			MQBinding mqBinding = activeMQService.createMQBinding(queueName);
			mapBinding.put(queueName, mqBinding);
		}
	}

	*//**
     * 	第二件事情 给秒杀单品一个抢购码
     * 	防止黑客 在秒杀还没开始就绕过前端 去抢购
     * 	当用户抢购时 会带着这个抢购码去后台 判断是不是服务器颁发的抢购码
     *//*
	private void beginHandle(long secKillId) {
		TSeckill seckill = seckillMapper.selectByPrimaryKey(secKillId);
		//抢购码过期时间 -》
		int expireTime=(int)((seckill.getEndTime()-seckill.getBeginTime())*0.001);
		//设置抢购码在redis当中
		RedisUtils.setex("seckill-code"+secKillId, expireTime, StrUtils.getRandomString(32));
		List<TSeckillSku> seckillSkus = getSeckillSkus(secKillId);
		//把每个单品库存放到redis当中
		for (TSeckillSku seckillSku : seckillSkus) {
			Integer totalCount = seckillSku.getTotalCount();
			RedisUtils.setex("seckill-skuLeftNum-"+seckillSku.getId(), expireTime, totalCount+"");
		}
		seckill.setState(SeckillStateConsts.DOING);
		seckillMapper.updateByPrimaryKeySelective(seckill);
	}*/

    /**
     * 第三件事情 把所有秒杀活动 信息放到缓存里面
     */
    private void putInfoToQiniuyun() {
        //查询即将开始和已经开始的秒杀活动
        ArrayList<Byte> states = new ArrayList<>();
        states.add(SeckillStateConsts.WAIT_BEGIN);
        states.add(SeckillStateConsts.DOING);
        TSeckillExample example = new TSeckillExample();
        Criteria criteria = example.createCriteria();
        criteria.andStateIn(states);
        //所有的已经发布的秒杀活动
        List<TSeckill> seckills = seckillMapper.selectByExample(example);
        for (TSeckill singleSeckill : seckills) {
            List<TSeckillSku> seckillSkus = getSeckillSkus(singleSeckill.getId());
            singleSeckill.setSkuList(seckillSkus);
        }
        //第一步秒杀活动信息转换为json数据
        String secKillJson = JSONObject.toJSONString(seckills);
        //为秒杀活动信息设置一个随机数文件名
        String randomFileName = StrUtils.getRandomString(16);
        qiNiuService.uploadObject(secKillJson.getBytes(), randomFileName + ".json");

        //第二步 把随机文件名称放到secname.json的文件里面
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("secKillDetail", randomFileName);
        qiNiuService.uploadObject(JSONObject.toJSONString(hashMap).getBytes(), "jayson.json");
    }

}
