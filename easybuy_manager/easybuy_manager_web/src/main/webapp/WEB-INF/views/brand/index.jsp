<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tableGroup">
	<table class="easyui-datagrid" title="品牌信息"
				data-options="rownumbers:true,fit:true,method:'get',
				pagination:true,pageSize:10,striped:true,singleSelect:false,
				toolbar:'#brandTB',url:'/brand/json'">
			<thead>
				<tr>
					<th data-options="field:'id',checkbox:true"></th>
					<th data-options="field:'name',width:100">品牌名</th>
					<th data-options="field:'englishName',width:150">英文名</th>
					<th data-options="field:'firstLetter',width:80">首字母</th>
					<th data-options="field:'productType',width:100,formatter:MXF.commonFormatter">商品分类</th>
				</tr>
			</thead>
	</table>
	<div id="brandTB">
			<div>
				<a href="#" data-cmd="add" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a href="#" data-cmd="edit" mustsel remote="true" data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
				<a href="#" data-cmd="del" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
				<a href="#" data-cmd="show" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-tip" plain="true">查看</a>
			</div>
			<div class="searchForm">
				<form>
					品牌名: 
					<input class="easyui-textbox theme-textbox-radius" name="keyword" style="width:100px;">
					商品类型: 
					<input class="easyui-combotree theme-textbox-radius" name="productType" 
					data-options="url:'/productType/tree',method:'get'" style="width:200px;">
					<a href="javascript:;" data-cmd="search" class="easyui-linkbutton button-default">查询</a>
					<a href="javascript:;" data-cmd="resetSearch" class="easyui-linkbutton">重置</a>
				</form>
			</div>
	</div>
</div>
	