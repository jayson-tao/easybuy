<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>


<!-- 正文，由view提供 -->
<div class="con-right fr">
<!-- 动态登录，设置密码 star -->
<script type="text/javascript" src="/static/js/user_center.js"></script>
<div class="set-password" style="display: none">
	您尚未设置登录密码，赶快去
	<a href="http://www.yaorange.cn/user/security/edit-password" target="_self" title="前往去设置登录密码">设置密码</a>
	吧！
</div>
<!-- 动态登录，设置密码 end -->
<div class="con-right-left fl">
	<div class="user-info">
		<!-- 我的账户相关信息 star -->
		<div class="myInfo">
			<!-- 弹出 star -->
			<div class="tipsBox">
				<div class="myGrade">
					<h3>我的等级信息</h3>
					<p>当前等级：初级会员一级</p>
					<p>
						<span>
							我的成长值：
							<a href="http://www.yaorange.cn/user/growth-value" class="second-color" target="_self">0</a>
						</span>
												<span>
							再积累
							<font class="second-color">2</font>
							成长值即可升级至 初级会员二级
						</span>
											</p>
				</div>
				<div class="myAccount">
					<h3>我的账户信息</h3>
					<p>
						个人信息：未完善，请
						<a href="http://www.yaorange.cn/user/profile" target="_self" class="btn-link">尽快完善</a>
											</p>
					<p>
						实名认证：未完善，请
						<a href="http://www.yaorange.cn/user/profile" target="_self" class="btn-link">尽快完善</a>
											</p>
					<p>
												<span>邮箱：4*******1@qq.com</span>
						 						<span>
							支付密码：							<a href="http://www.yaorange.cn/user/security/edit-surplus-password" target="_self" class="btn-link">立即开启</a>
													</span>
					</p>
				</div>
			</div>
			<!-- 弹出 end -->

			<div class="myInfoFront">
				<div class="imgHeaderBox">
					<a href="http://www.yaorange.cn/user/center.html" class="headerImg">

						<img src="/static/img/default_user_portrait_0.png">

					</a>
					<div class="updateInfo">
						<div class="opacityBox"></div>
						<a href="http://www.yaorange.cn/user/profile" class="realBox">修改资料</a>
					</div>
				</div>
				<p class="name">
					<a href="http://www.yaorange.cn/user/center.html">

						
						SZY083SDPF5239
						

					</a>
				</p>
				<p class="VIP">
					<a href="http://www.yaorange.cn/user/growth-value.html" target="_blank" class="imgVip imgVip1">
						<img src="/static/img/14788627664630.gif">
					</a>
					<a href="http://www.yaorange.cn/user/growth-value.html" target="_blank" class="txtExplain">初级会员一级</a>
				</p>
				<a href="http://www.yaorange.cn/user/security.html" class="safeText">账户安全</a>
				<span class="safeGrade">低</span>
				<div class="progressBar">
					<span class="progress progress2"></span>
				</div>
				<p class="safe-grade-info">
					<span class="email">
												<a href="http://www.yaorange.cn/user/security/edit-email.html" title="邮箱已绑定">
							<i></i>
							已绑定
						</a>
											</span>
					<span class="phone">
												<a href="http://www.yaorange.cn/user/security/edit-mobile.html" title="手机未绑定">
							<i></i>
							未绑定
						</a>
											</span>
					<span class="pay-password">
												<a href="http://www.yaorange.cn/user/security/edit-surplus-password.html" title="支付密码未开启">
							<i></i>
							未开启
						</a>
											</span>
				</p>
			</div>
		</div>

		<!-- 我的账户相关信息 end -->
		<!-- 我的账户财产以及订单 star -->
		<div class="myCapital">
			<div class="money">
				<ul class="clearfix">
					<li class="first">
						<div class="title">
							<span>我的余额</span>
						</div>

						<div class="pic">
							<a href="http://www.yaorange.cn/user/capital-account.html" title="我的余额">
								<i class="user_bg"></i>
							</a>
						</div>
						<p>
							<!-- <a href="javascript:show_surplus(1061)">
								<span id="surplus_div">显示余额</span>
							</a> -->
							<a href="http://www.yaorange.cn/user/capital-account.html">0</a>
						</p>
					</li>
					<li class="second">
						<div class="title">
							<span>我的成长值</span>
						</div>
						<div class="pic">
							<a href="http://www.yaorange.cn/user/growth-value.html" title="我的成长值">
								<i class="user_bg"></i>
							</a>
						</div>
						<p>

							<a href="http://www.yaorange.cn/user/growth-value.html">0</a>
						</p>
					</li>
					<li class="third">
						<div class="title">
							<span>我的优惠券</span>
						</div>
						<div class="pic">
							<a href="http://www.yaorange.cn/user/bonus.html" title="我的优惠券">
								<i class="user_bg"></i>
							</a>
						</div>
						<p>
							<a href="http://www.yaorange.cn/user/bonus.html">0张</a>
						</p>
					</li>
				</ul>
			</div>
			<div class="pending">
				<ul>
					<li class="first">
						<a href="http://www.yaorange.cn/user/order/list?type=unpayed" target="_self">
							待付款
							<font class="second-color">0</font>
						</a>
					</li>
					<li>
						<a href="http://www.yaorange.cn/user/order/list?order_status=unshipped" target="_self">
							待发货
							<font class="second-color">0</font>
						</a>
					</li>
					<li>
						<a href="http://www.yaorange.cn/user/order/list?order_status=shipped" target="_self">
							待收货
							<font class="second-color">0</font>
						</a>
					</li>
					<li>
						<a href="http://www.yaorange.cn/user/order/list?evaluate_status=unevaluate" target="_self">
							待评价
							<font class="second-color">0</font>
						</a>
					</li>
					<li>
						<a href="http://www.yaorange.cn/user/order/list?order_status=backing" target="_self">
							退款
							<font class="second-color">0</font>
						</a>
					</li>
				</ul>
			</div>
		</div>
		<!-- 我的账户财产以及订单 end -->
	</div>
	<div class="container">
		<ul class="tabs">
			<li class="active">
				<h3>
					<a href="http://www.yaorange.cn/user/center.html#tab1">商品收藏</a>
				</h3>
			</li>
			<li class="">
				<h3>
					<a href="http://www.yaorange.cn/user/center.html#tab2">店铺收藏</a>
				</h3>
			</li>
		</ul>
		<!-- 根据tab切换来判断查看更多的href,title的值 star -->
		<a href="http://www.yaorange.cn/user/collect/goods.html" target="_self" title="查看全部收藏的商品" class="more">查看更多</a>
		<!-- 根据tab切换来判断查看更多的href,title的值 end -->
		<div class="tab-container">
			<div id="tab1" class="model tab-con collect-goods" style="display: block;">
				<div class="model-con">
					<!--   -->
					<ul>
						

						<li class="first">
							<a href="http://www.yaorange.cn/goods/10.html" title="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜" target="_blank" class="img">
								<img src="/static/img/14789686200823.png" alt="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜">
							</a>
							<a href="http://www.yaorange.cn/goods/10.html" title="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜" target="_blank" class="name">加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜</a>
							<p class="second-color">￥28.80</p>
						</li>

						

						<li class="first">
							<a href="http://www.yaorange.cn/goods/9.html" title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子" target="_blank" class="img">
								<img src="/static/img/14789669544048.png" alt="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子">
							</a>
							<a href="http://www.yaorange.cn/goods/9.html" title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子" target="_blank" class="name">紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子</a>
							<p class="second-color">￥15.90</p>
						</li>

						

						<li class="first">
							<a href="http://www.yaorange.cn/goods/3078.html" title="2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋" target="_blank" class="img">
								<img src="/static/img/test1.jpg" alt="2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋">
							</a>
							<a href="http://www.yaorange.cn/goods/3078.html" title="2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋" target="_blank" class="name">2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋</a>
							<p class="second-color">￥36.90</p>
						</li>

						

						<li class="first">
							<a href="http://www.yaorange.cn/goods/876.html" title="冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋" target="_blank" class="img">
								<img src="/static/img/test2.jpg" alt="冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋">
							</a>
							<a href="http://www.yaorange.cn/goods/876.html" title="冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋" target="_blank" class="name">冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋</a>
							<p class="second-color">￥59.00</p>
						</li>

						

						<li class="first">
							<a href="http://www.yaorange.cn/goods/409.html" title="2016秋冬新款韩版毛呢外套女中长款大码加厚修身显瘦学生呢子大衣" target="_blank" class="img">
								<img src="/static/img/TB1CPIxOXXXXXaCXXXXXXXXXXXX_!!0-item_pic.jpg" alt="2016秋冬新款韩版毛呢外套女中长款大码加厚修身显瘦学生呢子大衣">
							</a>
							<a href="http://www.yaorange.cn/goods/409.html" title="2016秋冬新款韩版毛呢外套女中长款大码加厚修身显瘦学生呢子大衣" target="_blank" class="name">2016秋冬新款韩版毛呢外套女中长款大码加厚修身显瘦学生呢子大衣</a>
							<p class="second-color">￥88.00</p>
						</li>

						
					</ul>

					
				</div>
			</div>
			<div id="tab2" class="model tab-con collect-shop" style="display: none;">
				<div class="model-con">
					<!--   -->
					<ul>
						
						<li class="first">
							<a href="http://www.yaorange.cn/shop/6.html" title="易购物官方自营二号店" target="_blank" class="img">
								<div class="mask"></div>

								<img src="/static/img/default_shop_image_0.gif" alt="易购物官方自营二号店">
							</a>
							<a href="http://www.yaorange.cn/shop/6.html" title="" target="_blank" class="name">易购物官方自营二号店</a>
						</li>
						

					</ul>
					
				</div>
			</div>
		</div>
	</div>
	<!-- 根据浏览，猜您喜欢 star -->
		<div id="user_like" class="model history-like"><h3>
	<i></i>
	<span>根据浏览，猜您喜欢</span>
	<a href="javascript:change_like(1)" target="_self" title="换一批">
		换一批
		<i></i>
	</a>
