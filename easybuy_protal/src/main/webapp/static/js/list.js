	var begin_hidden = 0;
			
			$().ready(function() {
				initPageInfo();
				$.cartbox.load();
				
				$(function() {
					$('.breadcrumb .crumbs-nav').hover(function() {
						$(this).toggleClass('curr');
					})
				});
				
				/*$(".add-cart").click(function(event) {
					var goods_id = $(this).data("goods-id");
					var image_url = $(this).data("image-url");
					$.cart.add(goods_id, 1, {
						is_sku: false,
						event: event,
						image_url: image_url,
						callback: function() {
							var attr_list = $('.attr-list').height();
							$('.attr-list').css({
								"overflow": "hidden"
							});
							if(attr_list >= 200) {
								$('.attr-list').css({
									"overflow-y": "auto"
								});
							}
						}
					});
					// 列表页面属性弹框
				});*/
				$(".add-cart").click(function(event) {
					var goods_id = $(this).data("goods-id");
					var image_url = $(this).data("image-url");
					
					$.get('/product/sku?productId='+goods_id,{},function(result){
						$("body").append(result);
						var attr_list = $('.attr-list').height();
						$('.attr-list').css({
							"overflow": "hidden"
						});
						if(attr_list >= 200) {
							$('.attr-list').css({
								"overflow-y": "auto"
							});
						}
					});
				});
				$(".compare-btn").click(function(event) {
					var goods_id = $(this).data("compare-goods-id");
					var image_url = $(this).data("image-url");
					var that = $(this);
					if($(this).hasClass("curr")) {
						$.compare.remove(goods_id, function(result) {
							if(result.code == 0) {
								that.removeClass('curr');
							}
						});
					} else {
						$.compare.add(goods_id, image_url, event, function(result) {
							if(result.code == 0) {
								that.addClass('curr');
							}
						});
					}
				});

				// 移除对对比商品
				$.compare.removeCallback = function(goods_id, result) {
						$("[data-compare-goods-id='" + goods_id + "']").removeClass('curr');
					}
					// 清空对比商品
				$.compare.clearCallback = function(goods_id, result) {
					$("[data-compare-goods-id]").removeClass('curr');
				}

				// 规格相册
				sildeImg(0);

				<!-- 获取当前地址 -->
				// 地区组件
				var region_chooser = $(".region-chooser-container").regionchooser({
					value: "51,01",
					change: function(value, names, is_last) {
						if(value == '') {
							var values = this.values();
							if(values.length > 0) {
								value = values[values.length - 1].region_code;
							}
						}
					}
				});
				var goods_ids = '';
				$.collect.getGoodsList(goods_ids, null, function(result) {
					var goods_list = result.data;
					$(".goods-collect").each(function() {
						var goods_id = $(this).data("goods-id");
						if(result.code == 0) {
							if(goods_list){
								if(goods_list[goods_id]) {
									$(this).addClass("curr");
									$(this).find("span").html("已收藏");
								} else {
									$(this).removeClass("curr");
									$(this).find("span").html("收藏");
								}
							}
						}
					});
				});
				
				$.compare.getGoodsList(goods_ids, function(result) {
					var goods_list = result.data;
					$(".goods-comapre").each(function() {
						var goods_id = $(this).data("compare-goods-id");
						if(result.code == 0) {
							if(goods_list){
								if(goods_list[goods_id]) {
									$(this).addClass("curr");
								} else {
									$(this).removeClass("curr");
								}
							}
						}
					});
				});
				
				$('.other-vattr-li').bind('click', function() {
					var seled_input_num = $(this).parents('ul').find('input[type="checkbox"]:checked').length;
					if(seled_input_num > 0) {
						$(this).parents('dd').find('.select-button').eq(0).attr('class', 'select-button select-button-sumbit');
					} else if(seled_input_num == 0) {
						$(this).parents('dd').find('.select-button').eq(0).attr('class', 'select-button disabled');
					}
				});
				
			});
			
			function Show_More_Attrgroup() {
				if(begin_hidden == 0) {
					$(".filter-attr").each(function(i) {
						$(this).show();
					});
					$('#attr-group-more-text').html("收起");
					begin_hidden = 2;
				} else {
					$(".filter-attr").each(function(i) {
						if(i >= begin_hidden) {
							$(this).hide();
						} else {
							$(this).show();
						}
					});
					$('#attr-group-more-text').html("更多选项");
					begin_hidden = 0;
				}

				var kuan1 = $("#attr-list-ul").width();
				var kuan2 = $("#attr-group-more").width();
				var kuan = (kuan1 - kuan2) / 2;
				$('#attr-group-more').css("margin-left", kuan + "px");
			}

			// 是否显示“更多”__初始化
			function init_more(boxid, moreid, height) {
				var obj_brand = document.getElementById(boxid);
				var more_brand = document.getElementById(moreid);
				if(obj_brand.clientHeight > height) {
					obj_brand.style.height = height + "px";
					obj_brand.style.overflow = "hidden";
					more_brand.innerHTML = '<a href="javascript:void(0);"  onclick="slideDiv(this, \'' + boxid + '\', \'' + height + '\');" class="more" >更多</a>';
				}
			}
			// 收起
			function slideDiv(thisobj, divID, Height) {
				var obj = document.getElementById(divID).style;
				if(obj.height == "") {
					obj.height = Height + "px";
					obj.overflow = "hidden";
					thisobj.innerHTML = "更多";
					thisobj.className = "more";
					// 如果是品牌，额外处理
					if(divID == 'brand-abox') {
						// obj.width="456px";
						getBrand_By_Zimu(document.getElementById('brand-zimu-all'), '');
						document.getElementById('brand-sobox').style.display = "none";
						document.getElementById('brand-zimu').style.display = "none";
						document.getElementById('brand-abox-father').className = "";
					}
				} else {
					obj.height = "";
					obj.overflow = "";
					thisobj.innerHTML = "收起";
					thisobj.className = "more opened";
					// 如果是品牌，额外处理
					if(divID == 'brand-abox') {
						// obj.width="456px";
						document.getElementById('brand-sobox').style.display = "block";
						document.getElementById('brand-zimu').style.display = "block";
						// getBrand_By_Zimu(document.getElementById('brand-zimu-all'),'');
						document.getElementById('brand-abox-father').className = "brand-more";
					}
				}
			}

			function getBrand_By_Name(val) {
				val = val.toLocaleLowerCase();
				var brand_list = document.getElementById('brand-abox').getElementsByTagName('li');
				for(var i = 0; i < brand_list.length; i++) {
					// document.getElementById('brand-abox').style.width="auto";
					var name_attr_value = brand_list[i].getAttribute("name").toLocaleLowerCase();
					if(brand_list[i].title.indexOf(val) == 0 || name_attr_value.indexOf(val) == 0 || val == '') {
						brand_list[i].style.display = 'block';
					} else {
						brand_list[i].style.display = 'none';
					}
				}
			}
			// 点击字母切换品牌
			function getBrand_By_Zimu(obj, zimu) {
				document.getElementById('brand-sobox-input').value = "可搜索拼音、汉字查找品牌";
				obj.focus();
				var brand_zimu = document.getElementById('brand-zimu');
				var zimu_span_list = brand_zimu.getElementsByTagName('span');
				for(var i = 0; i < zimu_span_list.length; i++) {
					zimu_span_list[i].className = '';
				}
				var thisspan = obj.parentNode;
				thisspan.className = 'span';
				var brand_list = document.getElementById('brand-abox').getElementsByTagName('li');
				for(var i = 0; i < brand_list.length; i++) {
					// document.getElementById('brand-abox').style.width="auto";
					if(brand_list[i].getAttribute('rel') == zimu || zimu == '') {
						brand_list[i].style.display = 'block';
					} else {
						brand_list[i].style.display = 'none';
					}
				}
			}

			//点击品牌
			function searchBrand(o){
				var brand = $(o).closest('li').attr('brandId');
				$('#searchForm').find('[name="brand"]').val(brand);
				startSearch();
			}
			
			//点击价格区间
			function searchPrice(o){
				var priceText = $(o).text();
				if(priceText=='全部'){
					$('#priceMax').val('');
					$('#priceMin').val('');
					startSearch();
				}else{
					var priceArr = priceText.split('-');
					var min = parseInt($.trim(priceArr[0]));
					var max = parseInt($.trim(priceArr[1]));
					$('#priceMax').val(max);
					$('#priceMin').val(min);
					setPrice();
				}
				
			}
			
			// 自定义价格
			function setPrice() {
				var max = $('#priceMax').val();
				var min = $('#priceMin').val();
				if(max > 0 & min >= 0) {
					startSearch();
				} else {
					$('#priceMax').val('');
					$('#priceMin').val('');
				}
			}
			
			//排序
			function searchSort(sort,order){
				$('#searchForm').find('[name="sort"]').val(sort);
				$('#searchForm').find('[name="order"]').val(order);
				startSearch();
			}
			
			//开始搜索
			function startSearch(){
				$('#searchForm').find('[name="page"]').val(1);
				$('#searchForm').submit();
			}
			
			//分页跳转
			function go2Page(page){
				$('#searchForm').find('[name="page"]').val(page);
				$('#searchForm').submit();
			}
			
			//初始化页面
			function initPageInfo(){
				//解析参数
				var paramObj = {page:1,sort:'s'};
				var pindex = location.href.indexOf('?');
				if(pindex>0){
					var params = location.href.substring(pindex+1);
					var paramArr = params.split('&');
					for(var i=0;i<paramArr.length;i++){
						var kv = paramArr[i].split('=');
						if('#'!=kv[1]){
							paramObj[kv[0]] = decodeURI(kv[1]);
						}
					}
				}
				
				//搜索栏关键字
				$('#keyword').val(paramObj['keyword']);
				
				//分页条
				initPagination(paramObj);
				//绑定品牌点击事件
				$('#brand-abox').find('li').find('a').click(function(){
					searchBrand($(this));
				});
				//绑定价格点击事件
				$('ul.price').find('a').click(function(){
					searchPrice($(this));
				});
				//绑定排序点击事件
				$('#filter').find('.order').find('a').click(function(){
					var sort = $(this).attr('sort');
					var order = 'desc';
					var cls = $(this).find('b').attr('class');
					if(cls=='icon-order-DESCending'){
						order='asc';
					}
					searchSort(sort,order);
				});
				
				for(var k in paramObj){
						$('#searchForm').find('[name='+k+']').val(paramObj[k]);
				}
				
				
				//选中品牌
				if(paramObj["brand"]){
					$('#brand-abox').find('li').removeClass('brand-seled');
					$('#brand-abox').find('li[brandId='+paramObj["brand"]+']').addClass('brand-seled');
				}else{
					$('#brand-abox').find('li:first').addClass('brand-seled');
				}
				
				
				//选中价格
				$('ul.price').find('a').removeClass('selected');
				if(paramObj['priceMin']>=0 && paramObj['priceMax']>0){
						$('ul.price').find('a').each(function(){
							var txt = $(this).text();
							txt = txt.replace(/ /g,'');
							if(txt==(paramObj['priceMin']+'-'+paramObj['priceMax'])){
								$(this).addClass('selected');
							}
						});
				}else{
						$('ul.price').find('a').eq(0).addClass('selected');
				}
					
				//选中排序
				$('#filter').find('.order').find('dd').removeClass('curr').removeClass('first');
				var curOrder = $('#filter').find('.order').find('a[sort='+paramObj['sort']+']');
				curOrder.parent().addClass('curr').addClass('first');
				if(paramObj['order']=='asc'){
					curOrder.find('b').removeClass('icon-order-DESCending').addClass('icon-order-ASCending');
				}else{
					curOrder.find('b').removeClass('icon-order-ASCending').addClass('icon-order-DESCending');
				}
			}
			
			//初始化分页条
			function initPagination(paramObj){
				var curPage = paramObj['page'];
				if(curPage=='' || curPage==null){
					curPage = 1;
				}
				curPage = parseInt(curPage);
				var pagination = $('#pagination');
				var totalCount = parseInt(pagination.attr('total'));
				var totalDiv = $('<div class="page-wrap fr"><div class="total">共<span class="totalPages"></span>页,<span class="totalCount"></span>条记录</div></div>');
				pagination.append(totalDiv);
				$('.totalCount').text(totalCount);
				
				var pageLink = $('<div class="page-num fr"></div>');
				var totalPages = totalCount % 16 == 0? totalCount/16 : (parseInt(totalCount/16)+1);
				$('.totalPages').text(totalPages);
				
				var isFirst = (curPage == 1);
				var isLast = (curPage == totalPages);
				
				var prePage = (curPage-1)>1?(curPage-1):1;
				var nextPage = (curPage+1)<totalPages?(curPage+1):totalPages;
				//前后5页
				var scope = 5;
				if(isFirst){
					pageLink.append('<span><a class="num prev disabled " title="上一页">上一页</a></span>');
				}else{
					pageLink.append('<span><a class="num prev" page="'+prePage+'" title="上一页">上一页</a></span>');
				}
				
				var startPage = 1;
				var endPage = 2*scope+1;
				if(endPage>totalPages) endPage = totalPages;
				
				if(totalPages>endPage){
					if(curPage>scope+1){
						startPage = curPage - scope;
						endPage = curPage + scope;
						if(endPage>totalPages) endPage = totalPages;
						if((endPage-startPage)<(2*scope+1)){
							startPage = startPage - ((2*scope+1)-(endPage-startPage))+1;
							if(startPage<1) startPage = 1;
						}
					}
				}
				if(startPage>1){
					pageLink.append('<span><a class="num" page="1">首页</a></span>');
				}
				for(var i=startPage;i<=endPage;i++){
					if(i==curPage){
						pageLink.append('<span class="num curr"><a>'+i+'</a></span>');
					}else{
						pageLink.append('<span><a class="num" page="'+i+'">'+i+'</a></span>');
					}
				}
				
				if(isLast){
					pageLink.append('<span><a class="num next disabled" title="下一页">下一页</a></span>');
				}else{
					pageLink.append('<span><a class="num next" page="'+nextPage+'" title="下一页">下一页</a></span>');
				}
				
				pagination.append(pageLink);
				pagination.find('.num').click(function(){
					var page = $(this).attr('page');
					if(page){
						go2Page(page);
					}
				});
			}
			