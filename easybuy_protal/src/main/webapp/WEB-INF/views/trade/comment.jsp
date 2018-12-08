<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>

<!-- 正文，由view提供 -->

				<div class="con-right fr">
					<!---->
					<div class="con-right fr">
						<div class="con-right-text">
							<div class="tabmenu">
								<ul class="tab">
									<li class="active">我的评价</li>
								</ul>
							</div>
							<div class="content-info">
								<div class="content-list evaluate-list">
									<form id="searchForm" class="screen-term" method="GET">
										<label style="width: 30%;">
						<span>评价等级：</span>
						<select name="comment_level">
							<option value="0">全部评价</option>
							<option value="1">好评</option>
							<option value="2">中评</option>
							<option value="3">差评</option>
						</select>
					</label>
										<label style="width: 30%;">
						<span>评论内容：</span>
						<select name="comment_content">
							<option value="0">全部评论</option>
							<option value="1">有评论内容</option>
							<option value="2">无评论内容</option>
							<option value="3">有追加评论内容</option>
						</select>
					</label>
										<label style="width: 40%;">
						<input type="button" id="btn_search" value="搜索" class="search">
					</label>
									</form>
									<div class="evaluate-table evaluate-table-no-date">
										<div class="evaluate-list-head">
											<ul>
												<li style="width: 50%;">宝贝信息</li>
												<li style="width: 20%;">评分</li>
												<li style="width: 30%;">评价状态</li>
											</ul>
										</div>
										<!---->
										<div id="table_list">
											<!---->
											<div class="no-data">
												<i class="fa fa-exclamation-circle"></i> 暂无评价记录
											</div>
											<!---->
										</div>
										<!---->
									</div>
								</div>
								<div class="operat-tips">
									<h4>评价注意事项</h4>
									<ul class="operat-panel">
										<li>
											<span>如买家恶意评价，平台方一经核实，将有权隐藏您的评价信息，如有疑问，请联系平台方客服处理</span>
										</li>
										<li>
											<span>平台方开启评论审核后，买家提交的评论，平台方审核通过后才可在商品评论中展示</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>