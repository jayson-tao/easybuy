<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>

<!-- 正文，由view提供 -->

				<div class="con-right fr">
					<script type="text/javascript" src="/static/js/user_address.js"></script>
					<div class="con-right-text">
						<div class="tabmenu">
							<ul class="tab">
								<li class="active">收货地址</li>
							</ul>
						</div>
						<div class="content-info">
							<div class="address-info">
								<h2>
				
				<a href="javascript:add()">新增收货地址</a>
				
				<span>（已保存了2条地址，还能保存18条地址）</span>
			</h2>
								<div id="edit-address-div">
									<form id="UserAddressModel" class="form-horizontal" name="UserAddressModel" action="http://www.yaorange.com/user/address/add.html" method="post" novalidate="novalidate">
										<div class="form-group form-group-spe">
											<label for="useraddressmodel-consignee" class="input-left">
<span class="spark">*</span>
<span>收货人：</span>
</label>
											<div class="form-control-box">

												<input type="text" id="useraddressmodel-consignee" class="form-control error" name="UserAddressModel[consignee]" aria-required="true" aria-invalid="true">

											</div><span id="useraddressmodel-consignee-error" data-error-id="useraddressmodel-consignee-error" class="form-control-error"><i class="fa fa-warning"></i>收货人不能为空。</span>

											<div class="invalid"></div>
										</div>

										<div class="form-group form-group-spe">
											<label for="useraddressmodel-region_code" class="input-left">
<span class="spark">*</span>
<span>收货地址：</span>
</label>
											<div class="form-control-box">

												<span id="region_code_containter" class="region-select"></span>
												<input type="hidden" id="region_code" name="UserAddressModel[region_code]" aria-required="true" value="">

											</div>

											<div class="invalid"></div>
										</div>

										<div class="form-group form-group-spe">
											<label for="useraddressmodel-address_detail" class="input-left">
<span class="spark">*</span>
<span>详细地址：</span>
</label>
											<div class="form-control-box">

												<textarea id="useraddressmodel-address_detail" class="form-control" name="UserAddressModel[address_detail]" rows="5" placeholder="建议您如实填写详细收货地址，例如街道名称，门牌号码，楼层和房间号等信息" aria-required="true"></textarea>

											</div>

											<div class="invalid"></div>
										</div>

										<div class="form-group form-group-spe">
											<label for="useraddressmodel-mobile" class="input-left">
<span class="spark">*</span>
<span>手机号码：</span>
</label>
											<div class="form-control-box">

												<input type="text" id="useraddressmodel-mobile" class="form-control" name="UserAddressModel[mobile]" placeholder="手机号码" aria-required="true">

											</div>

											<div class="invalid"></div>
										</div>

										<div class="form-group form-group-spe">
											<label for="useraddressmodel-tel" class="input-left">

<span>固定电话：</span>
</label>
											<div class="form-control-box">

												<input type="text" id="useraddressmodel-tel" class="form-control" name="UserAddressModel[tel]" placeholder="固定电话">

											</div>

											<div class="invalid"></div>
										</div>

										<div class="form-group form-group-spe">
											<label for="useraddressmodel-email" class="input-left">

