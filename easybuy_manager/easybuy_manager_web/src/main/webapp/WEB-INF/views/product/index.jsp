<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tableGroup">
	<table id="productGrid" class="easyui-datagrid" title="商品信息"
				data-options="rownumbers:true,fit:true,method:'get',
				pagination:true,pageSize:10,striped:true,singleSelect:false,
				toolbar:'#productTB',url:'/product/json'">
			<thead>
				<tr>
					<th data-options="field:'id',checkbox:true"></th>
					<th data-options="field:'code',width:120">商品编码</th>
					<th data-options="field:'name',width:300">商品名</th>
					<th data-options="field:'onSaleTime',width:100">上架时间</th>
					<th data-options="field:'state',width:80,formatter:productStateFormatter">状态</th>
					<th data-options="field:'maxPrice',width:80,formatter:priceFormatter">最高价格</th>
					<th data-options="field:'minPrice',width:80,formatter:priceFormatter">最低价格</th>
					<th data-options="field:'saleCount',width:80,align:'center'">销量</th>
					<th data-options="field:'commentScore',width:80,align:'center'">评分</th>
				</tr>
			</thead>
	</table>
	<div id="productTB">
			<div>
				<a href="#" data-cmd="add" width="1050" height="600" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a href="#" data-cmd="edit" width="1050" height="600" mustsel remote="false" data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
				<a href="#" data-cmd="del" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
				<a href="#" data-cmd="show" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-tip" plain="true">查看</a>
				<span class="buttonSplit"> </span>
				<a href="#" data-cmd="editShowProperty" mustsel data-options="disabled:true" class="easyui-linkbutton"  plain="true" onclick="showPropertyForm(this)"><i class="iconfont">&#xe6a4;</i> 显示属性</a>
				<a href="#" data-cmd="showSkus" mustsel data-options="disabled:true" class="easyui-linkbutton"  plain="true"><i class="iconfont">&#xe6cb;</i> SKU管理</a>
				<a href="#" data-cmd="onSale" mustsel data-options="disabled:true" class="easyui-linkbutton"  plain="true"><i class="iconfont">&#xe6b1;</i> 上架</a>
				<a href="#" data-cmd="offSale" mustsel data-options="disabled:true" class="easyui-linkbutton"  plain="true"><i class="iconfont">&#xe6b7;</i> 下架</a>
			</div>
			<div class="searchForm">
				<form>
					关键字: <input name="keyword" class="easyui-textbox" style="width:180px">
					日期从: <input name="startDate" class="easyui-datebox" style="width:110px">
					到: <input name="endDate" class="easyui-datebox" style="width:110px">
					商品类型: 
					<input class="easyui-combotree theme-textbox-radius" name="productType" 
					data-options="url:'/productType/tree',method:'get'" style="width:180px;">
					<a href="javascript:;" data-cmd="search" class="easyui-linkbutton button-default">查询</a>
					<a href="javascript:;" data-cmd="resetSearch" class="easyui-linkbutton">重置</a>
				</form>
			</div>
	</div>
</div>

<script type="text/javascript">
function productStateFormatter(value){
	if(0==value){
		return '<red>下架</red>';
	}else if(1==value){
		return '<green>上架</green>';
	}
	return '';
}
function showPropertyForm(clickTarget){
	if($(clickTarget).hasClass('l-btn-disabled')) return;
	var row = $('#productGrid').datagrid('getSelected');
	var editWindow = $('<div></div>');
	editWindow.appendTo('body');
	$(editWindow).window({
		title:'显示属性编辑',
		width:600,    
	    height:400,    
	    modal:true,
	    href : '/product/showPropertyForm?id='+row.id,
		onLoad : function(){
			var $form = editWindow.find('form');
			$form.data('window',editWindow);
		},
		onClose : function(){
			editWindow.window('destroy');
		}
	});
}

function showSkus(clickTarget){
	if($(clickTarget).hasClass('l-btn-disabled')) return;
	var row = $('#productGrid').datagrid('getSelected');
	var editWindow = $('<div id="skuWindow"></div>');
	editWindow.appendTo('body');
	$(editWindow).window({
		title:'SKU管理 - '+row.name,
		//width:1200,    
	    //height:600,    
	    modal:true,
	    maximized:true,
	    href : '/product/skus?productId='+row.id,
		onLoad : function(){
			//var $form = editWindow.find('form');
			//$form.data('window',editWindow);
		},
		onClose : function(){
			editWindow.window('destroy');
		}
	});
}

function onSale(clickTarget,onSale){
	var actionName = '上架';
	var isOnSale = 1;
	if(onSale==0){
		isOnSale = 0;
		actionName = '下架';
	}
	if($(clickTarget).hasClass('l-btn-disabled')) return;
	MXF.confirm('确认'+actionName+'商品？',function(){
		var rows = $('#productGrid').datagrid('getSelections');
		if(rows==null || rows.length==0){
			MXF.error('请选择需要操作的数据');
			return;
		}
		var  _ids = '';
		for(var i=0;i<rows.length;i++){
			_ids+=','+rows[i].id;
		}
		_ids = _ids.substring(1);
		MXF.ajaxing(true);
		$.post('/product/onSale',{ids:_ids,onsale:isOnSale},function(data){
			MXF.ajaxing(false);
			MXF.ajaxFormDone(data);
			if(data.success){
				$('#productGrid').datagrid('reload');
			}
		});
	});
}

function offSale(clickTarget){
	onSale(clickTarget,0);
}
</script>
	