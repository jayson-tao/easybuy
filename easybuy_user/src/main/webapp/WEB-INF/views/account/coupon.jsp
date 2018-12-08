<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>

<!-- 正文，由view提供 -->

				<div class="con-right fr">
					<div class="con-right fr">
						<div class="con-right-text">
							<div class="tabmenu">
								<div class="user-status">
									<span class="tab-type active" data-type="1">
					<a href="javascript:void(0);" target="_self">
						<span>我的优惠券</span>
									<em class="tag-em SZY-SHOP-BONUS-COUNT">0</em>
									<span class="vertical-line">|</span>
									</a>
									</span>
								</div>
								
							</div>
							<div class="content-info">
								<div class="content-list">
									<form method="post" action="http://www.yaorange.com/user/bonus.html" name="">
										<div class="screen-box">
											<div class="sort-box fl">
												<span class="orderby" data-sortname="ub.bonus_price" data-sortorder="asc">
								<a href="javascript:;">
									金额
									<b class="icon-order-ASCending"></b>
								</a>
							</span>
												<span class="orderby" data-sortname="ub.end_time" data-sortorder="asc">
								<a href="javascript:;">
									到期时间
									<b class="icon-order-ASCending"></b>
								</a>
							</span>
												<span class="orderby" data-sortname="ub.start_time" data-sortorder="asc">
								<a href="javascript:;">
									生效时间
									<b class="icon-order-ASCending"></b>
								</a>
							</span>
											</div>
										</div>
									</form>

									<div id="table_list">
										<!---->
										<div class="coupon-list clearfix">
											<div class="no-data">
												<i class="fa fa-exclamation-circle"></i> 您还没有任何优惠券
											</div>
										</div>
										<!---->
									</div>

									<!-- 列表页面 _end -->
									<div class="operat-tips">
										<h4>我的优惠券注意事项</h4>
										<ul class="operat-panel">
											<li>
												<span>当您从购物车中去结算时，在订单确认页面可以选择您的优惠券，获得相应的优惠</span>
											</li>
											<li>
												<span>当您使用了优惠券的订单发生退货时，需要将使用了该优惠券的订单内所有商品全部退货完成后，才能退回优惠券</span>
											</li>
											<li>
												<span>店铺优惠券仅可在发行店铺使用；支付优惠券领取后会自动充值到您的余额中</span>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<script type="text/javascript">
							var tablelist = null;
							$().ready(function() {
								tablelist = $("#table_list").tablelist({
									page: {
										// 每页显示8条记录
										page_size: 8
									}
								});

								// 优惠券类型
								$("body").on("click", ".tab-type", function() {
									$(".tab-type").removeClass('active');
									$(this).addClass('active');

									var type = $(this).data("type");

									if(type == 0) {
										$(".bonus-search").hide();
									} else {
										$(".bonus-search").show();
									}

									tablelist.load({
										'type': type
									});

									return false;
								});
								// 排序
								$("body").on("click", ".orderby", function() {
									$(".orderby").removeClass('curr');
									$(this).addClass('curr');

									var sortname = $(this).data("sortname");
									var sortorder = ($(this).data('sortorder') == 'desc') ? 'asc' : 'desc';

									$(this).data('sortorder', sortorder)
									if(sortorder == 'desc') {
										$(this).find(".icon-order-ASCending").removeClass("icon-order-ASCending").addClass("icon-order-DESCending");
									} else {
										$(this).find(".icon-order-DESCending").removeClass("icon-order-DESCending").addClass("icon-order-ASCending");
									}

									tablelist.sort(sortname, sortorder).always(function(result) {

									});

									return false;
								});

								// 店铺搜索
								$("body").on("click", ".order-search-btn", function() {
									tablelist.load({
										'shop_name': $("#shop_name").val()
									})
									return false;
								});

								// 删除优惠券
								$("body").on("click", ".coupon-del", function() {
									var user_bonus_id = $(this).data('user-bonus-id');
									$.confirm("您确定要删除该优惠券吗？", function() {
										$.post("/user/bonus/delete.html", {
											user_bonus_id: user_bonus_id
										}, function(result) {
											if(result.code == 0) {
												$(".SZY-SYSTEM-BONUS-COUNT").html(result.system_bonus_count);
												$(".SZY-SHOP-BONUS-COUNT").html(result.shop_bonus_count);
												$.msg(result.message);
												tablelist.load();
											} else {
												$.msg(result.message, {
													time: 5000
												});
											}
										}, "JSON");
									});
								})

							});
						</script>
					</div>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>