<span>邮件地址：</span>
</label>
											<div class="form-control-box">

												<input type="text" id="useraddressmodel-email" class="form-control" name="UserAddressModel[email]" placeholder="xxx@xx.xx">

											</div>

											<div class="invalid"></div>
										</div>
										
										<div class="act">
											<input type="button" id="btn_save" value="保存收货地址">
											<input type="button" value="取消" class="m-l-10" onclick="cancel()">
										</div>

									</form>
									<script id="client_rules" type="text">
										[{"id": "useraddressmodel-region_code", "name": "UserAddressModel[region_code]", "attribute": "region_code", "rules": {"required":true,"messages":{"required":"收货地址不能为空。"}}},{"id": "useraddressmodel-user_id", "name": "UserAddressModel[user_id]", "attribute": "user_id", "rules": {"required":true,"messages":{"required":"用户ID不能为空。"}}},{"id": "useraddressmodel-consignee", "name": "UserAddressModel[consignee]", "attribute": "consignee", "rules": {"required":true,"messages":{"required":"收货人不能为空。"}}},{"id": "useraddressmodel-address_detail", "name": "UserAddressModel[address_detail]", "attribute": "address_detail", "rules": {"required":true,"messages":{"required":"详细地址不能为空。"}}},{"id": "useraddressmodel-mobile", "name": "UserAddressModel[mobile]", "attribute": "mobile", "rules": {"required":true,"messages":{"required":"手机号码不能为空。"}}},{"id": "useraddressmodel-user_id", "name": "UserAddressModel[user_id]", "attribute": "user_id", "rules": {"integer":true,"messages":{"integer":"用户ID必须是整数。"}}},{"id": "useraddressmodel-address_name", "name": "UserAddressModel[address_name]", "attribute": "address_name", "rules": {"string":true,"messages":{"string":"地址别名必须是一条字符串。","maxlength":"地址别名只能包含至多60个字。"},"maxlength":60}},{"id": "useraddressmodel-consignee", "name": "UserAddressModel[consignee]", "attribute": "consignee", "rules": {"string":true,"messages":{"string":"收货人必须是一条字符串。","maxlength":"收货人只能包含至多60个字。"},"maxlength":60}},{"id": "useraddressmodel-email", "name": "UserAddressModel[email]", "attribute": "email", "rules": {"string":true,"messages":{"string":"邮件地址必须是一条字符串。","maxlength":"邮件地址只能包含至多60个字。"},"maxlength":60}},{"id": "useraddressmodel-mobile", "name": "UserAddressModel[mobile]", "attribute": "mobile", "rules": {"string":true,"messages":{"string":"手机号码必须是一条字符串。","maxlength":"手机号码只能包含至多20个字。"},"maxlength":20}},{"id": "useraddressmodel-tel", "name": "UserAddressModel[tel]", "attribute": "tel", "rules": {"string":true,"messages":{"string":"固定电话必须是一条字符串。","maxlength":"固定电话只能包含至多20个字。"},"maxlength":20}},{"id": "useraddressmodel-region_code", "name": "UserAddressModel[region_code]", "attribute": "region_code", "rules": {"string":true,"messages":{"string":"收货地址必须是一条字符串。","maxlength":"收货地址只能包含至多255个字。"},"maxlength":255}},{"id": "useraddressmodel-address_detail", "name": "UserAddressModel[address_detail]", "attribute": "address_detail", "rules": {"string":true,"messages":{"string":"详细地址必须是一条字符串。","maxlength":"详细地址只能包含至多255个字。"},"maxlength":255}},{"id": "useraddressmodel-zipcode", "name": "UserAddressModel[zipcode]", "attribute": "zipcode", "rules": {"string":true,"messages":{"string":"邮编必须是一条字符串。","maxlength":"邮编只能包含至多6个字。"},"maxlength":6}},{"id": "useraddressmodel-mobile", "name": "UserAddressModel[mobile]", "attribute": "mobile", "rules": {"match":{"pattern":/^13[0-9]{1}[0-9]{8}$|15[0-9]{1}[0-9]{8}$|18[0-9]{1}[0-9]{8}$|17[0-9]{1}[0-9]{8}$|14[0-9]{1}[0-9]{8}$/,"not":false,"skipOnEmpty":1},"messages":{"match":"手机号码是无效的。"}}},{"id": "useraddressmodel-tel", "name": "UserAddressModel[tel]", "attribute": "tel", "rules": {"match":{"pattern":/^0[0-9]{2,3}-[0-9]{7,8}$/,"not":false,"skipOnEmpty":1},"messages":{"match":"固定电话是无效的。"}}},{"id": "useraddressmodel-email", "name": "UserAddressModel[email]", "attribute": "email", "rules": {"email":{"pattern":/^[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$/,"fullPattern":/^[^@]*<[a-zA-Z0-9!#$%& '*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?>$/,"allowName":false,"enableIDN":false,"skipOnEmpty":1},"messages":{"email":"邮件地址不是有效的邮箱地址。"}}},{"id": "useraddressmodel-zipcode", "name": "UserAddressModel[zipcode]", "attribute": "zipcode", "rules": {"match":{"pattern":/^[0-9]{6}$/,"not":false,"skipOnEmpty":1},"messages":{"match":"邮编是无效的。"}}},]
									</script>
									<script type="text/javascript">
										$().ready(function() {
											var validator = $("#UserAddressModel").validate();
											// 验证规则，此验证规则会影响编辑器中JavaScript的的格式化操作
											$.validator.addRules($("#client_rules").html());
											$("#btn_save").click(function() {
												if(!validator.form()) {
													return false;
												}
												var data = $("#UserAddressModel").serializeJson();
												var action = $("#UserAddressModel").attr('action');

												$.post(action, data, function(result) {
													if(result.code == 0) {
														$.msg(result.message);
														cancel();
														$.go(window.location.href);
													} else {
														$('#edit-address-div').html(result.data);
													}
												}, "json");
											});

											// 地区选择
											$("#region_code_containter").regionselector({
												value: '51,01',
												select_class: "select",
												change: function(value, names, is_last) {
													if(is_last) {
														$("#region_code").val(value);
														$("#region_code").valid();
													} else {
														$("#region_code").val("")
													}
												}
											});
										});
									</script>
								</div>

								<div id="table_list">
									<h2>已保存的地址</h2>
									<div class="shipping-address">

										<table class="shipping-list" cellpadding="0" cellspacing="0">
											<colgroup>
												<col style="width: 10%;">
												<col style="width: 10%;">
												<col style="width: 25%;">
												<col style="width: 10%;">
												<col style="width: 14%;">
												<col style="width: 9%;">
												<col style="width: 9%;">
											</colgroup>
											<tbody>
												<tr style="background: rgb(255, 255, 255);">
													<th>收货人</th>
													<th class="region-code-format">收货地址</th>
													<th class="address-detail" style="cursor: default;">详细地址</th>
													<th class="" style="cursor: default;">手机/固定电话</th>
													<th class="email" style="cursor: default;">邮箱</th>
													<th class="" style="cursor: default;">操作</th>
													<th class="address-default">&nbsp;</th>
												</tr>

												<tr style="background: rgb(255, 255, 255);">

													<td align="center">张女士</td>
													<td align="left">四川省 成都市 武侯区</td>
													<td align="left">小区12-1-305</td>
													<td align="center">
														<p>13981728871</p>
														<p></p>
													</td>
													<td align="center">-- --</td>
													<td align="center">
														<a class="address-oprate" href="javascript:edit(571)">修改</a>
														<span class="line">|</span>
														<a class="address-oprate" href="javascript:del(571)">删除</a>
													</td>
													<td align="center">

														<a class="note" href="javascript:set_default(571)" style="display: none;">设为默认</a>

													</td>
												</tr>

												<tr class="address-default" style="background: rgb(255, 255, 255);">

													<td align="center">李先生</td>
													<td align="left">四川省 成都市 郫县</td>
													<td align="left">犀浦镇龙王小区5-2-2</td>
													<td align="center">
														<p>13981728873</p>
														<p></p>
													</td>
													<td align="center">-- --</td>
													<td align="center">
														<a class="address-oprate" href="javascript:edit(570)">修改</a>
														<span class="line">|</span>
														<a class="address-oprate" href="javascript:del(570)">删除</a>
													</td>
													<td align="center">

														<span class="note">默认地址</span>

													</td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>

								<h2>
				
			</h2>
							</div>
						</div>
					</div>
					<!-- 引入地区三级联动js -->
					<script type="text/javascript" src="/static/js/jquery.region.js"></script>
					<!-- 表单验证 -->
					<script type="text/javascript" src="/static/js/jquery.validate.js"></script>
					<script type="text/javascript" src="/static/js/jquery.validate.custom.js"></script>
					<script type="text/javascript" src="/static/js/messages_zh.js"></script>
					<script type="text/javascript">
						var tablelist = null;
						$().ready(function() {
							tablelist = $("#table_list").tablelist({
								page: {
									page_size: 20
								}
							});
						});
					</script>
				</div>

				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>