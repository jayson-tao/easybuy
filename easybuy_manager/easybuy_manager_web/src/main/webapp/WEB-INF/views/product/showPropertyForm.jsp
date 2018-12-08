<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="storeShowPropertyForm" method="post" action="/product/storeShowProperty">
		<input type="hidden" name="productId" value="${product.id}"/>
        <span style="display:none;" id="selectedViewProperties">${productViewProperties}</span>
		<c:forEach items="${viewProperties}" var="p">
			<div class="input-div">
	            <label class="label-top">${p.propertyKey}</label>
	            <input type="hidden" name="propertyKeyId" value="${p.id}"/>
	            <input type="hidden" name="propertyKey" value="${p.propertyKey}"/>
	            	<c:if test="${p.inputMode==0}">
	            		<input type="hidden" name="propertyValueId" value="0"/>
	            		<input class="easyui-textbox theme-textbox-radius" name="propertyValue" data-options="required:true">
	            	</c:if>
	            	<c:if test="${p.inputMode==1}">
	            		<select class="easyui-combobox" name="propertyValueId" 
						data-options="required:true,valueField: 'id',textField: 'propertyValue',onChange:changeOption,url:'/propertyValue/json?propertyKeyId=${p.id}'" 
						style="width:420px;">
			            </select>
			            <input type="hidden" name="propertyValue" value=""/>
	            	</c:if>
	        </div>
		</c:forEach>
		<div class="input-div">
			<label class="label-top"></label>
            <a  class="easyui-linkbutton button-lg button-default" onclick="MXF.ajaxForm(this)">提交</a>
        </div>
</form>

<script>
//延时500ms回显后台返回的，已设置好的显示属性值
setTimeout(
	function(){
		var selectedViewProperties = $('#selectedViewProperties').text();
		if(''!=selectedViewProperties){
			var viewPropertyArr = MXF.jsonEval(selectedViewProperties);
			for(var i=0;i<viewPropertyArr.length;i++){
				var propSetObj = viewPropertyArr[i];
				var propertyKeyId = propSetObj.propertyKeyId;
				var propInput = $('#storeShowPropertyForm').find('input[name="propertyKeyId"][value="'+propertyKeyId+'"]');
				
				var propInputDiv = $(propInput).closest('.input-div');
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
		}
	}
,500);

//修改选项的ID值时，同步修改隐藏的选项文本值
function changeOption(newValue,oldValue){
	var propertyValue = $(this).combobox('getText');
	$(this).closest('.input-div').find('[name=propertyValue]').val(propertyValue);
}
</script>