</h3>
<div class="model-con">
	<ul>
				<li>
			<a href="http://www.yaorange.cn/goods/4" title="加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季" target="_blank" class="img">
				<img src="/static/img/14788784646707.jpg" alt="加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季">
			</a>
			<div class="goods-info">

				<a href="http://www.yaorange.cn/goods/4" title="加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季" target="_blank" class="name">加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季</a>
				<p class="second-color">￥29.50</p>
			</div>
		</li>
				<li>
			<a href="http://www.yaorange.cn/goods/7" title="浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤" target="_blank" class="img">
				<img src="/static/img/14789657995869.png" alt="浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤">
			</a>
			<div class="goods-info">

				<a href="http://www.yaorange.cn/goods/7" title="浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤" target="_blank" class="name">浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤</a>
				<p class="second-color">￥29.90</p>
			</div>
		</li>
				<li>
			<a href="http://www.yaorange.cn/goods/22" title="冬季超厚打底裤女外穿加绒加厚保暖秋冬高腰显瘦灰色一体踩脚棉裤" target="_blank" class="img">
				<img src="/static/img/test3.jpg" alt="冬季超厚打底裤女外穿加绒加厚保暖秋冬高腰显瘦灰色一体踩脚棉裤">
			</a>
			<div class="goods-info">

				<a href="http://www.yaorange.cn/goods/22" title="冬季超厚打底裤女外穿加绒加厚保暖秋冬高腰显瘦灰色一体踩脚棉裤" target="_blank" class="name">冬季超厚打底裤女外穿加绒加厚保暖秋冬高腰显瘦灰色一体踩脚棉裤</a>
				<p class="second-color">￥25.00</p>
			</div>
		</li>
				<li>
			<a href="http://www.yaorange.cn/goods/30" title="加绒韩版黑色打底裤女秋外穿薄款九分裤长裤大码弹力小脚裤铅笔裤" target="_blank" class="img">
				<img src="/static/img/TB1ddH2LFXXXXaBXXXXXXXXXXXX_!!0-item_pic.jpg" alt="加绒韩版黑色打底裤女秋外穿薄款九分裤长裤大码弹力小脚裤铅笔裤">
			</a>
			<div class="goods-info">

				<a href="http://www.yaorange.cn/goods/30" title="加绒韩版黑色打底裤女秋外穿薄款九分裤长裤大码弹力小脚裤铅笔裤" target="_blank" class="name">加绒韩版黑色打底裤女秋外穿薄款九分裤长裤大码弹力小脚裤铅笔裤</a>
				<p class="second-color">￥39.00</p>
			</div>
		</li>
			</ul>
