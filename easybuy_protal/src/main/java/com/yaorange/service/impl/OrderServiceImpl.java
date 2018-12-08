package com.yaorange.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yaorange.pojo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.yaorange.consts.bis.BooleanConsts;
import com.yaorange.consts.bis.OrderStateConsts;
import com.yaorange.consts.bis.PayBillBusinessTypeConsts;
import com.yaorange.consts.bis.PayChannelConsts;
import com.yaorange.consts.bis.PayInteractionStateConsts;
import com.yaorange.consts.bis.PayStateConsts;
import com.yaorange.consts.msg.MsgConst;
import com.yaorange.mapper.TOrderAddressMapper;
import com.yaorange.mapper.TOrderDetailMapper;
import com.yaorange.mapper.TOrderMapper;
import com.yaorange.mapper.TPayBillMapper;
import com.yaorange.mapper.TPayInteractionMapper;
import com.yaorange.mapper.TVipAddressMapper;
import com.yaorange.mapper.TVipCartMapper;
import com.yaorange.service.CartService;
import com.yaorange.service.OrderService;
import com.yaorange.util.CodeGenerateUtils;
import com.yaorange.util.Ret;
import com.yaorange.utils.SsoContext;

import javax.jms.*;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private CartService cartService;
	//支付截止时间
	@Value("${SYSTEM_PAYTIME_LIMIT_HOURS}")
	private String SYSTEM_PAYTIME_LIMIT_HOURS;

	@Autowired
	private TOrderMapper orderMapper;
	@Autowired
	private TVipAddressMapper addressMapper;
	@Autowired
	private TOrderAddressMapper orderAddressMapper;
	@Autowired
	private TOrderDetailMapper orderDetailMapper;
	@Autowired
	private TVipCartMapper cartMapper;
	@Autowired
	private TPayBillMapper payBillMapper;
	@Autowired
	private TPayInteractionMapper payInteractionMapper;
	//Spring提供的JMS工具类，它可以进行消息发送、接收等
	@Autowired
	private JmsTemplate jmsTemplate;
	//取消订单队列
	@Autowired
	private Destination cancelOrderQueue;

	/**
	 *订单id
	 * @param orderId
	 */
	@Override
	public Ret cancel(long orderId) {
		jmsTemplate.send(cancelOrderQueue, new MessageCreator() {
			//发送给取消订单消息队列
			@Override
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				message.setLong("orderId", orderId);
				return message;
			}
		});
		//修改当前订单状态为正在申请取消
		TOrder order = orderMapper.selectByPrimaryKey(orderId);
		order.setState(OrderStateConsts.CANCEL_APPLY);
		orderMapper.updateByPrimaryKeySelective(order);
		return Ret.me();
	}

	/**
	 * 我的订单的数据
	 * @param ssoId
	 * @return
	 */
	@Override
	public Map<String, Integer> allKindsOfNum(long ssoId) {
		TOrderExample allExample = new TOrderExample();
		com.yaorange.pojo.TOrderExample.Criteria allCriteria = allExample.createCriteria();
		allCriteria.andSsoIdEqualTo(ssoId);
		allCriteria.andStateNotEqualTo(OrderStateConsts.DELETED);
		int allNum = orderMapper.countByExample(allExample);

		TOrderExample waitPay = new TOrderExample();
		com.yaorange.pojo.TOrderExample.Criteria waitPayCriteria = waitPay.createCriteria();
		waitPayCriteria.andSsoIdEqualTo(ssoId);
		waitPayCriteria.andStateNotEqualTo(OrderStateConsts.DELETED);
		waitPayCriteria.andStateEqualTo(OrderStateConsts.WAIT_PAY);
		int waitPayNum = orderMapper.countByExample(waitPay);

		TOrderExample waitShip = new TOrderExample();
		com.yaorange.pojo.TOrderExample.Criteria waitShipCriteria = waitShip.createCriteria();
		waitShipCriteria.andSsoIdEqualTo(ssoId);
		waitShipCriteria.andStateNotEqualTo(OrderStateConsts.DELETED);
		waitShipCriteria.andStateEqualTo(OrderStateConsts.WAIT_SHIP_SEND);
		int waitShipNum = orderMapper.countByExample(waitShip);

		TOrderExample waitTake = new TOrderExample();
		com.yaorange.pojo.TOrderExample.Criteria waitTakeCriteria = waitTake.createCriteria();
		waitTakeCriteria.andSsoIdEqualTo(ssoId);
		waitTakeCriteria.andStateNotEqualTo(OrderStateConsts.DELETED);
		waitTakeCriteria.andStateEqualTo(OrderStateConsts.WAIT_SHIP_TAKE);
		int waitTakeNum = orderMapper.countByExample(waitTake);

		TOrderExample waitComment = new TOrderExample();
		com.yaorange.pojo.TOrderExample.Criteria waitCommentCriteria = waitComment.createCriteria();
		waitCommentCriteria.andSsoIdEqualTo(ssoId);
		waitCommentCriteria.andStateEqualTo(OrderStateConsts.FINISHED);
		waitCommentCriteria.andCommentStatusEqualTo((byte) 0);
		int waitCommentNum = orderMapper.countByExample(waitComment);

		Map<String, Integer> map = new HashMap<>();
		map.put("allCount", allNum);
		map.put("waitPay", waitPayNum);
		map.put("waitSend", waitShipNum);// 还差一个取消的
		map.put("waitTake", waitTakeNum);
		map.put("waitComment", waitCommentNum);
		return map;
	}


	@Override
	public void orderConfirm(Model model) {
		// 送货清单->购买的商品
		Map<String, Object> selectedProduct = cartService.selectedSku();
		model.addAttribute("selectedCartInfo", selectedProduct);
	}


	/**
	 * 创建订单
	 * @param formOrder
	 * @param addressId
	 * @return
	 */
	@Override
	public Ret createOrder(TOrder formOrder, long addressId) {
		//查询购物车商品
		List<TVipCart> vipCarts = cartService.queryVipCarts();
		int totalMoney = 0;
		for (TVipCart vipCart : vipCarts) {
			if (vipCart.getSelected() == BooleanConsts.YES) {
				TSku sku = vipCart.getSku();
				Integer availableStock = sku.getAvailableStock();
				Integer amount = vipCart.getAmount();
				// if(availableStock==amount){
				// }
				// 库存不足
				if (availableStock < amount) {
					return Ret.me().setSuccess(false).setCode(MsgConst.ORDER_STOCK_NOT_ENOUGH);
				}
				// 减库存
				sku.setAvailableStock(availableStock - amount);
				// 锁库存
				sku.setFrozenStock(amount + sku.getFrozenStock());
				totalMoney += (sku.getPrice() * amount);
			}
		}
		// 支付截止时间
		BigDecimal hours = new BigDecimal(SYSTEM_PAYTIME_LIMIT_HOURS);
		BigDecimal millisExpire = hours.multiply(new BigDecimal("3600000"));
		long payTime = millisExpire.add(new BigDecimal(System.currentTimeMillis())).longValue();
		// 订单编号全是数字
		String orderSn = CodeGenerateUtils.generateOrderSn(SsoContext.getSsoId());
		// 实际金额 : 商品总价totalMoney + 运费carrageFee - 优惠金额discountMoney - 优惠券金额
		// couponMoney- 活动促销金额promotionMoney
		// 计算运费
		Integer carrageFee = 0;
		// 计算优惠金额（会员折扣）
		Integer discountMoney = 0;
		// 计算优惠券金额（并使用优惠券）
		Long couponId = null;
		// 优惠券金额
		Integer couponMoney = 0;
		// 计算促销活动金额（并记录参与促销活动记录）
		Long promotionId = null;
		// 活动促销金额
		Integer promotionMoney = 0;
		Integer realMoney = totalMoney + carrageFee - discountMoney - couponMoney - promotionMoney;
		// 设置订单信息
		formOrder.setSsoId(SsoContext.getSsoId());
		formOrder.setOrderSn(orderSn);
		formOrder.setStoreId(1L);
		formOrder.setStoreName("易购网官方一号店");
		formOrder.setState(OrderStateConsts.WAIT_PAY);
		formOrder.setCarriageFee(carrageFee);
		formOrder.setTotalMoney(totalMoney);
		formOrder.setDiscountMoney(String.valueOf(discountMoney));
		formOrder.setRealMoney(realMoney);
		formOrder.setPayMoney(0);// 已支付 0
		formOrder.setCouponId(couponId);
		formOrder.setCouponMoney(couponMoney);
		formOrder.setPromotionId(promotionId);
		formOrder.setPromotionMoney(promotionMoney);
		formOrder.setCommentStatus(BooleanConsts.NO);
		formOrder.setCreateTime(System.currentTimeMillis());
		formOrder.setUpdateTime(formOrder.getCreateTime());
		formOrder.setLastPayTime(payTime);
		orderMapper.insert(formOrder);

		// -----------------------------------华丽的分割线-收货地址-----------------------------------
		TVipAddress address = addressMapper.selectByPrimaryKey(addressId);
		TOrderAddress orderAddress = new TOrderAddress();
		BeanUtils.copyProperties(address, orderAddress);
		// 如果不设置要报错
		orderAddress.setId(null);
		orderAddress.setOrderId(formOrder.getId());
		orderAddress.setOrderSn(orderSn);
		orderAddressMapper.insert(orderAddress);

		// -----------------------------------华丽的分割线-订单明细-----------------------------------
		// 设置订单详情
		for (TVipCart vipCart : vipCarts) {
			if (vipCart.getSelected() == BooleanConsts.YES) {
				// 当前sku
				TSku sku = vipCart.getSku();
				TOrderDetail orderDetail = new TOrderDetail();
				orderDetail.setAmount(vipCart.getAmount());
				orderDetail.setCreateTime(System.currentTimeMillis());
				orderDetail.setMarketPrice(sku.getMarketPrice());
				orderDetail.setName(vipCart.getName());
				orderDetail.setOrderId(formOrder.getId());
				orderDetail.setPrice(sku.getPrice());
				orderDetail.setProductId(vipCart.getProductId());
				orderDetail.setSkuId(vipCart.getSkuId());
				orderDetail.setSkuMainPic(vipCart.getSkuMainPic());
				orderDetail.setSkuProperties(vipCart.getSkuProperties());
				orderDetail.setTotalMoney(vipCart.getAmount() * sku.getPrice());
				orderDetail.setUpdateTime(orderDetail.getCreateTime());
				orderDetailMapper.insertSelective(orderDetail);
			}
		}

		// 删除购物车已购买部分的数据->选中的数据
		TVipCartExample example = new TVipCartExample();
		TVipCartExample.Criteria criteria = example.createCriteria();
		criteria.andSsoIdEqualTo(formOrder.getSsoId());
		criteria.andSelectedEqualTo(BooleanConsts.YES);
		cartMapper.deleteByExample(example);
		return Ret.me().setData(formOrder);
	}

	/**
	 * 创建支付单
	 * @param order
	 * @return
	 */
	@Override
	public TPayBill createPayBillOrder(TOrder order) {
		// 创建一个新的支付单
		TPayBill payBill = new TPayBill();
		//支付单号=》要传给支付宝
		String unionPaySn = CodeGenerateUtils.generateUnionPaySn();
		payBill.setUnionPaySn(unionPaySn);
		//订单的ID号
		payBill.setBusinessKey(order.getId());
		payBill.setBusinessType(PayBillBusinessTypeConsts.ORDER_WAIT_PAY);
		payBill.setCreateTime(System.currentTimeMillis());
		payBill.setUpdateTime(System.currentTimeMillis());
		payBill.setSsoId(order.getSsoId());

		payBill.setLastPayTime(order.getLastPayTime());
		payBill.setMoney(order.getRealMoney());// 支付金额
		payBill.setNote("商品订单支付" + order.getOrderSn());
		payBill.setPayChannel(order.getPayChannel());
		//设置订单状态为待支付
		payBill.setState(PayStateConsts.WAIT_PAY);
		payBillMapper.insert(payBill);

		//如果用户采用的是第三方支付 -》记录支付明细
		if(payBill.getPayChannel()!=PayChannelConsts.ACCOUNT){
			savePayInteraction(payBill);
		}
		return payBill;

	}

	/**
	 * 支付明细 -》防止扯皮
	 * @param payBill
	 */
	public void savePayInteraction(TPayBill payBill) {
		TPayInteraction payInteraction = new TPayInteraction();
		payInteraction.setCreateTime(System.currentTimeMillis());
		payInteraction.setMoney(payBill.getMoney());
		payInteraction.setPayBillId(payBill.getId());
		payInteraction.setPayChannel(payBill.getPayChannel());
		payInteraction.setState(PayInteractionStateConsts.WAIT);
		payInteraction.setUnionPaySn(payBill.getUnionPaySn());
		payInteraction.setUpdateTime(System.currentTimeMillis());
		payInteractionMapper.insert(payInteraction);
	}


}
