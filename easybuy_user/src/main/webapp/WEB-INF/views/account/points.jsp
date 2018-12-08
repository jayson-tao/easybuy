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
							<ul class="tab">
								<li class="active">我的积分</li>
							</ul>
						</div>
							<div class="content-info">

								<div id="con_status_2">
									<div class="growth-value-text">
										<table class="table">
											<thead>
												<tr>
													<th style="width: 35%;">来源/用途</th>
													<th style="width: 15%;">订单号/退款编号</th>
													<th style="width: 15%;">实付款</th>
													<th style="width: 10%;">积分</th>
													<th style="width: 25%;">获取时间</th>
												</tr>
											</thead>
										</table>
										<div class="no-data">
											<i class="fa fa-exclamation-circle"></i> 暂无积分记录
										</div>
									</div>
									<div class="growth-value-text">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			
				<script type="text/javascript">
					var tablelist = null;
					$().ready(function() {
						tablelist = $("#table_list").tablelist({
							params: $("#searchForm").serializeJson()
						});
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
					
				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>