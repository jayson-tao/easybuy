package com.yaorange.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yaorange.consts.ConstUtils;
import com.yaorange.consts.bis.AccountFlowConsts;
import com.yaorange.consts.bis.OrderStateConsts;
import com.yaorange.consts.bis.PayBillBusinessTypeConsts;
import com.yaorange.consts.bis.PayChannelConsts;
import com.yaorange.consts.bis.PayInteractionStateConsts;
import com.yaorange.consts.bis.PayStateConsts;
import com.yaorange.exception.BisException;
import com.yaorange.mapper.TOrderMapper;
import com.yaorange.mapper.TPayAccountFlowMapper;
import com.yaorange.mapper.TPayAccountMapper;
import com.yaorange.mapper.TPayBillMapper;
import com.yaorange.mapper.TPayInteractionMapper;
import com.yaorange.pojo.TOrder;
import com.yaorange.pojo.TPayAccount;
import com.yaorange.pojo.TPayAccountExample;
import com.yaorange.pojo.TPayAccountFlow;
import com.yaorange.pojo.TPayBill;
import com.yaorange.pojo.TPayBillExample;
import com.yaorange.pojo.TPayBillExample.Criteria;
import com.yaorange.pojo.TPayInteraction;
import com.yaorange.pojo.TPayInteractionExample;
import com.yaorange.service.OrderService;
import com.yaorange.service.PayService;

@Service
public class PayServiceImpl implements PayService {
	@Autowired
	private TPayBillMapper payBillMapper;
	@Autowired
	private OrderService orderService;
	@Autowired
	private TOrderMapper orderMapper;
	@Autowired
	private TPayInteractionMapper payInteractionMapper;
	@Autowired
	private TPayAccountMapper payAccountMapper;
	@Autowired
	private TPayAccountFlowMapper payAccountFlowMapper;

	/**
	 * 根据支付单号查询支付单信息
	 * @param sn
	 * @return
	 */
	@Override
	public TPayBill queryPayBillBySn(String sn) {
		TPayBillExample example = new TPayBillExample();
		Criteria criteria = example.createCriteria();
		criteria.andUnionPaySnEqualTo(sn);
		List<TPayBill> list = payBillMapper.selectByExample(example);
		TPayBill payBill = null;
		if (list.size() > 0) {
			payBill = list.get(0);
		}
		return payBill;
	}

	/**
	 * 修改支付单的状态
	 * @param sn 支付单号
	 * @param totalAmount 用户付款金额
	 * @param tradeNo 支付宝生成的流水号
	 * @param params
	 */
	@Override
	public TPayBill changePayBillStatus(String sn, String totalAmount, String tradeNo, Map<String, String> params) {
		TPayBill payBill = queryPayBillBySn(sn);
		BigDecimal aliMoney = new BigDecimal(totalAmount).multiply(new BigDecimal(100));
		// 为了异步调用的时候反复的调用
		if (payBill.getState() != PayStateConsts.WAIT_PAY) {
			return payBill;
		}

		// 如果用户付款金额和结算金额不一致 支付失败
		if (payBill.getMoney() != aliMoney.intValue()) {
			throw BisException.me();
		}
		// 如果第三方支付 主要是存储支付宝返回给网站的信息
		if (payBill.getPayChannel() != PayChannelConsts.ACCOUNT) {
			TPayInteractionExample example = new TPayInteractionExample();
			TPayInteractionExample.Criteria criteria = example.createCriteria();
			criteria.andPayBillIdEqualTo(payBill.getId());
			//根据支付单号查询支付明细信息
			List<TPayInteraction> list = payInteractionMapper.selectByExample(example);
			TPayInteraction payInteraction ;
			if (list.size() == 0) {
				orderService.savePayInteraction(payBill);
			} else {
				payInteraction = list.get(0);
				payInteraction.setNotifyTime(System.currentTimeMillis());
				payInteraction.setReactionData(JSONObject.toJSONString(params));
				payInteraction.setReturnMoney(payBill.getMoney());
				payInteraction.setReturnSeq(tradeNo);
				payInteraction.setState(PayInteractionStateConsts.NOTIFIED);
				payInteraction.setUpdateTime(System.currentTimeMillis());
				payInteractionMapper.updateByPrimaryKeySelective(payInteraction);
			}
		}
		// 记录支付流水
		createPayAccountFlow(payBill);
		//修改支付单状态为已支付
		payBill.setState(PayStateConsts.PAYED);
		payBill.setUpdateTime(System.currentTimeMillis());
		payBillMapper.updateByPrimaryKeySelective(payBill);
		return payBill;

	}

