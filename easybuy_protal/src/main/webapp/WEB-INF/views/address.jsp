<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="UserAddressModel" class="form-horizontal" name="UserAddressModel" action="/cart/address/store" method="post">
	<input type="hidden" name="id" value="${address.id}"/>
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-reciver" class="input-left"><span
			class="spark">*</span><span>收货人：</span></label>
		<div class="form-control-box">
			<input type="text" id="useraddressmodel-reciver"
				class="form-control" name="reciver" value="${address.reciver}">
		</div>
		<div class="invalid"></div>
	</div>
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-areaCode" class="input-left"><span
			class="spark">*</span><span>收货地址：</span></label>
		<div class="form-control-box">
			<span id="areaCode_containter" class="region-select"></span><input
				type="hidden" id="areaCode" name="areaCode" value="${address.areaCode}">
		</div>
		<div class="invalid"></div>
	</div>
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-address" class="input-left"><span
			class="spark">*</span><span>详细地址：</span></label>
		<div class="form-control-box">
			<textarea id="useraddressmodel-address"
				class="form-control address"
				name="address" rows="5"
				placeholder="建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息">${address.address}</textarea>
		</div>
		<div class="invalid"></div>
	</div>
	
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-phone" class="input-left"><span
			class="spark">*</span><span>手机号码：</span></label>
		<div class="form-control-box">
			<input type="text" id="useraddressmodel-phone" class="form-control"
				name="phone" placeholder="手机号码" value="${address.phone}">
		</div>
		<div class="invalid"></div>
	</div>
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-phone-back" class="input-left"><span>备用手机号码：</span></label>
		<div class="form-control-box">
			<input type="text" id="useraddressmodel-phone-back" class="form-control"
			value="${address.phoneBack}" name="phoneBack" placeholder="备用手机号码">
		</div>
		<div class="invalid"></div>
	</div>
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-postCode" class="input-left"><span>邮编：</span></label>
		<div class="form-control-box">
			<input type="text" id="useraddressmodel-postCode" class="form-control"
				name="postCode" placeholder="邮编" value="${address.postCode}">
		</div>
		<div class="invalid"></div>
	</div>
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-email" class="input-left"><span>电子邮箱：</span></label>
		<div class="form-control-box">
			<input type="text" id="useraddressmodel-email" class="form-control"
				name="email" placeholder="电子邮箱" value="${address.email}">
		</div>
		<div class="invalid"></div>
	</div>
	<div class="form-group form-group-spe">
		<label for="useraddressmodel-tel" class="input-left"><span>固定电话：</span></label>
		<div class="form-control-box">
			<input type="text" id="useraddressmodel-tel" class="form-control"
				name="tel" placeholder="固定电话" value="${address.tel}">
		</div>
		<div class="invalid"></div>
	</div>
	<div class="act">
		<input type="button" id="btn_save" value="保存收货地址"><input
			type="button" value="取消" class="m-l-10" onclick="cancel()">
	</div>
