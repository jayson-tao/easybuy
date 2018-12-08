<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 右侧边栏 _start -->
		<div class="right-sidebar-con">
			<div class="right-sidebar-main">
				<div class="right-sidebar-panel">
					<div id="quick-links" class="quick-links">
						<ul>
							<li class="quick-area quick-login sidebar-user-trigger">
								<!-- 用户 -->
								<a href="javascript:void(0);" class="quick-links-a">
									<i class="setting"></i>
								</a>
								<div class="sidebar-user quick-sidebar">
									<i class="arrow-right"></i>
									<div class="sidebar-user-info">
										<!-- 没有登录的情况 _start -->
										<div class="SZY-USER-NOT-LOGIN" style="">
											<div class="user-pic">
												<div class="user-pic-mask"></div>
												<img src="/static/img/test/default_user_portrait_0.png">
											</div>
											<br>
											<p>
												你好！请
												<a href="/client/login">登录</a>
												|
												<a href="/client/reg" class="color">注册</a>
											</p>
										</div>
										<!-- 没有登录的情况 _end -->
										<!-- 有登录的情况 _start -->
										<div class="SZY-USER-ALREADY-LOGIN" style="display: none;">
											<div class="user-have-login">
												<div class="user-pic">
													<div class="user-pic-mask"></div>
													<img src="" class="SZY-USER-PIC">
												</div>
												<div class="user-info">
													<p>
														用&nbsp;&nbsp;&nbsp;户：
														<span class="SZY-USER-NAME"></span>
													</p>

												</div>
											</div>
											<p class="m-t-10">
												<span class="prev-login">
					上次登录时间：
					<span class="SZY-USER-LAST-LOGIN"></span>
												</span>
												<a href="http://127.0.0.1" class="btn account-btn" target="_blank">个人中心</a>
												<a href="http://127.0.0.1/trade/order" class="btn order-btn" target="_blank">订单中心</a>
											</p>
										</div>
										<!-- 有登录的情况 _end -->
									</div>
								</div>
							</li>
							<li class="sidebar-tabs">
								<!-- 购物车 -->
								<div class="cart-list quick-links-a sidebar-cartbox-trigger">
									<i class="cart"></i>
									<div class="span">购物车</div>
									<span class="ECS_CARTINFO">
								<span class="cart_num SZY-CART-COUNT">0</span>
									<div class="sidebar-cart-box">
										<h3 class="sidebar-panel-header">
										<a href="javascript:void(0);" class="title">
											<i class="cart-icon"></i>
											<em class="title">购物车</em>
										</a>
										<span class="close-panel"></span>
									</h3>
									</div>
									</span>
								</div>
							</li>
							<li class="sidebar-tabs">
								<a href="javascript:void(0);" class="mpbtn_history quick-links-a sidebar-historybox-trigger">
									<i class="history"></i>
								</a>
								<div class="popup">
									<font id="mpbtn_histroy">我看过的</font>
									<i class="arrow-right"></i>
								</div>
							</li>
							<!-- 如果当前页面有对比功能 则显示对比按钮 _start-->
							<li class="sidebar-tabs">
								<a href="javascript:void(0);" class="mpbtn-contrast quick-links-a sidebar-comparebox-trigger">
									<i class="contrast"></i>
								</a>
								<div class="popup">
									对比商品
									<i class="arrow-right"></i>
								</div>
							</li>
							<!-- 如果当前页面有对比功能 则显示对比按钮 _end-->
							<li>
								<a href="http://127.0.0.1/trade/collect" target="_blank" class="mpbtn_stores quick-links-a">
									<i class="stores"></i>
								</a>
								<div class="popup">
									我收藏的店铺
									<i class="arrow-right"></i>
								</div>
							</li>
							<li id="collectGoods">
								<a href="http://127.0.0.1/trade/collect" target="_blank" class="mpbtn_collect quick-links-a">
									<i class="collect"></i>
								</a>
								<div class="popup">
									我的收藏
									<i class="arrow-right"></i>
								</div>
							</li>
						</ul>
					</div>
					<div class="quick-toggle">
						<ul>

							<li class="quick-area">
								<a class="quick-links-a" href="javascript:void(0);">
									<i class="customer-service"></i>
								</a>
								<div class="sidebar-service quick-sidebar">
									<i class="arrow-right"></i>

									<div class="customer-service">
										<a target="_blank" href="#">
											<span class="icon-qq"></span> QQ
										</a>
									</div>

									<div class="customer-service">
										<a target="_blank" href="#">
											<span class="icon-ww"></span> 旺旺
										</a>
									</div>

								</div>
							</li>

							<li class="quick-area">
								<a class="quick-links-a" href="javascript:void(0);">
									<i class="qr-code"></i>
								</a>
								<div class="sidebar-code quick-sidebar">
									<i class="arrow-right"></i>
									<img src="/static/img/test/mall_wx_qrcode_0.jpg">
								</div>
							</li>
							<li class="returnTop" style="display: none;">
								<a href="javascript:void(0);" class="return_top quick-links-a">
									<i class="top"></i>
								</a>
								<div class="popup">
									返回顶部
									<i class="arrow-right"></i>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="">
					<!--红包 start-->
					<!--红包 end-->
					<!--购物车 start-->

					<div class="right-sidebar-panels sidebar-cartbox">
						<div class="sidebar-cart-box">
							<h3 class="sidebar-panel-header">
			<a href="javascript:void(0);" class="title" target="_blank">
				<i class="cart-icon"></i>
				<em class="title">购物车</em>
			</a>
			<span class="close-panel"></span>
		</h3>
							<div class="sidebar-cartbox-goods-list">

								<div class="cart-panel-main">
									<div class="cart-panel-content">

										<!-- 没有商品的展示形式 _start -->
										<div class="tip-box">
											<i class="tip-icon"></i>
											<div class="tip-text">
												您的购物车里什么都没有哦
												<br>
												<a class="color" href="" title="再去看看吧" target="_blank">再去看看吧</a>
											</div>
										</div>
										<!-- 没有商品的展示形式 _end-->

									</div>
								</div>

							</div>
						</div>
					</div>
					<!--购物车 end-->
					<!--浏览历史 start-->
					<!---->
					<div class="right-sidebar-panels sidebar-historybox">
						<h3 class="sidebar-panel-header">
		<a href="javascript:;" class="title">
			<i></i>
			<em class="title">我的足迹</em>
		</a>
		<span class="close-panel"></span>
	</h3>
						<div class="sidebar-panel-main">
							<div class="sidebar-panel-content sidebar-historybox-goods-list">
								<!---->
								<!---->
								<!-- 没有浏览历史的展示形式 _start -->
								<div class="tip-box">
									<i class="tip-icon"></i>
									<div class="tip-text">
										您还没有在商城留下任何足迹哦
										<br>
										<a class="color" href="">赶快去看看吧</a>
									</div>
								</div>
								<!-- 没有浏览历史的展示形式 _end-->
								<!---->
								<!---->
							</div>
						</div>
					</div>
					<!---->
					<!--浏览历史 end-->
					<!--对比列表 start-->

					<!--对比列表 start-->
					<div class="right-sidebar-panels sidebar-comparebox">
						<h3 class="sidebar-panel-header">
		<a href="javascript:void(0);" class="title">
			<i class="compare-icon"></i>
			<em class="title">宝贝对比</em>
		</a>
		<span class="close-panel"></span>
	</h3>
						<div>
							<div class="sidebar-panel-main sidebar-comparebox-goods-list">

								<div class="sidebar-panel-content compare-panel-content">

									<!-- 没有对比商品的展示形式 _start -->
									<div class="tip-box">
										<i class="tip-icon"></i>
										<div class="tip-text">
											您的对比宝贝什么都没有哦
											<br>
											<a class="color" href="">再去看看吧</a>
										</div>
									</div>
									<!-- 没有对比商品的展示形式 _end-->

								</div>
							</div>

						</div>
					</div>
					<!--对比列表 end-->

					<!--对比列表 end-->
				</div>
			</div>
		</div>
		<!-- 右侧边栏 _end -->