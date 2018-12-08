<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--[if IE 8]> <html lang="zh-CN" class="ie8"> <![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml">
	<html lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title>用户中心</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<link type="text/css" rel="stylesheet" href="/static/css/common.css" />
		<link type="text/css" rel="stylesheet" href="/static/css/user.css" />
		<link type="text/css" rel="stylesheet" href="/static/css/color-style.css" />
		<script type="text/javascript" src="/static/js/jquery.js"></script>
		<script type="text/javascript" src="/static/js/layer.js"></script>
		<script type="text/javascript" src="/static/js/jquery.method.js"></script>
		<script type="text/javascript" src="/static/js/jquery.modal.js"></script>
		<script type="text/javascript" src="/static/js/common.js"></script>
		<script type="text/javascript" src="/static/js/jquery.tablelist.js"></script>
		<script type="text/javascript" src="/static/js/jquery.cookie.js"></script>
		<script type="text/javascript" src="/static/js/common1.js"></script>
		<script type="text/javascript" src="/static/js/user.js"></script>
		<!-- 倒计时 -->
		<script type="text/javascript" src="/static/js/jquery.countdown.js"></script>
	</head>

	<body>
		<div id="nav" class="bg-color">
			<div class="nav-content w1210">
				<div class="logo-info">
					<a href="http://127.0.0.1:8081" target="_blank" class="logo fore1">
						<img src="/static/css/mall_logo_0_white.png" style="margin-top: 10px;" />
					</a>
					<div class="user-link">
						<a href="http://127.0.0.1:8081" target="_self" class="fore2">我的商城</a>
						<a href="http://127.0.0.1:8081" target="_blank" class="fore3">返回商城首页</a>
					</div>
				</div>
				<div class="navitems">
					<ul>
						<li class="fore-1">
							<a href="/" target="_self" href="">首页</a>
						</li>
						<li class="fore-3">
							<div class="dl">
								<div class="dt">
									<span>账户设置</span>
									<b></b>
								</div>
								<div class="dd">
									<a href="/user/profile.html" target="_self">
										<span>个人资料</span>
									</a>
									<a href="/user/security.html" target="_self">
										<span>账户安全</span>
									</a>
									<a href="/user/bind.html" target="_self">
										<span>账号绑定</span>
									</a>
									<a href="/user/address.html" target="_self">
										<span>收货地址</span>
									</a>
								</div>
							</div>
						</li>
						<li class="fore-4">
							<a href="/user/message/internal.html">
								消息
							</a>
						</li>
						<li class="fore-4">
							<a href="/sso/logout">
								注销
							</a>
						</li>
					</ul>
				</div>

			</div>
		</div>
	
		<div id="content">
			<div class="content w1210 clearfix">