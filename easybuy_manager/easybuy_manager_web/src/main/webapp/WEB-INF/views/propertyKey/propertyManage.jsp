<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="easyui-layout" style="" data-options="fit:true">
    <div data-options="region:'west',title:'分类列表',split:true,border:true" style="width:300px;">
			<ul id="productTypeTree" class="easyui-tree"
				data-options="
						url: '/productType/tree',
						method: 'get',
						state:'closed',
						animate: true,
						onClick: clickTreeNode,
						onLoadSuccess:function(){
							$('#productTypeTree').tree('collapseAll');
						}
					"></ul>
    </div>
    <div data-options="region:'center',border:true,title:'属性key'">
    		<div class="tableGroup">
				<table id="propertyGrid" class="easyui-datagrid"
							data-options="singleSelect:true,fit:true,method:'get',
							pagination:false,striped:true,onSelect:selectProperty,onLoadSuccess:loadPropertySuccess,
							toolbar:'#propertyTB',url:'/propertyKey/json'">
						<thead>
							<tr>
								<th data-options="field:'propertyKey',width:120">属性名</th>
								<th data-options="field:'type',width:120,formatter:formatterPropertyType">类型</th>
								<th data-options="field:'inputMode',width:120,formatter:formatterInputMode">输入模式</th>
								<!-- <th data-options="field:'inputType',width:120">输入类型</th>
								<th data-options="field:'remark',width:120">属性说明</th> -->
							</tr>
						</thead>
				</table>
				<div id="propertyTB">
						<div>
							<a href="#" data-cmd="add" id="addPropertyBtn" class="easyui-linkbutton" data-options="disabled:true" iconCls="icon-add" plain="true">添加</a>
							<a href="#" data-cmd="edit" mustsel remote="false" data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
							<!-- <a href="#" data-cmd="del" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a> -->
							<a href="#" data-cmd="show" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-tip" plain="true">查看</a>
						</div>
				</div>
			</div>
    </div>

    <div data-options="region:'east',border:true,title:'属性value'" style="width:400px;">
    	<div class="tableGroup">
				<table id="propertyOptionGrid" class="easyui-datagrid"
							data-options="singleSelect:true,fit:true,method:'get',
							pagination:false,striped:true,
							toolbar:'#propertyOptionTB',url:'/propertyValue/json'">
						<thead>
							<tr>
								<th data-options="field:'propertyValue',width:120">选项值</th>
								<th data-options="field:'optionPic',width:120">配图</th>
							</tr>
						</thead>
				</table>
				<div id="propertyOptionTB">
						<div>
							<a href="#" id="addPropertyOptionBtn" data-cmd="add" class="easyui-linkbutton" data-options="disabled:true" iconCls="icon-add" plain="true">添加</a>
							<a href="#" data-cmd="edit" mustsel remote="false" data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
							<a href="#" data-cmd="del" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
							<a href="#" data-cmd="show" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-tip" plain="true">查看</a>
						</div>
				</div>
			</div>
    </div>
</div>

<script type="text/javascript">
	function formatterPropertyType(value,row,index){
		if(0==value){
			return '显示';
		}else if(1==value){
			return '销售';
		}
		return '';
	}
	function formatterInputMode(value,row,index){
		if(0==value){
			return '文本框';
		}else if(1==value){
			return '下拉列表';
		}else if(2==value){
			return '复选框';
		}
		return '';
	}
	function clickTreeNode(node){
		if(null==node.children || 0==node.children.length){//叶子节点
			$('#propertyGrid').datagrid('load',{productType : node.id});
			$('#propertyTB').find('a[data-cmd]').linkbutton('disable');
			$('#addPropertyBtn').linkbutton('enable');
		}else{
			$('#propertyGrid').datagrid('load',{});
			$('#propertyTB').find('a[data-cmd]').linkbutton('disable');
		}
	}

	function loadPropertySuccess(data){
		$('#propertyOptionTB').find('a[data-cmd]').linkbutton('disable');
		$('#propertyOptionGrid').datagrid('load',{});
	}

	function selectProperty(index,row){
		if(0==row.inputMode){//文本框输入模式
			$('#propertyOptionTB').find('a[data-cmd]').linkbutton('disable');
			$('#propertyOptionGrid').datagrid('load',{propertyKeyId : row.id});
		}else{
			$('#addPropertyOptionBtn').linkbutton('enable');
			$('#propertyOptionGrid').datagrid('load',{propertyKeyId : row.id});
		}
	}
</script>