</div></div>
</div>
<div class="con-right-right fr">
	<!-- 商城公告 star -->
	<div class="model shop-notice" style="display: none">
		<h3>
			<i class="bg-color"></i>
			<span>商城公告</span>
		</h3>
		<div class="notice-con">用户中心公告！双十一大促销！因可能存在系统缓存、页面更新导致价格变动异常等不确定性情况出现，如您发现活动商品标价或促销信息有异常，请您立即联系我们，以便我们及时补正！</div>
	</div>
	<!-- 商城公告 end -->
	<!-- 我的购物车 star -->
	<div class="model model-spe cart">
		<h3>
			<i class="bg-color"></i>
			<span>我的购物车</span>
		</h3>
		<div class="model-con">
			<!-- *购物城中商品数量为0时 start-->
						<!-- *购物城中商品数量为0时 end-->
			<div>
				<ul>
					
					<!-- -->
					<li>

						<a href="http://www.yaorange.cn/goods/3039.html" title="自粘墙纸贴画创意电视背景墙砖纹壁纸3d立体墙贴客厅卧室装饰贴纸" target="_blank" class="img">
							<img src="/static/img/TB2d7ygdlyN.eBjSZFkXXb8YFXa_!!1732113555.jpg" alt="自粘墙纸贴画创意电视背景墙砖纹壁纸3d立体墙贴客厅卧室装饰贴纸">
						</a>
						<p class="price">￥11.80</p>
					</li>
					
					<!-- -->
					<li>

						<a href="http://www.yaorange.cn/goods/1933.html" title="天天特价包包2016新款秋冬斜挎包韩版手提包流苏贝壳包女包单肩包" target="_blank" class="img">
							<img src="/static/img/test4.jpg" alt="天天特价包包2016新款秋冬斜挎包韩版手提包流苏贝壳包女包单肩包">
						</a>
						<p class="price">￥29.99</p>
					</li>
					
					<!-- -->
					<li>

						<a href="http://www.yaorange.cn/goods/80.html" title="【周黑鸭旗舰店_锁鲜】气调盒装卤鸭脖320g 武汉特产食品零食小吃" target="_blank" class="img">
							<img src="/static/img/TB1lewkJpXXXXbwXFXXXXXXXXXX_!!0-item_pic.jpg" alt="【周黑鸭旗舰店_锁鲜】气调盒装卤鸭脖320g 武汉特产食品零食小吃">
						</a>
						<p class="price">￥36.80</p>
					</li>
					
					<!-- -->
					<li>

						<a href="http://www.yaorange.cn/goods/69.html" title="良品铺子甘栗仁小栗子仁板栗仁零食坚果干果炒货休闲食品糖炒板栗原味80g*3袋" target="_blank" class="img">
							<img src="/static/img/TB1WC_WMVXXXXaLaXXXXXXXXXXX_!!0-item_pic.jpg" alt="良品铺子甘栗仁小栗子仁板栗仁零食坚果干果炒货休闲食品糖炒板栗原味80g*3袋">
						</a>
						<p class="price">￥19.90</p>
					</li>
					
					
					

				</ul>
				<div class="see-all">
					<a href="http://www.yaorange.cn/cart.html" target="_blank">
						查看购物车(
						<em class="second-color">5</em>
						)
					</a>
				</div>
			</div>

					</div>
	</div>
	<!-- 我的购物车 end -->
	<!-- 我的足迹 star -->
	<div class="model model-spe history">
		<h3>
			<i class="bg-color"></i>
			<span>我的足迹</span>
		</h3>
		<div class="model-con">
			
			<!-- *积分兑换的商品数量为0时 end-->
			<div>
				<ul>
					
					
					<li>
						<a href="http://www.yaorange.cn/goods/10.html" title="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜 黑色 均码" target="_blank" class="img">
							<img src="/static/img/14789706798322.png" alt="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜 黑色 均码">
						</a>
						<p class="price">￥28.80</p>
					</li>
					
					
					
					<li>
						<a href="http://www.yaorange.cn/goods/9.html" title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子 经典版黑色 均码" target="_blank" class="img">
							<img src="/static/img/14789700377694.png" alt="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子 经典版黑色 均码">
						</a>
						<p class="price">￥15.90</p>
					</li>
					
					
					
					<li>
						<a href="http://www.yaorange.cn/goods/3078.html" title="2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋米色[时尚版] 36" target="_blank" class="img">
							<img src="/static/img/TB2lg1Fcp5N.eBjSZFvXXbvMFXa_!!1737892074.jpg" alt="2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋米色[时尚版] 36">
						</a>
						<p class="price">￥39.90</p>
					</li>
					
					
					
					<li>
						<a href="http://www.yaorange.cn/goods/876.html" title="冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋黑色 36 标准鞋码" target="_blank" class="img">
							<img src="/static/img/TB2nG9HXByN.eBjSZFgXXXmGXXa_!!678391467.jpg" alt="冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋黑色 36 标准鞋码">
						</a>
						<p class="price">￥59.00</p>
					</li>
					
					
					
					
				</ul>
				<div class="see-all">
					<a href="http://www.yaorange.cn/user/history.html" target="_blank">
						查看全部(
						<em class="second-color">5</em>
						)
					</a>
				</div>
			</div>
			
		</div>
	</div>
	<!-- 我的足迹 end-->
</div></div>


<%@include file="/WEB-INF/views/footer.jsp"%>