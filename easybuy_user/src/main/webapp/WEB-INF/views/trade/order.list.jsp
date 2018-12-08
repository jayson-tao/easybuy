<%@page import="com.yaorange.consts.bis.OrderStateConsts"%>
<%@page import="com.yaorange.consts.bis.PayChannelConsts"%>
<%@page import="com.yaorange.consts.ConstUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="order" items="${page.rows}">
<!-- 订单 -->
<div class="trade-order">
	<table class="trade-order-goods">
		<colgroup>
<col style="width: 36%;">
<col style="width: 10%;">
<col style="width: 5%;">
<col style="width: 10%;">
<col style="width: 15%;">
<col style="width: 11%;">
<col style="width: 13%;">
</colgroup>
<tbody>
	<tr class="trade-order-info">
		<td colspan="2">
			<label>
				<input type="checkbox" name="order_delete" value="${order.id}" class="table-list-checkbox">
				<span style="">${extMap['date'.concat(order.id)]}</span>
			</label>
			<span>订单号：</span>
			<span><a href="/trade/order/info/product/${order.id}">${order.orderSn}</a></span>
		</td>
		<td colspan="4">
			<span class="shop-logo">
				<img src="/static/img/shop-icon2.png">
			</span>
			<a href="javascript:;" title="易购物官方自营二号店" class="shop-name">易购物官方自营二号店</a>
			<a href="javascript:;" class="ww-light service-btn" data-shop_id="6">
				<img src="/static/img/test/openim.png" width="20" height="20" border="0" alt="在线客服">
			</a>
		</td>
		<td class="order-recycle-bin">
			<c:if test="${order.state==3 or order.state==5}">
			<!-- 订单关闭、完成状态有效-->
			<a onclick="order_delete(${order.id},1)">
				<i></i>
				<span>删除</span>
			</a>
			<!-- 订单关闭、完成状态有效-->
			</c:if>
		</td>
