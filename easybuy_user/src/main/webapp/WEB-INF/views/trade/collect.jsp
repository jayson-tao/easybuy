<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>

<!-- 正文，由view提供 -->

				<div class="con-right fr">
					<div class="con-right fr">
						<div class="con-right-text">
							<div class="tabmenu">
								<div class="user-status">
									<span class="active" id="status1" onclick="setTab(&#39;status&#39;,1,2)">
					<a href="http://www.yaorange.com/user/collect/goods.html" target="_self">
						<span>商品收藏</span>

									</a>
									</span>
								</div>
							</div>
							<div class="content-info">
								<!---->
								<div class="collect-list" id="con_status_1">
									<div class="floatbar">
										<div class="bar-float">
											<div class="select">
												<ul>
													<!-- 选择的当前的状态 给a标签追加class值为"sel-select" _start -->
													<li id="goods_list" class="sel-item">
														<!-- <a class="sel-link sel-select" href="/user/collect">全部宝贝<em></em></a>-->
														<a class="sel-link sel-select">
															全部宝贝
															<em>6 </em>
														</a>
													</li>
													<!-- 选择的当前的状态 给a标签追加class值为"sel-select" _end -->
													<li id="invalid_list" class="sel-item">
														<a class="sel-link">
															失效
															<em>1</em>
														</a>
													</li>
												</ul>
											</div>
											<div class="fav-search fav-goods-search cleatfix">
												<form class="search-panel-focused" id="searchForm" action="http://www.yaorange.com/user/collect/goods.html">
													<div class="search-panel-fields">
														<input type="text" name="search_goods" placeholder="宝贝搜索" class="search-combobox-input">
													</div>
													<div class="search-button">
														<input name="goods_list" type="submit" class="btn-search" value="搜索">
													</div>
													<input name="tab" type="hidden" value="goods_list">
													<input name="type" type="hidden" value="1">
												</form>
											</div>
											<!-- 如果是'同店商品'，将此模块隐藏 _start -->
											<div class="tools">
												<div class="tool-showbtn">批量管理</div>
												<ul class="tool-list">
													<!-- 如果是全选状态，给li标签追加class值"tool-item-selall"  _start-->
													<li class="tool-item">
														<i class="icon-selall"></i> 全选
													</li>
													<!-- 如果是全选状态，给li标签追加class值"tool-item-selall"  _end-->
													<li id="tools" class="tool-item">
														<i class="icon-delitem"></i> 删除
													</li>
													<li class="tool-item tool-hidebtn">取消管理</li>
												</ul>
											</div>
											<!-- 如果是'同店商品'，将此模块隐藏 _end -->
											<div class="compare">
												<div class="compare-txt">
													已选择宝贝
													<span class="">0</span> /3
												</div>
												<div class="compare-open">宝贝对比</div>
												<!-- 如果是允许商品对比，将"disable"类名删除 _start -->
												<div class="compare-start disable">开始对比</div>
												<!-- 如果是允许商品对比，将"disable"类名删除 _end -->
												<div class="compare-close">取消对比</div>
											</div>
										</div>
									</div>
									<!---->
									<div id="table_list">
										<div id="fav-list">
											<!-- -->
											<ul class="img-item-list clearfix">

												<li class="fav-item" id="collect292">
													<div class="controller-box">
														<div class="controller-img-box">
															<a href="http://www.yaorange.com/goods/10.html" class="controller-img-link" target="_blank" title="">
																<img class="controller-img" src="/static/img/14789686200823.png" alt="">
															</a>
														</div>
														<a class="add-cat-btn" data-tip="10" title="加入购物车">加入购物车</a>
														<a name="292" data-fig="goods_list" class="del-btn" title="删除宝贝">删除</a>
													</div>
													<div class="item-title">
														<a title="加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜" target="_blank" href="http://www.yaorange.com/goods/10.html"> 加绒加厚打底裤女士秋冬款外穿显瘦高腰保暖裤子棉裤冬季踩脚裤袜 </a>
													</div>
													<div class="price-container">
														<div class="price-box">
															<!---->
															<div class="price">
																<strong class="color">￥28.80</strong>
															</div>
															<!---->
														</div>
													</div>
													<div class="edit-pop">
														<input type="hidden" class="form-control" value="292">
														<div class="edit-pop-bg"><input type="hidden" class="form-control" value="10"></div>
														<div class="edit-pop-btn">
															<i class="edit-icon"></i>
														</div>
													</div>
												</li>
												<!---->

												<li class="fav-item" id="collect291">
													<div class="controller-box">
														<div class="controller-img-box">
															<a href="http://www.yaorange.com/goods/9.html" class="controller-img-link" target="_blank" title="">
																<img class="controller-img" src="/static/img/14789669544048.png" alt="">
															</a>
														</div>
														<a class="add-cat-btn" data-tip="9" title="加入购物车">加入购物车</a>
														<a name="291" data-fig="goods_list" class="del-btn" title="删除宝贝">删除</a>
													</div>
													<div class="item-title">
														<a title="紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子" target="_blank" href="http://www.yaorange.com/goods/9.html"> 紧身裤女加厚加绒踩脚裤打底裤丝袜秋冬款外穿冬季保暖裤一体裤子 </a>
													</div>
													<div class="price-container">
														<div class="price-box">
															<!---->
															<div class="price">
																<strong class="color">￥15.90</strong>
															</div>
															<!---->
														</div>
													</div>
													<div class="edit-pop">
														<input type="hidden" class="form-control" value="291">
														<div class="edit-pop-bg"><input type="hidden" class="form-control" value="9"></div>
														<div class="edit-pop-btn">
															<i class="edit-icon"></i>
														</div>
													</div>
												</li>
												<!---->

												<li class="fav-item" id="collect290">
													<div class="controller-box">
														<div class="controller-img-box">
															<a href="http://www.yaorange.com/goods/3078.html" class="controller-img-link" target="_blank" title="">
																<img class="controller-img" src="/static/img/TB1xtesNVXXXXa.XFXXYXGcGpXX_M2.SS2" alt="">
															</a>
														</div>
														<a class="add-cat-btn" data-tip="3078" title="加入购物车">加入购物车</a>
														<a name="290" data-fig="goods_list" class="del-btn" title="删除宝贝">删除</a>
													</div>
													<div class="item-title">
														<a title="2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋" target="_blank" href="http://www.yaorange.com/goods/3078.html"> 2016新款冬季雪地靴女学生平底短靴女鞋短筒保暖靴子加绒韩版棉鞋 </a>
													</div>
													<div class="price-container">
														<div class="price-box">
															<!---->
															<div class="price">
																<strong class="color">￥36.90</strong>
															</div>
															<!---->
														</div>
													</div>
													<div class="edit-pop">
														<input type="hidden" class="form-control" value="290">
														<div class="edit-pop-bg"><input type="hidden" class="form-control" value="3078"></div>
														<div class="edit-pop-btn">
															<i class="edit-icon"></i>
														</div>
													</div>
												</li>
												<!---->

												<li class="fav-item" id="collect289">
													<div class="controller-box">
														<div class="controller-img-box">
															<a href="http://www.yaorange.com/goods/876.html" class="controller-img-link" target="_blank" title="">
																<img class="controller-img" src="/static/img/TB1kk3vNFXXXXXuaXXXYXGcGpXX_M2.SS2" alt="">
															</a>
														</div>
														<a class="add-cat-btn" data-tip="876" title="加入购物车">加入购物车</a>
														<a name="289" data-fig="goods_list" class="del-btn" title="删除宝贝">删除</a>
													</div>
													<div class="item-title">
														<a title="冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋" target="_blank" href="http://www.yaorange.com/goods/876.html"> 冬季女鞋短筒雪地靴女短靴棉鞋女学生韩版加绒马丁靴高帮保暖冬鞋 </a>
													</div>
													<div class="price-container">
														<div class="price-box">
															<!---->
															<div class="price">
																<strong class="color">￥59.00</strong>
															</div>
															<!---->
														</div>
													</div>
													<div class="edit-pop">
														<input type="hidden" class="form-control" value="289">
														<div class="edit-pop-bg"><input type="hidden" class="form-control" value="876"></div>
														<div class="edit-pop-btn">
															<i class="edit-icon"></i>
														</div>
													</div>
												</li>
												<!---->

												<li class="fav-item" id="collect287">
													<div class="controller-box">
														<div class="controller-img-box">
															<a href="http://www.yaorange.com/goods/409.html" class="controller-img-link" target="_blank" title="">
																<img class="controller-img" src="/static/img/TB1CPIxOXXXXXaCXXXXXXXXXXXX_!!0-item_pic.jpg" alt="">
															</a>
														</div>
														<a class="add-cat-btn" data-tip="409" title="加入购物车">加入购物车</a>
														<a name="287" data-fig="goods_list" class="del-btn" title="删除宝贝">删除</a>
													</div>
													<div class="item-title">
														<a title="2016秋冬新款韩版毛呢外套女中长款大码加厚修身显瘦学生呢子大衣" target="_blank" href="http://www.yaorange.com/goods/409.html"> 2016秋冬新款韩版毛呢外套女中长款大码加厚修身显瘦学生呢子大衣 </a>
													</div>
													<div class="price-container">
														<div class="price-box">
															<!---->
															<div class="price">
																<strong class="color">￥88.00</strong>
															</div>
															<!---->
														</div>
													</div>
													<div class="edit-pop">
														<input type="hidden" class="form-control" value="287">
														<div class="edit-pop-bg"><input type="hidden" class="form-control" value="409"></div>
														<div class="edit-pop-btn">
															<i class="edit-icon"></i>
														</div>
													</div>
												</li>
												<!---->

												<li class="fav-item" id="collect285">
													<div class="controller-box">
														<div class="controller-img-box">
															<a href="http://www.yaorange.com/goods/416.html" class="controller-img-link" target="_blank" title="">
																<img class="controller-img" src="/static/img/TB2mWXWaDnB11BjSspdXXaTIpXa_!!341406431.jpg" alt="">
															</a>
														</div>
														<a class="add-cat-btn" data-tip="416" title="加入购物车">加入购物车</a>
														<a name="285" data-fig="goods_list" class="del-btn" title="删除宝贝">删除</a>
													</div>
													<div class="item-title">
														<a title="蕾丝衫女长袖2016秋冬装新款雪纺小衫大码女装加绒网纱打底衫上衣" target="_blank" href="http://www.yaorange.com/goods/416.html"> 蕾丝衫女长袖2016秋冬装新款雪纺小衫大码女装加绒网纱打底衫上衣 </a>
													</div>
													<div class="price-container">
														<div class="price-box">
															<!---->
															<div class="price">
																<strong class="color">￥49.90</strong>
															</div>
															<!---->
														</div>
													</div>
													<div class="edit-pop">
														<input type="hidden" class="form-control" value="285">
														<div class="edit-pop-bg"><input type="hidden" class="form-control" value="416"></div>
														<div class="edit-pop-btn">
															<i class="edit-icon"></i>
														</div>
													</div>
												</li>
												<!---->
												<!---->
											</ul>
											<form name="selectPageForm" action="http://www.yaorange.com/user/collect/goods.html" method="get">
												<!--分页-->
												<div class="page">
													<div class="page-wrap fr">
														<div id="pagination" class="page">
															<script data-page-json="true" type="text">
																{"page_key":"page","page_id":"pagination","default_page_size":15,"cur_page":1,"page_size":10,"page_size_list":[1,10,20,30,50],"record_count":6,"page_count":1,"offset":0,"url":null,"sql":null}
															</script>
															<div class="page-wrap fr">
																<div class="total">共6条记录
																	
																</div>
															</div>
															<div class="page-num fr">
																<span class="num prev disabled" style="display: none;">
			<a class="fa fa-angle-double-left" data-go-page="1" title="第一页"></a>
		</span>

																<span>
			<a class="num prev disabled " title="上一页">上一页</a>
		</span>


																<span class="num curr">
			<a data-cur-page="1">1</a>
		</span>

																<span class="disabled" style="display: none;">
			<a class="num " data-go-page="1" title="最后一页"></a>
		</span>

																<span>
			<a class="num next disabled" title="下一页">下一页</a>
		</span>

															</div>
															<script type="text/javascript">
																$().ready(function() {
																	$(".pagination-goto > .goto-input").keyup(function(e) {
																		$(".pagination-goto > .goto-link").attr("data-go-page", $(this).val());
																		if(e.keyCode == 13) {
																			$(".pagination-goto > .goto-link").click();
																		}
																	});
																	$(".pagination-goto > .goto-button").click(function() {
																		var page = $(".pagination-goto > .goto-link").attr("data-go-page");
																		if($.trim(page) == '') {
																			return false;
																		}
																		$(".pagination-goto > .goto-link").attr("data-go-page", page);
																		$(".pagination-goto > .goto-link").click();
																		return false;
																	});
																});
															</script>
														</div>
													</div>
												</div>
											</form>
											<!---->
										</div>
									</div>
									<!-- 全部商品列表 _end -->
								</div>
								<!---->
								<script type="text/javascript">
									$(function() {
										$(".select>ul>li").click(function() {
											$.loading.start();
											var page = $(this).attr('id');
											if(typeof(page) == "undefined") {
												page = "";
											}
											$.ajax({
												type: 'GET',
												url: '/user/collect/goods?tab=' + page + '',
												dataType: 'json',
												success: function(result) {
													$(".content-info").html(result.data);
												}
											})
										})
									})
								</script>
								<script type="text/javascript">
									$(function() {
										$("#tools").click(function() {
											var arr = new Array();
											var int = 0;
											$(".edit-pop-select input").each(function() {
												arr[int] = $(this).val();
												int++;
											});
											if(int > 0) {
												$.confirm("是否删除选定内容？", function(s) {
													var li_len = $("ul[class='img-item-list clearfix']>li").length;
													var select_len = 0;
													var invalid = 0;
													if(s) {
														$.ajax({
															type: 'GET',
															url: '/user/collect/delete-collect?id=' + arr,
															dataType: 'json',
															success: function(result) {
																$("#goods_list em").html(result.collect_count);
																$("#invalid_list em").html(result.invalid_count);
																$("#shop_same em").html(result.shop_count_list);
																tablelist.load();
																$.msg("删除成功");
															}
														})
													}
												});
											} else {
												$.msg("亲,请先选择要删除的的宝贝");
											}

										})
									})
								</script>
								<script type="text/javascript">
									var tablelist = null;
									$().ready(function() {
										tablelist = $("#table_list").tablelist({
											params: $("#searchForm").serializeJson()
										});
										$("#searchForm").submit(function() {
											// 序列化表单为JSON对象
											var data = $(this).serializeJson();
											console.info(data);
											// Ajax加载数据
											tablelist.load(data);
											// 阻止表单提交
											return false;
										});

									});
								</script>
							</div>
						</div>
					</div>
					
					<script type="text/javascript">
						$(function() {
							$(".select li").click(function() {
								var page = $(this).attr('id');
								if(typeof(page) == "undefined") {
									page = "";
								}
								$.ajax({
									type: 'GET',
									url: '/user/collect?tab=' + page + '',
									dataType: 'json',
									success: function(result) {
										$(".content-info").html(result.data);
									}
								})
							})
						})
					</script>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>