/**
 * AJAX后台、卖家中心公共组件
 */

(function($) {

	$.topbar = {
		init: function() {
			if ($(".SZY-USER-NAME").size() > 0) {
				$.get('/site-user', {}, function(result) {
					//reslut格式参考
					//未登录：{"code":0,"data":{"cart":{"goods_count":0},"message":{"internal_count":"0"}}}
					/*已登录：{"code":0,"data":{
					   					"cart":{"goods_count":2},
					   					"message":{"internal_count":"0"},
										"user_name":"yaorange",
										"headimg":"yaorange.png",
										"last_time":1486538020,
										"last_ip":"100.97.126.14",
										"last_region_code":null,
										"last_time_format":"2017-02-08 15:13:40",
										"user_rank":{
											"rank_id":"1",
											"rank_name":"初级会员一级",
											"rank_img":"14788627664630.gif",
											"min_points":"0",
											"max_points":"1",
											"type":"0"
										}
									}
							}
					*/

					if (result.code == 0 && result.data != null) {
						$.sidebar.renderLogin(result.data);
						$.sidebar.initLogin = true;
						var data = result.data;
					}
				}, "json");
			}
		}
	};

	// 侧边栏
	$.sidebar = {
		// 初始化登录信息
		initLogin: false,
		// 初始化
		init: function() {
			// 侧边栏浏览记录
			$(".sidebar-historybox-trigger").click(function() {
				var target = this;
				if ($(target).data("load")) {
					return;
				}
				$.get("js/data/boxgoodslist.json", {}, function(result) {
					if (result.code == 0) {
						$(".sidebar-historybox").find(".sidebar-historybox-goods-list").html(result.data);
					}
					$(target).data("load", true);
				}, "json");
			});

			// 初始化侧边栏登录信息
			$(".sidebar-user-trigger").mouseover(function() {

				if ($.sidebar.initLogin) {
					return;
				}

				$.get('/site-user', {}, function(result) {
					if (result.code == 0 && result.data != null) {
						$.sidebar.renderLogin(result.data);
					}
				});

				$.sidebar.initLogin = true;
			});
		},
		renderLogin: function(user) {

			if (user && user.cart) {
				var count = user.cart.goods_count;
				if (count > 99) {
					count = "99+";
				}
				// 购物车中商品数量
				$(".SZY-CART-COUNT").html(count);
			}

			// 用户信息
			if (user && user.user_name) {

				var target = $(".SZY-USER-ALREADY-LOGIN");

				$(target).find(".SZY-USER-NAME").html(user.user_name);

				$(target).find(".SZY-USER-PIC").attr("src", user.headimg);

				if (user.user_rank) {

					$(target).find(".SZY-USER-RANK-IMG").attr("src", user.user_rank.rank_img);

					$(target).find(".SZY-USER-RANK-NAME").html(user.user_rank.rank_name);

				}

				$(target).find(".SZY-USER-LAST-LOGIN").html(user.last_time_format);

				$(".SZY-USER-NOT-LOGIN").hide();
				$(".SZY-USER-ALREADY-LOGIN").show();
			} else {
				$(".SZY-USER-NOT-LOGIN").show();
				$(".SZY-USER-ALREADY-LOGIN").hide();
			}
		},
		// 飞入购物车效果
		fly: function(image_url, event, target) {
			if (image_url && event && $(target).size() > 0) {
				// 结束的地方的元素
				var offset = $(target).offset();
				var flyer = $('<img class="fly-img" src="' + image_url + '">');
				if ($.isFunction(flyer.fly)) {
					flyer.fly({
						start: {
							left: event.pageX - 20,
							top: event.pageY - $(window).scrollTop()
						},
						end: {
							left: offset.left + 20,
							top: offset.top - $(window).scrollTop() + 50,
							width: 0,
							height: 0
						},
						onEnd: function() {
							this.destory();
						}
					});
				}
			}
		}
	};

	// 购物车盒子
	$.cartbox = {
		// 上次访问的时间戳
		lasttime: 0,
		// 当前购物车盒子中商品的数量
		count: 0,
		// 初始化
		init: function() {

			$(".cartbox").mouseenter(function() {
				var time = new Date().getTime();
				if ($.cartbox.lasttime == 0 || time - $.cartbox.lasttime > 5 * 1000) {
					$.cartbox.load();
				}
				$(this).find(".cartbox-goods-list").show();
			}).mouseleave(function() {
				$(this).find(".cartbox-goods-list").hide();
			});

			$(".sidebar-cartbox-trigger").click(function() {
				var time = new Date().getTime();
				if ($.cartbox.lasttime == 0 || time - $.cartbox.lasttime > 5 * 1000) {
					$.cartbox.load();
				}
			});
		},
		createCartboxGoodsList(data){
			/*
			 //有购物车数据
					{"code":0,"data":{
										"goodsNumber":2,
										"goodsTotalPrice":65.43,
										"data" : [
											{"id":1,"productId":12,"skuId":12,"name":"良品铺子","skuMainPic":"a.jpg","sku":{"price":21.1},"amount":2},
											{"id":1,"productId":13,"skuId":12,"name":"良品铺子","skuMainPic":"a.jpg","sku":{"price":21.1},"amount":2}
										]
									}
					}
			 */
			var htm = '';
			htm+='<div class="dropdown-title"><h4 class="fl">购物清单</h4></div><div class="dropdown-goods-list"><ul>';
			for(var i=0;i<data.data.length;i++){
				var cart = data.data[i];
			htm+='<li><div class="p-img"><a href="/p/'+cart.productId+'?sku='+cart.skuId+'" target="_blank"> ';
			htm+='<img src="http://pijbgt8k2.bkt.clouddn.com/'+cart.skuMainPic+'?imageView2/1/w/50/h/50" width="50" height="50" alt=""></a></div>';
			htm+='<div class="p-name"><a href="/p/'+cart.productId+'?sku='+cart.skuId+'" title="" target="_blank">'+cart.name+'</a></div>';
			htm+='<div class="p-detail"><span class="p-price"> <strong class="second-color">￥'+cart.sku.price*0.01+'</strong> ×'+cart.amount+' </span><br>';
			htm+='<a class="delete" href="javascript:void(0)" onclick="$.cart.remove('+cart.id+')">删除</a></div></li>';
			}
			htm+='</ul></div><div class="dropdown-footer clearfix"><div class="p-total">';
			htm+='共 <b class="second-color">'+data.goodsNumber+'</b> 件商品 共计 <strong class="second-color">￥'+data.goodsTotalPrice*0.01+'</strong>';
			htm+='</div><a href="/cart/index" title="去购物车" class="bg-color">去购物车</a></div>';
			return htm;
		},
		createSideCartboxGoodsList(data){
			var htm = '';
			htm+='<div class="cart-panel-main">';
			htm+='<div class="cart-panel-content" style="height: 225px;">';
			htm+='<div class="cart-list">';
			for(var i=0;i<data.data.length;i++){
				var cart = data.data[i];
				htm+='<div class="cart-item ">';
				htm+='<div class="item-goods">';
				htm+='<span class="p-img"><a href="/p/'+cart.productId+'?sku='+cart.skuId+'"><img src="http://pijbgt8k2.bkt.clouddn.com/'+cart.skuMainPic+'?imageView2/1/w/50/h/50" width="50" height="50"></a></span>';
				htm+='<div class="p-name"><a href="/p/'+cart.productId+'?sku='+cart.skuId+'" title="'+cart.name+'">'+cart.name+'</a></div>';
				htm+='<div class="p-price"><strong class="second-color">￥'+cart.sku.price*0.01+'</strong> ×'+cart.amount+'</div>';
				htm+='<a href="javascript:void(0);" class="p-del" onclick="$.cart.remove('+cart.id+')">删除</a>';
				htm+='</div></div>';
			}
			htm+='</div></div></div>';
			htm+='<div class="cart-panel-footer"><div class="cart-footer-checkout">';
			htm+='<div class="number"> 共 <strong class="count second-color">'+data.goodsNumber+'</strong> 件商品</div>';
			htm+='<div class="sum">共计： <strong class="total second-color">￥'+data.goodsTotalPrice*0.01+'</strong></div>';
			htm+='<a class="btn bg-color" href="/cart/index" target="_blank">去购物车结算</a></div></div>';
			return htm;
		},
		// 加载
		load: function() {

			$.cartbox.lasttime = new Date().getTime();
			var emptyCartInfo0 = '<div class="cart-type"><i class="cart-type-icon"></i><div class="cart-type-text">您的购物车里什么都没有哦<br/><a class="color" href="/" title="再去看看吧" target="_blank">再去看看吧</a></div></div>';
			var emptyCartInfo1 = '<div class="cart-panel-main"><div class="cart-panel-content"><div class="tip-box"><i class="tip-icon"></i><div class="tip-text">您的购物车里什么都没有哦<br/><a class="color" href="/" title="再去看看吧" target="_blank">再去看看吧</a></div></div></div></div>';
			if ($(".cartbox").size() > 0 || $(".sidebar-cartbox").size() > 0) {
				$.get("/cart/cart-data", {}, function(result) {
					/**
					 *goodsNumber goodsTotalPrice data
					 //无购物车数据
					 {"code":0,"data":{
										"goodsNumber":0,
										"goodsTotalPrice":0,
										"data" :null
									}
					}
					//有购物车数据
					{"code":0,"data":{
										"goodsNumber":2,
										"goodsTotalPrice":65.43,
										"data" : [
											{"id":1,"productId":12,"skuId":12,"name":"良品铺子","skuMainPic":"a.jpg","sku":{"price":21.1},"amount":2},
											{"id":1,"productId":13,"skuId":12,"name":"良品铺子","skuMainPic":"a.jpg","sku":{"price":21.1},"amount":2}
										]
									}
					}
					 */
					if (result.code == 0) {
						$.cartbox.count = result.data.goodsNumber;
						$.cartbox.renderCount();

						var cartbox_goods_list = $(".cartbox").find(".cartbox-goods-list");
						var sidebar_cartbox_goods_list = $(".sidebar-cartbox").find(".sidebar-cartbox-goods-list");

						if(0==$.cartbox.count){//购物车为空
							if (cartbox_goods_list.size() > 0) {
								$(cartbox_goods_list).html(emptyCartInfo0);
							}
							if (sidebar_cartbox_goods_list.size() > 0) {
								$(sidebar_cartbox_goods_list).html(emptyCartInfo1);
								$(".sidebar-cartbox").find('.cart-panel-content').height($(window).height() - 90);
								$(".sidebar-cartbox").find('.bonus-panel-content').height($(window).height() - 40);
							}
						}else{
							if (cartbox_goods_list.size() > 0) {
								var cartInfo = $.cartbox.createCartboxGoodsList(result.data);
								$(cartbox_goods_list).html(cartInfo);
							}

							if (sidebar_cartbox_goods_list.size() > 0) {
								var cartInfo = $.cartbox.createSideCartboxGoodsList(result.data);
								$(sidebar_cartbox_goods_list).html(cartInfo);
								$(".sidebar-cartbox").find('.cart-panel-content').height($(window).height() - 90);
								$(".sidebar-cartbox").find('.bonus-panel-content').height($(window).height() - 40);
							}
						}


					}
				}, "json");
			}

		},
		// 设置新增了几件商品
		add: function(number) {
			// 计数累计
			this.count = parseInt(this.count) + parseInt(number);
			// 移入刷新
			this.lasttime = 0;
			// 渲染数量
			this.renderCount();
		},
		// 渲染数量
		renderCount: function(count) {
			if (!count) {
				count = this.count;
			}
			if (count > 99) {
				count = "99+";
			}
			$(".cartbox").find(".SZY-CART-COUNT").html(count);

			$(".sidebar-cartbox-trigger").find(".SZY-CART-COUNT").html(count);
		}
	};

	// 购物车
	$.cart = {
		loading: false,
		request: null,
		// 立即购买
		quickBuy: function(id, number, options) {
			$.loading.start();
			var data = {
				skuId: id,
				number: number
			};

			// 拼团
			if (options && options.group_sn) {
				data.groupSn = options.group_sn;
			}

			$.post('/cart/immediatelyBuy', data, function(result) {
				if (result.code == 0) {
					//正常提交
					location.href = "/order/confirm";
				} else {
					$.msg(result.message, {
						time: 5000
					});
				}
			}, "json").always(function() {
				$.loading.stop()
			});
		},
		// 添加购物车
		// @param sku_id 商品SKU编号
		// @param number 数量
		// @param options 其他参数 {is_sku-是否为SKU, image_url-图片路径, event-点击事件,
		// shop_id-店铺编号
		// callback-回调函数}
		add: function(id, number, options) {
			var defaults = {
				// 是否为SKU商品
				is_sku: true,
				// 图片路径
				image_url: undefined,
				// 点击事件
				event: undefined,
				// 回调函数
				callback: undefined
			};

			options = $.extend(true, defaults, options);

			var data = {
				skuId: id,
				number: number
			};

			if (options.shop_id != undefined && options.shop_id != 0) {
				data.shopId = options.shop_id;
			}

			if (options.is_sku) {
				$.post('/cart/add', data, function(result) {
					if (result.code == 0) {
						$.msg(result.message);
						// 刷新购物车数量
						$.cartbox.add(number);
						// 飞入购物车
						$.sidebar.fly(options.image_url, options.event, $(".sidebar-cartbox-trigger"));
					} else {
						$.msg(result.message, {
							time: 5000
						});
					}

					// 回调函数
					if ($.isFunction(options.callback)) {
						options.callback.call($.cart, result);
					}
				}, "json");
			} else {
				// 添加商品
				$.post('/product/sku', {
					goods_id: id,
					number: number
				}, function(result) {
					if (result.code == 0) {
						$.msg(result.message);
						// 刷新购物车数量
						$.cartbox.add(number);
						// 飞入购物车
						$.sidebar.fly(options.image_url, options.event, $(".sidebar-cartbox-trigger"));
					} else if (result.code == 98) {//显示sku选择器
						$("body").append(result.data);
					} else {
						$.msg(result.message, {
							time: 5000
						});
					}

					// 回调函数
					if ($.isFunction(options.callback)) {
						options.callback.call($.cart, result);
					}

				});
			}

		},
		// 从购物车主页面中删除
		del: function(cart_ids, callback , elements) {

			if (this.request != null && $.isFunction(this.request.abort)) {
				// 终止请求
				this.request.abort();
			}

			var str_cats = '';
			if(null!=cart_ids){
				for(var i=0;i<cart_ids.length;i++){
					str_cats+=','+cart_ids[i];
				}
			}
			if(str_cats.length>0) str_cats  = str_cats.substring(1);

			this.request = $.post('/cart/del', {
				cartIds: str_cats
			}, function(result) {

				if (result.code == 0) {
					if (result.message != null && result.message.length > 0) {
						$.msg(result.message);
					}
					// 刷新购物车
					$.cartbox.load();
				} else {
					$.msg(result.message, {
						time: 5000
					});
				}

				// 回调函数
				if ($.isFunction(callback)) {
					callback.call($.cart, result , elements);
				}

			}, "json");

			return this.request;
		},
		// 从mini购物车中删除
		remove: function(cart_ids, callback) {
			if (this.request != null && $.isFunction(this.request.abort)) {
				// 终止请求
				this.request.abort();
			}

			this.request = $.post('/cart/remove', {
				cartIds: cart_ids
			}, function(result) {
				if (result.code == 0) {
					if (result.message != null && result.message.length > 0) {
						$.msg(result.message);
					}
					// 刷新购物车
					$.cartbox.load();
				} else {
					$.msg(result.message, {
						time: 5000
					});
				}

				// 回调函数
				if ($.isFunction(callback)) {
					callback.call($.cart, result);
				}

			}, "json");

			return this.request;
		},
		/**
		 * 根据规格串的数组获取SKU编号
		 *
		 * @params array spec_ids 规格串的数组
		 * @params array sku_ids 以SKU规格串为Key，包含“sku_id”属性的数组
		 */
		getSkuId: function(spec_ids, sku_ids) {

			var temp_spec_ids = spec_ids.join("|");
			if (sku_ids[temp_spec_ids]) {
				return sku_ids[temp_spec_ids]['sku_id'];
			} else {
				// 求数组的全排序
				var spec_ids_list = $.toPermute(spec_ids);

				for (var i = 0; i < spec_ids_list.length; i++) {
					spec_ids = spec_ids_list[i];

					spec_ids = spec_ids.join("|");

					if (sku_ids[spec_ids]) {
						return sku_ids[spec_ids]['sku_id'];
					}

				}

				return null;
			}
		},
		// 改变购物车中商品数量
		// @param cart_id 购物车编号
		// @param number 变更后的数量
		// @param callback 变更后的回调函数
		changeNumber: function(cart_id, number, callback) {

			if (this.request != null && $.isFunction(this.request.abort)) {
				// 终止请求
				this.request.abort();
			}

			this.request = $.post('/cart/changeNumber', {
				cartId: cart_id,
				number: number
			}, function(result) {

				if (result.code == 0) {

				} else {
					$.msg(result.message, {
						time: 5000
					});
				}

				if ($.isFunction(callback)) {
					callback.call($.cart, result);
				}

			}, "json");

			return this.request;
		},
		// 选择商品
		select: function(cart_ids, callback) {
			if (this.request != null && $.isFunction(this.request.abort)) {
				// 终止请求
				this.request.abort();
			}

			this.request = $.post('/cart/select', {
				cartIds: cart_ids.join(",")
			}, function(result) {

				if (result.code == 0) {

				} else {
					$.msg(result.message, {
						time: 5000
					});
				}

				if ($.isFunction(callback)) {
					callback.call($.cart, result);
				}

			}, "json");

			return this.request;
		}
	};
	// 在线客服
	$.openim = function(options) {

		var name = 'webcall'; // 网页名称，可为空;
		var iWidth = 700; // 弹出窗口的宽度;
		var iHeight = 580; // 弹出窗口的高度;
		// 获得窗口的垂直位置
		var iTop = (window.screen.availHeight - 30 - iHeight) / 2;
		// 获得窗口的水平位置
		var iLeft = (window.screen.availWidth - 10 - iWidth) / 2;

		var win_object = window.open('', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');

		win_object.document.write('<html><head><title>正在连接客服，请稍后...</title><meta charset="utf-8" /><meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" /><link type="text/css" rel="stylesheet" href="/css/common.css" /></head><body><div class="loading"><div class="loading-img"><img src="/images/aliim-loading.gif"></div></div></body></html>');

		var defaults = {
			goods_id: null,
			order_id: null,
			shop_id: null
		};

		options = $.extend(defaults, options);

		var goods_id = options.goods_id;
		var order_id = options.order_id;
		var shop_id = options.shop_id;

		$.get('/user/im/check.html', {}, function(result) {

			// 转向网页的地址;
			var url = '/user/im/open.html';
			if (goods_id) {
				url += '?goods_id=' + goods_id;
			} else if (order_id) {
				url += '?order_id=' + order_id;
			} else if (shop_id) {
				url += '?shop_id=' + shop_id;
			}

			win_object.location = url;

		}, "json");
	}

	$.sidebar.comparebox = {
		// 上次访问的时间戳
		lasttime: 0,
		// 当前购物车盒子中商品的数量
		count: 0,
		// 初始化
		init: function() {
			if ($(".sidebar-comparebox").size() == 0) {
				return;
			}
			$(".sidebar-comparebox-trigger").click(function() {
				var time = new Date().getTime();
				if ($.sidebar.comparebox.lasttime == 0 || time - $.sidebar.comparebox.lasttime > 5 * 1000) {
					$.sidebar.comparebox.load();
				}
			});
		},
		// 加载
		load: function() {
			if ($(".sidebar-comparebox").size() == 0) {
				return;
			}
			$.sidebar.comparebox.lasttime = new Date().getTime();
			$.get("/compare/box-goods-list", {}, function(result) {
				if (result.code == 0) {
					$(".sidebar-comparebox").find(".sidebar-comparebox-goods-list").html(result.data);
				}
			}, "json");
		},
		reset: function() {
			$.sidebar.comparebox.lasttime = 0;
		}
	};

	// 对比
	$.compare = {
		// 添加/移除对比商品
		// @param goods_id 商品编号
		// @param image_url 图片路径
		// @param event 点击事件
		// @param callback 回调函数 result.data=0 已经移除 result.data=1已经加入
		toggle: function(goods_id, image_url, event, callback) {
			$.post('/compare/toggle', {
				goods_id: goods_id
			}, function(result) {
				if (result.code == 0) {
					// 重置
					$.sidebar.comparebox.reset();
					if (result.data == 1) {
						// 飞入
						$.sidebar.fly(image_url, event, $(".sidebar-comparebox-trigger"));
					}
				} else {
					$.msg(result.message);
				}
				// 回调函数
				if ($.isFunction(callback)) {
					callback.call($.compare, result);
				}
			}, "json");
		},
		// 添加对比商品
		// @param goods_id 商品编号
		// @param image_url 图片路径
		// @param event 点击事件
		// @param callback 回调函数
		add: function(goods_id, image_url, event, callback) {
			$.post('/compare/add', {
				goods_id: goods_id
			}, function(result) {
				if (result.code == 0) {
					// 重置
					$.sidebar.comparebox.reset();
					// 飞入
					$.sidebar.fly(image_url, event, $(".sidebar-comparebox-trigger"));

				} else {
					$.msg(result.message);
				}
				// 回调函数
				if ($.isFunction(callback)) {
					callback.call($.compare, result);
				}
			}, "json");
		},
		// 移除对比商品
		remove: function(goods_id, callback) {
			$.post('/compare/remove', {
				goods_id: goods_id
			}, function(result) {
				if (result.code == 0) {
					// 重置
					$.sidebar.comparebox.load();
				} else {
					$.msg(result.message, {
						time: 5000
					});
				}
				// 回调函数
				if ($.isFunction(callback)) {
					callback.call($.compare, result);
				}

				// 回调函数
				if ($.isFunction($.compare.removeCallback)) {
					$.compare.removeCallback.call($.compare, goods_id, result);
				}
			}, "json");
		},
		// 清空对比商品
		clear: function() {
			$.post('/compare/clear', {}, function(result) {
				if (result.code == 0) {
					// 重置
					$.sidebar.comparebox.load();
				} else {
					$.msg(result.message, {
						time: 5000
					});
				}

				if ($.isFunction($.compare.clearCallback)) {
					$.compare.clearCallback.call($.compare, result);
				}
			}, "json");
		},
		// 获取对比商品
		getGoodsList: function(goods_ids, callback) {

			var data = {
				goods_ids: goods_ids
			};

			$.get('/goods-compare-state', data, function(result) {

				if ($.isFunction(callback)) {
					callback.call(this, result);
				}
			}, "json");
		},

		// 清空的回调函数
		clearCallback: null,
		// 移除回调函数
		// @param goods_id
		// @param result
		removeCallback: null
	};

	// 收藏接口
	$.collect = {
		// 收藏、取消收藏商品
		// @params goods_id
		// @params goods_id
		// @params sku_id
		// @params callback
		// @params show_count true-返回收藏数量 false-不返回收藏数量
		toggleGoods: function(goods_id, sku_id, callback, show_count) {
			if (!sku_id) {
				sku_id = 0;
			}

			var data = {
				goods_id: goods_id,
				sku_id: sku_id
			};

			if (show_count) {
				data.show_count = 1;
			}

			$.post('/cart/collect/add', data, function(result) {
				if (result.code == 0) {
					if (result.data == 1) {
						// 收藏成功
					} else {
						// 取消收藏
					}
					$.msg(result.message);
				} else {
					$.msg(result.message, {
						time: 5000
					});
				}

				if ($.isFunction(callback)) {
					callback.call(this, result);
				}

			}, "json");
		},
		// 收藏、取消收藏店铺
		toggleShop: function(shop_id, callback, show_count) {

			var data = {
				shop_id: shop_id
			};

			if (show_count) {
				data.show_count = 1;
			}

			$.post('/cart/collect/add', data, function(result) {
				if (result.code == 0) {
					if (result.bonus_info && result.bonus_info.html) {
						$("body").append(result.bonus_info.html);
					} else {
						$.msg(result.message);
					}

				} else {
					$.msg(result.message, {
						time: 5000
					});
				}

				if ($.isFunction(callback)) {
					callback.call(this, result);
				}

			}, "json");
		},

		// 添加收藏
		addGoods: function(goods_id, sku_id, callback) {
			if (!sku_id) {
				sku_id = 0;
			}
			$.post('/cart/collect/add', {
				goods_id: goods_id,
				sku_id: sku_id
			}, function(result) {
				$.msg(result.message);
				if ($.isFunction(callback)) {
					callback.call(this, result);
				}

			}, "json");
		},
		// 添加收藏
		addShop: function(shop_id, callback) {
			$.post('/cart/collect/add', {
				shop_id: shop_id
			}, function(result) {

				if (result.bonus_info && result.bonus_info.html) {
					$("body").append(result.bonus_info.html);
				} else {
					$.msg(result.message);
				}

				if ($.isFunction(callback)) {
					callback.call(this, result);
				}

			}, "json");
		},
		removeGoods: function(goods_id, sku_id, callback) {
			$.post('/cart/collect/remove.html', {
				goods_id: goods_id,
				sku_id: sku_id
			}, function(result) {
				$.msg(result.message);

				if ($.isFunction(callback)) {
					callback.call(this, result);
				}

			}, "json");
		},
		removeShop: function(shop_id, callback) {
			$.post('/cart/collect/remove.html', {
				shop_id: shop_id
			}, function(result) {
				$.msg(result.message);

				if ($.isFunction(callback)) {
					callback.call(this, result);
				}

			}, "json");
		},
		getGoodsList: function(goods_ids, sku_ids, callback) {

			if (!sku_ids) {
				sku_ids = 0;
			}

			var data = {
				goods_ids: goods_ids,
				sku_ids: sku_ids
			};

			$.get('/goods-collect-state', data, function(result) {

				if ($.isFunction(callback)) {
					callback.call(this, result);
				}
			}, "json");
		}
	};

	// 红包
	$.bonus = {
		/**
		 * 领取红包
		 */
		receive: function(bonus_id, callback) {
			return $.post("/cart/bonus/receive.html", {
				bonus_id: bonus_id
			}, function(result) {
				if ($.isFunction(callback)) {
					callback.call(this, result);
				}
			}, "JSON");
		}
	};

	if (!$("body").data("cart-js-init")) {
		// 顶部栏初始化
		$.topbar.init();
		// 初始化侧边栏
		$.sidebar.init();
		// 初始化购物车盒子
		$.cartbox.init();
		// 初始化
		$.sidebar.comparebox.init();
		// 标记
		$("body").data("cart-js-init", true);
	}

})(jQuery);
