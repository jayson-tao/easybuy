// JavaScript Document
$(function() {
	// 加载购物车数据
	$.cartbox.load();
	// 商品选择框
	$("body").off('click','.goods-checkbox').on('click', '.goods-checkbox', function() {
		var shop_id = $(this).data("shop-id");
		if ($(this).hasClass('select')) {
			$(this).removeClass('select');
			$(this).find(":checkbox").prop("checked", false);
			$('#cart_shop_' + shop_id).find(".shop-checkbox").removeClass('select');// 店铺全选取消
			$('.all-checkbox').removeClass('select');// 全选取消
		} else {
			$(this).addClass('select');
			$(this).find(":checkbox").prop("checked", true);

			if ($("#cart_shop_" + shop_id).find(":checkbox").size() == $("#cart_shop_" + shop_id).find(":checkbox:checked").size()) {
				$("#cart_shop_" + shop_id).find(".shop-checkbox").addClass('select');// 店铺全选选中
			}

			if ($("#cart_list").find(":checkbox").size() == $("#cart_list").find(":checkbox:checked").size()) {
				$('.all-checkbox').addClass('select');// 全选选中
			}
		}
		select();
	})

	// 店铺选择框
	$("body").off('click','.shop-checkbox').on('click', '.shop-checkbox', function() {
		var shop_id = $(this).data("shop-id");
		if ($(this).hasClass('select')) {
			$('#cart_shop_' + shop_id).find('.cart-checkbox').removeClass('select');
			$('#cart_shop_' + shop_id).find(":checkbox").prop("checked", false);
			$('.all-checkbox').removeClass('select');// 全选取消
		} else {
			$('#cart_shop_' + shop_id).find('.cart-checkbox').addClass('select');
			$('#cart_shop_' + shop_id).find(":checkbox").prop("checked", true);
			if ($("#cart_list").find(":checkbox").length == $("#cart_list").find(":checkbox:checked").length) {
				$('.all-checkbox').addClass('select');// 全选选中
			}
		}
		select();
	})

	// 全选框
	$("body").off('click','.all-checkbox').on('click', '.all-checkbox', function() {
		if ($(this).hasClass('select')) {
			$('.cart-checkbox').removeClass('select');
			$("#cart_list").find(":checkbox").prop("checked", false);
		} else {
			$('.cart-checkbox').addClass('select');
			$("#cart_list").find(":checkbox").prop("checked", true);
		}
		select();
	})

	// 优惠券弹框
	$("body").on('click', '.shop-coupon-trigger', function() {
		$(this).parents('.order-body').siblings().find('.SHOP-BONUS .arrow').removeClass('curr');
		$(this).parents('.order-body').siblings().find('.SHOP-BONUS .coupon-popup').hide();
		$(this).find('.arrow').toggleClass('curr');
		$(this).siblings('.coupon-popup').toggle();
	})

	// 优惠券弹框关闭
	$("body").on('click', '.coupon-popup .close', function() {
		$(this).parent('.coupon-popup').siblings('.shop-coupon-trigger').find('.arrow').removeClass('curr');
		$(this).parent('.coupon-popup').hide();
	})
		
	/*$(document).on("click",function(e){ 
		var target = $(e.target); 
		if(target.closest(".SHOP-BONUS").length == 0){ 
			$('.SHOP-BONUS-POPUP').hide();
			$('.SHOP-BONUS .arrow').removeClass('curr');
		} 
	}) */

	// 选择商品事件
	function select() {
		var cart_ids = new Array();
		var shop_id = new Array();
		$("#cart_list").find("input[type='checkbox']:checked").each(function() {
			cart_ids.push($(this).val());
			shop_id.push($(this).attr('data-shopid'));
		})

		$.cart.select(cart_ids, function(result) {
			//更新结算信息
			refreshCartData(result);
		});
	}

	// 商品数量变动
	function changeNumber() {
		$(".amount").find(":text").amount({
			change: function(element, value) {
				var cart_id = $(element).data('cart-id');
				var goods_number = $(element).data('goods-number');
				var number = value;
				var max = this.max;
				$.cart.changeNumber(cart_id, number, function(result) {
					if (result.code == 0) {
						//更新本条购物车数据(原价、优惠价、金额)
						var marketPrice = '￥'+result.data.marketPrice*0.01;
						var price = '￥' + result.data.price*0.01;
						var subTotal = '￥' + result.data.subTotal*0.01;
						$(element).closest('.item-holder').find('em.price-original').text(marketPrice);
						$(element).closest('.item-holder').find('em.price-now').text(price);
						$(element).closest('.item-holder').find('.td-sum').find('em').text(subTotal);
						//更新结算信息
						refreshCartData(result);
					} else {
						$(element).val(goods_number);
					}
				});
			}
		})
	}
	
	// 删除某条商品
	$("body").on('click', '.del', function() {
		var elements = $(this);
		var cart_ids = $(this).attr('data-cart-id');

		if (!cart_ids) {
			cart_ids = [];
			elements = $("#cart_list").find(":checkbox:checked");
			elements.each(function() {
				cart_ids.push($(this).val());
			})
		} else {
			cart_ids = [cart_ids];
		}

		if (cart_ids.length == 0) {
			$.msg("请选择您要移除的商品");
			return;
		}

		$.confirm("您确定要从购物车中移除选中的商品吗?", function() {
			$.cart.del(cart_ids, function(result,elements) {
				if (result.code == 0) {
					//移除本条购物车数据
					$(elements).closest('.item-holder').remove();
					//如果店铺下没有购物数据，删除商户信息
					$('.order-body').each(function(){
						var itemLength = $(this).find('.item-holder').length;
						if(0==itemLength){
							$(this).remove();
						}
					});
					//更新结算信息
					refreshCartData(result);
				}
			},elements);
		})
	});
	
	//刷新购物车数据
	function refreshCartData(result){
		if (result.code == 0) {
			var data = result.data;
			var selectedGoodsNumber = data.selectedGoodsNumber || 0;
			var selectedTotalPrice ='￥ '+ (data.selectedGoodsTotalPrice*0.01 || '0.00');
			$(".SZY-CART-SELECT-GOODS-NUMBER").html(selectedGoodsNumber);
			$(".SZY-CART-SELECT-GOODS-AMOUNT").html(selectedTotalPrice);
		}
	}
	
	// 结算
	$("body").on('click', '.submit-btn', function() {
		submit();
	});
	
	// 结算
	function submit() {
		$.post('/cart/settleAccounts', {}, function(result) {
			$(".item-content").removeClass('bgcolor');
			if (result.code == 0) {
				// 正常提交
				location.href = '/order/confirm';
			} else {
				$.msg(result.message+" "+result.info, {
					time: 3000
				});
			}
		}, "json");
	}

	function init() {
		// 初始加载商品数量变动步进器
		changeNumber();

		// 设置页面上checkbox状态
		if ($("#cart_list").find(":checkbox").size() == $("#cart_list").find(":checkbox:checked").size()) {
			$('.all-checkbox').addClass('select');// 全选选中
		}

		$(".order-body").each(function() {
			if ($(this).find(":checkbox").length == $(this).find(":checkbox:checked").length) {
				$(this).find('.shop-checkbox').addClass('select');// 店铺选中
			}
		})
	}

	// 初始化
	init();

});