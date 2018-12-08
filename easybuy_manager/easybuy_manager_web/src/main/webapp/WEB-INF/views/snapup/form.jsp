<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.skulistTile{
	margin-left:60px; font-size:18px; margin-top:10px;
}
.skuEditTable td{
	border-bottom : solid 1px #eee;
}
.skuEditTable td,th{
	padding:5px;
}
.skuEditTable input{
	border:solid 1px #ccc !important;
	height:25px; line-height:25px; padding-left:3px;
}
</style>
<form method="post" action="/snapup/store">
<div style="width:600px;float:left;">
		<input type="hidden" name="id" />
		<input type="hidden" name="skuDatas" id="skuDatas" value="${skuDatas}"/>
		<div class="input-div">
            <label class="label-top">活动标题</label>
            <input class="easyui-textbox theme-textbox-radius" name="title" value="${seckill.title}" data-options="required:true">
        </div>
		<div class="input-div">
            <label class="label-top">开始时间</label>
            <input name="beginTimeFormat" class="easyui-datetimebox" style="width:210px"  data-options="required:true" value="${beginTimeFormat}">
        </div>
		<div class="input-div">
            <label class="label-top">结束时间</label>
            <input name="endTimeFormat" class="easyui-datetimebox" style="width:210px" data-options="required:true" value="${endTimeFormat}">
        </div>
		<div class="input-div">
            <label class="label-top">背景图</label>
            <div style="margin-left:120px;margin-top: -20px;">
            <input name="activePic" class="qiniuUploader" multiply="false" maxFiles="1" value="${seckill.activePic}"/>
            </div>
        </div>

		<div class="input-div">
            <label class="label-top">说明</label>
             <input class="easyui-textbox theme-textbox-radius" data-options="multiline:true" style="height:60px;"
            name="description" value="${seckill.description}">
        </div>

</div>
<div style="width:700px;float:left;">
<div class="skulistTile">参与单品信息</div>
        	<table class="skuEditTable" style="margin-left:60px;">
        	<thead>
        		<tr><th>sku编码</th><th>单品标题</th><th>秒杀价</th><th>数量</th><th>操作</th></tr>
        	</thead>
        	<tbody>
        		<tr><td><input id="skuCode" onchange="refreshSkuInfo()"/></td><td><input id="skuTitle"/></td><td><input id="skuPrice"/></td><td><input id="skuAmount"/></td><td><a onclick="addSeckillSku()">添加</a></td></tr>
        	</tbody>
        	</table>
</div>
		<div class="input-div" style="clear:both;overflow:hidden;padding-top:30px;">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this)">提交</a>
			<a  class="easyui-linkbutton button-lg" onclick="MXF.clearForm(this)">清空</a>
        </div>
</form>

<script>
MXF.initQiniuUploader($('input[name="activePic"]'));

function refreshSkuInfo(){
	var skuCode = $('#skuCode').val();
	$.post('/snapup/getSku',{skuCode:skuCode},function(data){
		console.debug(data);
		if(null==data || ''==data){
			MXF.error('错误的sku编码');
			return ;
		}
		var availableStock = data.availableStock;
		var skuId = data.id;
		var price = data.price;
		var productId = data.productId;
		var skuMainPic = data.skuMainPic;
		$('#skuPrice').val(price * 0.01);
		$('#skuAmount').val(availableStock);
		$('#skuCode').data('skuId',skuId);
		$('#skuCode').data('productId',productId);
		$('#skuCode').data('skuMainPic',skuMainPic);

	});
}

function addSeckillSku(){
	var skuCode = $('#skuCode').val();
	var skuTitle = $('#skuTitle').val();
	var skuPrice = $('#skuPrice').val();
	var skuAmount = $('#skuAmount').val();

	var skuId = $('#skuCode').data('skuId');
	var productId = $('#skuCode').data('productId');
	var skuMainPic = $('#skuCode').data('skuMainPic');
	if( skuId == undefined || ''==skuId){
		MXF.error('请输入正确的sku编码');
		$('#skuCode').focus();
		return;
	}

	if(skuCode==''){
		MXF.error('请输入sku编码');
		$('#skuCode').focus();
		return;
	}
	if(skuTitle==''){
		MXF.error('请输入单品标题');
		$('#skuTitle').focus();
		return;
	}
	if(skuPrice==''){
		MXF.error('请输入单品抢购价格');
		$('#skuPrice').focus();
		return;
	}
	if(skuAmount==''){
		MXF.error('请输入参与活动的单品数量');
		$('#skuAmount').focus();
		return;
	}

	if($('tr[skuId='+skuId+']').length > 0){
		MXF.error('该单品已加入该活动');
		return ;
	}

	var tr = createSkuTr(skuId,productId,skuMainPic,skuTitle,skuPrice,skuAmount);

	$('.skuEditTable').find('tbody').append(tr);

	$('#skuCode').data('skuId','');
	$('#skuTitle').val('');
	$('#skuPrice').val('');
	$('#skuAmount').val('');

	refreshSkusData();
}

function createSkuTr(skuId,productId,skuMainPic,skuTitle,skuPrice,skuAmount){
	var tr = $('<tr><td><img src=""/></td><td></td><td></td><td></td>' +
	'<td><a onclick="rmoveSeckillSku(this)">删除</a></td></tr>');
	tr.attr('skuId',skuId);
	tr.attr('productId',productId);
	tr.attr('skuMainPic',skuMainPic);
	tr.attr('skuTitle',skuTitle);
	tr.attr('skuPrice',skuPrice);
	tr.attr('skuAmount',skuAmount);

	tr.find('td').eq(0).find('img').attr('src','http://pijbgt8k2.bkt.clouddn.com//'+skuMainPic+'?imageView2/1/w/40/h/40');
	tr.find('td').eq(1).text(skuTitle);
	tr.find('td').eq(2).text(skuPrice);
	tr.find('td').eq(3).text(skuAmount);
	return tr;
}

function rmoveSeckillSku(o){
	MXF.confirm('确认移除？',function(){
		$(o).closest('tr').remove();
		refreshSkusData();
	});
}

function refreshSkusData(){
	var skuTrs = $('.skuEditTable').find('tbody').find('tr');
	var data = '';
	for(var i=1;i<skuTrs.length;i++){
		var tr = skuTrs.eq(i);
		var skuId = tr.attr('skuId');
		var productId = tr.attr('productId');
		var skuMainPic = tr.attr('skuMainPic');
		var skuTitle = tr.attr('skuTitle');
		var skuPrice = parseInt(tr.attr('skuPrice')) * 100;
		var skuAmount = tr.attr('skuAmount');

		data+=':::'+skuId+'::'+productId+'::'+skuMainPic+'::'+skuTitle+'::'+skuPrice+'::'+skuAmount;
		console.debug(data);
	}
	data = data.substring(3);
	$('#skuDatas').val(data);
}

function initSkuTr(){
	var skuDatas = $('#skuDatas').val();
	if(skuDatas=='') return;
	var tbodyDataArr = skuDatas.split(':::');
	for(var i=0;i<tbodyDataArr.length;i++){
		var trDataArr = tbodyDataArr[i].split('::');
		var skuId = trDataArr[0];
		var productId = trDataArr[1];
		var skuMainPic = trDataArr[2];
		var skuTitle = trDataArr[3];
		var skuPrice = trDataArr[4];
		var skuAmount = trDataArr[5];

		var tr = createSkuTr(skuId,productId,skuMainPic,skuTitle,skuPrice,skuAmount);
		$('.skuEditTable').find('tbody').append(tr);
	}
}

initSkuTr();
</script>
