<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="padding:10px">

<a href="#" onclick="addSku()" class="easyui-linkbutton" iconCls="icon-add">添加Sku</a>

<div id="editSkuDiv" style="display:none;border:solid 1px #ccc;border-radius:4px;padding:10px;margin-top:10px;overflow:hidden;background:#f9f9f9;">
<form id="skuForm" action="/product/storeSku">
<input type="hidden" name="id" value=""/>
<input type="hidden" name="productId" value="${productId}"/>
<div style="width:250px;float:left;">
<table class="table table-very table-basic">
			<c:forEach items="${propertyKeys}" var="p" varStatus="psta">
			<c:if test="${p.inputMode==0}">
			<tr><td>
			<input type="hidden" name="propertyKeyId" value="${p.id}"/>
	        <input type="hidden" name="propertyKey" value="${p.propertyKey}"/>
			${p.propertyKey}</td>
			<td>
			<input type="hidden" name="propertyValueId" value="0"/>
			<input class="easyui-textbox" data-options="required:true" style="width:200px;" name="propertyValue"/>
			</td></tr>
			</c:if>

			<c:if test="${p.inputMode==1}">
			<tr><td>
			<input type="hidden" name="propertyKeyId" value="${p.id}"/>
	        <input type="hidden" name="propertyKey" value="${p.propertyKey}"/>
			${p.propertyKey}</td><td>
			<select name="propertyValueId" class="easyui-combobox" style="width:200px;" data-options="required:true,valueField: 'id',textField: 'propertyValue',onChange:changeOption,url:'/propertyValue/json?propertyKeyId=${p.id}'"></select>
			<input type="hidden" name="propertyValue" value=""/>
			</td>
			</tr>
			</c:if>
			</c:forEach>
</table>
</div>
<div style="width:1000px;float:right;">
<table class="table table-very table-basic">
	<tr><td>市场价</td><td><input class="easyui-textbox" name="marketPrice" data-options="required:true" style="width:200px;"/></td><td>优惠价</td><td><input class="easyui-textbox" data-options="required:true" name="price" style="width:200px;"/></td><td>成本价</td><td><input class="easyui-textbox" name="costPrice" style="width:200px;"/></td></tr>
	<tr><td>可用库存</td><td><input class="easyui-textbox" data-options="required:true" name="availableStock" style="width:200px;"/></td><td>锁定库存</td><td><input class="easyui-textbox" data-options="required:true" name="frozenStock" style="width:200px;"/></td><td>排序</td><td><input class="easyui-textbox" name="sortIndex" style="width:200px;"/></td></tr>
	<tr><td>SKU主图</td>
	<td colspan="4" id="skuPicEditor"><input name="skuMainPic" class="qiniuUploader" multiply="false" /></td><td>
	<a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this,storeSkuCallback,formatSkuPrice)">提交</a>
	<a  class="easyui-linkbutton button-lg button-danger" onclick="$('#editSkuDiv').hide()">取消</a>
	</td>
	</tr>
</table>
</div>
</form>
</div>

<table class="table table-striped">
	<thead>
		<tr>
			<th>SKU编码</th>
			<c:forEach items="${propertyKeys}" var="p">
			<th propertyKeyId="${p.id}">${p.propertyKey}</th>
			</c:forEach>
			<th>市场价</th>
			<th>优惠价</th>
			<th>成本价</th>
			<th>销量</th>
			<th>排序</th>
			<th>可用库存</th>
			<th>锁定库存</th>
			<th>预览图</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${skuList}" var="sku">
		<tr>
			<td>${sku.skuCode}</td>
			<c:forEach items="${propertyKeys}" var="p">
				<c:forEach items="${sku.skuPropertyList}" var="op">
					<c:if test="${p.id==op.propertyKeyId}">
						<td>${op.propertyValue}</td>
					</c:if>
				</c:forEach>
			</c:forEach>
			<td>${sku.marketPrice*0.01}</td>
			<td>${sku.price*0.01}</td>
			<td>${sku.costPrice*0.01}</td>
			<td>${sku.saleCount}</td>
			<td>${sku.sortIndex}</td>
			<td>${sku.availableStock}</td>
			<td>${sku.frozenStock}</td>
			<td>
				<c:if test="${sku.skuMainPic!=null && sku.skuMainPic!=''}">
					<img src="http://pijbgt8k2.bkt.clouddn.com/${sku.skuMainPic}?imageView2/1/w/30/h/30" />
				</c:if>
			</td>
			<td><a class="easyui-linkbutton button-default button-sm" onclick="editSku(${sku.id})">编辑</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>

<script type="text/javascript">
function clearSkuForm(){
	$('#skuForm').find('[name=id]').val('');
	$('#skuForm').find('[textboxname=marketPrice]').textbox('setValue','');
	$('#skuForm').find('[textboxname=saleCount]').textbox('setValue','');
	$('#skuForm').find('[textboxname=sortIndex]').textbox('setValue','');
	$('#skuForm').find('[textboxname=price]').textbox('setValue','');
	$('#skuForm').find('[textboxname=costPrice]').textbox('setValue','');
	$('#skuForm').find('[textboxname=availableStock]').textbox('setValue','');
	$('#skuForm').find('[textboxname=frozenStock]').textbox('setValue','');
	$('#skuForm').find('[textboxname=skuMainPic]').textbox('setValue','');

}
function addSku(){
	$('#editSkuDiv').show();
	clearSkuForm();
	MXF.initQiniuUploader($('input[name="skuMainPic"]'));
}

function editSku(id){
	$.post('/product/sku/'+id,{},function(data){
		$('#editSkuDiv').show();
        //清空原七牛云上传控件
		$('#skuPicEditor').empty();
		//重新添加
		$('#skuPicEditor').html('<input name="skuMainPic" class="qiniuUploader" multiply="false"/>');
		data.marketPrice = data.marketPrice *0.01;
		data.price = data.price*0.01;
		data.costPrice = data.costPrice*0.01;
		$('#skuForm').form('load',data);
		//重新渲染
		MXF.initQiniuUploader($('input[name="skuMainPic"]'));

		//对属性集合进行赋值
		var propertyArr = data.skuPropertyList;
		for(var i=0;i<propertyArr.length;i++){
			var propSetObj = propertyArr[i];
			var propertyKeyId = propSetObj.propertyKeyId;
			var propInput = $('#skuForm').find('input[name="propertyKeyId"][value="'+propertyKeyId+'"]');

			var propInputDiv = $(propInput).closest('tr');
			var optionIdInput = propInputDiv.find('[name=propertyValueId]');
			var optionIdValue = propSetObj['propertyValueId'];
			if(0!=optionIdValue){
				optionIdInput = propInputDiv.find('select');
				$(optionIdInput).combobox('setValue',optionIdValue);
			}else{
				optionIdInput.val(optionIdValue);
			}
			propInputDiv.find('[name=propertyValue]').val(propSetObj['value']);
			propInputDiv.find('[textboxname=propertyValue]').textbox('setValue',propSetObj['value']);
		}
	});
}

function changeOption(newValue,oldValue){
	var propertyValue = $(this).combobox('getText');
	$(this).closest('tr').find('[name=propertyValue]').val(propertyValue);
}

function storeSkuCallback($form,data){
	$('#skuWindow').window('refresh');
}

function formatSkuPrice(param){
	param.price = 100 * param.price;
	param.marketPrice = 100 * param.marketPrice;
	param.costPrice = 100 * param.costPrice;
}
</script>
