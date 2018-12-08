<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common-link.jsp" %>
		<title>易购网 - 购我所爱 I LOVE BUY</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
	</head>
	<body class="pace-done">
		<%@include file="/WEB-INF/views/common-header-top.jsp" %>
		<%@include file="/WEB-INF/views/common-header.jsp" %>
		<%@include file="/WEB-INF/views/common-nav-other.jsp" %>
		<!-- 开始：主要区域内容 -->
		<!-- css -->
		<link type="text/css" rel="stylesheet" href="/static/css/goods.css">
		<!-- 地区选择器 -->
		<script type="text/javascript" src="/static/js/jquery.region.js"></script>
		<script type="text/javascript" src="/static/js/jquery.widget.js"></script>
		<script type="text/javascript" src="/static/js/jquery.history.js"></script>
		<div class="w1210">
			<div class="breadcrumb clearfix">
				<a href="/" class="index">首页</a>
				<c:forEach var="bread" items="${breads}">
				<span class="crumbs-arrow">&gt;</span>
				<div class="crumbs-nav crumbs-nav0">
					<a class="crumbs-title" href="/list?productType=${bread.currentType.id}">${bread.currentType.name}<i class="icon"></i></a>
					<div class="crumbs-drop">
						<ul class="crumbs-drop-list">
							<c:forEach var="type" items="${bread.otherTypes}">
							<li><a href="/list?productType=${type.id}">${type.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				</c:forEach>
				<span class="crumbs-arrow">&gt;</span>
				<span class="last">${product.name}</span>
			</div>


			<!-- 商品详细信息 -->
			<div class="goods-info">
			<!-- 商品图片以及相册 _star-->
			<div id="preview" class="preview">
			<!-- 商品相册容器 -->
			<div class="goodsgallery"></div>
			<script id="SZY_SKU_IMAGES" type="text">
			[<c:forEach var="img" items="${product.images}" varStatus="st"><c:if test="${st.index==0}">"${img}"</c:if><c:if test="${st.index>0}">,"${img}"</c:if></c:forEach>]
			</script>

			<script type="text/javascript">
				// 图片相册
				var images = [];
				var imgArr = $.parseJSON($("#SZY_SKU_IMAGES").html());
				for(var i=0;i<imgArr.length;i++){
					var arr = [];
					var imgKey = imgArr[i];
					arr[0] = 'http://pijbgt8k2.bkt.clouddn.com/'+imgKey+'?imageView2/1/w/60/h/60';
					arr[1] = 'http://pijbgt8k2.bkt.clouddn.com/'+imgKey+'?imageView2/1/w/400/h/400';
					arr[2] = 'http://pijbgt8k2.bkt.clouddn.com/'+imgKey+'?imageView2/1/w/460/h/460';
					images[i] = arr;
				}
				$(".goodsgallery").goodsgallery({
					images: images
				});
			</script>
			<!--相册 END-->
					<div class="goods-gallery-bottom">
						<a href="javascript:void(0);" class="goods-compare compare-btn fr add-compare " data-goods-id="${product.id}" data-sku-id="6163" data-image-url="${product.images[0]}">
							<i></i> 对比
						</a>

						<a href="javascript:void(0);" class="goods-col fr collect-goods" data-goods-id="${product.id}">
							<i></i> <span>收藏商品 </span>
						</a>

						<div class="bdsharebuttonbox fr bdshare-button-style0-16" data-bd-bind="XXXXXXXXX">
							<a class="bds_more" href="#" data-cmd="more" style="background: none; color: #999; line-height: 25px; height: 25px; margin: 0px 10px; padding-left: 20px; display: block;">
								<i style="width: 13px; height: 13px; background: transparent url(/static/css/goods-icon.png) no-repeat -113px -65px; vertical-align: middle; display: inline-block;"></i> 分享
							</a>
						</div>
					</div>

					<script type="text/javascript">
						window._bd_share_config = {
							"common": {
								"bdSnsKey": {},
								"bdText": "感觉不错，分享一下~",
								"bdMini": "2",
								"bdMiniList": false,
								"bdPic": "http://68products.oss-cn-beijing.aliyuncs.com/taobao-yun-images/41458920633/TB2K2cAaICO.eBjSZFzXXaRiVXa_!!1739732836.jpg?x-oss-process=image/resize,m_pad,limit_0,h_320,w_320",
								"bdStyle": "0",
								"bdSize": "16"
							},
							"share": {}
						};
						with(document) {
							0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = '//bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
						}
					</script>
				</div>
				<!-- 商品图片以及相册 _end-->

				<!-- 商品详细信息 _star-->
				<div class="detail-info">
					<form action="" method="post" name="" id="">
						<!-- 商品名称 -->
						<h1 class="goods-name SZY-GOODS-NAME">${product.name}</h1>
						<!-- 商品简单描述 -->
						<p class="goods-brief second-color">${product.subName}</p>

						<div class="goods-price">
							<!-- 商品不同的价格 -->
							<div class="show-price">
								<span class="price">市场价</span>
								<font class="market-price SZY-MARKET-PRICE">￥0.00</font>
							</div>
							<div class="realy-price">
								<div class="now-prices">
									<span class="price">售&nbsp;&nbsp;&nbsp;价</span>
									<strong class="p-price second-color SZY-GOODS-PRICE">￥0.00</strong>
								</div>
							</div>

							<!-- 商品赠品 -->
							<div class="prom-gift SZY-GIFT-LIST" style="display: none;">
								<div class="dt">买即送</div>
								<div class="dd">
									<span class="prom-gift-label SZY-GIFT-LABEL">
										<em>赠品</em>
									</span>
								</div>
								<div>赠完为止</div>
							</div>
						</div>

						<!-- 在售的商品 _start -->
						<!-- 运费 -->
						<div class="freight">
							<div class="dt">配送至</div>
							<div class="dd">
								<div class="post-age">
									<div class="region-chooser-container" style="z-index: 3"></div>
									<div class="post-age-info">
										<p>
											<span class="freight-info"></span>
										</p>
									</div>
								</div>
							</div>
						</div>
						<!-- 服务 -->
						<div class="freight">
							<div class="dt">服&nbsp;&nbsp;&nbsp;务</div>
							<div class="dd">
								<div class="post-age">
									由 <a href="/" target="_blank" class="color">易购网官方自营二号店</a>
									负责发货，并提供售后服务。
								</div>
							</div>
						</div>
						<!-- 评价、销量、积分 -->
						<div class="info-other">
							<ul class="other">
								<li>
									<p>
										累积评价
										<span>
										<a id="evaluate_num" href="#" class="second-color">5人评价</a>
										</span>
									</p>
								</li>
								<li>
									<p>
										累计销量
										<span class="second-color">0</span>
									</p>
								</li>
								<li class="last">
									<p>
										赠送积分
										<span class="second-color">0</span>
									</p>
								</li>
							</ul>
						</div>

						<div class="choose">
							<!-- 商品规格 -->
							<c:forEach var="keyName" items="${keyNames}">
							<dl class="attr">
								<dt class="dt">${keyName}</dt>
								<dd class="dd">
									<ul>
										<c:forEach var="op" items="${keyNameAndValueIdAndValueName[keyName]}">
										<li class="goods-spec-item" data-spec-id="${op.k}" data-is-default="0">
											<a href="javascript:void(0);" title="${op.v}">
												<span class="value-label">${op.v}</span>
											</a>
										</li>
										</c:forEach>
									</ul>
								</dd>
							</dl>
							</c:forEach>
							<!-- end 商品规格 -->

							<!-- 购买数量 -->
							<dl class="amount">
								<dt class="dt">数量</dt>
								<dd class="dd">
									<span class="amount-widget">
								<input type="text" class="amount-input" value="1" data-amount-min="1" data-amount-max="491" maxlength="8" title="请输入购买量">
								<span class="amount-btn">
									<span class="amount-plus">
										<i>+</i>
									</span>
									<span class="amount-minus">
										<i>-</i>
									</span>
									</span>
									<span class="amount-unit">件</span>
									</span>
									<em class="stock SZY-GOODS-NUMBER">库存0件</em>

								</dd>
							</dl>
							<!-- 限购提示语 -->

							<!-- 加入购物车按钮、手机购买 -->
							<div class="action">
								<div class="btn-buy">
									<a href="javascript:void(0);" class="buy-goods color">
										<span class="buy-goods-bg bg-color"></span>
										<span class="buy-goods-border"></span> 立即购买
									</a>
								</div>
								<div class="btn-buy">
									<a href="javascript:void(0);" class="add-cart bg-color">
										<i></i> 加入购物车
									</a>
								</div>
								<div class="btn-buy">
									<a href="javascript:void(0);" class="no-auth hide"> 无权购买 </a>
								</div>
								<div class="btn-phone">
									<a href="/" class="go-phone">
										<span>手机购买</span>
										<i></i>
										<div id="phone-tan" style="display: none;">
											<span class="arr"></span>
											<div class="m-qrcode-wrap">
												<img src="/static/img/test/mall_wx_qrcode_0.jpg" width="100" height="100">
											</div>
										</div>
									</a>
								</div>
							</div>
							<!-- 服务承诺 -->
						</div>
						<!-- 在售的商品 _end -->
					</form>
				</div>
				<!-- 商品详细信息 _end-->

				<!-- 店铺信息 _star-->
				<div class="store-info">
					<dl class="store-logo">
						<a href="javascript:void(0);">
							<img src="/static/img/test/default_shop_logo_0.gif" width="" height="">
						</a>
					</dl>
					<dl class="store-name third-store">
						<a href="javascript:void(0);" class="name" title="易购网官方自营二号店">易购网官方自营二号店</a>
					</dl>

					<dl class="store-score">
						<dd>
							<!-- 通过分数判断width的宽度-->
							<div class="score-sum color">
								4.39
								<span>综合</span>
							</div>
							<ul class="score-part">
								<li>
									<span class="score-desc">描述相符</span>
									<span class="score-detail color">4.17</span>
								</li>
								<li>
									<span class="score-desc">服务态度</span>
									<span class="score-detail color">4.50</span>
								</li>
								<li>
									<span class="score-desc">发货速度</span>
									<span class="score-detail color">4.50</span>
								</li>
							</ul>
						</dd>
					</dl>
					<dl class="store-other">
						<dt>信 誉：</dt>
						<dd>
							<img src="/static/img/test/14653018315416.gif" class="rank" title="普通皇冠五">
						</dd>
					</dl>

					<dl class="store-other">
						<dt>所在地：</dt>
						<dd>四川省 成都市</dd>
					</dl>
					<!-- 客服 -->

					<dl class="store-other">
						<dt class="tool">客 服：</dt>
						<dd class="tool">
							<a href="javascript:void(0);" data-goods_id="429" class="service-btn">
								<img src="/static/img/test/openim.png" width="20" height="20" border="0" alt="在线客服">
								<span>在线客服</span>
							</a>
						</dd>
					</dl>

					<dl class="store-other">
						<dt>工商执照：</dt>
						<dd>
							<a id="license" href="javascript:void(0);">
								<img src="/static/img/test/national_emblem_light.png" height="18" title="工商执照">
							</a>
						</dd>
					</dl>

					<div class="enter-store">
						<div class="enter-store-item">
							<a class="bg-color goto-shop" href="javascript:void(0);">
								<i></i> 进入店铺
							</a>
							<a class="bg-color shop-add " href="javascript:void(0);">
								<i></i>
								<span>收藏本店</span>
							</a>
						</div>
					</div>
				</div>
				<!-- 店铺信息 _end-->
			</div>

			<!-- 内容 -->
			<div class="clearfix">
				<!-- 左半部分内容 -->
				<div class="fl">
					<!-- 客服组 -->
					<div class="store-service">
						<div class="store-logo"><img src="/static/img/test/service.png" width="" height=""></div>
						<div class="store-service-group left-content">
							<div class="store-service-type first">
								<h4>在线咨询</h4>
								<div class="service-list">
									<em>咨询客服qq</em>
									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服一</span>
									</a>
									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服二</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服三</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服四</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服五</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服六</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服七</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服八</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服九</span>
									</a>

									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=xxxxxxxxxx&amp;site=qq&amp;menu=yes" class="service-btn">
										<img border="0" src="/static/img/test/pa" alt="QQ" title="点击这里给我发消息" style="height: 20px;">
										<span>客服十</span>
									</a>
								</div>

								<div class="service-list">
									<em>咨询客服旺旺</em>
									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服七</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服三</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服四</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服五</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服六</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服八</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服九</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服十</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服一</span>
									</a>

									<a href="http://amos1.taobao.com/msg.ww?v=2&amp;uid=ilovebuy&amp;s=2" target="_blank" class="service-btn">
										<img src="/static/img/test/online.ww" border="0" alt="淘宝旺旺">
										<span>客服二</span>
									</a>

								</div>

								<div class="service-list">
									<em>在线客服</em>
									<a href="javascript:;" data-goods_id="429" class="service-btn">
										<img src="/static/img/test/openim.png" width="20" height="20" border="0" alt="在线客服">
										<span>联系我们</span>
									</a>
								</div>
							</div>
							<div class="store-service-type">
								<h4>工作时间</h4>
								<div class="service-time">
									<p>工作时间 AM 08:00 - PM 20:00</p>
								</div>
							</div>
						</div>
					</div>

					<!-- 店内分类 -->
					<!-- -->
					<div class="store-category">
						<h3 class="left-title">店内分类</h3>
						<div class="left-content tree">
							<ul>

								<li class="parent_li">
									<span>
								<i class="icon-minus-sign"></i>
							</span>
									<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=10" target="_self" title="男装" class="tree-first">男装</a>
									<ul>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=12" target="_self" title="男装">男装</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=15" target="_self" title="小西装">小西装</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=61" target="_self" title="棉服">棉服</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=62" target="_self" title="针织衫">针织衫</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=63" target="_self" title="夹克羊毛衫">夹克羊毛衫</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=64" target="_self" title="加绒裤">加绒裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=65" target="_self" title="真皮皮衣">真皮皮衣</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=69" target="_self" title="T恤">T恤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=70" target="_self" title="西服套装">西服套装</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=71" target="_self" title="牛仔裤">牛仔裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=72" target="_self" title="毛呢大衣">毛呢大衣</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=73" target="_self" title="风衣">风衣</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=74" target="_self" title="仿皮皮衣">仿皮皮衣</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=75" target="_self" title="卫裤/运动裤">卫裤/运动裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=76" target="_self" title="短裤">短裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=77" target="_self" title="中老年男装">中老年男装</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=78" target="_self" title="大码男装">大码男装</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=79" target="_self" title="羊绒衫">羊绒衫</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=80" target="_self" title="工装唐装/中山装">工装唐装/中山装</a>
										</li>

									</ul>
								</li>

								<li class="parent_li">
									<span>
								<i class="icon-minus-sign"></i>
							</span>
									<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=16" target="_self" title="女装" class="tree-first">女装</a>
									<ul>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=18" target="_self" title="休闲裤">休闲裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=19" target="_self" title="大码女装">大码女装</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=20" target="_self" title="中老年女装">中老年女装</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=21" target="_self" title="潮牌">潮牌</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=22" target="_self" title="半身裙">半身裙</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=25" target="_self" title="仿皮皮衣">仿皮皮衣</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=26" target="_self" title="马甲">马甲</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=27" target="_self" title="正装裤">正装裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=28" target="_self" title="礼服">礼服</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=29" target="_self" title="旗袍">旗袍</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=30" target="_self" title="雪纺衫">雪纺衫</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=31" target="_self" title="吊带">吊带</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=32" target="_self" title="短裤">短裤</a>
										</li>

									</ul>
								</li>

								<li class="parent_li">
									<span>
								<i class="icon-minus-sign"></i>
							</span>
									<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=17" target="_self" title="内衣类" class="tree-first">内衣类</a>
									<ul>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=33" target="_self" title="保暖内衣">保暖内衣</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=34" target="_self" title="秋衣秋裤">秋衣秋裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=35" target="_self" title="男士内裤">男士内裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=36" target="_self" title="女式内裤">女式内裤</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=37" target="_self" title="休闲棉袜">休闲棉袜</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=38" target="_self" title="商式男袜">商式男袜</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=39" target="_self" title="打底衫">打底衫</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=40" target="_self" title="睡衣">睡衣</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=41" target="_self" title="文胸">文胸</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=42" target="_self" title="打底裤袜">打底裤袜</a>
										</li>

									</ul>
								</li>

								<li class="parent_li">
									<span>
								<i class="icon-minus-sign"></i>
							</span>
									<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=44" target="_self" title="女鞋" class="tree-first">女鞋</a>
									<ul>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=45" target="_self" title="防水台">防水台</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=47" target="_self" title="马丁靴">马丁靴</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=48" target="_self" title="雪地靴">雪地靴</a>
										</li>

									</ul>
								</li>

								<li class="parent_li">
									<span>
								<i class="icon-minus-sign"></i>
							</span>
									<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=49" target="_self" title="男鞋" class="tree-first">男鞋</a>
									<ul>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=50" target="_self" title="商务休闲鞋">商务休闲鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=51" target="_self" title="正装鞋">正装鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=52" target="_self" title="帆布鞋">帆布鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=53" target="_self" title="增高鞋">增高鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=54" target="_self" title="沙滩鞋">沙滩鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=55" target="_self" title="传统布鞋">传统布鞋</a>
										</li>

									</ul>
								</li>

								<li class="parent_li">
									<span>
								<i class="icon-minus-sign"></i>
							</span>
									<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=56" target="_self" title="运动鞋包" class="tree-first">运动鞋包</a>
									<ul>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=57" target="_self" title="跑步鞋">跑步鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=58" target="_self" title="休闲鞋">休闲鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=59" target="_self" title="篮球鞋">篮球鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=60" target="_self" title="帆布鞋">帆布鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=81" target="_self" title="板鞋">板鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=82" target="_self" title="拖鞋">拖鞋</a>
										</li>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=83" target="_self" title="训练鞋">训练鞋</a>
										</li>

									</ul>
								</li>

								<li class="parent_li">
									<span>
								<i class="icon-minus-sign"></i>
							</span>
									<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=84" target="_self" title="运动服饰" class="tree-first">运动服饰</a>
									<ul>

										<li>
											<span>
										<i class="arrow"></i>
									</span>
											<a href="http://www.yaorange.cn/shop/6/list.html?cat_id=85" target="_self" title="T恤">T恤</a>
										</li>

									</ul>
								</li>

							</ul>
						</div>
					</div>

					<!-- 排行榜 -->

					<div class="store-rank-list">
						<h3 class="left-title">店内排行榜</h3>
						<div class="left-content rank-list">
							<ul class="tab-nav j-tab-nav">
								<li class="current">销售量</li>
								<li class="">收藏数</li>
							</ul>
							<div class="tab-con">
								<div class="j-tab-con">
									<ul class="goods-list" style="display: block;">

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/47238.html" title="花花公子男士纯棉秋衣秋裤薄款棉毛衫青年全棉基础保暖内衣男套装">
													<img src="/static/img/test/TB1RwYELXXXXXXHaXXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/47238.html" title="花花公子男士纯棉秋衣秋裤薄款棉毛衫青年全棉基础保暖内衣男套装">花花公子男士纯棉秋衣秋裤薄款棉毛衫青年全棉基础保暖内衣男套装</a>
												<span class="color">￥79.00</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/48007.html" title="南极人男士内裤男纯棉质平角裤大码青年卡通四角内裤男生可爱裤头">
													<img src="/static/img/test/TB13UeJKVXXXXcJXpXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/48007.html" title="南极人男士内裤男纯棉质平角裤大码青年卡通四角内裤男生可爱裤头">南极人男士内裤男纯棉质平角裤大码青年卡通四角内裤男生可爱裤头</a>
												<span class="color">￥35.80</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/46754.html" title="南极人男士保暖内衣男加厚加绒女冬秋衣秋裤中老年保暖套装防寒衣">
													<img src="/static/img/test/TB186J.NpXXXXbXXFXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/46754.html" title="南极人男士保暖内衣男加厚加绒女冬秋衣秋裤中老年保暖套装防寒衣">南极人男士保暖内衣男加厚加绒女冬秋衣秋裤中老年保暖套装防寒衣</a>
												<span class="color">￥49.90</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/55413.html" title="南极人丝袜连裤袜防勾丝秋季中厚打底裤袜秋冬款加绒加厚连体连脚">
													<img src="/static/img/test/TB12zSlNVXXXXb.aXXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/55413.html" title="南极人丝袜连裤袜防勾丝秋季中厚打底裤袜秋冬款加绒加厚连体连脚">南极人丝袜连裤袜防勾丝秋季中厚打底裤袜秋冬款加绒加厚连体连脚</a>
												<span class="color">￥12.60</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/46670.html" title="南极人男士女士秋衣秋裤棉毛衫圆领打底薄款情侣保暖内衣女套装">
													<img src="/static/img/test/TB1kTfaOXXXXXb6XpXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/46670.html" title="南极人男士女士秋衣秋裤棉毛衫圆领打底薄款情侣保暖内衣女套装">南极人男士女士秋衣秋裤棉毛衫圆领打底薄款情侣保暖内衣女套装</a>
												<span class="color">￥39.80</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/46611.html" title="南极人保暖内衣男士女士双层加厚加绒冬季秋衣秋裤套装黄金绒暖甲">
													<img src="/static/img/test/TB1aShoOpXXXXb.XFXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/46611.html" title="南极人保暖内衣男士女士双层加厚加绒冬季秋衣秋裤套装黄金绒暖甲">南极人保暖内衣男士女士双层加厚加绒冬季秋衣秋裤套装黄金绒暖甲</a>
												<span class="color">￥39.90</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/50058.html" title="袜子男纯棉中筒袜棉袜秋冬季短袜全棉吸汗防臭男士商务男袜礼盒装">
													<img src="/static/img/test/TB17pAPMVXXXXcbXpXXYXGcGpXX_M2.SS2">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/50058.html" title="袜子男纯棉中筒袜棉袜秋冬季短袜全棉吸汗防臭男士商务男袜礼盒装">袜子男纯棉中筒袜棉袜秋冬季短袜全棉吸汗防臭男士商务男袜礼盒装</a>
												<span class="color">￥25.80</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/48868.html" title="南极人无痕内裤女纯棉裆性感大码中腰女士裤头棉质面料少女三角裤">
													<img src="/static/img/test/TB18nkXOXXXXXXvXFXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/48868.html" title="南极人无痕内裤女纯棉裆性感大码中腰女士裤头棉质面料少女三角裤">南极人无痕内裤女纯棉裆性感大码中腰女士裤头棉质面料少女三角裤</a>
												<span class="color">￥39.90</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/48123.html" title="彼尔丹5条礼盒装男士内裤纯棉质性感潮青年平角裤四角裤男生裤头">
													<img src="/static/img/test/TB1XxpOLpXXXXauapXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/48123.html" title="彼尔丹5条礼盒装男士内裤纯棉质性感潮青年平角裤四角裤男生裤头">彼尔丹5条礼盒装男士内裤纯棉质性感潮青年平角裤四角裤男生裤头</a>
												<span class="color">￥29.90</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/29637.html" title="英伦车一次性口罩防尘防雾霾病菌可爱男女冬季黑潮款透气50只加厚">
													<img src="/static/img/test/TB1CXZANVXXXXalaFXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/29637.html" title="英伦车一次性口罩防尘防雾霾病菌可爱男女冬季黑潮款透气50只加厚">英伦车一次性口罩防尘防雾霾病菌可爱男女冬季黑潮款透气50只加厚</a>
												<span class="color">￥8.10</span>
											</div>
										</li>

									</ul>
									<ul class="goods-list" style="display: none;">

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/80904.html" title="秋冬季男士中长款风衣男款韩版修身型毛呢大衣男装呢子加厚外套潮">
													<img src="/static/img/test/TB1deEVJVXXXXaVXVXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/80904.html" title="秋冬季男士中长款风衣男款韩版修身型毛呢大衣男装呢子加厚外套潮">秋冬季男士中长款风衣男款韩版修身型毛呢大衣男装呢子加厚外套潮</a>
												<span class="color">￥88.00</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/20171.html" title="2016冬季加绒棉鞋男士休闲鞋韩版板鞋潮鞋冬款加厚保暖防水男鞋子">
													<img src="/static/img/test/TB1m1qWNFXXXXcCXFXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/20171.html" title="2016冬季加绒棉鞋男士休闲鞋韩版板鞋潮鞋冬款加厚保暖防水男鞋子">2016冬季加绒棉鞋男士休闲鞋韩版板鞋潮鞋冬款加厚保暖防水男鞋子</a>
												<span class="color">￥29.90</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/71606.html" title="男士男鞋布鞋秋季潮鞋帆布鞋休闲鞋高帮鞋板鞋子懒人鞋冬季棉鞋男">
													<img src="/static/img/test/TB1PlFbNpXXXXb7XFXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/71606.html" title="男士男鞋布鞋秋季潮鞋帆布鞋休闲鞋高帮鞋板鞋子懒人鞋冬季棉鞋男">男士男鞋布鞋秋季潮鞋帆布鞋休闲鞋高帮鞋板鞋子懒人鞋冬季棉鞋男</a>
												<span class="color">￥39.00</span>
											</div>
										</li>

										<li class="goods-item first">
											<div class="picture">
												<a href="http://www.yaorange.cn/71433.html" title="环球白色高帮帆布鞋女春秋男平底平跟学生板鞋黑布鞋韩版情侣球鞋">
													<img src="/static/img/test/TB1vu39LFXXXXXHXXXXXXXXXXXX_!!0-item_pic.jpg">
												</a>
											</div>
											<div class="price">
												<a href="http://www.yaorange.cn/71433.html" title="环球白色高帮帆布鞋女春秋男平底平跟学生板鞋黑布鞋韩版情侣球鞋">环球白色高帮帆布鞋女春秋男平底平跟学生板鞋黑布鞋韩版情侣球鞋</a>
												<span class="color">￥39.00</span>
											</div>
										</li>

									</ul>
								</div>
							</div>
						</div>
					</div>

					<!-- 您浏览过 -->

				</div>
				<!-- 右半部分内容 -->
				<div class="right right-con">
					<div class="wrapper">
						<div id="main-nav-holder" class="goods-detail">
							<ul id="nav" class="tab">
								<li class="title-list current">
									<a href="javascript:;">规格参数</a>
								</li>
								<li class="title-list">
									<a href="javascript:;">商品详情</a>
								</li>
								<li class="title-list">
									<a id="evaluate_count" href="javascript:;">累计评价(5)</a>
								</li>
							</ul>
							<div class="right-side">
								<a href="javascript:void(0);" class="right-addcart add-cart" id="right-addcart">
									<i></i> 加入购物车
								</a>

								<div class="right-side-con" style="height: 317px;">
									<ul class="right-side-ul">
										<li class="abs-active">
											<i></i>
											<span>规格参数</span>
										</li>
										<li class="">
											<i></i>
											<span>商品详情</span>
										</li>
										<li class="">
											<i></i>
											<span>商品评价</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div id="main_widget_1">
							<!-- 规格参数 _star -->
							<div id="goods_attr_list" class="goods-detail-con goods-detail-tabs">
								<ul class="goods-spec">
								<c:forEach var="kv" items="${viewPropertyList}">
									<li>
										${kv.k}：<span id="goods_attr_" title="${kv.v}" class="goods-attr-value">${kv.v}</span>
									</li>
								</c:forEach>
								</ul>
							</div>
							<!-- 规格参数 _end -->

							<!-- 商品详情 _star -->
							<div id="goods_introduce" class="goods-detail-con goods-detail-tabs">
								<!-- 商品后台上传的商品描述 -->
								<div class="detail-content goods-detail-content">
									${productExt.richContent}
								</div>
							</div>
							<!-- 商品详情 end -->

							<!-- 商品评价 start -->
							<div id="goods_evaluate" class="goods-detail-con goods-detail-tabs"></div>
							<!-- 商品评价 end -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 头部右侧鼠标经过图片放大效果 _start -->
		<script type="text/javascript" src="/static/js/bubbleup.js"></script>
		<!-- 头部右侧鼠标经过图片放大效果 _end -->
		<!-- 套餐、店内排行等左右切换效果 _start-->
		<script type="text/javascript" src="/static/js/tabs.js"></script>
		<!-- 套餐、店内排行等左右切换效果 _end -->
		<!-- 右侧商品信息等定位切换效果 _start -->
		<script type="text/javascript" src="/static/js/tabs_totop.js"></script>
		<!-- 右侧商品信息等定位切换效果 _end -->
		<!-- 放大镜 _start -->
		<script type="text/javascript" src="/static/js/magiczoom.js"></script>
		<!-- 放大镜 _end -->
		<!-- 控制图片经过放大 -->
		<script type="text/javascript" src="/static/js/goods.js"></script>
		<!-- 地址选择 _start -->
		<script type="text/javascript" src="/static/js/select_region.js"></script>
		<!-- 地址选择 _end -->
		<script id="SZY_GIFT_TEMPLATE" type="text">
			<div class="prom-gift-list">
				<a href="" title="" target="_blank">
					<img src="" width="25" height="25" class="gift-img" />
				</a>
				<em class="gift-number color">×</em>
			</div>
		</script>

		<script id="SZY_SKU_LIST" type="text">${skuListJson}</script>
		<!-- 获取当前地址 -->
		<script type="text/javascript">
			var sku_ids = {};
			var local_region_code = "51,01";
			var sku_freights = [];

			function getSkuId() {
				var spec_ids = [];
				$(".choose").find(".attr").each(function() {
					var spec_id = $(this).find(".selected").data("spec-id");
					spec_ids.push(spec_id);
				});
				console.debug(spec_ids,sku_ids);
				var sku_id = $.cart.getSkuId(spec_ids, sku_ids);
				if(sku_id == null) {
					return false;
				}
				return sku_id;
			}

			//暂不处理
			function changeLocation(region_code) {
				if(region_code == undefined || region_code == null || region_code.length == 0) {
					return;
				}
				var sku_id = getSkuId();
				return ;
			}

			function getSkuInfo(sku_id, is_default, callback) {
				if($(document).data("SZY-SKU-" + sku_id)) {
					var sku = $(document).data("SZY-SKU-" + sku_id);
					sku.is_default = is_default;
					// 回调
					if($.isFunction(callback)) {
						callback.call({}, sku);
					}
				} else {
					$.get('/goods/sku', {
						sku_id: sku_id
					}, function(result) {
						if(result.code == 0) {
							var sku = result.data;
							sku.is_default = is_default;
							$(document).data("SZY-SKU-" + sku_id, sku);
							// 回调
							if($.isFunction(callback)) {
								callback.call({}, sku);
							}
						} else {
							$.msg(result.message, {
								time: 5000
							});
						}
					}, "json");
				}
			}

			// 设置SKU信息
			function setSkuInfo(sku) {
				if(sku == undefined || sku == null || sku == false) {
					$(".add-cart").addClass("disabled");
					$(".buy-goods").addClass("disabled");
					$(".SZY-GOODS-NUMBER").html("库存不足");
					$(".SZY-GOODS-PRICE").html('暂无');
					$(".SZY-MARKET-PRICE").html('暂无报价');
					return;
				}

				var goods_number = sku.goods_number;

				// 点击默认规格才会切换相册
				if(sku.is_default == 1) {
					// 相册
					$(".goodsgallery").goodsgallery({
						images: sku.sku_images
					});
				}
				// 商品名称
				//$(".SZY-GOODS-NAME").html(sku.sku_name);
				// 售价
				$(".SZY-GOODS-PRICE").html('￥'+sku.goods_price*0.01+'.00');
				// 市场价
				$(".SZY-MARKET-PRICE").html('￥'+sku.market_price*0.01+'.00');

				if(parseFloat(sku.market_price) == 0) {
					$(".SZY-MARKET-PRICE").parents(".show-price").hide();
				} else {
					$(".SZY-MARKET-PRICE").parents(".show-price").show();
				}

				// 库存
				if(goods_number > 0) {
					$(".SZY-GOODS-NUMBER").html("库存" + goods_number + "件");
				} else {
					$(".SZY-GOODS-NUMBER").html("库存不足");
				}

				if(goods_number == 0) {
					$(".add-cart").addClass("disabled");
					$(".buy-goods").addClass("disabled");
				} else {
					$(".buy-goods").removeClass("disabled");
					$(".add-cart").removeClass("disabled");
				}

				$(".amount-input").data("amount-min", 1);
				$(".amount-input").data("amount-max", goods_number);

				if(goods_number > 0 && $(".amount-input").val() == 0) {
					$(".amount-input").val(1);
				} else if(goods_number == 0 && $(".amount-input").val() != 0) {
					$(".amount-input").val(0);
				}

				var goods_number_input = parseInt($(".amount-input").val());
				if(goods_number_input > goods_number) {
					$(".amount-input").val(goods_number);
				}
			}

			$().ready(function() {
				$.cartbox.load();
				var sku_lists = $.parseJSON($("#SZY_SKU_LIST").html());
				for(var i=0;i<sku_lists.length;i++){
					var theSku = sku_lists[i];
					sku_ids[theSku['spec_ids']] = theSku;
					$(document).data("SZY-SKU-" + theSku.sku_id, theSku);
				}

				if("51,01" == '') {
					local_region_code = 0;
				} else {
					local_region_code = '51,01';
				}

				if(local_region_code && local_region_code.length > 0) {
					changeLocation(local_region_code);
				}

				//变更配送地址
				var region_chooser = $(".region-chooser-container").regionchooser({
					value: local_region_code,
					change: function(value, names, is_last) {
						if(!is_last) {
							return;
						}
						// 记录当前地址选择
						local_region_code = value;
						changeLocation(value);
					}
				});

				// 步进器
				var goods_number_amount = $(".amount-input").amount({
					value: 1,
					min: 1,
					max: "491",
					change: function(value) {
						if(value == this.max) {

						}
					}
				});

				//选择属性选项
				$(".goods-spec-item").click(function() {
					if($(this).hasClass("invalid")) {
						return;
					}

					$(this).siblings(".selected").removeClass("selected").find("i").remove();
					$(this).addClass("selected").append("<i></i>");

					// 是否为默认规格
					var is_default = $(this).data("is-default");

					var sku_id = getSkuId();
					if(sku_id) {
						getSkuInfo(sku_id, is_default, function(sku) {
							setSkuInfo(sku);
						});
					} else {
						setSkuInfo(false);
					}
				}).hover(function() {
						$(this).addClass("selected");
					}, function() {
						if($(this).find("i").size() == 0) {
							$(this).removeClass("selected");
						}
					}
				);

				//选中第一个有效的sku
				for(var key in sku_ids){
					var firstSku = sku_ids[key];
					if(null!=firstSku){
						var opIdArr = key.split('\|');
						var attrGroup = $(".choose .attr");
						for(var i=0;i<opIdArr.length;i++){
							var currentLi = attrGroup.eq(i).find('li[data-spec-id="'+opIdArr[i]+'"]');
							$(currentLi).click();
						}
						break;
					}
				}


				// 立即购买
				$(".buy-goods").click(function() {
						if($(this).hasClass("disabled")) {
							return;
						}
						var sku_id = getSkuId();
						var number = $(".amount-input").val();
						$.cart.quickBuy(sku_id, number);
				});
				// 添加购物车
				$(".add-cart").click(function(event) {
					if($(this).hasClass("disabled")) {
						return;
					}
					var image_url = $(".goodsgallery").find(".gg-handler li:first img").attr("src");
					var sku_id = getSkuId();
					$.cart.add(sku_id, $(".amount-input").val(), {
						is_sku: true,
						image_url: image_url,
						event: event
					})
				});

				// 添加对比
				$(".add-compare").click(function(event) {
					var target = $(this);
					var goods_id = $(this).data("goods-id");
					var sku_id = $(this).add("sku-id");
					var image_url = $(this).data("image-url");
					if($(target).hasClass("curr")){
						$.compare.remove(goods_id, function(result) {
							if(result.code == 0) {
								$(target).removeClass("curr");
							}
						});
					}else{
						$.compare.add(goods_id, image_url, event, function(result) {
							if(result.code == 0) {
								$(target).addClass("curr");
							}
						});
					}
				});

				// 添加收藏
				$(".collect-goods").click(function(event) {
					var target = $(this);
					var goods_id = $(this).data("goods-id");
					var sku_id = getSkuId();
					$.collect.toggleGoods(goods_id, sku_id, function(result) {
						if(result.code != 0) {
							return;
						}
						if(result.data == 1) {
							$(target).addClass("curr");
							$(target).find("span").html("取消收藏");
						} else {
							$(target).removeClass("curr");
							$(target).find("span").html("收藏商品");
						}
					}, true);
				});
				// 添加收藏
				$(".collect-shop").click(function(event) {
					var target = $(this);
					var shop_id = "6";
					$.collect.toggleShop(shop_id, function(result) {
						if(result.data == 1) {
							$(target).find("span").html("取消收藏");
						} else {
							$(target).find("span").html("收藏本店");
						}
					});
				});
			});
		</script>
		<script type="text/javascript">
			//固定滚动条位置
			$.fixedScorll.read("SZY_GOODS_SCORLL");

			$().ready(function() {
				var desc_container = $(".goods-detail-content");
				var evaluate_container = $("#goods_evaluate");

				function load() {
					// 评论
					if(!$("body").data("loading-goods-comment")) {
						// 计算高度
						if($(document).scrollTop() >= $(evaluate_container).offset().top - $(window).height()) {
							$("body").data("loading-goods-comment", true);
							$.get('/static/js/data/goods-comment.json', {
								sku_id: "6163",
								output: 1
							}, function(result) {
								if(result.code == 0) {
									$(evaluate_container).html(result.data);
								}
							}, "json");
						}
					}
				}

				load();

				// 加载商品详情和评论
				$(window).scroll(function() {
					load();
				});

			});
		</script>
		<!-- 结束：主要区域内容-->
		<%@include file="/WEB-INF/views/common-right-sidebar.jsp" %>
		<!-- 站点底部-->
		<%@include file="/WEB-INF/views/common-footer.jsp" %>
	</body>

</html>
