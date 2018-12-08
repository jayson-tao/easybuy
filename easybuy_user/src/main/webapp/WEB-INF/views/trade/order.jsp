<%@page import="com.yaorange.consts.bis.OrderStateConsts"%>
<%@page import="com.yaorange.consts.bis.PayChannelConsts"%>
<%@page import="com.yaorange.consts.ConstUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>

<!-- 正文，由view提供 -->

				<div class="con-right fr">
					<div class="con-right-text">
						<div class="tabmenu">
							<div class="user-status">
								<span class="user-statu active">
								<a id="sa" class="tabs- color">
									<span>所有订单</span>
									<em class="tag-em">0</em>
									<span class="vertical-line">|</span>
								</a>
								</span>
								<span class="user-statu">
								<a id="s0" class="tabs-">
									<span>待付款</span>
									<em class="tag-em">0</em>
									<span class="vertical-line">|</span>
								</a>
								</span>
								<span class="user-statu">
								<a id="s1" class="tabs-">
									<span>待发货</span>
									<em class="tag-em">0</em>
									<span class="vertical-line">|</span>
								</a>
								</span>
								<span class="user-statu">
								<a id="s2" class="tabs-">
									<span>待收货</span>
									<em class="tag-em">0</em>
									<span class="vertical-line">|</span>
								</a>
								</span>
								<span class="user-statu">
								<a id="sc" class="tabs- tp-tag-a">
									<span>待评价</span>
									<em class="tag-em">0</em>
								</a>
								</span>
							</div>
							<div class="user-tab-right">
								<a href="javascript:;" onclick="alert('还没有做呢')">订单回收站</a>
							</div>
						</div>
						
						
						<div class="content-info">
							<div class="content-list order-list">
								<form id="searchForm" name="searchForm" action="/trade/order" method="GET">
									<div class="content-search order-search"></div>
									<input name="page" type="hidden" value="1"/>
									<div class="order-screen-term">
										<label style="width: 30%;">
											<span>商品标题/订单号：</span>
											<input type="text" id="keyword" class="form-control" name="keyword" placeholder="输入商品标题或订单号">
										</label>
										<label style="width: 30%;">
											<span>交易状态：</span>
											<span class="select">
												<select id="order_status" class="form-control" name="state">
												<option value="-1">全部</option>
												<option value="0">等待买家付款</option>
												<option value="1">等待卖家发货</option>
												<option value="2">卖家已发货</option>
												<option value="3">交易成功</option>
												<option value="5">交易关闭</option>
												</select>
												<input type="hidden" id="commentStatus" name="isComment" value="">
											</span>
										</label>
										<label style="width: 30%;">
											<span>成交时间：</span>
											<span class="select">
												<select id="order_time" class="form-control" name="year">
												<option value="0">近三个月订单</option>
												<option value="2017">今年内订单</option>
												<option value="2016">2016年订单</option>
												</select>
											</span>
										</label>
										<label style="width: 10%;">
											<input type="submit" value="搜索" class="search" id="searchFormSubmit">
										</label>
									</div>
								</form>

								<div id="table_list">
									<table class="table">
										<colgroup>
											<col style="width: 38%;">
											<col style="width: 10%;">
											<col style="width: 5%;">
											<col style="width: 12%;">
											<col style="width: 12%;">
											<col style="width: 11%;">
											<col style="width: 12%;">
										</colgroup>
										<thead>
											<tr>
												<th>宝贝</th>
												<th class="" style="cursor: default;">单价（元）</th>
												<th>数量</th>
												<th></th>
												<th>金额（元）</th>
												<th class="" style="cursor: default;">交易状态</th>
												<th class="" style="cursor: default;">交易操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th colspan="7">
													<div class="fl">
														<label class="input-label">
															<input class="checkBox table-list-checkbox-all" type="checkbox" title="全选/全不选" onclick="checkAll(this)">
															全选
														</label>
														<button class="btn-default" type="button" onclick="order_deletes(1)">批量删除订单</button>
													</div>
												</th>
											</tr>
										</tbody>
									</table>
									<!-- 订单列表数据 div-->
									<div id="orderList"></div>
								</div>

							</div>

							<div class="operat-tips" style="clear:both;">
								<h4>订单注意事项</h4>
								<ul class="operat-panel">
									<li>
										<span>下单后订单会为您保留48小时，如48小时内未付款，系统将自动取消您的订单</span>
									</li>

									<li>
										<span>如买家下单后长时间未付款，卖家将有可能关闭您的订单</span>
									</li>
									<li>
										<span>卖家发货后，“确认收货”倒计时自动开启，到期系统将自动确认收货，您可在小于三天时手动“延长收货时间”</span>
									</li>
								</ul>
							</div>
						</div>
					</div>

					<script>
						$().ready(function() {
							$("body").on("click", ".edit-order", function() {
								var type = $(this).data("type");
								var id = $(this).data("id");

								title = '';
								var action = 'cancel';
								if(type == 'delay') {
									title = "延长确认收货时间";
								}
								if(type == 'cancel') {
									title = "确认取消订单？";
									action = 'cancel';
								}
								if(type == 'shipQuery') {
									title = "物流跟踪";
									action = 'ship';
								}
								if(type == 'confirmShip') {
									title = "确认收货？";
									action = 'confirmShip';
								}
								if(type == 'refund') {
									title = "退换货";
									action = 'refund';
								}
								if(type == 'comment') {
									title = "评价";
									action = 'comment';
								}
								/* $.modal({
									title: title,
									trigger: $(this),
									content : '',//内容
									// ajax加载的设置  
									 ajax: {
										url: '/user/order/edit-order?from=list',
										data: {
											type: type,
											id: id
										}
									}
								}); */
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
												$('#searchForm').submit();
											}
										}
									});
								}, function(index) {
									layer.close(index);
								});
								
							});

						});
					</script>

					<script type="text/javascript">
						$().ready(function() {
							$("#searchForm").submit(function() {
								$.loading.start();
								$('#commentStatus').val('');
								
								// 控制下方快速选择tab样式
								if($("#order_status").val() == '-1') {
									$("a[class^='tabs-']").removeClass('color');
									$("a[id='sa']").addClass('color');
									$(".user-statu").removeClass('active');
									$("a[id='sa']").parent(".user-statu").addClass('active');
								}else if($("#order_status").val() != '') {
									$("a[class^='tabs-']").removeClass('color');
									$("a[id='s" + $("#order_status").val() + "']").addClass('color');
									$(".user-statu").removeClass('active');
									$("a[id='s" + $("#order_status").val() + "']").parent(".user-statu").addClass('active');
								} else if($("#evaluate_status").val() == 'unevaluate') {
									$("a[class^='tabs-']").removeClass('color');
									$("a[id='sc']").addClass('color');
									$(".user-statu").removeClass('active');
									$("a[id='sc']").parent(".user-statu").addClass('active');
								} else {
									$("a[class^='tabs-']").removeClass('color');
									$("a[id='sa']").addClass('color');
									$(".user-statu").removeClass('active');
									$("a[id='sa']").parent(".user-statu").addClass('active');
								}

								// 序列化表单为JSON对象
								var params = $(this).serialize();
								$('#orderList').load('/trade/order/list?'+params,{},function(response,status,xhr){
									
								});
								// 阻止表单提交
								return false;
							});
							
							$('.user-status').find('.active').find('a').click();
						});

						//切换面板
						$("a[class^='tabs-']").click(function() {
							$.loading.start();

							$("a[class^='tabs-']").removeClass('color');
							$(".user-statu").removeClass('active');
							$(this).addClass('color');
							$(this).parent(".user-statu").addClass('active');
							$('#commentStatus').val('');
							$('#keyword').val('');
							$('#order_time').val(0);
							
							var tabId = $(this).attr('id');
							var state = -1;
							if('sa'==tabId){//所有
								state = -1;
								$('#order_status').val(-1);
							}else if('sc'==tabId){//评论
								state = 3;
								$('#order_status').val(3);
								$('#commentStatus').val(0);
							}else{//其它
								state = parseInt(tabId.substring(1));
								$('#order_status').val(state);
							}
							
							var params = $('#searchForm').serialize();
							$('#orderList').load('/trade/order/list?'+params,{},function(response,status,xhr){
								try{
									var ret = $.parseJSON(response);
									if(ret.code==2){//需要登录
										location.href = ret.data;
									}
								}catch(e){}
							});
							
						});

						//全选/不选
						function checkAll(o){
							var order_ids = document.getElementsByName("order_delete");
							for(var i = 0; i < order_ids.length; i++) {
								order_ids[i].checked = o.checked;
							}
						}
						
						function order_delete(order_id) {
							var text = "";
							var url = "/trade/order";
							text = "您确定要删除订单吗？";

							layer.alert(text, {
								icon: 3,
								skin: 'layer-ext-moon',
								btn: ['确定', '取消']
							}, function() {
								$.loading.start();
								$.ajax({
									type: 'POST',
									url: '/trade/order/delete',
									data: {
										orderId: order_id
									},
									dataType: 'json',
									success: function(data) {
										$.loading.stop();
										$.msg(data.message);

										if(data.code == 0) {
											$('#searchForm').submit();
										}
									}
								});
							}, function(index) {
								layer.close(index);
							});
						}

						function order_deletes() {
							var order_ids = document.getElementsByName("order_delete");
							
							var orderIds = '';
							
							for(var i = 0; i < order_ids.length; i++) {
								if(order_ids[i].checked == true) {
									orderIds +=','+ order_ids[i].value;
								}
							}
							if(orderIds.length >0){
								orderIds = orderIds.substring(1);
							}

							if(orderIds.length <= 0) {
								$.msg("请勾选待删除订单！");
								return false;
							}
							
							order_delete(orderIds);
							
						}
					</script>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>