<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common-link.jsp" %>
<link type="text/css" rel="stylesheet" href="/static/css/flow.css" />
		<title>购物车 - 购我所爱 I LOVE BUY</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
	</head>
	<body>
		<div class="as-shelter"></div>
		<%@include file="/WEB-INF/views/common-header-top.jsp" %>
		<%@include file="/WEB-INF/views/common-header.jsp" %>
		<script type="text/javascript" src="/static/js/cart.js" ></script>
		<div class="w990" id="content">
			<div class="content">
				<div class="cart-filter-bar">
					<div class="switch-cart" id="cart_num">
						<!-- 购物车数量 -->
						<span class="color">我的购物车<em class="color"></em></span>
					</div>
				</div>
				<div class="cart-main">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div class="select-all">
									<div class="cart-checkbox all-checkbox">
										<!-- <input type="checkbox" name="" value="true"> -->
										<label for="">勾选购物车内所有商品</label>
										<span>&nbsp;&nbsp;全选</span>
									</div>
								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-info">
								<div class="td-inner">&nbsp;</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价（元）</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额（元）</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>

					<div id="cart_list">
						<!-- 各个店铺下的信息 -->

						<div id="cart_shop_5" class="order-body">
							<div class="shop">
								<div class="shop-info">
									<div class="cart-checkbox shop-checkbox " data-shop-id="5">
										<label for="">勾选此店铺下所有商品</label>
									</div>
									&nbsp;&nbsp;

									<span class="shop-icon">
										<img src="/static/img/test/shop-icon2.png" />
									</span>
									<span class="shop-name">店铺：</span>
									<a href='javascript:;' title="易购物官方自营三号店">易购物官方自营一号店</a>
									<!-- 客服 -->
									<span class="shop-customer">
									<a href="javascript:;" class="ww-light" data-shop_id="5"><img src="/static/img/test/openim.png" width="20" height="20" border="0" alt="在线客服"></a>
									</span>
								</div>
							</div>
							<div class="order-content">
								<div class="item-list">
									<div class="bundle bundle-last">
										<!-- 购物车中商品列表 -->
										<c:forEach var="cart" items="${cartInfo.data}">
										<div class="item-holder" id="cartid${cart.id}">
											<div class="item-body">
												<ul class="item-content clearfix goods_${cart.id}_${cart.skuId}">
													<li class="td td-chk">
														<div class="td-inner">
															<div class="cart-checkbox goods-checkbox <c:if test="${cart.selected==1}">select</c:if>" data-shop-id="5">
																<input type="checkbox" name="checkbox" <c:if test="${cart.selected==1}">checked</c:if> value="${cart.id}">
																<label for="">勾选商品</label>
															</div>
														</div>
													</li>
													<li class="td td-item">
														<div class="td-inner">
															<div class="item-pic">
																<a href="/p/${cart.productId}" target="_blank" class="">
																	<img src="http://pijbgt8k2.bkt.clouddn.com/${cart.skuMainPic}?imageView2/1/w/80/h/80" class="itempic">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="/p/${cart.productId}" target="_blank" title="${cart.name}" class="item-title">
																		${cart.name}
																	</a>
																</div>
															</div>
														</div>
													</li>
													<li class="td td-info">
														<div class="item-props">
															<p class="sku-line">${cart.skuProperties}</p>
														</div>
													</li>
													<li class="td td-price">
														<div class="td-inner">
															<div class="item-price">
																<div class="price-content">
																	<div class="price-line">
																		<em class="price-original">￥${cart.sku.marketPrice*0.01}</em>
																	</div>
																	<div class="price-line">
																		<em class="price-now">￥${cart.sku.price*0.01}</em>
																	</div>
																</div>
															</div>
														</div>
													</li>
													<li class="td td-amount">
														<div class="td-inner">
															<div class="amount-wrapper">
																<div class="item-amount">
																	<span class="amount-widget amount">
																		<input type="text" class="amount-input" value="${cart.amount}" data-goods-number="1"
																		data-sku-id="${cart.skuId}" data-cart-id="${cart.id}" id="number${cart.id}"
																		data-amount-min="1" data-amount-max="${cart.sku.availableStock}" maxlength="8" title="请输入购买量">
																		<span class="amount-btn">
																			<span class="amount-plus">
																				<i>+</i>
																			</span>
																			<span class="amount-minus">
																				<i>-</i>
																			</span>
																		</span>
																	</span>
																</div>

																<div class="amount-msg" style="display:none"></div>
															</div>
														</div>
													</li>
													<li class="td td-sum">
														<div class="td-inner">
															<em class="number second-color">￥${cart.sku.price * cart.amount * 0.01}</em>
														</div>
													</li>
													<li class="td td-op">
														<div class="td-inner">
															<a href="javascript:void(0);" class="del" data-cart-id="${cart.id}">删除</a>
														</div>
													</li>
												</ul>
											</div>
										</div>
										</c:forEach>


									</div>
								</div>
							</div>

						</div>

					</div>
				</div>

				<!-- 购物车统计 -->
				<div class="cart-foot">
					<div class="cart-foot-wrapper">
						<div class="select-all">
							<div class="cart-checkbox all-checkbox">
								<!-- <input type="checkbox" name="" value=""> -->
								<label for="">勾选所有商品</label>
								<span>&nbsp;&nbsp;全选</span>
							</div>
						</div>
						<div class="operations">
							<a href="javascript:void(0)" class="del">删除</a>
							<!-- <a href="">分享</a> -->
						</div>
						<div class="cart-bar-right" id="cart_count">
							<!-- 购物车金额 -->
							<div class="amount-sum">
								<span class="txt">已选商品</span>
								<em class="second-color SZY-CART-SELECT-GOODS-NUMBER">${cartInfo.selectedGoodsNumber}</em>
								<span class="txt">件</span>
							</div>
							<div class="price-sum">
								<span class="txt">合计（不含运费）:</span>
								<strong class="price second-color SZY-CART-SELECT-GOODS-AMOUNT">￥${cartInfo.selectedGoodsTotalPrice*0.01}</strong>
							</div>
							<div class="btn-area">
								<a href="javascript:void(0)" class="submit-btn">
									<span>结 算</span>
								</a>
							</div>

						</div>
					</div>

				</div>

			</div>
		</div>

		<script type="text/javascript" src="/static/js/jquery.widget.js"></script>
		<script type="text/javascript" src="/static/js/common.js"></script>
		<script type="text/javascript" src="/static/js/tabs.js"></script>
		<script type="text/javascript" src="/static/js/cart.js"></script>

		<!-- 结束：主要区域内容-->
		<%@include file="/WEB-INF/views/common-right-sidebar.jsp" %>
		<!-- 站点底部-->
		<%@include file="/WEB-INF/views/common-footer.jsp" %>
	</body>

</html>
