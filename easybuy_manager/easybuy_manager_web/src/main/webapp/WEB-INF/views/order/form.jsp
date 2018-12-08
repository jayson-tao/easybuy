<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post" action="/order/store">
		<input type="hidden" name="id" />
		<div class="input-div">
            <label class="label-top">订单名</label>
            <input class="easyui-textbox theme-textbox-radius" name="name" data-options="required:true">
        </div>
		<div class="input-div">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this)">提交</a>
			<a  class="easyui-linkbutton button-lg" onclick="MXF.clearForm(this)">清空</a>
        </div>
        <hr style="border:0;margin-bottom:20px;"/>
</form>

<script>

</script>