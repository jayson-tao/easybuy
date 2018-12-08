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
								<li class="active">充值记录</li>
							</ul>
							<div class="user-tab-right">
								<a href="http://www.yaorange.com/user/recharge/online-recharge">在线充值</a>
							</div>
						</div>
						<div class="content-info">
							<form id="searchForm" name="searchForm" action="http://www.yaorange.com/user/recharge.html" method="GET">
								<div class="screen-term">
									<label style="width: 33%;">
				<span>充值类型：</span>
				<select>
					<option value="0">全部</option>
					<option value="1">在线充值</option>
				</select>
			</label>
									<label style="width: 33%; display: none">
				<span>类型：</span>
				<span class="select">
<select id="pay_type" class="form-control" name="pay_type">
<option value="all">全部记录</option>
<option value="paid">已支付记录</option>
<option value="not_paid">未支付记录</option>
</select>
</span>
			</label>
									<label style="width: 33%;">
				<span>充值日期：</span>
				<span class="select">
<select id="pay_time" class="form-control" name="pay_time">
<option value="0">全部</option>
<option value="1">近三个月充值</option>
<option value="2">近半年充值</option>
<option value="3">一年内充值</option>
</select>
</span>
			</label>
									<label>
				<input type="submit" value="搜索" class="search">
			</label>
								</div>

							</form>
							<div class="recharge-list clearfix">
								<div class="floatbar">
									<div class="bar-float">
										<div class="select">
											<ul>
												<!-- 选择的当前的状态 给li标签追加class值为"active" _start -->
												<li class="sel-item active" id="all">
													<a class="sel-link" href="javascript:;">全部记录</a>
												</li>
												<!-- 选择的当前的状态 给li标签追加class值为"active" _end -->
												<li class="sel-item" id="paid">
													<a class="sel-link" href="javascript:;">已支付记录</a>
												</li>
												<li class="sel-item" id="not_paid">
													<a class="sel-link" href="javascript:;">未支付记录</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
								<!-- 全部记录 _start -->
								<div id="con_recharge_1" class="list-type">
									<div class="list-type-text">

										<div id="table_list">
											<!---->
											<table class="table">
												<thead>
													<tr>
														<th>充值时间</th>
														<th>充值金额（元）</th>
														<th>留言</th>
														<th>状态</th>
														<th>支付方式</th>
													</tr>

												</thead>
											</table>
											<div class="no-data">
												<i class="fa fa-exclamation-circle"></i> 没有符合条件的记录
											</div>

										</div>

									</div>
									<!-- 全部记录 _end -->
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
								if($("#pay_type").val() != 'all') {
									$("li[class^='sel-item']").removeClass('active');
									$("li[id='" + $("#pay_type").val() + "']").addClass('active');
								} else {
									$("li[class^='sel-item']").removeClass('active');
									$("li[id='all'").addClass('active');
								}

								// 序列化表单为JSON对象
								var data = $(this).serializeJson();
								// Ajax加载数据
								tablelist.load(data);
								// 阻止表单提交
								return false;
							});
						});

						$("li[class^='sel-item']").click(function() {
							$("li[class^='sel-item']").removeClass('active');
							$(this).addClass('active');
							$("#pay_type").val($(this).attr("id"));

							tablelist = $("#table_list").tablelist({
								params: $("#searchForm").serializeJson()
							});
							tablelist.load();
						});
					</script>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>