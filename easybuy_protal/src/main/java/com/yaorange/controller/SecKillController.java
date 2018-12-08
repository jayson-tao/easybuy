package com.yaorange.controller;

import com.yaorange.exception.BisException;
import com.yaorange.util.RedisUtils;
import com.yaorange.util.Ret;
import com.yaorange.utils.SsoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller

public class SecKillController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @RequestMapping("/snapup")
    public String index(){
        return "snapup";
    }

    /**
     * 获取抢购码
     * @param secKillId
     * @param secKillSkuIds
     * @return
     */
    @RequestMapping("/seckill/code")
    @ResponseBody
    public Ret secKillCode(long secKillId, String secKillSkuIds) {
        Map<String, Object> retData=new HashMap<>();
        //从redis中获取抢购码
        String code = RedisUtils.get("seckill-code"+secKillId);
        String[] secKillSkuIdList = secKillSkuIds.split(" ");
        //获取商品剩余库存量
        ArrayList<Map<String, String>> remainSkus = new ArrayList<>();
        for (String secKillSkuId : secKillSkuIdList) {
            String leftNum = RedisUtils.get("seckill-skuLeftNum-"+secKillSkuId);
            if(leftNum==null){
                leftNum="0";
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("skuid", secKillSkuId);
            hashMap.put("num", leftNum);
            remainSkus.add(hashMap);
        }
        retData.put("code", code);
        retData.put("seckillId", secKillId);
        retData.put("numList", remainSkus);
        return Ret.me().setData(retData);
    }

    /**
     * 抢购
     * @param code
     * @param secKillId
     * @param secKillSkuId
     * @return
     */
    @RequestMapping("/seckill/hit")
    @ResponseBody
    public  Ret  secKillHit(String code,long secKillId,long secKillSkuId) {
        String redisCode = RedisUtils.get("seckill-code"+secKillId);
        //判断code是否相等
        if(!code.equals(redisCode)){
            throw BisException.me().setInfo("抢购还未开始或已经结束");
        }
        //获取系统当前库存剩余量
        String leftNum = RedisUtils.get("seckill-skuLeftNum-"+secKillSkuId);
        if(Integer.parseInt(leftNum)<=0){
            throw BisException.me().setInfo("商品已经被抢光了");
        }
        //消息队列
        String queueName="seckillQueueName-"+secKillSkuId;
        //发送消息
        jmsTemplate.send(queueName,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setObject("secKillSkuId", secKillSkuId);
                message.setObject("ssoId", SsoContext.getSsoId());
                return message;
            }
        });
        return Ret.me();
    }
}
