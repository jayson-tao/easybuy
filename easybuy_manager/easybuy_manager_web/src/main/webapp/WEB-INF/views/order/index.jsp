<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tableGroup">
	<table id="orderGrid" class="easyui-datagrid" title="订单信息"
				data-options="rownumbers:true,fit:true,method:'get',
				pagination:true,pageSize:10,striped:true,singleSelect:false,
				toolbar:'#orderTB',url:'/order/json'">
			<thead>
				<tr>
					<th data-options="field:'id',checkbox:true"></th>
					<th data-options="field:'orderSn',width:120">订单号</th>
					<th data-options="field:'state',width:60,formatter:orderStateFormatter">状态</th>
					<th data-options="field:'totalMoney',width:100,formatter:currencyFormatter">订单总价</th>
					<th data-options="field:'carriageFee',width:100,formatter:currencyFormatter">运费</th>
					<th data-options="field:'couponMoney',width:80,formatter:currencyFormatter">优惠券金额</th>
					<th data-options="field:'promotionMoney',width:80,formatter:currencyFormatter">优惠促销金额</th>
					<th data-options="field:'realMoney',width:80,formatter:currencyFormatter">应付金额</th>
					<th data-options="field:'payMoney',width:80,formatter:currencyFormatter">实付金额</th>
				</tr>
			</thead>
	</table>
	<div id="orderTB">
			<div>
				<a href="#" data-cmd="show" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-tip" plain="true">查看</a>
				<span class="buttonSplit"> </span>
				<a href="#" data-cmd="sendShip" mustsel data-options="disabled:true" class="easyui-linkbutton"  plain="true"><i class="iconfont">&#xe6b1;</i> 发货</a>
			</div>
			<div class="searchForm">
				<form>
					关键字: <input name="keyword" class="easyui-textbox" style="width:180px">
					<a href="javascript:;" data-cmd="search" class="easyui-linkbutton button-default">查询</a>
					<a href="javascript:;" data-cmd="resetSearch" class="easyui-linkbutton">重置</a>
				</form>
			</div>
	</div>
</div>

<script type="text/javascript">

function orderStateFormatter(v){
	if(v==0) return '<yellow>待付款</yellow>';
	if(v==1) return '<blue>待发货</blue>';
	if(v==2) return '<orange>待收货</orange>';
	if(v==3) return '<green>交易完成</green>';
	if(v==4) return '取消中';
	if(v==5) return '<red>交易关闭</red>';
}

function currencyFormatter(v){
	return v * 0.01;
}

function sendShip(clickTarget){
	if($(clickTarget).hasClass('l-btn-disabled')) return;
	MXF.confirm('确认发货？',function(){
		var rows = $('#orderGrid').datagrid('getSelections');
		if(rows==null || rows.length==0){
			MXF.error('请选择需要操作的数据');
			return;
		}
		var  _ids = '';
		for(var i=0;i<rows.length;i++){
			if(rows[i].state!=1){
				MXF.alert('只有待发货状态的订单才能发货！！');
				return ;
			}
			_ids+=','+rows[i].id;
		}
		_ids = _ids.substring(1);
		MXF.ajaxing(true);
		$.post('/order/sendShip',{ids:_ids},function(data){
			MXF.ajaxing(false);
			MXF.ajaxFormDone(data);
			if(data.success){
				$('#orderGrid').datagrid('reload');
			}
		});
	});
}
</script>
	