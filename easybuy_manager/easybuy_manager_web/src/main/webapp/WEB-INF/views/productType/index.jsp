<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="easyui-layout" style="" data-options="fit:true">   
    <div data-options="region:'west',title:'分类列表',split:true,border:true" style="width:300px;">
			<ul id="productTypeTree" class="easyui-tree"
				data-options="
						url: '/productType/tree',
						state:'closed',
						method: 'get',
						animate: true,
						onClick: clickTreeNode,
						onAfterEdit : updateTreeNode,
						onContextMenu: function(e,node){
							e.preventDefault();
							$(this).tree('select',node.target);
							$('#productTypeTreeContextMenu').menu('show',{
								left: e.pageX,
								top: e.pageY
							});
						},
						onLoadSuccess:function(){
							$('#productTypeTree').tree('collapseAll');
						}
					"></ul>
    </div>   
    <div data-options="region:'center',border:true,title:'分类详细',href:'/productType/edit'" style="padding: 10px;"></div>   
</div>  

<div id="productTypeTreeContextMenu" class="easyui-menu" style="width: 120px;">
	<div onclick="appendTreeNode()" data-options="iconCls:'icon-add'">添加子节点</div>
	<div onclick="removeTreeNode()" data-options="iconCls:'icon-remove'">删除节点</div>
	<div class="menu-sep"></div>
	<div onclick="expandTree()">展开</div>
	<div onclick="collapseTree()">收缩</div>
	<div onclick="reloadTree()">刷新</div>
</div>
<script type="text/javascript">
	function clickTreeNode(node){
		//$(this).tree('beginEdit',node.target);
		MXF.clearForm($('#productTypeForm'));
		$('#productTypeForm').form('load',node);
	}
	function updateTreeNode(node){
		console.debug(node);
	}
	function appendTreeNode() {
		var t = $('#productTypeTree');
		var node = t.tree('getSelected');
		var parentNode = (node ? node.target : null);
		var parentNodeId = 0;
		if(null!=node) parentNodeId = node.id;
		t.tree('append', {
			parent : parentNode,
			data : [ {
				pid:parentNodeId,text : '新建节点'
			}]
		});
	}
	function removeTreeNode() {
		var node = $('#productTypeTree').tree('getSelected');
		if(node&&node.id!=null){
			MXF.confirm('你确认要删除选中数据?', function(){
					MXF.ajaxing(true);
                	$.post('/productType/delete',{id:node.id},function(data){
                		MXF.ajaxing(false);
                		MXF.ajaxFormDone(data);
        				if(data.success){
        					$('#productTypeTree').tree('remove', node.target);
        				}
        			});
            });
		}else{
			$('#productTypeTree').tree('remove', node.target);
		}
	}
	function collapseTree() {
		var node = $('#productTypeTree').tree('getSelected');
		$('#productTypeTree').tree('collapse', node.target);
	}
	function expandTree() {
		var node = $('#productTypeTree').tree('getSelected');
		$('#productTypeTree').tree('expand', node.target);
	}
	function reloadTree(){
		$('#productTypeTree').tree('reload');
	}
</script>