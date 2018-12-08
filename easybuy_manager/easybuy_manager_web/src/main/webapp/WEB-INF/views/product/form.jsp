<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="post" action="/product/store">
		<input type="hidden" name="id" />
		<div class="input-div">
            <label class="label-top">商品名</label>
            <input class="easyui-textbox theme-textbox-radius" name="name" data-options="required:true">
        </div>
		<div class="input-div">
            <label class="label-top">副名称</label>
            <input class="easyui-textbox theme-textbox-radius" name="subName">
        </div>
		<div class="input-div">
            <label class="label-top">类型</label>
            <input id="productTypeTree"  class="easyui-tree easyui-combotree theme-textbox-radius" name="productType"
            data-options="required:true,url:'/productType/tree',method:'get',onChange:changeProductType
            ,state:'closed',onLoadSuccess:function(){
							$('#productTypeTree').tree('collapseAll');
						}">
        </div>
		<div class="input-div">
            <label class="label-top">品牌</label>
            <input id="brandCombo" class="easyui-textbox theme-textbox-radius" name="brandId" value="${product.brandId}">
        </div>
        <div class="input-div">
            <%--上传到七牛云 qiniuUploader.js--%>
            <label class="label-top">图片</label>
            <div style="margin-left:120px;margin-top: -20px;">
            <input name="resources" class="qiniuUploader" multiply="true" maxFiles="5" value="${resources}"/>
            </div>
        </div>
		<div class="input-div">
			<label class="label-top">商品属性集</label>
			<select id="propertiesCombobox" class="easyui-combobox" name="propertyKeyIds"
			data-options="required:true,valueField: 'id',textField: 'propertyKey',onLoadSuccess:initPropertiesValue,
			multiple:true,url:'/propertyKey/json?productType=${productType}'"
			style="width:450px;">
            </select>
		</div>
		<div class="input-div">
            <label class="label-top">简介(关键字)</label>
            <input class="easyui-textbox theme-textbox-radius" data-options="multiline:true" style="height:60px;"
            name="productExt.description" value="${productExt.description}">
        </div>
		<div class="input-div" style="padding-left:115px;">
            <script id="productUeditor${mills}" name="productExt.richContent" type="text/plain" style="height:300px;">
				${productExt.richContent}
            </script>

            <script type="text/javascript">
	           var ue = UE.getEditor('productUeditor${mills}');
	        </script>
        </div>



		<div class="input-div">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this)">提交</a>
			<a  class="easyui-linkbutton button-lg" onclick="MXF.clearForm(this)">清空</a>
        </div>
        <hr style="border:0;margin-bottom:20px;"/>
</form>
<script>
function initPropertiesValue(){
	$('#propertiesCombobox').combobox('setValues',[${selectProperties}]);
}
function changeProductType(newValue,oldValue){
	$('#propertiesCombobox').combobox('setValues',[]);
	$('#propertiesCombobox').combobox('reload','/propertyKey/json?productType='+newValue);
}

MXF.initQiniuUploader($('input[name="resources"]'));

$('#brandCombo').combogrid({
    panelWidth:450,
    url: '/brand/data',
    idField:'id',
    textField:'name',
    mode:'remote',
    fitColumns:true,
    columns:[[
        {field:'id',title:'ID',width:10},
        {field:'name',title:'品牌名',width:50},
        {field:'englishName',title:'英文名',align:'center',width:50}
    ]]
});
</script>
