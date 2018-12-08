<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/static/css/skuselector.css" />
<div class="pop-choose-spec-mask" style="display: block;"></div>
<div id="${product.code}" class="pop-choose-spec-main"
	style="display: block;">
	<div class="pop-choose-spec-header">
		<img src="http://pijbgt8k2.bkt.clouddn.com/${product.images[0]}?imageView2/1/w/96/h/96"
			class='goods-thumb SZY-GOODS-IMAGE' />
		<div class="attribute-header-right">
			<span class="goodprice choose-result-price"><em
				class="SZY-GOODS-PRICE">￥${product.minPrice*0.01} - ${product.maxPrice*0.01}</em></span><span
				class="goods-number SZY-GOODS-NUMBER">库存0件</span>
		</div>
		<a class="pop-choose-spec-close" href="javascript:void(0);" title="关闭"></a>
	</div>
	<div class="pop-choose-spec-con">
		<div class="attr-list choose">
			<c:forEach var="attrName" items="${attrNameList}">
			<dl class="attr">
				<dt class="dt">${attrName}：</dt>
				<dd class="dd">
					<ul>
						<c:forEach var="op" items="${attrMap[attrName]}">
						<li data-spec-id="${op.k}" data-is-default="0"><a
							href="javascript:void(0);" title="${op.v}"><span
								class="value-label">${op.v}</span></a></li>
						</c:forEach>
					</ul>
				</dd>
			</dl>
			</c:forEach>
		</div>
		<div class="choose-btn">
			<dl class="amount">
				<dt class="dt">购买数量：</dt>
				<dd class="dd">
					<span class="amount-widget"><input type="text"
						class="amount-input" value="1" maxlength="8" title="请输入购买量"><span
						class="amount-btn"><span class="amount-plus"><i>+</i></span><span
							class="amount-minus"><i>-</i></span></span><span class="amount-unit">件</span></span>
				</dd>
			</dl>
			<input type="button" class="btn btn-primary btn-add-cart"
				value="加入购物车" /><input type="button"
				class="btn pop-choose-spec-close" value="取消" />
		</div>
	</div>
</div>
<script type="text">
格式示例：
[
	{
		"sku_id":"32564",
		"spec_ids":"15221|15229",
		"goods_number":"9843",
		"goods_price":"16.80",
		"sku_image":"79.jpg",
		"sku_image_thumb":"79.jpg",
		"market_price" : 22.89
	},
	{
		"sku_id":"32590",
		"spec_ids":"15221|15224",
		"goods_number":"9705",
		"goods_price":"16.80",
		"sku_image":"80.jpg",
		"sku_image_thumb":"80.jpg",
		"market_price" : 22.89
	}
]
</script>
<script id="SZY_SKU_LIST_${product.code}" type="text">${skuListJson}</script>
<script type="text/javascript" src="/static/js/jquery.widget.js"></script>
<script type="text/javascript">
$().ready(function() {
	var productPropChooser = $("#${product.code}");

	var sku_ids = {};
	var sku_lists = $.parseJSON($("#SZY_SKU_LIST_${product.code}").html());
	for(var i=0;i<sku_lists.length;i++){
		var theSku = sku_lists[i];
		sku_ids[theSku['spec_ids']] = theSku;
	}

	function getSkuId() {
		var spec_ids = [];

		productPropChooser.find(".choose")
			.find(".attr").each(function() {
				var spec_id = $(this).find(".selected").data("spec-id");
				spec_ids.push(spec_id);
			});

		var sku_id = $.cart.getSkuId(spec_ids, sku_ids);
		return sku_id;
	}

	function getSkuInfo() {
		var sku_id = getSkuId();
		for (var spec_id in sku_ids) {
			var sku = sku_ids[spec_id];
			if (sku.sku_id == sku_id) {
				return sku;
			}
		}
		return null;
	}

	function setSkuInfo(sku) {
		var goods_number = 0;
		var goods_price = 0;
		var goods_image = "http://pijbgt8k2.bkt.clouddn.com/${product.images[0]}?imageView2/1/w/96/h/96";
		if (sku == null) {
			productPropChooser.find(".btn-add-cart").addClass("disabled");
			productPropChooser.find(".SZY-GOODS-NUMBER").html("库存不足");
		} else {
			productPropChooser.find(".btn-add-cart").removeClass("disabled");
			goods_number = sku.goods_number;
			goods_price = sku.goods_price*0.01;
			productPropChooser.find(".SZY-GOODS-IMAGE").attr("src", "http://pijbgt8k2.bkt.clouddn.com/"+sku.sku_image_thumb+"?imageView2/1/w/96/h/96");
			productPropChooser.find(".SZY-GOODS-NUMBER").html("库存" + goods_number + "件");
		}

		// 设置步进器
		var amount_obj = productPropChooser.find(".amount-input");
		$(amount_obj).data("amount-max", goods_number);
		if (goods_number > 0 && $(".amount-input").val() == 0) {
			$(amount_obj).val(1);
		} else if (goods_number == 0 && $(".amount-input").val() != 0) {
			$(amount_obj).val(0);
		}

		var goods_number_input = parseInt($(amount_obj).val());
		if (goods_number_input > goods_number) {
			$(amount_obj).val(goods_number);
		}
		var format = "￥#0#";
		productPropChooser.find(".SZY-GOODS-PRICE").html(format.replace("#0#", goods_price));
	}

	function getSkuImage() {
		var image_url = undefined;
		productPropChooser.find(".choose").find(".attr").each(function() {
			var spec_id = $(this).find(".selected").data("spec-id");
			image_url = $(this).find(".selected").find("img").attr("src");
			return false;
		});

		if (!image_url) {
			image_url = "http://pijbgt8k2.bkt.clouddn.com/${product.images[0]}?imageView2/1/w/96/h/96";
		}

		return image_url;
	}

	// 步进器
	productPropChooser.find(".amount-input").amount({value: 1,min: 1});
	productPropChooser.find(".amount-input").val(1);
	productPropChooser.find(".choose li").click(function() {
			if ($(this).hasClass("invalid")) {
				return;
			}
			$(this).siblings(".selected").removeClass("selected").find("i").remove();
			$(this).addClass("selected").append("<i></i>");
			var sku = getSkuInfo();
			setSkuInfo(sku);
		}).hover(
			function() {
				$(this).addClass("selected");
			},
			function() {
				if ($(this).find("i").size() == 0) {
					$(this).removeClass("selected");
				}
	});


	//选中第一个有效的sku
	for(var key in sku_ids){
		var firstSku = sku_ids[key];
		if(null!=firstSku){
			var opIdArr = key.split('\|');
			var attrGroup = productPropChooser.find(".choose .attr");
			for(var i=0;i<opIdArr.length;i++){
				var currentLi = attrGroup.eq(i).find('li[data-spec-id="'+opIdArr[i]+'"]');
				$(currentLi).click();
			}
			break;
		}
	}

	// 加入购物车
	productPropChooser.find(".btn-add-cart").click(function(event) {
			if ($(this).hasClass("disabled")) {
				return;
			}
			var sku_id = getSkuId();
			var image_url = getSkuImage();
			var goods_number = productPropChooser.find(".amount-input").val();
			$.cart.add(sku_id, goods_number,
					{is_sku: true,event: event,image_url: image_url,
						callback: function() {
							productPropChooser.find(".pop-choose-spec-close").click();
						}
					});
	});

	productPropChooser.find(".pop-choose-spec-close").click(function() {
			$(".pop-choose-spec-mask").remove();
			$(".pop-choose-spec-main").remove();
	});

});
