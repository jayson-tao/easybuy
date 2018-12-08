<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- 网站头像 -->
		<link type="text/css" rel="stylesheet" href="/static/css/iconfont.css">
		<link type="text/css" rel="stylesheet" href="/static/css/common.css">
		<!--整站改色 _start-->
		<link type="text/css" rel="stylesheet" href="/static/css/color-style.css">
		<!--整站改色 _end-->
		<link rel="stylesheet" href="/static/css/layer.css" id="layuicss-skinlayercss">
<link type="text/css" rel="stylesheet" href="/static/css/flow.css">
<title>支付结果 - 易购网</title>
</head>
<body>
<div class="header login-header w990">
			<div class="logo-info">
				<a href="javascript:;" onclick="goHome()" class="logo">
					<img src="/static/css/mall_logo_0.png">
				</a>
				<span class="findpw">支付中心</span>
			</div>
</div>
		
	<div class="content-bg">
		<div class="content-main w990">
			<c:if test="${payBill.state==2}">
			<!-- 已过期不能支付提示 -->
			<div class="payment-fail">
				<div class="payment-fail-con">
					<i></i>
					<div class="payment-fail-msg">
						<h3 class="color">支付已过期！</h3>
						<p>您在规定的时间内未完成付款，交易自动关闭，该支付过期后不能再进行支付</p>
						<p>
							您可前往 <a href="http://127.0.0.1" class="color">易购网商城</a> 重新选购商品并下单。
						</p>
					</div>
				</div>
			</div>
			<!-- end 已过期不能支付提示 -->
			</c:if>
			<c:if test="${payBill.state==1}">
			<!-- 支付成功提示 -->
			<div class="payment-success">
				<div class="payment-success-con">
					<i></i>
					<div class="payment-success-msg">
						<h3>支付成功！</h3>
						<p>恭喜您！您的支付已成功，我们会尽快处理您的而订单业务，请随时关注您的订单通知。</p>
						<p>
							您可前往订单中心 <a href="http://127.0.0.1/trade/order" class="color">我的订单</a> 查看所有订单的情况，也可前往  <a href="http://127.0.0.1" class="color">易购网商城</a> 继续购物。
						</p>
					</div>
				</div>
				<div class="payment-success-order">
					<p>以下交易单已支付成功！</p>
					<div class="success-order-list">
						<ul>
							<li class="first"><span class="transaction"> 交易单号： <font
									class="color"> <a href="http://127.0.0.1/trade/order/info/${payBill.businessType}-${payBill.businessKey}"
										title="点击查看订单" class="color">${payBill.unionPaySn}</a>
								</font>
							</span> <span class="payable"> 应付金额： <font class="color">￥${payBill.money * 0.01}</font>
							</span> <span class="delivery"> 由 <font> <a
										href="#" title="点击进入店铺"
										class="color">易购网官方自营二号店</a>
								</font> 发货
							</span> <span class="pay-btn"> <a
									href="http://127.0.0.1/trade/order/info/${payBill.businessType}-${payBill.businessKey}" class="submit-btn">查看订单</a>
							</span></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- end 支付成功提示 -->
			</c:if>
			<c:if test="${payBill.state==0}">
			<!-- 支付失败提示 -->
			<div class="payment-fail">
				<div class="payment-fail-con">
					<i></i>
					<div class="payment-fail-msg">
						<h3 class="color">尚未支付成功！</h3>
						<p>如果您已付款，可能因交易量激增导致交易单延迟处理（最长数秒至数分钟）</p>
						<p>
							您可稍后 <a href="" class="color">刷新本页面</a> 或前往 <a
								href="http://127.0.0.1/trade/order" class="color">我的订单</a> 查看支付情况
						</p>
					</div>
				</div>
				<div class="payment-fail-order">
					<p>以下交易单尚未支付成功，请您尽快完成支付！</p>
					<div class="fail-order-list">
						<ul>
							<li class="first"><span class="transaction"> 交易单号： <font
									class="color"> <a href="http://127.0.0.1/trade/order/info/${payBill.businessType}-${payBill.businessKey}"
										 title="点击查看订单" class="color">${payBill.unionPaySn}</a>
								</font>
							</span> <span class="payable"> 应付金额： <font class="color">￥${payBill.money * 0.01}</font>
							</span> <span class="delivery"> 由 <font> <a
										href="#" title="点击进入店铺"
										class="color">易购网官方自营二号店</a>
								</font> 发货
							</span> <span class="pay-btn"> <a
									href="/gateway?sn=${payBill.unionPaySn}" class="submit-btn">重新付款</a>
							</span></li>
						</ul>
					</div>
				</div>
				<div class="payment-fail-reason">
					<h2>付款遇到问题了，先看看是不是由于下面的原因：</h2>
					<ul>
						<li>
							<h3>所需支付金额超过了银行支付限额</h3>
							<p>建议您登录网上银行提高上限额度，或是分若干次充值到您的账户余额，即能使用账户余额轻松支付。</p>
						</li>
						<li>
							<h3>支付宝、百度钱包或者网银页面显示错误或者空白</h3>
							<p>部分网银对不同浏览器的兼容性有限，导致无法正常支付，建议您使用IE浏览器进行支付操作。</p>
						</li>
						<li>
							<h3>网上银行已扣款，交易单仍显示“未付款”</h3>
							<p>可能由于银行的数据没有即时传输，请不要担心，请稍后刷新页面查看。如较长时间仍显示未付款，可联系客服（028-88888888）为您解决。</p>
						</li>
					</ul>
				</div>
			</div>
			<!-- end 支付失败提示 -->
			</c:if>
			
		</div>
	</div>