</form>
<script id="client_rules" type="text">
[{"id": "useraddressmodel-areaCode", "name": "areaCode", "attribute": "areaCode", "rules": 
	{"required":true,"messages":{"required":"收货地址不能为空。"}}},
{"id": "useraddressmodel-reciver", "name": "reciver", "attribute": "reciver", "rules": 
	{"required":true,"messages":{"required":"收货人不能为空。"}}},
{"id": "useraddressmodel-address", "name": "address", "attribute": "address", "rules": 
	{"required":true,"messages":{"required":"详细地址不能为空。"}}},
{"id": "useraddressmodel-phone", "name": "phone", "attribute": "phone", "rules": 
	{"required":true,"messages":{"required":"手机号码不能为空。"}}},
{"id": "useraddressmodel-reciver", "name": "reciver", "attribute": "reciver", "rules": 
	{"string":true,"messages":{"string":"收货人必须是一条字符串。","maxlength":"收货人只能包含至多60个字符。"},"maxlength":60}},
{"id": "useraddressmodel-email", "name": "email", "attribute": "email", "rules": 
	{"string":true,"messages":{"string":"邮件地址必须是一条字符串。","maxlength":"邮件地址只能包含至多60个字符。"},"maxlength":60}},
{"id": "useraddressmodel-phone", "name": "phone", "attribute": "phone", "rules": 
	{"string":true,"messages":{"string":"手机号码必须是一条字符串。","maxlength":"手机号码只能包含至多20个字符。"},"maxlength":20}},
{"id": "useraddressmodel-tel", "name": "tel", "attribute": "tel", "rules": 
	{"string":true,"messages":{"string":"固定电话必须是一条字符串。","maxlength":"固定电话只能包含至多20个字符。"},"maxlength":20}},
{"id": "useraddressmodel-areaCode", "name": "areaCode", "attribute": "areaCode", "rules": 
	{"string":true,"messages":{"string":"收货地址必须是一条字符串。","maxlength":"收货地址只能包含至多255个字符。"},"maxlength":255}},
{"id": "useraddressmodel-address", "name": "address", "attribute": "address", "rules": 
	{"string":true,"messages":{"string":"详细地址必须是一条字符串。","maxlength":"详细地址只能包含至多50个字符。"},"maxlength":50}},
{"id": "useraddressmodel-postCode", "name": "postCode", "attribute": "postCode", "rules": 
	{"string":true,"messages":{"string":"邮编必须是一条字符串。","maxlength":"邮编只能包含至多6个字符。"},"maxlength":6}},
{"id": "useraddressmodel-phone", "name": "phone", "attribute": "phone", "rules": 
	{"match":{"pattern":/^13[0-9]{1}[0-9]{8}$|15[0-9]{1}[0-9]{8}$|18[0-9]{1}[0-9]{8}$|17[0-9]{1}[0-9]{8}$|14[0-9]{1}[0-9]{8}$/,"not":false,"skipOnEmpty":1},"messages":{"match":"手机号码是无效的。"}}},
{"id": "useraddressmodel-tel", "name": "tel", "attribute": "tel", "rules": 
	{"match":{"pattern":/^0[0-9]{2,3}-[0-9]{7,8}$/,"not":false,"skipOnEmpty":1},"messages":{"match":"固定电话是无效的。"}}},
{"id": "useraddressmodel-email", "name": "email", "attribute": "email", "rules": 
	{"email":{"pattern":/^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$/,"fullPattern":/^[^@]*<[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?>$/,"allowName":false,"enableIDN":false,"skipOnEmpty":1},"messages":{"email":"邮件地址不是有效的邮箱地址。"}}},
{"id": "useraddressmodel-postCode", "name": "postCode", "attribute": "postCode", "rules": 
	{"match":{"pattern":/^[0-9]{6}$/,"not":false,"skipOnEmpty":1},"messages":{"match":"邮编是无效的。"}}}]
</script>
<script type="text/javascript">
$().ready(function() {
	var regionselector_init = true;
	var initCode = "${address.areaCode}";
	if(''==initCode || 'null'==initCode) initCode = '51,01';
	var regionselector_reload = false;// 地区选择
	var regionselector = $("#areaCode_containter").regionselector({
		value: initCode,
		select_class: "select",
		change: function(value, names, is_last) {
			$("#areaCode").val(value);
			$("#areaCode").data("is_last", is_last);
			
			if (regionselector_reload) {
				regionselector_reload = false;
				return;
			}
			if (regionselector_init) {
				regionselector_init = false;
				return;
			}
			if (value != "") {
				var adcode = value.split(",");
				adcode = adcode.slice(0, 2).join("");
			}
		}
	  });
		
		
		var validator = $("#UserAddressModel").validate();
		// 验证规则，此验证规则会影响编辑器中JavaScript的的格式化操作
		$.validator.addRules($("#client_rules").html());
		$("#btn_save").click(function() {
			if (!validator.form()) {
				return false;
			}
			
			var data = $("#UserAddressModel").serializeJson();
			var action = $("#UserAddressModel").attr('action');
			$.post(action, data, function(result) {
				if (result.code == 0) {
					$.msg(result.message);
					var id = $('#UserAddressModel').find('input[name=id]').val();
					cancel();
					
					//刷新地址区域数据
					var address = result.data;
					if(''!=id){//修改，删除原数据
						$('.address-list').find('.address-box[data-address-id='+id+']').remove();
					}
					var newAddress = createAddressDiv(address);
					$('.address-list').append(newAddress);
					$('.address-list').find('.active').removeClass('active');
					newAddress.addClass('active');
				} else {
					$.msg(result.message+' '+result.info, {time: 3000});
				}
			}, "json");
		});
		
		function createAddressDiv(address){
			console.debug(address);
			var newAddress = $('#addressTemplate').clone(true);
			newAddress.removeAttr('id');
			newAddress.attr('data-address-id',address.id);
			var boxInfo = newAddress.find('.address-box-info');
			boxInfo.attr('data-address-id',address.id);
			boxInfo.find('.name').html(address.reciver);
			boxInfo.find('.detaile').html(address.fullAddress);
			boxInfo.find('.number-phone').html(address.phone);
			
			var boxOperate = newAddress.find('.addr-operate');
			boxOperate.find('a').attr('data-address-id',address.id);
			if(address.defaultAddress == 0){
				boxOperate.find('.deftip').remove();
			}else{
				boxOperate.find('.address-default').remove();
			}
			newAddress.css('display','block');
			return newAddress;
		}
	});
</script>
