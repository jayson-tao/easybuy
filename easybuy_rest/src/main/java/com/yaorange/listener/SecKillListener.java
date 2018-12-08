package com.yaorange.listener;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.yaorange.consts.bis.SeckillResultStateConsts;
import com.yaorange.mapper.TSeckillResultMapper;
import com.yaorange.mapper.TSeckillSkuMapper;
import com.yaorange.pojo.TSeckillResult;
import com.yaorange.pojo.TSeckillSku;
import com.yaorange.util.RedisUtils;

/**
 * 秒杀消费者监听器
 */
public class SecKillListener implements MessageListener{

	@Autowired
	private TSeckillSkuMapper seckillSkuMapper;
	@Autowired
	private TSeckillResultMapper seckillResultMapper;

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage)message;
		long secKillSkuId=0;
		long ssoId=0;
		try {
			secKillSkuId=mapMessage.getLong("secKillSkuId");
			ssoId=mapMessage.getLong("ssoId");
		} catch (JMSException e) {
			e.printStackTrace();
		}

		String redisLeftNum = RedisUtils.get("seckill-skuLeftNum-" + secKillSkuId);
		if (Integer.parseInt(redisLeftNum) <= 0) {
			return;
		}
		RedisUtils.decr("seckill-skuLeftNum-" + secKillSkuId);

		TSeckillSku seckillSku = seckillSkuMapper.selectByPrimaryKey(secKillSkuId);
		// 减库存
		seckillSku.setLeftCount(seckillSku.getLeftCount() - 1);
		seckillSkuMapper.updateByPrimaryKeySelective(seckillSku);

		// 写入抢购成功结果记录
		TSeckillResult seckillResult = new TSeckillResult();
		seckillResult.setCreateTime(System.currentTimeMillis());
		seckillResult.setSeckillSkuId(secKillSkuId);
		seckillResult.setSsoId(ssoId);
		seckillResult.setTotalCount(1);
		seckillResult.setState(SeckillResultStateConsts.WAIT_CONFIRM);
		seckillResult.setLastConfirmTime(System.currentTimeMillis() + (long) 0.01 * 60 * 1000);
		seckillResultMapper.insertSelective(seckillResult);

	}

}
