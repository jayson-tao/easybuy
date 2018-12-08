package com.yaorange.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.domain.OrderDetail;
import com.yaorange.consts.ConstUtils;
import com.yaorange.consts.ICodes;
import com.yaorange.consts.bis.OrderStateConsts;
import com.yaorange.consts.bis.PayBillBusinessTypeConsts;
import com.yaorange.exception.BisException;
import com.yaorange.mapper.TOrderAddressMapper;
import com.yaorange.mapper.TOrderDetailMapper;
import com.yaorange.mapper.TOrderMapper;
import com.yaorange.pojo.TOrder;
import com.yaorange.pojo.TOrderAddress;
import com.yaorange.pojo.TOrderAddressExample;
import com.yaorange.pojo.TOrderDetail;
import com.yaorange.pojo.TOrderDetailExample;
import com.yaorange.pojo.TOrderExample;
import com.yaorange.pojo.TOrderExample.Criteria;
import com.yaorange.query.OrderQuery;
import com.yaorange.service.OrderService;
import com.yaorange.util.Page;
import com.yaorange.util.Ret;
import com.yaorange.util.StrUtils;
import com.yaorange.utils.SsoContext;

/**
 * 交易中心
 *
 *
 */
@Controller
@RequestMapping("/trade")
public class TradeController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private TOrderMapper orderMapper;
	@Autowired
	private TOrderDetailMapper orderDetailMapper;
	@Autowired
	private TOrderAddressMapper orderAddressMapper;


	@RequestMapping("/{page}")
	public String collect(@PathVariable String page) {
		// TODO 我的收藏页面
		return "trade/"+page;
	}
	/**
	 * 商品订单详细信息页面
	 */
	@RequestMapping("/order/info/product/{id}")
	public String productOrderDetail(@PathVariable(value = "id") Long id, Model model) {
		TOrder order = orderMapper.selectByPrimaryKey(id);
		TOrderAddressExample example = new TOrderAddressExample();
		TOrderAddressExample.Criteria criteria = example.createCriteria();
		criteria.andOrderIdEqualTo(id);
		List<TOrderAddress> addresses = orderAddressMapper.selectByExample(example);
		if (addresses.size() > 0) {
			TOrderAddress address = addresses.get(0);
			order.setOrderAddress(address);
		}
		Map<String, Object> orderTradeStatus = new HashMap<>();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		orderTradeStatus.put("createTime", format.format(new Date(order.getCreateTime())));
		if (order.getState() == OrderStateConsts.WAIT_PAY) {
			orderTradeStatus.put("lastPayTime", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(order.getLastPayTime())));
		}
		if (order.getState() == OrderStateConsts.WAIT_SHIP_TAKE) {
			orderTradeStatus.put("lastConfirmTime", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date(order.getLastConfirmShipTime())));
		}
		if (order.getPayTime() != null) {
			orderTradeStatus.put("payTime", format.format(new Date(order.getPayTime())));
		}
		if (order.getShipSendTime() != null) {
			orderTradeStatus.put("shipSendTime", format.format(new Date(order.getShipSendTime())));
		}
		if (order.getFinishedTime() != null) {
			orderTradeStatus.put("finishedTime", format.format(new Date(order.getFinishedTime())));
		}
		if (order.getCommentTime() != null) {
			orderTradeStatus.put("commentTime", format.format(new Date(order.getCommentTime())));
		}

		model.addAttribute("order", order);
		model.addAttribute("orderTradeStatus", orderTradeStatus);
		return "trade/order.detail";
	}

	/**
	 * 我的订单
	 *
	 * @return
	 */
	@RequestMapping("/order")
	public String order() {
		return "trade/order";
	}

	/**
	 * 我的订单 - 订单列表数据
	 *
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping("/order/list")
	public String orderList(Model model, OrderQuery query) {
		// 计算各个状态订单的数量
		Map<String, Integer> allKindsOfNum = orderService.allKindsOfNum(SsoContext.getSsoId());
		model.addAttribute("allKindsOfNum", JSONObject.toJSONString(allKindsOfNum));

		// 分页查询订单
		TOrderExample example = new TOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andSsoIdEqualTo(SsoContext.getSsoId());
		if(query.getState()==-1){
			criteria.andStateNotEqualTo(query.getState());
		}else{
			criteria.andStateEqualTo(query.getState());
		}
		example.setOrderByClause("update_time desc");
		List<TOrder> rows = orderMapper.selectByExample(example);
		int total = orderMapper.countByExample(example);
		Page<TOrder> page = new Page<>(rows, total, query);

		Map<String, Object> orderStatus = new HashMap<>();
		for (TOrder order : rows) {
			Byte state = order.getState();
			// 订单中文状态
			String stateName = ConstUtils.getBisConstName(OrderStateConsts.class, state.intValue());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			orderStatus.put("date" + order.getId(), dateFormat.format(new Date(order.getCreateTime())));
			orderStatus.put("stateName" + order.getId(), stateName);
			if (order.getState() == OrderStateConsts.WAIT_PAY) {
				// 05/15/2018 16:40:24
				dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				long lastPayTime = order.getLastPayTime();
				Date date = new Date(lastPayTime);
				String dateFormatText = dateFormat.format(date);
				orderStatus.put("payDate" + order.getId(), dateFormatText);
			}
			if (order.getState() == OrderStateConsts.WAIT_SHIP_TAKE) {
				dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				long lastConfirmDate = order.getLastConfirmShipTime();
				Date date = new Date(lastConfirmDate);
				String dateFormatText = dateFormat.format(date);
				orderStatus.put("lastConfirmDate" + order.getId(), dateFormatText);
			}
			// 订单详细信息
			TOrderDetailExample detaliExample = new TOrderDetailExample();
			TOrderDetailExample.Criteria detaliCriteria = detaliExample.createCriteria();
			detaliCriteria.andOrderIdEqualTo(order.getId());
			List<TOrderDetail> detailList = orderDetailMapper.selectByExample(detaliExample);
			for (TOrderDetail orderDetail : detailList) {
				orderDetail.setSkuProperties(StrUtils.changePropertyStyle(orderDetail.getSkuProperties()));
			}
			order.setDetailList(detailList);
		}
		model.addAttribute("page", page);
		model.addAttribute("orderStatus", orderStatus);
		return "trade/order.list";
	}

	//删除订单
	@RequestMapping("/order/delete")
	@ResponseBody
	public Ret orderDelete(String orderId) {
		Long[] orderIds = StrUtils.splitToLong(orderId);
		List<Long> ids = Arrays.asList(orderIds);
		TOrderExample example = new TOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		criteria.andSsoIdEqualTo(SsoContext.getSsoId());
		TOrder order = new TOrder();
		order.setState(OrderStateConsts.DELETED);
		orderMapper.updateByExampleSelective(order,example);
		return Ret.me();
	}

	//确认收货
	@RequestMapping("/order/confirmShip")
	@ResponseBody
	public Ret confirmShip(Long orderId) {
		// TODO
		// userCenterService.orderConfirmFinish(SsoContext.getSsoId(), orderId);
		return Ret.me();
	}


	//统一订单信息跳转接口  bn业务信息  业务类型-业务键
	@RequestMapping("/order/info/{bn}")
	public String tradeOrder(@PathVariable(value="bn") String bn){
		if(StringUtils.isBlank(bn)){
			throw BisException.me().setCode(ICodes.ILLEGAL_ACCESS);
		}
		String[] bnArr = bn.split("-");
		byte bisType = Byte.parseByte(bnArr[0]);
		Long bisId = Long.parseLong(bnArr[1]);

		String url = "redirect:/";
		switch (bisType) {
			case PayBillBusinessTypeConsts.ORDER_WAIT_PAY:
				url = "redirect:/trade/order/info/product/"+bisId;
				break;
			case PayBillBusinessTypeConsts.ORDER_RECHARGE:
				//TODO .set url
				break;
			case PayBillBusinessTypeConsts.ORDER_REFUND:
				//TODO .set url
				break;

			default:
				break;
		}

		return url;
	}
}
