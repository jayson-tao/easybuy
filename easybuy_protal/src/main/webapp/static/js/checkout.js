// JavaScript Document

var b = 0;
var c = 0;
if ($(".confirm-pay").size() > 0) {
	b = $(".confirm-pay").offset().top;
	c = $(".confirm-pay").outerHeight();
}

$(function() {
	//加载购物车
	$.cartbox.load();
	
	// 移除收货地址提示背景类
	$("body").on('click', '#addressinfo', function() {
		$(this).removeClass('bgcolor');
	})

	// 新增收货地址弹框
	$("body").on('click', '.addr-add', function() {
		$('.addr-box').show();
		$('.bg').show();
		showAddressHtml();
	})

	$("body").on('click', '.addr-box-oprate', function() {
		$('.addr-box').hide();
		$('.bg').hide();
	});
	
	//检查是否有收货地址，没有则直接弹出添加地址框
	if($('#addressinfo').find('.address-box').length==0){
		$('.addr-add').click();
	}

	// 编辑收货址
	$("body").on('click', '.address-edit', function() {
		$('.addr-box').show();
		$('.bg').show();
		var address_id = $(this).data('address-id');
		var active_address_id = $(".address-list").find(".address-box").filter(".active").data("address-id");

		$.ajax({
			type: 'GET',
			url: '/cart/address?id='+address_id,
			dataType: 'html',
			success: function(result) {
				$('#edit-address-div').html(result);
			}
		});
		return false;
	})

	// 删除收货地址
	$("body").on('click', '.address-delete', function() {
		var address_id = $(this).data('address-id');
		var active_address_id = $(".address-list").find(".address-box").filter(".active").data("address-id");

		var box = $(this).parents(".address-box");
		$.confirm("您确定要删除此收货地址吗？", function() {
			$.get('/user/address/del', {
				id: address_id
			}, function(result) {
				if (result.code == 0) {
					$(box).remove();
					if (active_address_id == address_id) {
						var addressBoxList = $(".address-list").find(".address-box");
						if(addressBoxList.length>=1){
							addressBoxList.eq(0).addClass('active');
						}
					}
				}
				$.msg(result.message+' '+result.info);
			}, "json");
		});
		return false;
	})

	// 设置收货地址为默认
	$("body").on('click', '.address-default', function() {
		var address_id = $(this).data('address-id');
		$.get('/user/address/setDefault', {
			id: address_id
		}, function(result) {
			if (result.code == 0) {
				//删除原默认标签
				var defaultLabel = $('.address-list').find('.deftip');
				defaultLabel.parent().append('<a href="javascript:void(0)" class="address-default" data-address-id="'+result.data+'">设为默认</a>');
				defaultLabel.remove();
				//添加新的默认标签
				$('.address-list').find('.address-box[data-address-id='+result.data+']').find('.address-default')
					.replaceWith('<span class="deftip">默认地址</span>');
			}
			$.msg(result.message+' '+result.info);
		}, "json");

		return false;
	})

	// 选择收货地址
	$("body").on('click', '.address-box', function() {
		var address_id = $(this).data('address-id');
		$(this).siblings().removeClass("active");
		$(this).addClass("active");
	})

	// 更多收货地址展开收缩效果
	$("body").on('click', '.addr-more', function() {
		$(this).find('i').toggleClass('active');
		$(this).find('span').html($(this).find('i').hasClass('active') ? "收起收货地址" : "展开收货地址");
		$('.address-more').toggle();
	});

	// 设置最佳送货时间
	$("#set_best_time").click(function() {
		return false;
	});

	// 设置最佳送货时间
	$("body").on('click', '.best_time', function() {
		if ($(this).is(":checked")) {
			var send_time_id = $(this).val();
			var send_time = '';

			$(".box").removeClass('active').removeClass('active2');
			// 指定送货时间，去掉后面的日期
			$(".best-time-desc").html('');
			// 指定送货时间，去掉已经选的日期
			$(".set_time").removeClass('current');
			$(this).parent().parent().addClass('active');
		}
	})

	

	// 设置支付方式
	$("body").on('click', '.pay_code', function() {
		changePayment(this);
	})

	// 付款信息弹框关闭事件
	$("body").on('click', '.payment-box-oprate', function() {
		$('.payment-box').hide();
		$('.bg').hide();
	});

	if ($(".confirm-pay").size() > 0) {
		// 结算页面提交按钮滚动悬浮效果
		b = $(".confirm-pay").offset().top;
		c = $(".confirm-pay").outerHeight();
		$(window).scroll(function(event) {
			resetSubmitPosition(b, c);
		})
	}

	$(".range-use").hover(function() {
		$(this).find(".platform-type-tips").toggleClass("hide");
	});
	
	
	// 结算页面提交
	$("body").on('click', '.gopay', function() {
		var target = $(this);
		if ($(target).data("loading")) {
			return;
		}
		var data = {};

		// 收货地址检查
		var addressId = $(".address-list").find(".address-box").filter(".active").data("address-id");
		if (addressId == undefined) {
			$("#addressinfo").addClass('bgcolor');
			$("body,html").animate({
				scrollTop: 0
			}, 200);
			$.msg("请选择收货地址");
			return;
		}
		data.addressId = addressId;
		
		//送货时间
		var shipTime = $('.best_time:checked').val();
		data.shipTime = shipTime;
		
		//物流公司
		var shipStore = $('#shipStore').val();
		data.shipStore = shipStore;
		
		//订单留言
		var leaveword = $('#leaveword').val();
		data.leaveword = leaveword;
		
		//发票信息
		data.needBill = 0;
		//订单来源
		data.orderFrom = 0;//PC
		//支付方式
		var payChannel = $('#paylist').find('li.seled').attr('payChannel');
		data.payChannel = payChannel;

		var win_object = window.open();
		win_object.document.write('<html><head><title>正在处理，请稍后...</title><meta charset="utf-8" /><meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" /><link type="text/css" rel="stylesheet" href="/static/css/common.css" /></head><body><div class="loading"><div class="loading-img"><img src="/static/img/loading.gif"></div></div></body></html>');
		$(target).data("loading", true).html("正在提交...");
		$.ajax({
			url: '/order/submit',
			type: 'POST',
			dataType: 'json',
			async: false,
			data: data,
			success: function(result) {
				if (result.code == 0) {
					var url = result.data;
					var urlArr = url.split('?');
					$('.pay_result').attr('href',$('.pay_result').attr('href')+'?'+urlArr[1]);
					// 打开页面
					win_object.location.href = url;
					$('.payment-box').show();
					$('.bg').show();
					return;
				}

				// 失败关闭窗口
				win_object.close();

				if (result.code != 0) {
					$("#" + result.data).addClass('bgcolor');
					$.msg(result.message);
				}
			}
		}).always(function() {
			$(target).data("loading", false).html("确认交易");
		});
	});
	
});

function resetSubmitPosition(bb, cc) {
	if ($(".confirm-pay").size() > 0) {
		if (bb == undefined || cc == undefined) {
			b = $(".confirm-pay").offset().top;
			c = $(".confirm-pay").outerHeight();
		} else {
			b = bb;
			c = cc;
		}
		var d = $(window).height();
		var e = $(window).scrollTop();
		var f = $('.site-footer').height();
		b - d - e + c - 10 > 0 ? ($(".confirm-pay").addClass("bottom")) : ($(".confirm-pay").removeClass("bottom"));
	}
}

// 调用发货地址添加地址显示层
function showAddressHtml() {
	$.ajax({
		type: 'GET',
		url: '/cart/address',
		dataType: 'html',
		success: function(result) {
			$('#edit-address-div').html(result);
		}
	});
}

// 取消添加地址
function cancel() {
	$('.addr-box').hide();
	$('.bg').hide();
}

// 变更设置支付信息
function changePayment(o) {
	$(o).parent().find('.seled').removeClass('seled');
	$(o).addClass('seled');
}
