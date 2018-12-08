<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/common-link.jsp" %>
		<title>易购网 - 购我所爱 I LOVE BUY</title>
	</head>

	<body class="pace-done">
		<%@include file="/WEB-INF/views/common-header-top.jsp" %>
		<%@include file="/WEB-INF/views/common-header.jsp" %>
		<%@include file="/WEB-INF/views/common-nav-other.jsp" %>
		<!-- 开始：主要区域内容 -->
		<!-- css -->
		<link type="text/css" rel="stylesheet" href="/static/css/category.css">

		<script type="text/javascript" src="/static/js/jquery.region.js"></script>
		<script type="text/javascript" src="/static/js/jquery.widget.js"></script>
		<script type="text/javascript" src="/static/js/jquery.tablelist.js"></script>

		<script type="text/javascript" src="/static/js/category.js"></script>
		<script type="text/javascript" src="/static/js/list.js"></script>

		<div class="blank"></div>
		<div class="w1210">
			<!--热卖推荐-->

			<div id="hotsale">
				<div class="hd bg-color">热卖推荐</div>
				<div class="mc">

					<dl>
						<dt>
					<a target="_blank" href="http://www.jayson.com/goods-4.html" title="加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季" style="background: url({ imageurl($ lazyload_image)">
						<img src="/static/img/test/14788784646707.jpg" data-original="" alt="" style="display: inline;">
					</a>
				</dt>
						<dd>
							<div class="p-name">
								<a target="_blank" href="http://www.yaorange.cn/goods-4.html" title="加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季">加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季</a>
							</div>
							<div class="p-price">
								特价：
								<font class="shop-price second-color"> ￥29.50 </font>
							</div>
							<div class="btns">
								<a target="_blank" href="http://www.yaorange.cn/goods-4.html" class="bg-color">查看详情</a>
							</div>
						</dd>
					</dl>

					<dl>
						<dt>
					<a target="_blank" href="http://www.yaorange.cn/goods-7.html" title="浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤" style="background: url({ imageurl($ lazyload_image)">
						<img src="/static/img/test/14789657995869.png" data-original="" alt="" style="display: inline;">
					</a>
				</dt>
						<dd>
							<div class="p-name">
								<a target="_blank" href="http://www.yaorange.cn/goods-7.html" title="浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤">浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤</a>
							</div>
							<div class="p-price">
								特价：
								<font class="shop-price second-color"> ￥29.90 </font>
							</div>
							<div class="btns">
								<a target="_blank" href="http://www.yaorange.cn/goods-7.html" class="bg-color">查看详情</a>
							</div>
						</dd>
					</dl>

					<dl>
						<dt>
					<a target="_blank" href="http://www.yaorange.cn/goods-9.html" title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子" style="background: url({ imageurl($ lazyload_image)">
						<img src="/static/img/test/14789669544048.png" data-original="" alt="" style="display: inline;">
					</a>
				</dt>
						<dd>
							<div class="p-name">
								<a target="_blank" href="http://www.yaorange.cn/goods-9.html" title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子">紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子</a>
							</div>
							<div class="p-price">
								特价：
								<font class="shop-price second-color"> ￥15.90 </font>
							</div>
							<div class="btns">
								<a target="_blank" href="http://www.yaorange.cn/goods-9.html" class="bg-color">查看详情</a>
							</div>
						</dd>
					</dl>

					<dl>
						<dt>
					<a target="_blank" href="http://www.yaorange.cn/goods-10.html" title="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜" style="background: url({ imageurl($ lazyload_image)">
						<img src="/static/img/test/14789686200823.png" data-original="" alt="" style="display: inline;">
					</a>
				</dt>
						<dd>
							<div class="p-name">
								<a target="_blank" href="http://www.yaorange.cn/goods-10.html" title="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜">加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜</a>
							</div>
							<div class="p-price">
								特价：
								<font class="shop-price second-color"> ￥28.80 </font>
							</div>
							<div class="btns">
								<a target="_blank" href="http://www.yaorange.cn/goods-10.html" class="bg-color">查看详情</a>
							</div>
						</dd>
					</dl>

				</div>
			</div>

			<!--当前位置，面包屑-->
			<div class="breadcrumb clearfix">
				<a href="/" class="index">首页</a>
				<c:forEach var="bread" items="${crumbs}">
				<span class="crumbs-arrow">&gt;</span>
				<div class="crumbs-nav crumbs-nav0">
					<a class="crumbs-title" href="/list?productType=${bread.parent.id}">${bread.parent.name}<i class="icon"></i></a>
					<div class="crumbs-drop">
						<ul class="crumbs-drop-list">
							<c:forEach var="type" items="${bread.children}">
							<li><a href="/list?productType=${type.id}">${type.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				</c:forEach>
			</div>

			<form action="/list" method="get" id="searchForm">
				<input name="keyword" type="hidden"/>
				<input name="productType" type="hidden"/>
				<input name="brand" type="hidden"/>
				<input name="sort" type="hidden"/>
				<input name="order" type="hidden"/>
				<input name="page" type="hidden"/>
				<!--筛选条件-->
				<div class="search-wrap" id="attr-list-ul">
					<dl style="border-top:none;" id="attr-group-dl-brand" >
						<dt>品牌：</dt>
						<dd class="moredd">
							<label id="brand-more"><a href="javascript:void(0);" onclick="slideDiv(this, 'brand-abox', '83');" class="more">更多</a></label>
						</dd>
						<dd>
							<div id="brand-sobox" style="display:none;">
								<input id="brand-sobox-input" value="可搜索拼音、汉字查找品牌" type="text" onkeyup="getBrand_By_Name(this.value);">
							</div>
							<div id="brand-zimu" class="clearfix" style="display: none;">
								<span class="span">
									<a href="javascript:void(0);" onmouseover="getBrand_By_Zimu(this,'')" id="brand-zimu-all">所有品牌</a><b></b>
								</span>
								<c:forEach var="b" items="${firstLetters}">
								<span>
									<a href="javascript:void(0);" onmouseover="getBrand_By_Zimu(this,'${b}')">${b}</a><b></b>
								</span>
								</c:forEach>
							</div>

							<div id="brand-abox-father">
								<ul id="brand-abox" class="brand-abox-imgul" style="height: 83px; overflow: hidden;">
									<li class="brand" brandId="" title="全部" rel="" name="">
										<a href="javascript:;">
											全部<span class="color">全部</span><i></i>
										</a>
									</li>
									<c:forEach var="brand" items="${brands}">
									<li class="brand" brandId="${brand.id}" title="${brand.name}" rel="${brand.firstLetter}" name="${brand.firstLetter}">
										<a href="javascript:;">
											${brand.name}<span class="color">${brand.name}</span><i></i>
										</a>
									</li>
									</c:forEach>
								</ul>
							</div>
						</dd>
					</dl>
					<script type="text/javascript">
						init_more('brand-abox', 'brand-more', '83');
					</script>
					<!--价格-->
					<dl>
						<dt>价格：</dt>
						<dd class="moredd">&nbsp;</dd>
						<dd>
							<ul class="price" >
								<li><a>全部</a></li>
								<li><a>0 - 200</a></li>
								<li><a>200 - 400</a></li>
								<li><a>400 - 800</a></li>
								<li><a>800 - 1200</a></li>
								<li><a>1200 - 2000</a></li>
								<li>
									<input name="priceMin" id="priceMin" class="input-txt" autocomplete="off"
									type="text" onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')"><i></i>
									<input name="priceMax" id="priceMax" class="input-txt" autocomplete="off"
									type="text" onkeyup="this.value=this.value.replace(/\D/g,'')"
									onafterpaste="this.value=this.value.replace(/\D/g,'')">
									<a class="select-button" href="javascript:void(0);"
									onclick="setPrice();">确定</a>
								</li>
							</ul>
						</dd>
					</dl>
				</div>
			</form>


			<div class="blank15"></div>
			<div class="content-wrap category-wrap clearfix">
				<!--左侧内容-->
				<div class="aside" style="width: 210px;">
					<span class="slide-aside"></span>
					<div class="aside-inner" style="width: 210px; display: block;">
						<!--新品推荐-->

						<div class="aside-con">
							<h2 class="aside-tit">新品推荐</h2>
							<ul class="aside-list">
								<li>
									<div class="p-img">
										<a target="_blank" title="加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季" href="http://www.yaorange.cn/goods-4.html" style="background: url({ imageurl($ lazyload_image)">
											<img alt="" src="/static/img/test/14788784646707(1).jpg" data-original="" style="display: inline;">
										</a>
									</div>
									<div class="p-name">
										<a target="_blank" title="加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季" href="http://www.yaorange.cn/goods-4.html">加绒打底裤加厚外穿女裤秋款铅笔黑色小脚高腰秋冬款保暖长裤冬季</a>
									</div>
									<div class="p-price">
										<span class="sale-price second-color">￥29.50</span>
										<span class="market-price">
									<del>￥29.50</del>
								</span>
									</div>
								</li>

								<li>
									<div class="p-img">
										<a target="_blank" title="浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤" href="http://www.yaorange.cn/goods-7.html" style="background: url({ imageurl($ lazyload_image)">
											<img alt="" src="/static/img/test/14789657995869(1).png" data-original="" style="display: inline;">
										</a>
									</div>
									<div class="p-name">
										<a target="_blank" title="浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤" href="http://www.yaorange.cn/goods-7.html">浪莎加绒加厚打底裤女秋冬外穿高腰大码踩脚黑色保暖棉裤小脚长裤</a>
									</div>
									<div class="p-price">
										<span class="sale-price second-color">￥29.90</span>
										<span class="market-price">
									<del>￥39.90</del>
								</span>
									</div>
								</li>

								<li>
									<div class="p-img">
										<a target="_blank" title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子" href="http://www.yaorange.cn/goods-9.html" style="background: url({ imageurl($ lazyload_image)">
											<img alt="" src="/static/img/test/14789669544048(1).png" data-original="" style="display: inline;">
										</a>
									</div>
									<div class="p-name">
										<a target="_blank" title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子" href="http://www.yaorange.cn/goods-9.html">紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子</a>
									</div>
									<div class="p-price">
										<span class="sale-price second-color">￥15.90</span>
										<span class="market-price">
									<del>￥50.00</del>
								</span>
									</div>
								</li>


							</ul>
						</div>

						<!--销量排行榜-->

						<div class="aside-con">
							<h2 class="aside-tit">销量排行榜</h2>
							<ul class="aside-list">

								<li>
									<div class="p-img">
										<a target="_blank" title="花花公子男士纯棉秋衣秋裤薄款棉毛衫青年全棉基础保暖内衣男套装" href="http://www.yaorange.cn/goods-2393.html" style="background: url({ imageurl($ lazyload_image)">
											<img alt="" src="/static/img/test/TB1RwYELXXXXXXHaXXXXXXXXXXX_!!0-item_pic.jpg" data-original="http://yaorange.img-cn-beijing.aliyuncs.com/图片/taobao-yun-images/537310635822/TB1RwYELXXXXXXHaXXXXXXXXXXX_!!0-item_pic.jpg?x-oss-process=image/resize,m_pad,limit_0,h_450,w_450" style="display: inline;">
										</a>
									</div>
									<div class="p-name">
										<a target="_blank" title="花花公子男士纯棉秋衣秋裤薄款棉毛衫青年全棉基础保暖内衣男套装" href="http://www.yaorange.cn/goods-2393.html">花花公子男士纯棉秋衣秋裤薄款棉毛衫青年全棉基础保暖内衣男套装</a>
									</div>
									<div class="p-price">
										<span class="sale-price second-color">￥79.00</span>
										<span class="sale-num">销量：375568</span>
									</div>
								</li>

								<li>
									<div class="p-img">
										<a target="_blank" title="南极人男士内裤男纯棉质平角裤大码青年卡通四角内裤男生可爱裤头" href="http://www.yaorange.cn/goods-2436.html" style="background: url({ imageurl($ lazyload_image)">
											<img alt="" src="/static/img/test/TB13UeJKVXXXXcJXpXXXXXXXXXX_!!0-item_pic.jpg" data-original="http://yaorange.img-cn-beijing.aliyuncs.com/图片/taobao-yun-images/39309371619/TB13UeJKVXXXXcJXpXXXXXXXXXX_!!0-item_pic.jpg?x-oss-process=image/resize,m_pad,limit_0,h_450,w_450" style="display: inline;">
										</a>
									</div>
									<div class="p-name">
										<a target="_blank" title="南极人男士内裤男纯棉质平角裤大码青年卡通四角内裤男生可爱裤头" href="http://www.yaorange.cn/goods-2436.html">南极人男士内裤男纯棉质平角裤大码青年卡通四角内裤男生可爱裤头</a>
									</div>
									<div class="p-price">
										<span class="sale-price second-color">￥35.80</span>
										<span class="sale-num">销量：363671</span>
									</div>
								</li>

								<li>
									<div class="p-img">
										<a target="_blank" title="南极人男士保暖内衣男加厚加绒女冬秋衣秋裤中老年保暖套装防寒衣" href="http://www.yaorange.cn/goods-2386.html" style="background: url({ imageurl($ lazyload_image)">
											<img alt="" src="/static/img/test/TB186J.NpXXXXbXXFXXXXXXXXXX_!!0-item_pic.jpg" data-original="http://yaorange.img-cn-beijing.aliyuncs.com/图片/taobao-yun-images/521136254098/TB186J.NpXXXXbXXFXXXXXXXXXX_!!0-item_pic.jpg?x-oss-process=image/resize,m_pad,limit_0,h_450,w_450" style="display: inline;">
										</a>
									</div>
									<div class="p-name">
										<a target="_blank" title="南极人男士保暖内衣男加厚加绒女冬秋衣秋裤中老年保暖套装防寒衣" href="http://www.yaorange.cn/goods-2386.html">南极人男士保暖内衣男加厚加绒女冬秋衣秋裤中老年保暖套装防寒衣</a>
									</div>
									<div class="p-price">
										<span class="sale-price second-color">￥49.90</span>
										<span class="sale-num">销量：322352</span>
									</div>
								</li>

							</ul>
						</div>

					</div>
				</div>
				<!--右侧内容-->
				<div class="main" style="padding-left: 225px;">
					<div  id="filter">
						<!--排序-->
							<div class="fore1">
								<dl class="order">
									<dd><a sort="zh" >综合</a></dd>
									<dd><a sort="xl">销量<b class="icon-order-DESCending"></b></a></dd>
									<dd><a sort="xp">新品<b class="icon-order-DESCending"></b></a></dd>
									<dd><a sort="pl">评论<b class="icon-order-DESCending"></b></a></dd>
									<dd><a sort="jg">价格<b class="icon-order-DESCending"></b></a></dd>
									<dd><a sort="rq">人气<b class="icon-order-DESCending"></b></a></dd>
								</dl>
								<div class="total">
									共<span class="totalCount" class="color"></span> 个商品 &nbsp;
								</div>
							</div>

							<div class="fore2">
								<div class="filter-btn">
									<span class="distribution">配送至</span>
									<div class="region-chooser-container" style="z-index: 3"></div>
									<a href="#" class="filter-tag ">
										<input class="none" name="fff" onclick="" type="checkbox">
										<i class="icon"></i>
										<span class="text">仅显示有货</span>
									</a>
								</div>
								<div class="filter-mod">
									<a href="#" title="大图模式" class="filter-type filter-type-grid curr">
										<span class="filter-type-icon"></span>
									</a>
									<a href="#" title="列表模式" class="filter-type filter-type-list">
										<span class="filter-type-icon"></span>
									</a>
								</div>
							</div>
					</div>

					<!--主体商品内容展示-->
						<ul class="list-grid clearfix">
							<c:forEach var="p" items="${page.rows}" varStatus="st">
							<!-- 如果是4的整数倍，给 li 标签添加class="last"值，即class="item last" -->
							<c:if test="${(st.index+1)%4 == 0}">
							<li class="item last">
							</c:if>
							<c:if test="${(st.index+1)%4 > 0}">
							<li class="item">
							</c:if>
								<div class="item-con">
									<div class="item-pic">
										<a href="/p/${p.id}" title="${p.name}" target="_blank">
											<img src="http://pijbgt8k2.bkt.clouddn.com//${p.images[0]}?imageView2/1/w/220/h/220" style="display: inline;">
										</a>
									</div>
									<!-- <div class="img-scroll scrolled">
										<a href="javascript:;" class="img-prev">&lt;</a>
										<a href="javascript:;" class="img-next">&gt;</a>
										<div class="img-wrap">
											<ul class="img-main" style="left: 0px; width: 238px;">
												<li class="img-item">
													<a href="javascript:;" title="粉色" class="curr"><img width="25" height="25" src="/static/img/test/1.jpg"></a>
												</li>
												<li class="img-item">
													<a href="javascript:;" title="红色"><img width="25" height="25" src="/static/img/test/2.jpg"></a>
												</li>
											</ul>
										</div>
									</div> -->
									<div class="item-info">
										<div class="item-price">
											<em class="sale-price second-color">￥${p.minPrice*0.01}</em>
											<em class="sale-count">已售${p.saleCount}件</em>
										</div>
										<div class="item-name">
											<a href="/p/${p.id}" target="_blank" title="${p.name}">${p.name}</a>
											<i class="free-shipping">包邮</i>
										</div>
										<div class="item-con-info">
											<div class="fl">
												<div class="item-operate">
													<a class="operate-btn compare-btn goods-comapre"
													data-compare-goods-id="${p.id}" data-image-url="http://pijbgt8k2.bkt.clouddn.com/${p.images[0]}?imageView2/1/w/220/h/220">
														<i></i> 对比
													</a>

													<a href="javascript:;" onclick="toggleGoods('${p.id}',47238,this)" class="operate-btn collet-btn goods-collect" data-goods-id="${p.id}">
														<i></i>
														<span>收藏</span>
													</a>

													<a href="#" target="_blank" class="operate-btn comment-btn">
														<i></i> 0
													</a>
												</div>
												<div class="item-shop">
													<a href="/" target="_blank" title="易购网官方自营二号店">
														<span>易购网官方自营二号店</span>
													</a>
												</div>
											</div>
											<div class="fr">
												<div class="item-add-cart">
													<a href="javascript:;" style="background-image: url(/static/css/add-cart.jpg)"
													data-goods-id="${p.id}" data-image-url="http://pijbgt8k2.bkt.clouddn.com/${p.images[0]}?imageView2/1/w/220/h/220"
													class="add-cart disable" title="加入购物车"></a>
												</div>
											</div>
										</div>
									</div>

								</div>
							</li>
							</c:forEach>

						</ul>
						<!--分页-->
						<div class="pull-right page-box">
							<div id="pagination" class="page" total="${page.total}">
							</div>
						</div>
				</div>
			</div>
		</div>
		<!-- 结束：主要区域内容-->
		<%@include file="/WEB-INF/views/common-right-sidebar.jsp" %>
		<!-- 站点底部-->
		<%@include file="/WEB-INF/views/common-footer.jsp" %>
	</body>

</html>
