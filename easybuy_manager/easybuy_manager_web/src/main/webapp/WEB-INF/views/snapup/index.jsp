<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="tableGroup">
	<table id="snapupGrid" class="easyui-datagrid" title="抢购信息"
				data-options="rownumbers:true,fit:true,method:'get',
				pagination:true,pageSize:10,striped:true,singleSelect:false,
				toolbar:'#snapupTB',url:'/snapup/json'">
			<thead>
				<tr>
					<th data-options="field:'id',checkbox:true"></th>
					<th data-options="field:'title',width:200">标题</th>
					<th data-options="field:'state',width:60,formatter:snapupStateFormatter">状态</th>
					<th data-options="field:'beginTime',width:150,formatter:dateFormatter">开始时间</th>
					<th data-options="field:'endTime',width:150,formatter:dateFormatter">结束时间</th>
					<th data-options="field:'description',width:380">说明</th>
				</tr>
			</thead>
	</table>
	<div id="snapupTB">
			<div>
				<a href="#" data-cmd="add" width="1350" height="600" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
				<a href="#" data-cmd="edit" width="1350" height="600" mustsel remote="false" data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>
				<a href="#" data-cmd="show" mustsel data-options="disabled:true" class="easyui-linkbutton" iconCls="icon-tip" plain="true">查看</a>
				<span class="buttonSplit"> </span>
				<a href="#" data-cmd="sendShip" mustsel data-options="disabled:true" class="easyui-linkbutton"  plain="true"><i class="iconfont">&#xe6b1;</i> 发布抢购</a>
			</div>
	</div>
</div>

<script type="text/javascript">

function snapupStateFormatter(v){
	if(v==0) return '<green>待发布</green>';
	if(v==1) return '<blue>待启动</blue>';
	if(v==2) return '<orange>进行中</orange>';
	if(v==3) return '<red>已结束</red>';
}

function sendShip(clickTarget){
	if($(clickTarget).hasClass('l-btn-disabled')) return;
	MXF.confirm('发布后的抢购将不能进行编辑，确认发布？',function(){
		var rows = $('#snapupGrid').datagrid('getSelections');
		if(rows==null || rows.length==0){
			MXF.error('请选择需要操作的数据');
			return;
		}
		var  _ids = '';
		for(var i=0;i<rows.length;i++){
			if(rows[i].state!=0){
				MXF.alert('只有待发布状态的订单才能发布！！');
				return ;
			}
			_ids+=','+rows[i].id;
		}
		_ids = _ids.substring(1);
		MXF.ajaxing(true);
		$.post('/snapup/publish',{secKillId:_ids},function(data){
			MXF.ajaxing(false);
			MXF.ajaxFormDone(data);
			if(data.success){
				$('#snapupGrid').datagrid('reload');
			}
		});
	});
}
</script>
	