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
								<li class="active">退款退货</li>
							</ul>
						</div>
						<div class="content-info">
							<div class="content-list refund-return-list">
								<form id="searchForm" action="http://www.yaorange.com/user/back.html" method="GET">
									<div class="screen-term">
										<label style="width: 29%;">
					<span>订单编号：</span>
					<input type="text" id="order_sn" class="form-control" name="order_sn" placeholder="订单编号">
				</label>
										<label style="width: 29%;">
					<span>退款退货单编号：</span>
					<input type="text" id="back_sn" class="form-control" name="back_sn" placeholder="退款退货单编号">
				</label>
										<label>
					<input id="btn_submit" type="submit" value="搜索" class="search">
				</label>
									</div>

								</form>

								<div id="table_list">
									<table class="table">
										<thead>
											<tr>
												<th style="width: 30%;">商品信息/订单编号/退款编号</th>
												<th style="width: 16%;">卖家</th>
												<th style="width: 8%;">交易金额(整单)</th>
												<th style="width: 8%;">退款金额</th>
												<th style="width: 10%;">申请时间</th>
												<th style="width: 10%;">超时时间</th>
												<th style="width: 13%;">退款退货状态</th>
												<th style="width: 5%;">操作</th>
											</tr>
										</thead>
									</table>
									<div class="no-data">
										<i class="fa fa-exclamation-circle"></i> 没有符合条件的记录
									</div>
								</div>

							</div>

							<div class="operat-tips">
								<h4>退款退货注意事项</h4>
								<ul class="operat-panel">
									<li>
										<span>买家“确认收货”前和“确认收货”后发起的“仅退款/退款退货”申请均属于退款退货管理。</span>
									</li>
									<li>
										<span>买家“确认收货”后发起的维修申请、换货申请均属于换货维修管理。</span>
									</li>
									<li>
										<span>卖家同意退款后，退款信息将自动推送至平台方，由平台方管理员为买家退款。</span>
									</li>
								</ul>
							</div>
						</div>
					</div>

					<script type="text/javascript">
						var tablelist = null;
						$().ready(function() {
							// 加载时加入即时查询搜索条件
							tablelist = $("#table_list").tablelist({
								params: $("#searchForm").serializeJson()
							});
							// 搜索
							$("#searchForm").submit(function() {
								// 序列化表单为JSON对象
								var data = $(this).serializeJson();
								console.info(data);
								// Ajax加载数据
								tablelist.load(data);
								// 阻止表单提交
								return false;
							});
						});
					</script>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>