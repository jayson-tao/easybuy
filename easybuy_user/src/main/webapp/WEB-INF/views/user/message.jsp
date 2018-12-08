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
								<span class="active" id="profile1" onclick="setTab(&#39;profile&#39;,1,2)">
				<a href="javascript:void(0);" target="_self">
					<span>站内信</span>
								<span class="vertical-line">|</span>
								</a>
								</span>
								<span class="" id="profile2" onclick="setTab(&#39;profile&#39;,2,2)">
				<a href="javascript:void(0);" target="_self">
					<span>系统消息</span>
								<span class="vertical-line">|</span>
								</a>
								</span>
							</div>
						</div>
						<div class="content-info">
							<div id="con_profile_1">

								<div class="mg-content" id="table_list">
									<ul>
										<li>
											<p class="mg-time">
												<span>2017-02-08 16:30:56</span>
											</p>
											<div class="mg-info">
												<h3>系统自动取消订单提醒</h3>
												<div class="mg-detail">亲爱的顾客SZY083SDPF5239，由于您未在规定时间内付款，系统已自动取消20170121837040订单，谢谢您的支持。</div>
											</div>
										</li>
									</ul>

									<div id="pagination" class="page">
										<script data-page-json="true" type="text">
											{"page_key":"page","page_id":"pagination","default_page_size":15,"cur_page":1,"page_size":10,"page_size_list":[1,10,20,30,50],"record_count":1,"page_count":1,"offset":0,"url":null,"sql":null}
										</script>
										<div class="page-wrap fr">
											<div class="total">共1条记录</div>
										</div>
										<div class="page-num fr">
											<span class="num prev disabled" style="display: none;">
			<a class="fa fa-angle-double-left" data-go-page="1" title="第一页"></a>
		</span>

											<span>
			<a class="num prev disabled " title="上一页">上一页</a>
		</span>
											<span class="num curr">
			<a data-cur-page="1">1</a>
		</span>
											<span class="disabled" style="display: none;">
			<a class="num " data-go-page="1" title="最后一页"></a>
		</span>

											<span>
			<a class="num next disabled" title="下一页">下一页</a>
		</span>

										</div>
										<script type="text/javascript">
											$().ready(function() {
												$(".pagination-goto > .goto-input").keyup(function(e) {
													$(".pagination-goto > .goto-link").attr("data-go-page", $(this).val());
													if(e.keyCode == 13) {
														$(".pagination-goto > .goto-link").click();
													}
												});
												$(".pagination-goto > .goto-button").click(function() {
													var page = $(".pagination-goto > .goto-link").attr("data-go-page");
													if($.trim(page) == '') {
														return false;
													}
													$(".pagination-goto > .goto-link").attr("data-go-page", page);
													$(".pagination-goto > .goto-link").click();
													return false;
												});
											});
										</script>
									</div>

								</div>

							</div>
							<div id="con_profile_2" style="display: none;">系统消息</div>
						</div>
					</div>

				</div>
				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>