<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form  method="post" action="/brand/store">
		<input type="hidden" name="id" />
		<div class="input-div">
            <label class="label-top">品牌名</label>
            <input class="easyui-textbox theme-textbox-radius" name="name" data-options="required:true">
        </div>

		<div class="input-div">
            <label class="label-top">英文名</label>
            <input class="easyui-textbox theme-textbox-radius" name="englishName">
        </div>

		<div class="input-div">
            <label class="label-top">商品类型</label>
            <input class="easyui-combotree theme-textbox-radius" name="productType" data-options="required:true,url:'/productType/tree',method:'get'">
        </div>

        <div class="input-div">
            <label class="label-top">排序号</label>
            <input class="easyui-textbox theme-textbox-radius" name="sortIndex">
        </div>

        <div class="input-div">
            <label class="label-top">LOGO</label>
            <div style="width:478px;float:right;">
	            <input name="logo" class="qiniuUploader" multiply="false" value="${brand.logo}"/>
	            <script type="text/javascript">
	            MXF.initQiniuUploader($('input[name="logo"]'));
	            </script>
            </div>
        </div>

        <div class="input-div">
            <label class="label-top">品牌简介</label>
            <input class="easyui-textbox theme-textbox-radius" data-options="multiline:true" name="description" style="height:60px;">
        </div>

		<div class="input-div">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this)">提交</a>
			<a  class="easyui-linkbutton button-lg" onclick="MXF.clearForm(this)">清空</a>
        </div>
</form>
