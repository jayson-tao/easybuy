<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post" action="/propertyValue/store">
		<input type="hidden" name="id" />
		<input type="hidden" name="propertyKeyId" />
		<div class="input-div">
            <label class="label-top">选项值</label>
            <input class="easyui-textbox theme-textbox-radius" name="propertyValue" data-options="required:true">
        </div>
		<div class="input-div">
            <label class="label-top">配图</label>
            <input class="easyui-textbox theme-textbox-radius" name="optionPic">
        </div>
        
		<div class="input-div">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this)">提交</a>
			<a  class="easyui-linkbutton button-lg" onclick="MXF.clearForm(this)">清空</a>
        </div>
</form>