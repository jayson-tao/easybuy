<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post" action="/propertyKey/store">
		<input type="hidden" name="id" />
		<input type="hidden" name="productType" />
		<div class="input-div">
            <label class="label-top">属性名</label>
            <input class="easyui-textbox theme-textbox-radius" name="propertyKey" data-options="required:true">
        </div>
		<div class="input-div">
            <label class="label-top">属性类型</label>
            <input name="type" type="radio" checked="checked" value="0"> 显示
            <input name="type"  type="radio"  value="1"> 销售
        </div>
		<div class="input-div">
            <label class="label-top">输入模式</label>
            <select class="easyui-combobox theme-textbox-radius" name="inputMode"
            data-options="required:true,valueField: 'k',textField: 'v',url: '/const/propertyInputMode'"
            style="width:200px">
            </select>
        </div>
		<div class="input-div">
            <label class="label-top">输入类型</label>
            <select class="easyui-combobox theme-textbox-radius" name="inputType"
            data-options="valueField: 'k',textField: 'v',url: '/const/propertyInputType'"
             style="width:200px">
            </select>
        </div>

        <div class="input-div">
            <label class="label-top">备注</label>
            <input class="easyui-textbox theme-textbox-radius" data-options="multiline:true" name="remark"  style="height:80px">
        </div>

		<div class="input-div">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this)">提交</a>
			<a  class="easyui-linkbutton button-lg" onclick="MXF.clearForm(this)">清空</a>
        </div>
</form>