</tr>
<c:forEach var="sku" items="${order.detailList}" varStatus="st">
<tr>
	<td class="goods-info">
		<div style="overflow: hidden;">
			<a class="goods-img" href="http://macbook:8081/p/${sku.productId}?skuId=${sku.skuId}" target="_blank">
				<img src="http://p9j37xm9a.bkt.clouddn.com/${sku.skuMainPic}?imageView2/1/w/80/h/80">
			</a>
			<div class="item-con">
				<div class="item-name">
					<a href="http://macbook:8081/p/${sku.productId}?skuId=${sku.skuId}" target="_blank">
						<span>${sku.name}</span>
					</a>
				</div>
				<div class="item-props">
					<span class="sku">
					${sku.skuProperties}
					</span>
				</div>
				<div class="item-icons"></div>
			</div>
		</div>
	</td>
	<td class="goods-price">
		<p class="del">${sku.marketPrice * 0.01}</p>
		<p class="second-color">${sku.price * 0.01 }</p>
	</td>
	<td class="goods-num">${sku.amount}</td>
	<td class="goods-operate"></td>
	
	<c:if test="${st.index==0}">
	<!-- 第一行输出订单整体信息和操作信息 -->
	<td class="goods-payment" rowspan="${order.detailList.size()}">
		<p> 总金额： <b>￥${order.realMoney * 0.01}</b> </p>
		<p> 待付款： <strong class="second-color">￥${order.realMoney * 0.01}</strong> </p>
		<p> <span>(免邮)</span> </p>
		<p> <a class="phone-order">PC端</a> </p>
		<p> <span>
		<br>
		<img src="/static/img/pay/${order.payChannel}.png" height="25"/>
		</span> </p>
	</td>
	<td class="trading-status" rowspan="${order.detailList.size()}">
		<div class="operate"> <a>
		${extMap["stateName".concat(order.id)]}
		</a> </div>
		<div class="operate">
			<a href="/trade/order/info/product/${order.id}">订单详情</a>
		</div>
	</td>
	<td class="trading-operate" rowspan="${order.detailList.size()}">
		<c:if test="${order.state == 0}">
		<!-- 待付款状态输出 - 倒计时、立即付款、取消订单-->
		<div class="operate">
			<p class="confirm-receipt-time">
				还剩 <span id="counter_${order.id}"></span>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#counter_${order.id}").countdown({
							date: "${extMap['payDate'.concat(order.id)]}",
							onChange: function(event, timer) {},
							onComplete: function(event) {
								$(this).html("已超时！");
								location.href = '/trade/order';
							},
							leadingZero: true
						});
					});
				</script>
			</p>
			<a href="http://macbook/gateway?bn=0-${order.id}" target="_blank" class="on-payment">立即付款</a>
		</div>
		<div class="operate">
			<a class="cancel-payment edit-order" data-id="${order.id}" data-type="cancel">取消订单</a>
		</div>
		</c:if>
		
		<!-- 待发货/取消申请状态输出 - 取消订单-->
		<c:if test="${order.state == 1 || 4==order.state}">
		<c:if test="${order.state == 1}">
		<div class="operate">
			<a class="cancel-payment edit-order" data-id="${order.id}" data-type="cancel">取消订单</a>
		</div>
		</c:if>
		<c:if test="${order.state == 4}">
		<div class="operate">
			<a>取消中</a>
		</div>
		</c:if>
		</c:if>
		
		<!-- 待收货状态输出 - 物流跟踪\确认收货-->
		<c:if test="${order.state == 2}">
		
		<div class="operate">
		<p class="confirm-receipt-time">
				还剩 <span id="counter_${order.id}"></span>
				<script type="text/javascript">
					$(document).ready(function() {
						$("#counter_${order.id}").countdown({
							date: "${extMap['lastConfirmDate'.concat(order.id)]}",
							onChange: function(event, timer) {},
							onComplete: function(event) {
								$(this).html("已超时！");
								location.href = '/trade/order';
							},
							leadingZero: true
						});
					});
				</script>
			</p>
			<a class="edit-order" data-id="${order.id}" data-type="confirmShip">确认收货</a>
		</div>
		<div class="operate">
			<a class="edit-order" data-id="${order.id}" data-type="shipQuery">物流跟踪</a>
		</div>
		</c:if>
		
		<!-- 已完成输出 - 退/换货 评价（已评价/评价）-->
		<c:if test="${order.state == 3}">
			<c:if test="${order.saleReturnState==0}">
				<div class="operate">
					<a class="edit-order" data-id="${order.id}" data-type="refund">退换货</a>
				</div>
				<c:if test="${order.commentStatus==0}">
				<div class="operate">
					<a class="edit-order" data-id="${order.id}" data-type="comment">评价</a>
				</div>
				</c:if>
				<c:if test="${order.commentStatus==1}">
				<div class="operate">
					<a href="/trade/comment">查看评价</a>
				</div>
				</c:if>
			</c:if>
			<c:if test="${order.saleReturnState!=0}">
				<div class="operate">
					<a href="/trade/refund">查看退/换货订单</a>
				</div>
			</c:if>
		</c:if>
		
		<!-- 交易关闭 输出 无 -->
		<c:if test="${order.state == 5}"></c:if>
		
	</td>
	<!-- 第一行输出订单整体信息和操作信息 -->
	</c:if>
	
</tr>
</c:forEach>
		</tbody>
	</table>
</div>
<!-- end 订单 -->
</c:forEach>
<!--分页-->
<div class="orderPage"></div>

<script>
var staOrderJson = $.parseJSON('${staJson}');
//allCount, waitPay, waitSend, waitTake, waitComment
$('.user-status').find('#sa').find('em').text(staOrderJson.allCount);
$('.user-status').find('#sc').find('em').text(staOrderJson.waitComment);
$('.user-status').find('#s0').find('em').text(staOrderJson.waitPay);
$('.user-status').find('#s1').find('em').text(staOrderJson.waitSend);
$('.user-status').find('#s2').find('em').text(staOrderJson.waitTake);

//分页
var pageParams = {
	curPage: ${page.curPage},
	total : ${page.total},
	pageSize : ${page.pageSize},
	go : function(page){
		$('#searchForm').find('input[name=page]').val(page);
		$('#searchForm').submit();
	}
};
myPagination('.orderPage',pageParams);
</script>