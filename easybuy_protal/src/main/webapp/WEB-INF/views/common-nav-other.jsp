<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="category-box category-box-border">
	<div class="w1210">
		<div class="home-category fl">
			<a href="/" class="menu-event"
				title="查看全部商品分类"> <i></i> 全部商品分类
			</a>
			<div class="expand-menu category-layer">
				<span class="category-layer-bg bg-color"></span>
				<%@include file="/data/template/product.type.vm.html"%>
			</div>
		</div>
		<%@include file="/WEB-INF/views/common-nav-enter.jsp" %>
	</div>
</div>
