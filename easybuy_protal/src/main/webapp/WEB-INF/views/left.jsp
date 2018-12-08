<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入左侧导航条文件 -->
				<div class="con-left fl">
					<div class="nav-list">
						<div class="func func1">
							<p class="title">
								<i></i>
								<span>会员中心</span>
							</p>
							<a href="/" class="item">
								<span>欢迎页</span>
								<i></i>
							</a>
							<a href="/user/profile" class="item ">
								<span>个人资料</span>
								<i></i>
							</a>
							<a href="/user/secret" class="item ">
								<span>账户安全</span>
								<i></i>
							</a>

							<a href="/user/address" class="item ">
								<span>收货地址</span>
								<i></i>
							</a>
							<a href="/user/message" class="item ">
								<span>我的消息</span>
								<i></i>
							</a>
							<a href="/user/growth" class="item ">
								<span>我的成长值</span>
								<i></i>
							</a>
						</div>
						<div class="func func2">
							<p class="title">
								<i></i>
								<span>交易中心</span>
							</p>
							<a href="/trade/order" class="item ">
								<span>我的订单</span>
								<i></i>
							</a>
							<a href="/trade/comment" class="item ">
								<span>我的评价</span>
								<i></i>
							</a>
							<a href="/trade/refund" class="item ">
								<span>退款退货</span>
								<i></i>
							</a>
							
							<a href="/trade/complaint" class="item ">
								<span>我的投诉</span>
								<i></i>
							</a>
							<a href="/trade/collect" class="item ">
								<span>我的收藏</span>
								<i></i>
							</a>
						</div>
						<div class="func func3">
							<p class="title">
								<i></i>
								<span>资金中心</span>
							</p>
							<a href="/account/home" class="item ">
								<span>我的资金账户</span>
								<i></i>
							</a>
							<a href="/account/recharge" class="item  ">
								<span>我的充值</span>
								<i></i>
							</a>
							<a href="/account/points" class="item">
								<span>我的积分</span>
								<i></i>
							</a>
							<a href="/account/coupon" class="item ">
								<span>我的优惠券</span>
								<i></i>
							</a>
						</div>
						<div class="func func4">
							<p class="title">
								<i></i>
								<span>服务中心</span>
							</p>
							<a href="#" class="item">
								<span>退换货政策</span>
								<i></i>
							</a>
							<a href="#" class="item">
								<span>操作帮助</span>
								<i></i>
							</a>
						</div>
					</div>
				</div>
				<script>
					//默认选中菜单
					function initSelectMenu(){
						var href = location.href;//http://xxxx:xx/user/profile?xxx=xxxx
						var appPath = "/";
						href = href.substring(href.indexOf('://')+3);
						var index = href.indexOf('/');
						if(index>=0){
							href = href.substring(index);
							var index2 = href.indexOf('?');
							if(index2>=0){
								appPath = href.substring(0,index2);
							}else{
								appPath = href;
							}
						}
						if(appPath=='') appPath = '/';
						$('.nav-list').find('.curs').removeClass('curs');
						$('.nav-list').find('[href="'+appPath+'"]').addClass('curs');
					}
					initSelectMenu();
				</script>