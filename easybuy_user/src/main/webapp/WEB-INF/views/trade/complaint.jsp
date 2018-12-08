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
								<li class="active">我的投诉</li>
							</ul>
						</div>
						<div class="content-info refund-return-list">
							<div class="complaint-list">
								<form id="searchForm" method="GET" action="http://www.yaorange.com/user/complaint.html" name="">
									<div class="screen-term">
										<label style="width: 30%;">
						<span>订单编号：</span>
						<input id="order_id" type="text" name="order_id">
					</label>
										<label style="width: 30%;">
						<span>投诉编号：</span>
						<input type="text" name="complaint_id" id="complaint_id">
					</label>
										<label style="width: 30%;">
						<span>投诉状态：</span>
						<select id="complaint_status">
							<option value="-1">全部</option>
							
							<option value="0">买家提起投诉，等待卖家处理</option>
							
							<option value="1">协商处理中</option>
							
							<option value="2">投诉已撤销</option>
							
							<option value="3">申请平台方介入</option>
							
							<option value="4">平台方处理中</option>
							
							<option value="5">平台方已仲裁，投诉成立</option>
							
							<option value="6">平台方已仲裁，投诉不成立</option>
							

						</select>
					</label>
										<label style="width: 30%;">
						<span>申请时间：</span>
						<select id="complaint_time">
							<option value="0">全部</option>
							<option value="1">近3个月的订单</option>
							<option value="2">近半年的订单</option>
							<option value="3">今年内的订单</option>

						</select>
					</label>
										<label style="width: 10%;">
						<input type="submit" value="搜索" class="search">
					</label>
									</div>
								</form>

								<!---->
								<table id="table_list" class="table">
									<thead>
										<tr>
											<th style="width: 14%;">投诉编号</th>
											<th style="width: 16%;">订单编号</th>
											<th style="width: 16%; cursor: default;" class="">投诉卖家</th>
											<th style="width: 17%; cursor: default;" class="">投诉原因</th>
											<th style="width: 12%; cursor: default;" class="">申请时间</th>
											<th style="width: 15%;">投诉状态</th>
											<th style="width: 8%;">操作</th>
										</tr>
										<tr style="border-right-style: none; border-left-style: none; border-bottom-style: none">
											<td colspan="7">
												<div class="no-data">
													<i class="fa fa-exclamation-circle"></i> 您还没有任何投诉记录
												</div>
											</td>
										</tr>
									</thead>
								</table>
								<!---->

							</div>
							<div class="operat-tips">
								<h4>我的投诉注意事项</h4>
								<ul class="operat-panel">
									<li>
										<span>交易状态为“交易成功”后，4天内可以投诉商家</span>
									</li>
									<li>
										<span>可申请由平台方介入处理投诉，如投诉成功后，被投诉店铺将会受到惩罚</span>
									</li>
								</ul>
							</div>
						</div>
					</div>

					<a class="scroll-to-top active"><i class="fa fa-chevron-up"></i></a>

					<script type="text/javascript">
						$().ready(function() {
							var tablelist = $("#table_list").tablelist({
								params: $("#searchForm").serializeJson()
							});
							$("#searchForm").submit(function() {
								tablelist.load({
									// 订单编号
									'order_id': $("#order_id").val(),
									// 投诉编号
									'complaint_id': $("#complaint_id").val(),
									//投诉状态
									'complaint_status': $("#complaint_status").val(),
									//投诉时间
									'complaint_time': $("#complaint_time").val(),
								});
								return false;
							});
						});
					</script>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>