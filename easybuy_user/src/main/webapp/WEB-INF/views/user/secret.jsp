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
								<li class="active">账户安全</li>
							</ul>
						</div>
						<div class="content-info">
							<div class="safe-user-info">
								<h3>您的账户信息</h3>
								<div class="user-pic">
									<span>
										<img src="/static/img/14865372927544.png">
									</span>
								</div>
								<div class="user-intro">
									<dl>
										<dt>登录账号：</dt>
										<dd>SZY083SDPF5239</dd>
									</dl>
									<dl>
										<dt>绑定邮箱：</dt>
										<dd> 4*******1@qq.com </dd>
									</dl>
									<dl>
										<dt>绑定手机：</dt>
										<dd> 未绑定 </dd>
									</dl>
									<dl>
										<dt>上次登录：</dt>
										<dd>
											2017-02-08 15:13:40 |
											<span> IP地址：</span> 100.97.126.14 [ 运营商级NAT(宽带运营商局域网)- ] <span>
							（不是您登录的？请立即
							<a href="http://www.yaorange.com/user/security/edit-password" class="color">“更改密码”</a>
							）。
						</span>
										</dd>
									</dl>
								</div>
							</div>
							<div class="warn-box">
								<p>
									<span>当前安全级别：</span>
									<strong>低</strong>
									<i class="validated2"></i>
									<span>（建议您启动全部安全设置，以保障账户及资金安全）</span>
								</p>
							</div>
							<div id="safe" class="safe">
								<div class="safe-list">
									<div class="fore1">
										<s class="safe-bg2"></s>
										<strong>登录密码</strong>
									</div>
									<div class="fore2">
										<span>已设置登录密码。</span>
									</div>
									<div class="fore3">
										<a href="http://www.yaorange.com/user/security/edit-password" class="btn btn-specil">修改密码</a>
									</div>
								</div>
								<div class="safe-list">
									<div class="fore1">
										<s class="safe-bg2"></s>
										<strong>邮箱验证</strong>
										<b class="icon-id01"></b>
									</div>
									<div class="fore2">
										<span>
						 您绑定的邮箱：
						<font class="color">4*******1@qq.com</font>
						，该邮箱可用于账号登录，快速找回登录密码、支付密码，接收账户余额变动提醒等。 					</span>
									</div>
									<div class="fore3">
										<a href="http://www.yaorange.com/user/security/edit-email" class="btn btn-specil">修改邮箱</a>
									</div>
								</div>
								<div class="safe-list">
									<div class="fore1">
										<s class="safe-bg1"></s>
										<strong>手机验证</strong>
										<b class="icon-id01d"></b>
									</div>
									<div class="fore2">
										<span>
						 绑定后，可用于账号登录，快速找回登录密码、支付密码，接收账户余额变动提醒等。 					</span>
									</div>
									<div class="fore3">
										<a href="http://www.yaorange.com/user/security/edit-mobile" class="btn ">绑定手机</a>
									</div>
								</div>
								<div class="safe-list">
									<div class="fore1">
										<s class="safe-bg1"></s>
										<strong>支付密码</strong>
										<!-- 未开启标签样式 注意：如果已开启标签样式为“icon-id02” _star -->
										<b class="icon-id02d"></b>
										<!-- 未开启标签样式  _end -->
									</div>
									<div class="fore2">
										<span>启用支付密码后，可保障您账户余额的支付安全,在使用账户资产时，需通过支付密码进行支付认证。</span>
									</div>
									<div class="fore3">
										<a href="http://www.yaorange.com/user/security/edit-surplus-password" class="btn">开启支付密码</a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- 管理支付密码弹框 _star -->
					<div id="modal-box">
						<div class="modal-box-con pay-info">
							<p class="end-info">您的支付密码已开启！</p>
							<p>
								<a href="http://www.yaorange.com/user/security/close-surplus-password" title="关闭支付密码" class="btn">关闭支付密码</a>
								<a href="http://www.yaorange.com/user/security/edit-surplus-password" title="修改支付密码" class="btn">修改支付密码</a>
							</p>
							<p>
								<a href="http://www.yaorange.com/user/security/edit-surplus-password" title="前去找回密码">忘记支付密码？</a>
							</p>
						</div>
					</div>
					<script type="text/javascript">
						$("#btn").click(function() {
							var modal = $.modal({
								title: '管理支付密码',
								content: $('#modal-box').html(),
							});
						});
					</script>
					<!-- 管理支付密码弹框 _end -->
				</div>
				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>