<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>

<!-- 正文，由view提供 -->


				<div class="con-right fr">
					<div class="con-right-text">
						<div class="tabmenu">
							<ul class="tab">
								<li class="active">订单详情</li>
							</ul>
						</div>

						<div class="content-info">
							<div class="order-step">
								<!--完成步骤为dl添加current样式，完成操作内容后会显示完成时间-->
								<dl class="<c:if test="${extMap.createTime!=null}">current</c:if> step-first">
									<dt>拍下商品</dt>
									<dd class="step-bg"></dd>
									<dd class="date" title="下单时间">${extMap.createTime}</dd>
								</dl>
								<dl class="<c:if test="${extMap.payTime!=null}">current</c:if>">
									<dt>买家付款</dt>
									<dd class="step-bg"></dd>
									<dd class="date" title="买家付款时间">${extMap.payTime}</dd>
								</dl>
								<dl class="<c:if test="${extMap.shipSendTime!=null}">current</c:if>">
									<dt>商家发货</dt>
									<dd class="step-bg"></dd>
									<dd class="date" title="商家发货时间">${extMap.shipSendTime}</dd>
								</dl>
								<dl class="<c:if test="${extMap.finishedTime!=null}">current</c:if>">
									<dt>确认收货</dt>
									<dd class="step-bg"></dd>
									<dd class="date" title="确认收货时间">${extMap.finishedTime}</dd>
								</dl>
								<dl class="<c:if test="${extMap.commentTime!=null}">current</c:if>">
									<dt>买家评价</dt>
									<dd class="step-bg"></dd>
									<dd class="date" title="完成时间">${extMap.commentTime}</dd>
								</dl>
							</div>
							<div class="trade-details">
								<table class="trade-details-table" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td class="table-td trade-imfor">
												<div class="trade-imfor-title">
													<h3>订单信息</h3>
												</div>
												<ul>
													<li class="table-list">
														<div class="trade-imfor-dt">收货地址：</div>
														<div class="trade-imfor-dd">
															<div class="address-detail">${order.orderAddress.reciver}，${order.orderAddress.phone}， ${order.orderAddress.fullAddress}</div>
														</div>
													</li>
													<li class="table-list">
														<div class="trade-imfor-dt">发票信息：</div>
														<div class="trade-imfor-dd imfor-short-dd">
															<span class="short-dd-nick">无需发票</span>
														</div>
													</li>
													<li class="table-list">
														<div class="trade-imfor-dt">买家留言：</div>
														<div class="trade-imfor-dd message-detail">
															<span class="no-content">${order.leaveword}</span>
														</div>
													</li>
													<li class="table-list">
														<div class="trade-imfor-dt">送货时间：</div>
														<div class="trade-imfor-dd message-detail">
															<span class="no-content">${order.shipTime}</span>
														</div>
													</li>
													<li class="table-list separate-top">
														<div class="trade-imfor-dt">订单编号：</div>
														<div class="trade-imfor-dd imfor-short-dd">${order.orderSn}</div>
														<div class="drop-down-container order-number">
															<span class="more-detail">更多</span>
															<div class="small-drop-down">
																<div class="drop-down-content trade-detail-list" style="display: none;">
																	<div class="list-pointer"></div>
																	<table class="trade-dropdown-table">
																		<tbody>
																			<tr>
																				<td class="trade-dropdown-title">成交时间：</td>
																				<td class="trade-dropdown-data">${extMap.createTime}</td>
																			</tr>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</li>
													<li class="table-list">
														<div class="trade-imfor-dt">支付方式：</div>
														<div class="trade-imfor-dd message-detail">
															<span class="no-content"><img src="/static/img/pay/${order.payChannel}.png" height="25"/></span>
														</div>
													</li>
													<li class="table-list">
														<div class="trade-imfor-dt">商家信息：</div>
														<div class="trade-imfor-dd imfor-short-dd">
															<span class="short-dd-nick" title="易购物官方自营二号店">
															易购物官方自营二号店
															<a class="ww-light service-btn" data-shop_id="6" href="javascript:;">
																<img src="/static/img/test/openim.png" width="20" height="20" border="0" alt="在线客服">
															</a>
															</span>
														</div>
														<div class="drop-down-container merchant-detail-panel">
															<span class="more-detail">更多</span>
															<div class="small-drop-down">
																<div class="drop-down-content trade-detail-list">
																	<div class="list-pointer"></div>
																	<table class="trade-dropdown-table">
																		<tbody>
																			<tr>
																				<td class="trade-dropdown-title">该店主未实名认证</td>
																			</tr>
																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</li>
												</ul>
											</td>
											<td class="table-td">
											<!-- 待支付 -->
											<c:if test="${order.state==0}">
												<dl class="user-status-imfor">
													<dt class="imfor-icon"><img src="/static/img/warning.png"></dt>
													<dd class="imfor-title"><h3>订单状态：商品已拍下，等待买家付款</h3></dd>
												</dl>
												<ul class="user-status-prompt">
													<li> 
														<span> 还有 <strong class="second-color" id="counter_order"></strong>来付款，超时订单将自动关闭
														</span>
													</li>
													<script type="text/javascript">
														$(document).ready(function() {
															$("#counter_order").countdown({
																date: "${extMap.lastPayTime}",
																onChange: function(event, timer) {},
																onComplete: function(event) {
																	$(this).html("已超时！");
																	location.href = '/trade/order';
																}, leadingZero: true
															});
														});
													</script>
												</ul>
												<dl class="user-status-operate">
													<dt>您可以</dt>
													<dd>
														<a href="http://macbook/gateway?bn=0-${order.id}" class="on-payment">立即付款</a>
													</dd>
													<dd>
														<a class="btn-link edit-order" data-id="${order.id}" data-type="cancel">取消订单</a>
													</dd>
												</dl>
												</c:if>
												
												<!-- 待发货 -->
												<c:if test="${order.state==1  || 4==order.state}">
													<dl class="user-status-imfor">
													<dt class="imfor-icon"><img src="/static/img/success.png"></dt>
													<c:if test="${order.state==1}">
													<dd class="imfor-title"><h3>订单状态：用户已付款，等待卖家发货</h3></dd>
													</c:if>
													<c:if test="${order.state==4}">
													<dd class="imfor-title"><h3>订单状态：用户申请取消订单，等待系统确认</h3></dd>
													</c:if>
												</dl>
												<dl class="user-status-operate">
													<dt>您可以</dt>
													<dd>
													<c:if test="${order.state==1}">
														<a class="btn-link edit-order" data-id="${order.id}" data-type="cancel">取消订单</a>
													</c:if>
													<c:if test="${order.state==4}">
														<a>取消中</a>
													</c:if>
													</dd>
												</dl>
												</c:if>
												
												<!-- 待收货 -->
												<c:if test="${order.state==2}">
													<dl class="user-status-imfor">
													<dt class="imfor-icon"><img src="/static/img/success.png"></dt>
													<dd class="imfor-title"><h3>订单状态：卖家已发货，等待买家收货</h3></dd>
												</dl>
												<ul class="user-status-prompt">
													<li> 
														<span> 还有 <strong class="second-color" id="counter_order"></strong>来确认收货，超时将自动确认收货
														</span>
													</li>
													<script type="text/javascript">
														$(document).ready(function() {
															$("#counter_order").countdown({
																date: "${extMap.lastConfirmTime}",
																onChange: function(event, timer) {},
																onComplete: function(event) {
																	$(this).html("已超时！");
																	location.href = '/trade/order';
																}, leadingZero: true
															});
														});
													</script>
												</ul>
												<dl class="user-status-operate">
													<dt>您可以</dt>
													<dd>
														<a class="btn-link edit-order" data-id="${order.id}" data-type="confirmShip">确认收货</a>
													</dd>
													<dd>
														<a class="btn-link edit-order" data-id="${order.id}" data-type="shipQuery">物流跟踪</a>
													</dd>
												</dl>
												</c:if>
												
												<!-- 已完成 -->
												<c:if test="${order.state==3}">
												<!-- 没有退换货 -->
												<c:if test="${order.saleReturnState==0}">
												<dl class="user-status-imfor">
													<dt class="imfor-icon"><img src="/static/img/success.png"></dt>
													<c:if test="${order.commentStatus==0}">
													<dd class="imfor-title"><h3>订单状态：订单完成，等待买家评价</h3></dd>
													</c:if>
													<c:if test="${order.commentStatus==1}">
													<dd class="imfor-title"><h3>订单状态：订单完成，买家已评价</h3></dd>
													</c:if>
												</dl>
												<dl class="user-status-operate">
													<dt>您可以</dt>
													<c:if test="${order.commentStatus==0}">
													<dd>
														<a class="btn-link edit-order" data-id="${order.id}" data-type="comment">评价</a>
													</dd>
													</c:if>
													<c:if test="${order.commentStatus==1}">
													<dd>
														<a class="edit-order" href="/trade/comment">查看评价</a>
													</dd>
													</c:if>
													<dd>
														<a class="btn-link edit-order" data-id="${order.id}" data-type="refund">退/换货</a>
													</dd>
												</dl>
												</c:if>
												<!-- 退换货 -->
												<c:if test="${order.saleReturnState!=0}">
												<dl class="user-status-imfor">
													<dt class="imfor-icon"><img src="/static/img/warning.png"></dt>
													<dd class="imfor-title"><h3>订单状态：买家已申请退/换货</h3></dd>
												</dl>
												<dl class="user-status-operate">
													<dt>您可以</dt>
													<dd>
														<a class="btn-link" href="/trade/refund">查看退/换货订单</a>
													</dd>
												</dl>
												</c:if>
												</c:if>
												
												<!-- 交易关闭-->
												<c:if test="${order.state==5}">
													<dl class="user-status-imfor">
													<dt class="imfor-icon"><img src="/static/img/fail.png"></dt>
													<dd class="imfor-title"><h3>订单状态：交易已关闭</h3></dd>
												</dl>
												<dl class="user-status-operate">
													<dt>您可以</dt>
													<dd>
														<a class="btn-link edit-order" data-id="${order.id}" data-type="delete">删除该订单</a>
													</dd>
												</dl>
												</c:if>
												
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="bought-listform">
								<dl class="bought-listform-header">
									<dd class="header-item">商品</dd>
									<dd class="header-price">单价（元）</dd>
									<dd class="header-count">数量</dd>
									<dd class="header-favorable">优惠（元）</dd>
									<dd class="header-status">状态</dd>
									<dd class="header-logistics">运费（元）</dd>
								</dl>
								<table class="bought-goods-list" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td class="header-content-detail">
												<ul>
													<li class="bought-listform-content">
														<div class="content-package">
															<span class="package-header"> 商品详细 </span>
														</div>
														<table cellspacing="0" cellpadding="0">
															<tbody>
																<c:forEach var="sku" items="${order.detailList}" varStatus="st">
																<tr>
																	<td class="header-item">
																		<div class="item-container clearfix">
																			<div class="item-img">
																				<a class="pic s50" href="http://macbook:8081/p/${sku.productId}?skuId=${sku.skuId}" title="查看宝贝详情" target="_blank">
																					<img src="http://p9j37xm9a.bkt.clouddn.com/${sku.skuMainPic}?imageView2/1/w/50/h/50">
																				</a>
																			</div>
																			<div class="item-meta">
																				<a class="item-link" href="http://macbook:8081/p/${sku.productId}?skuId=${sku.skuId}" title="查看宝贝详情" target="_blank">
																					${sku.name}
																				</a>

																				<span class="icon-list">
																					<span class="icon-group"></span>
																				</span>
																				<div class="item-props">
																					<span class="sku">${sku.skuProperties}</span>
																				</div>
																			</div>
																		</div>
																	</td>
																	<td class="header-price font-high-light">￥${sku.price * 0.01 }</td>
																	<td class="header-count font-high-light">${sku.amount}</td>
																	<td class="header-favorable font-high-light">
																		<div class="favorable-hight-light">￥0.00</div>
																	</td>
																	<td class="header-status font-high-light">
																		<div class="font-black">未付款</div>
																	</td>
																</tr>
																</c:forEach>
															</tbody>
														</table>
													</li>
												</ul>
											</td>
											<td class="header-content-logistics">
												<div class="font-high-light">￥${order.carriageFee * 0.01}</div>
												<div class="font-high-light">( 快递 )</div>
											</td>
										</tr>

									</tbody>
								</table>
							</div>
							<div class="order-total">
								<div class="total-count">
									<div class="total-count-pay">
					                    <div class="count-title-pay">实付款：</div>
					                    <div class="total-count-num color">
					                        <strong>￥${order.payMoney * 0.01 }</strong>
					                    </div>
                                    </div>
									<div class="total-count-pay">
										<div class="total-count-pay-info">
											<span class="first">订单总额：￥${order.totalMoney * 0.01 }</span>
										</div>
										<div class="total-count-pay-info">
											<span>商品总额：￥${order.totalMoney * 0.01 }</span>

											<em>+</em>
											<span>运费：￥${order.carriageFee * 0.01 }</span>

											<em>-</em>
											<span>优惠金额：￥0.00</span>

											<em>-</em>
											<span>优惠券：￥0.00</span>

											<em>-</em>
											<span>活动促销：￥0.00</span>

											<em>=</em>
											<span class="end second-color">实付款：￥${order.realMoney *0.01 }</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<script>
						$().ready(function() {
							$("body").on("click", ".edit-order", function() {
								var type = $(this).data("type");
								var id = $(this).data("id");

								title = '';
								String action = "cancel";
								if(type == 'delay') {
									title = "延长确认收货时间";
								}
								if(type == 'confirmShip') {
									title = "确认收货";
									action = "confirmShip";
								}
								if(type == 'cancel') {
									title = "取消订单";
									action = "cancel";
								}
								
								layer.alert(title, {
									icon: 3,
									skin: 'layer-ext-moon',
									btn: ['确定', '取消']
								}, function() {
									$.loading.start();
									$.ajax({
										type: 'POST',
										url: '/trade/order/'+action,
										data: {
											orderId: id
										},
										dataType: 'json',
										success: function(data) {
											$.loading.stop();
											$.msg(data.message);

											if(data.code == 0) {
												location.href='';
											}
										}
									});
								}, function(index) {
									layer.close(index);
								});
								
								
							});
						});
					</script>
				</div>
			

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>