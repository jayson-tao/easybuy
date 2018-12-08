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
				<a id="trans-detail" class="tabs- color">
					<span>交易明细</span>
								<em class="tag-em"></em>
								<span class="vertical-line">|</span>
								</a>
								</span>
								<span class="user-statu">
				<a id="income" class="tabs-">
					<span>收入</span>
								<em class="tag-em"></em>
								<span class="vertical-line">|</span>
								</a>
								</span>
								<span class="user-statu">
				<a id="expend" class="tabs-">
					<span>支出</span>
								<em class="tag-em"></em>
								<span class="vertical-line">|</span>
								</a>
								</span>
							</div>
							<div class="user-tab-right">
								<a href="http://www.yaorange.com/user/recharge/online-recharge.html">在线充值</a>
								<a href="http://www.yaorange.com/user/deposit/add">申请提现</a>
							</div>
						</div>
						<div class="content-info">
							<div class="content-list">
								<form id="searchForm" name="searchForm" action="http://www.yaorange.com/user/capital-account.html" method="GET">
									<div class="content-search order-search" style="display: none"></div>
									<div class="order-screen-term" style="display: none">
										<label style="width: 30%;">
					<span>交易类型：</span>
					<span class="select">
<select id="trade_type" class="form-control" name="trade_type">
<option value="trans-detail">交易明细</option>
<option value="income">收入</option>
<option value="expend">支出</option>
</select>
</span>
					<span id="searchFormSubmit" class="order-search-btn">搜索</span>
				</label>
									</div>

								</form>

								<div class="use-detail clearfix">
									<span class="fl">
					可提现资金：
					<strong class="second-color">0.00</strong>
					元
				</span>
									<span class="fl">
					不可提现资金：
					<strong class="second-color">0.00</strong>
					元
				</span>
									<span class="fl">
					冻结资金：
					<strong class="second-color">0.00</strong>
					元
				</span>
								</div>

								<div class="content-list">
									<!-- 交易明细 _start -->
									<div id="con_status_1" class="list-type">
										<div class="list-type-text">

											<div id="table_list">
												<!---->
												<table class="table">
													<thead>
														<tr>
															<th style="width: 40%; cursor: default;" class="">来源/用途</th>
															<th style="width: 20%; cursor: default;" class="">收入/支出</th>
															<th style="width: 20%;">时间</th>
															<th style="width: 20%;">备注</th>
														</tr>
													</thead>
												</table>
												<div class="no-data">
													<i class="fa fa-exclamation-circle"></i> 没有符合条件的记录
												</div>

											</div>

										</div>
									</div>
								</div>

								<div class="operat-tips">
									<h4>我的资金账户注意事项</h4>
									<ul class="operat-panel">
										<li>
											<span>账户余额是您在本网站可用于支付的金额，您可在线充值.</span>
										</li>
										<li>
											<span>您资金账户中的余额分为三类：可提现资金、不可提现资金、冻结资金</span>
										</li>
										<li>
											<span>如果您创建了店铺，则可以看到店铺的资金变动明细</span>
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
								params: $("#searchForm").serializeJson(),
							});

							$("#searchForm").submit(function() {
								// 控制下方快速选择tab样式
								if($("#trade_type").val() != '') {
									$("a[class^='tabs-']").removeClass('color');
									$("a[id='" + $("#trade_type").val() + "']").addClass('color');
									$(".user-statu").removeClass('active');
									$("a[id=''" + $("#trade_type").val() + "']").parent(".user-statu").addClass('active');
								} else {
									$("a[class^='tabs-']").removeClass('color');
									$("a[id='trans-detail']").addClass('color');
									$(".user-statu").removeClass('active');
									$("a[id='trans-detail").parent(".user-statu").addClass('active');
								}

								// 序列化表单为JSON对象
								var data = $(this).serializeJson();
								// Ajax加载数据
								tablelist.load(data);
								// 阻止表单提交
								return false;
							});
						});

						$("a[class^='tabs-']").click(function() {
							$("a[class^='tabs-']").removeClass('color');
							$(".user-statu").removeClass('active');
							$(this).addClass('color');
							$(this).parent(".user-statu").addClass('active');

							$("#trade_type").val($(this).attr("id"));

							tablelist = $("#table_list").tablelist({
								params: $("#searchForm").serializeJson()
							});
							tablelist.load();
						});
					</script>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>