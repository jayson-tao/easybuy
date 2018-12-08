<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common-link.jsp" %>
<link type="text/css" rel="stylesheet" href="/static/css/flow.css">
	<title>确认订单</title>
	</head>

	<body>
		<div id="bg" class="bg" style="display: none;"></div>
		<%@include file="/WEB-INF/views/common-header-top.jsp" %>

		<div class="header">
			<div class="w990">
				<div class="logo-info">
					<a href="/" class="logo">
						<img src="/static/img/test/mall_logo_0.png">
					</a>
				</div>
				<div class="cart-progress">
					<ul>
						<li class="finish finish-01">
							<i>1</i>
							<span>
								<a href="http://www.yaorange.cn/checkout.html">我的购物车</a>
							</span>
							<b></b>
						</li>
						<li class="finish finish-02">
							<i>2</i>
							<span>确认订单</span>
							<b></b>
						</li>
						<li class="finish">
							<i>3</i>
							<span>付款</span>
							<b></b>
						</li>
						<li class="finish">
							<i>4</i>
							<span>支付成功</span>
							<b></b>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="content-bg">
			<div class="content-main w990">
				<div class="content-info">
					<!-- 收货地址 模板-->
					<div id="addressTemplate" style="display:none;" data-address-id="" class="address-box">
										<div class="address-box-info" data-address-id="">
											<div class="name"></div>
											<div class="detaile"></div>
											<div class="number-phone"></div>
										</div>
										<div class="addr-operate">
											<a href="javascript:void(0)" class="address-edit color" data-address-id="" title="修改地址">修改</a>
											<a href="javascript:void(0)" class="address-delete color" data-address-id="" title="删除地址">删除</a>
											<span class="deftip">默认地址</span>
											<a href="javascript:void(0)" class="address-default" data-address-id="">设为默认</a>
										</div>
					</div>
					<div class="address-container border-line" id="addressinfo">
						<div id="user_address_list" class="main-content">
							<h2 class="title">地址选择</h2>
							<div class="address">
								<div class="address-list clearfix">
								<!-- 收货地址列表 -->
								<c:forEach var="addr" items="${addrList}" varStatus="st">
									<div data-address-id="${addr.id}" class="address-box <c:if test="${1==addr.defaultAddress}">active</c:if>">
										<div class="address-box-info" data-address-id="${addr.id}">
											<div class="name">${addr.reciver}</div>
											<div class="detaile">${addr.fullAddress}</div>
											<div class="number-phone">${addr.phone}</div>
										</div>
										<div class="addr-operate">
											<a href="javascript:void(0)" class="address-edit color" data-address-id="${addr.id}" title="修改地址">修改</a>
											<a href="javascript:void(0)" class="address-delete color" data-address-id="${addr.id}" title="删除地址">删除</a>
											<c:if test="${0==addr.defaultAddress}">
											<a href="javascript:void(0)" class="address-default" data-address-id="${addr.id}">设为默认</a>
											</c:if>
											<c:if test="${1==addr.defaultAddress}">
											<!-- 默认地址一直显示用span标签 -->
											<span class="deftip">默认地址</span>
											</c:if>
										</div>
									</div>
								</c:forEach>
								</div>
								<div class="addr-control">
									<a href="javascript:void(0)" class="addr-add" title="增加新地址">
										<i>+</i>
										<span>使用新地址</span>
									</a>

								</div>
							</div>
						</div>
					</div>
					<!-- 送货时间 -->
					<div class="time-container border-line">
						<div class="main-content">
							<h2 class="title">
								送货时间
								<span>送货时间仅供参考，快递公司会尽量满足您的要求</span>
							</h2>
							<div class="delivery-time clearfix">
								<!-- 选中的送货时间 给下面的div增加class值"active" 也就是class="box active" _star-->
								<div class="box active">
									<label>
										<input type="radio" data="" class="best_time" name="shipTime" value="工作日/周末/假日均可" checked>
										<span>工作日/周末/假日均可</span>
									</label>
								</div>

								<div class="box ">
									<label>
										<input type="radio" data="" class="best_time" name="shipTime" value="仅周末送货">
										<span>仅周末送货</span>
									</label>
								</div>

								<div class="box ">
									<label>
										<input type="radio" data="" class="best_time" name="shipTime" value="仅工作日送货">
										<span>仅工作日送货</span>
									</label>
								</div>


							</div>
						</div>
					</div>
					<!-- 所有店铺商品清单 -->
					<div class="goods-list border-line">
						<div class="main-content">
							<h2 class="title">商品清单</h2>
							<div class="order-goods">
								<!-- 根据店铺对商品进行拆单 每个table是一个店铺的商品 _star-->
								<table cellpadding="0" cellspacing="0" border="0" width="100%" class="order-goods-list">
									<tbody>
										<tr>
											<th class="goods-title">
												<div class="order-body">
													<div class="shop">
														<div class="shop-info">
															<span class="shop-icon">
																<img src="/static/img/test/shop-icon2.png">
															</span>
															<span class="shop-name">店铺：</span>
															<a href="#" title="">易购物官方自营一号店</a>
															<span class="shop-customer">
																<a href="javascript:;" class="ww-light service-online" data-shop_id="7"><img src="/static/img/test/openim.png" width="20" height="20" border="0" alt="在线客服"></a>
															</span>
														</div>
													</div>
												</div>
											</th>
											<th class="goods-price">单价（元）</th>
											<th class="goods-amount">数量</th>
											<th class="goods-sum">小计(元)</th>
											<th class="goods-postage">配送方式</th>
										</tr>
										<tr>
											<td colspan="4" class="goods-content">
												<c:forEach var="cart" items="${selectedCartInfo.data}">
												<table cellpadding="0" cellspacing="0" border="0" width="100%">
													<tbody>
														<tr class="goods_${cart.productId}">
															<td class="goods-img">
																<a href="/p/${cart.productId}?skuId=${cart.skuId}" title="${cart.name}" target="_blank" class="img">
																	<img src="http://pijbgt8k2.bkt.clouddn.com/${cart.skuMainPic}?imageView2/1/w/50/h/50">
																</a>
															</td>
															<td class="goods-master">
																<p class="item-title">
																	<a href="/p/${cart.productId}?skuId=${cart.skuId}" title="${cart.name}" target="_blank">
																		${cart.name}
																	</a>
																</p>
																<div class="item-other-info">
																	<div class="promo-logos"></div>
																	<div class="item-icon-list">
																		<div class="item-icons">
																		</div>
																	</div>
																</div>
															</td>
															<td class="goods-attr">
																<p class="sku-line">${cart.skuProperties}</p>
															</td>
															<td class="goods-price">￥${cart.sku.price * 0.01}</td>
															<td class="goods-amount">${cart.amount}</td>
															<td class="goods-sum">
																<p class="sum second-color">￥${cart.sku.price * cart.amount * 0.01 }</p>
															</td>
														</tr>
													</tbody>
												</table>
												</c:forEach>
											</td>
											<td class="goods-postage">
												<div class="postage">
													<label>
														<input type="radio" name="" checked="checked">
														<span>普通配送</span>
													</label>
													<select id="shipStore" class="shipping-select" data-shop-id="7">
														<option value="1" selected>普通快递 包邮</option>
													</select>
												</div>
											</td>
										</tr>
										<tr>
											<td colspan="2" class="goods-annex">
												<div class="memo">
													<span>买家留言：</span>
													<div class="buyer-msg">
														<textarea class="text postscript" id="leaveword" data-shop-id="7" placeholder="选填，可填写您与卖家达成一致的要求"></textarea>
													</div>
												</div>
											</td>
											<td colspan="3" class="goods-bill" id="shop_count_7">
												<div class="bill">
													<div class="order-pay">
														店铺合计
														<span>(含运费)</span> ：
														<strong class="second-color SZY-SHOP-ORDER-AMOUNT-7" data-shop-id="7">￥${selectedCartInfo.selectedGoodsTotalPrice*0.01}</strong>
													</div>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<!-- 发票信息 -->
					<div class="invoice-info border-line">
						<div class="main-content">
							<h2 class="title">发票信息</h2>
							<div class="invoice-content">
								<!-- 发票详细信息 _star -->
								<div class="inv-info">
									<span>不开发票</span>
								</div>
							</div>
						</div>
					</div>

					<!-- 支付方式 -->
					<div class="pay-type border-line">
						<div class="main-content">
							<h2 class="title">支付方式</h2>
							<div class="pay-type-content">
								<div class="pay-all" id="pay_bank">
									<ul id="paylist" class="payment-tab">
										<li class="clearfix pay_code first seled" payChannel="1">
											<img alt="支付宝支付" src="/static/img/alipay.png" />
										</li>
										<li class="clearfix pay_code" payChannel="2">
											<img alt="微信支付" src="/static/img/wepay.png" />
										</li>

										<li class="clearfix pay_code" payChannel="3">
											<img alt="银联支付" src="/static/img/union.png" />
										</li>

										<li class="clearfix pay_code" payChannel="0">
											<img alt="余额支付" src="/static/img/yue.png" /><span>(￥0.00)</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<!-- 提交订单 -->
					<div class="confirm-pay" id="checkout_amount">

						<div class="total-count">
							<div class="total-count-pay">
								<div class="total-count-pay-info">
									<span class="first">
										订单总额：
										<span class="SZY-ORDER-AMOUNT">￥${selectedCartInfo.selectedGoodsTotalPrice*0.01}</span>
									</span>
								</div>
								<div class="total-count-pay-info">
									<span>
										订单总额：
										<span class="SZY-GOODS-AMOUNT">￥${selectedCartInfo.selectedGoodsTotalPrice*0.01}</span>
									</span>
									<em>+</em>
									<span>
										运费：
										<span class="SZY-SHIPPING-FEE-AMOUNT">￥0.00</span>
									</span>
									<em>-</em>
									<span>
										优惠券：
										<span class="">￥0</span>
									</span>
									<em>=</em>
									<span class="end second-color">
										应付款：
										<span class="SZY-ORDER-MONEY-PAY">￥ ${selectedCartInfo.selectedGoodsTotalPrice*0.01}</span>
									</span>
								</div>
							</div>
						</div>
						<div class="back-to-cart fl">
							<a href="/cart/index" title="返回购物车列表" class="color">返回修改购物车</a>
						</div>
						<div class="submit-box fr">
							<div class="price-box fl">
								<span>应付总额：</span>
								<span class="price color SZY-ORDER-AMOUNT">￥${selectedCartInfo.selectedGoodsTotalPrice*0.01}</span>
							</div>

							<div class="fr">
								<a href="javascript:void(0);" class="submit-btn gopay bg-color">确认交易</a>
							</div>
						</div>

					</div>
				</div>

				<!-- 新增地址弹框 -->
				<div class="bomb-box addr-box">
					<div class="box-title">使用新地址</div>
					<div class="box-oprate addr-box-oprate"></div>
					<div class="content-info" id="edit-address-div"></div>
				</div>

				<!-- 发票信息弹框 -->
				<div class="bomb-box invoice-box">
					<div class="box-title">发票信息</div>
					<div class="box-oprate invoice-box-oprate"></div>
					<div class="content-info">
						<div class="tab-nav">
							<ul>
								<li class="tab-nav-item  tab-item-selected" data-invoice-type="0" data-invoice-name="不开发票">
									不开发票
									<b></b>
								</li>
								<li class="tab-nav-item disabled " data-invoice-type="1" data-invoice-name="普通发票">
									普通发票
									<b></b>
								</li>
								<li class="tab-nav-item disabled " data-invoice-type="2" data-invoice-name="增值税发票">
									增值税发票
									<b></b>
								</li>
							</ul>
						</div>
						<!-- 普通税发票 _star -->
						<!-- <form id="invoice_type_0" action="" method="post" class="form-horizontal">
							<div class="act">
								<input type="button" value="保存发票信息" id="inv_submit">
								<input type="button" value="取消" class="m-l-10" id="inv_cancle">
							</div>
						</form> -->
					</div>
				</div>
			</div>
		</div>

		<!-- 付款信息弹框 -->
		<div class="bomb-box payment-box">
			<div class="box-title">请付款</div>
			<div class="content-info">
				<p class="warning">
					<i></i>
					<span>请您在新打开的页面上完成付款。</span>
				</p>
				<p class="prompt">付款完成前请不要关闭此窗口</p>
				<p class="prompt">完成付款后请根据您的情况点击下面的按钮</p>
				<p class="btns">
					<a href="http://127.0.0.1/payResult" class="pay_result">已完成付款</a>
					<a href="http://127.0.0.1/payResult" class="m-l-10 pay_result">付款遇到问题</a>
				</p>
			</div>
		</div>

		<!-- 引入底部文件 -->
		<!-- 底部 _start-->
		<div class="site-footer">
			<div class="footer-related">
				<div class="footer-info">
					<div class="info-text">
						<!-- 底部导航 -->
						<p class="nav-bottom">
						</p>
						<p>
							Copyright 强哥出品(www.yaorange.cn) 版权所有
							<a href="http://www.miibeian.gov.cn/" target="_blank">蜀ICP备88888888号</a>
						</p>
					</div>
				</div>
			</div>
		</div>


		<script type="text/javascript" src="/static/js/checkout.js"></script>
		<script type="text/javascript" src="/static/js/common.js"></script>
		<script type="text/javascript" src="/static/js/szy.cart.js"></script>
		<script type="text/javascript" src="/static/js/jquery.region.js"></script>
		<!-- 表单验证 -->
		<script type="text/javascript" src="/static/js/jquery.validate.js"></script>
		<script type="text/javascript" src="/static/js/jquery.validate.custom.js"></script>
		<script type="text/javascript" src="/static/js/messages_zh.js"></script>
	</body>

</html>
