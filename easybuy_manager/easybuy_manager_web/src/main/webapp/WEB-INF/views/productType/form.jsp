<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form id="productTypeForm" method="post" action="/productType/store">
		<input type="hidden" name="id" />
		<div class="input-div">
            <label class="label-top">分类名</label>
            <input class="easyui-textbox theme-textbox-radius" name="name" data-options="required:true">
        </div>
        
		<div class="input-div">
            <label class="label-top">父类</label>
            <input id="productTypeTreeCombo" class="easyui-combotree theme-textbox-radius" name="pid" data-options="url:'/productType/tree',method:'get',
						onLoadSuccess:function(){
							var comboTree = $('#productTypeTreeCombo').combotree('tree');
							$(comboTree).tree('collapseAll');
						}">
        </div>
        
		<div class="input-div">
            <label class="label-top">排序</label>
            <input class="easyui-textbox theme-textbox-radius" name="sortIndex">
        </div>

		<div class="input-div">
            <label class="label-top">LOGO(图标)</label>
            <input class="easyui-textbox theme-textbox-radius" name="logo">
        </div>
        
		<div class="input-div">
            <label class="label-top">SEO关键字</label>
            <input class="easyui-textbox theme-textbox-radius" name="seoKeywords">
        </div>
		
		<div class="input-div">
            <label class="label-top">SEO标题</label>
            <input class="easyui-textbox theme-textbox-radius" name="seoTitle">
        </div>
		
		<div class="input-div">
            <label class="label-top">描述</label>
            <input class="easyui-textbox theme-textbox-radius" data-options="multiline:true" name="description" style="height:50px;">
        </div>
		
		<div class="input-div">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this,productTypeStoreCallBack)">提交</a>
			<a  class="easyui-linkbutton button-lg" onclick="MXF.clearForm(this)">清空</a>
        </div>
</form>

<script>
function productTypeStoreCallBack($form,data){
	if(data.success){
		//MXF.clearForm($form);
		$('#productTypeTree').tree('reload');
	}	
}
</script>