<!-- 底部 -->
		<div class="site-footer">

			<div class="footer-desc-copyright">

				<p class="footer-ecscinfo">
					<a href="#">首页</a>
					|

					<a href="#">隐私保护</a>
					|

					<a href="#">联系我们</a>
					|

					<a href="#">免责条款</a>
					|

					<a href="#">公司简介</a>
					|

					<a href="#">意见反馈</a>

					|
					<a rel="nofollow"  href="#">会员登录</a>
					|
					<a rel="nofollow"  href="http://bbs.yaorange.cn/">会员论坛</a>
					|
					<a href="javascript:;" rel="nofollow">客服热线028-86261949</a>
				</p>
				<p class="footer-otherlink">
					<a title="易购商城"  href="http://yaorange.cn">易购商城</a>

					|

					<a title="菁鱼课堂"  href="http://www.yaorange.cn">菁鱼课堂</a>

					|

					<a title="资讯速递"  href="http://www.yaorange.cn">资讯速递</a>

					|

					<a title="快递查询"  href="http://m.kuaidi100.com">快递查询</a>

					|

					<a title="论坛"  href="http://bbs.yaorange.com/forum.php">会员论坛</a>

					|

					<a title="易购网"  href="http://www.yaorange.cn">易购网</a>

				</p>

				<p class="footer-beian"> ICP备案证书号:
					<a rel="nofollow"  href="#">蜀ICP备88888888号-1</a>
					<a rel="nofollow"  href="#"><i></i>蜀公网安备 45323525326664号</a>
				</p>
				<p class="footer-Copyright">Copyright &copy; 2017
					<a  style="margin:0;padding:0;" href="http://www.yaorange.com/">yaorange.cn</a> All Rights Reserved. </p>
				<p>&nbsp;</p>

				<p class="footer-fp-img">
					<a  href="#"><img src="/static/img/test/kxwz.png"></a>
					<a  href="#"><img src="/static/img/test/smyz.png"></a>
					<a  href="#"><img src="/static/img/test/cxyz.jpg"></a>
					<a  href="#"><img src="/static/img/test/hyyz.png"></a>
					<a  href="#"><img src="/static/img/test/jpfw.png"></a>
				</p>
			</div>

		</div>
		<!-- 底部 _end-->
</body>
</html>