	/**
	 * 通过支付单创建支付流水 记录 进行记录 为了防止扯皮 了解一下
	 */
	public TPayAccountFlow createPayAccountFlow(TPayBill payBill) {
		TPayAccountExample example = new TPayAccountExample();
		TPayAccountExample.Criteria criteria = example.createCriteria();
		criteria.andSsoIdEqualTo(payBill.getSsoId());
		List<TPayAccount> list = payAccountMapper.selectByExample(example);
		TPayAccount payAccount = new TPayAccount();
		if (list.size() > 0) {
			payAccount = list.get(0);
		}
		TPayAccountFlow accountFlow = new TPayAccountFlow();
		accountFlow.setCreateTime(System.currentTimeMillis());
		accountFlow.setSsoId(payBill.getSsoId());
		accountFlow.setNickName("");
		accountFlow.setMoney(payBill.getMoney());
		// 自己的账户 退款肯定就是收入
		if (payBill.getBusinessType() == PayBillBusinessTypeConsts.ORDER_REFUND || payBill.getBusinessType() == PayBillBusinessTypeConsts.ORDER_CANCEL) {
			accountFlow.setType(AccountFlowConsts.INCOME);
		} else {
			accountFlow.setType(AccountFlowConsts.OUTCOME);
		}
		accountFlow.setBusinessName(ConstUtils.getBisConstName(PayBillBusinessTypeConsts.class, payBill.getBusinessType()));
		accountFlow.setPayChannel(payBill.getPayChannel());
		accountFlow.setPayChannelName(ConstUtils.getBisConstName(PayChannelConsts.class, accountFlow.getPayChannel()));
		accountFlow.setNote(payBill.getNote());
		accountFlow.setDigest(payBill.getDigest());
		accountFlow.setUnionPaySeq(payBill.getUnionPaySn());
		accountFlow.setBusinessType(payBill.getBusinessType());
		accountFlow.setBusinessKey(payBill.getBusinessKey());

		accountFlow.setAvilableBalance(payAccount.getUseableBalance());
		accountFlow.setFrozenBalance(payAccount.getFrozenBalance());
		payAccountFlowMapper.insert(accountFlow);
		return accountFlow;
	}

	/**
	 * 修改订单状态
	 * @param payBill
	 */
	@Override
	public void changeOrderState(TPayBill payBill) {
		// 修改订单状态
		Long orderId = payBill.getBusinessKey();
		TOrder order = orderMapper.selectByPrimaryKey(orderId);
		// 之前已经修改了订单状态
		if (order.getState() != OrderStateConsts.WAIT_PAY) {
			return;
		}
		order.setState(OrderStateConsts.WAIT_SHIP_SEND);
		order.setPayMoney(payBill.getMoney());
		order.setUpdateTime(System.currentTimeMillis());
		orderMapper.updateByPrimaryKeySelective(order);
	}

	/**
	 * 通过订单id查询支付单信息
	 * @param orderId
	 * @return
	 */
	@Override
	public TPayBill queryPayBillByOrderId(long orderId){
		TPayBillExample example = new TPayBillExample();
		Criteria criteria = example.createCriteria();
		criteria.andBusinessKeyEqualTo(orderId);
		List<TPayBill> list = payBillMapper.selectByExample(example);
		TPayBill payBill = new TPayBill();
		if (list.size() > 0) {
			payBill = list.get(0);
		}
		return payBill;

	}

}
