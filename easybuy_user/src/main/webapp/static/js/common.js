function goHome(){
	location.href = 'http://127.0.0.1:8081';
}
//切换图形验证码
function changeCaptcha(o){
	var url = $(o).attr('src');
	var timestamp = (new Date()).valueOf();  
    var index = url.indexOf("?",url);  
    if (index > 0) {  
        url = url.substring(0, url.indexOf("?"));  
    }  
    
    url = url + "?timestamp=" + timestamp;  
    $(o).attr('src',url);
}
//转换html参数为json对象
function getHtmlParmas(){
	//解析参数
	var paramObj = {};
	var pindex = location.href.indexOf('?');
	if(pindex>0){
		var params = location.href.substring(pindex+1);
		var paramArr = params.split('&');
		for(var i=0;i<paramArr.length;i++){
			var kv = paramArr[i].split('=');
			if('#'!=kv[1]){
				paramObj[kv[0]] = decodeURI(kv[1]);
			}
		}
	}
	return paramObj;
}

//初始化分页条
function myPagination(pagenationObj,params){
	var pagination = $(pagenationObj);
	pagination.css('overflow','hidden');
	var pageSize = params.pageSize || pagination.attr('curPage') || 10;
	pageSize = parseInt(pageSize);
	var curPage = params.curPage || pagination.attr('curPage');
	if(curPage=='' || curPage==null){
		curPage = 1;
	}
	curPage = parseInt(curPage);
	
	var totalCount = params.total || parseInt(pagination.attr('total')) || 0;
	totalCount = parseInt(totalCount);
	var totalDiv = $('<div class="page-wrap fr"><div class="total">共<span class="totalPages"></span>页,<span class="totalCount"></span>条记录</div></div>');
	pagination.append(totalDiv);
	$('.totalCount').text(totalCount);
	
	var pageLink = $('<div class="page-num fr"></div>');
	var totalPages = totalCount % pageSize == 0? totalCount/pageSize : (parseInt(totalCount/pageSize)+1);
	$('.totalPages').text(totalPages);
	
	var isFirst = (curPage <= 1);
	var isLast = (curPage >= totalPages);
	
	var prePage = (curPage-1)>1?(curPage-1):1;
	var nextPage = (curPage+1)<totalPages?(curPage+1):totalPages;
	//前后5页
	var scope = 5;
	if(isFirst){
		pageLink.append('<span><a class="num prev disabled " title="上一页">上一页</a></span>');
	}else{
		pageLink.append('<span><a class="num prev" page="'+prePage+'" title="上一页">上一页</a></span>');
	}
	
	var startPage = 1;
	var endPage = 2*scope+1;
	if(endPage>totalPages) endPage = totalPages;
	
	if(totalPages>endPage){
		if(curPage>scope+1){
			startPage = curPage - scope;
			endPage = curPage + scope;
			if(endPage>totalPages) endPage = totalPages;
			if((endPage-startPage)<(2*scope+1)){
				startPage = startPage - ((2*scope+1)-(endPage-startPage))+1;
				if(startPage<1) startPage = 1;
			}
		}
	}
	if(startPage>1){
		pageLink.append('<span><a class="num" page="1">首页</a></span>');
	}
	for(var i=startPage;i<=endPage;i++){
		if(i==curPage){
			pageLink.append('<span class="num curr"><a>'+i+'</a></span>');
		}else{
			pageLink.append('<span><a class="num" page="'+i+'">'+i+'</a></span>');
		}
	}
	
	if(isLast){
		pageLink.append('<span><a class="num next disabled" title="下一页">下一页</a></span>');
	}else{
		pageLink.append('<span><a class="num next" page="'+nextPage+'" title="下一页">下一页</a></span>');
	}
	
	pagination.append(pageLink);
	pagination.find('.num').click(function(){
		var page = $(this).attr('page');
		if(page){
			if($.isFunction(params.go)){
				params.go(page);
			}
		}
	});
}

$().ready(function(){try{$("[data-toggle='tooltip']").tooltip()}catch(e){}try{$(".chosen-select").chosen()}catch(e){}try{$('.bootstrap-switch [type="checkbox"]').bootstrapSwitch({radioAllOff:true,onSwitchChange:function(e,t){$(e.target).prop("checked",t);$(e.target).change()}});$("[data-switch-toggle]").on("click",function(){var e=$(this).data("switch-toggle");return $("#switch-"+e).bootstrapSwitch("toggle"+e.charAt(0).toUpperCase()+e.slice(1))})}catch(e){}try{}catch(e){}try{$(".explanation").find(".explain-checkZoom").click(function(){if($(".explanation").hasClass("up")){$(".explanation").removeClass("up").addClass("down");$(".explanation").find(".explain-panel").slideToggle(200)}else{$(".explanation").addClass("up").removeClass("down");$(".explanation").find(".explain-panel").slideToggle(200)}})}catch(e){}try{searchMore()}catch(e){}try{$("input.icheck").iCheck({checkboxClass:"icheckbox_minimal-blue",radioClass:"iradio_minimal-blue",increaseArea:"20%"});$(".edit-table ul").mCustomScrollbar();popover();refurbish()}catch(e){}try{$('a,.btn,.checkBox,button,.selectpicker,input[type="radio"],input[type="checkbox"]').focus(function(){this.blur()})}catch(e){}try{$(".col-sm-8").find(".click-fade").click(function(){$(this).siblings(".edit").show()});$(".col-sm-8").find(".fa-times-circle").click(function(){$(this).parents(".edit").hide()})}catch(e){}try{$("body").on("click",".pwd-toggle",function(){var e=$(this).data("id");if($(".pwd-toggle").hasClass("fa-eye")){$(".pwd-toggle").removeClass("fa-eye");$(".pwd-toggle").addClass("fa-eye-slash");$("#"+e).attr("type","password")}else{$(".pwd-toggle").addClass("fa-eye");$(".pwd-toggle").removeClass("fa-eye-slash");$("#"+e).attr("type","text")}})}catch(e){}try{$("body").on("mouseover",".popover-box",function(){$(this).find(".popover-info").show()});$("body").on("mouseout",".popover-box",function(){$(this).find(".popover-info").hide()})}catch(e){}try{if($.isFunction($.loading.start)){$("body").on("click",".click-loading",function(){$.loading.start()})}}catch(e){}try{var t=document,a=t.getElementsByTagName("input"),o="placeholder"in t.createElement("input"),n=function(e){var t=e.getAttribute("placeholder"),a=e.defaultValue;if(a==""){e.value=t}e.onfocus=function(){if(e.value===t){this.value=""}};e.onblur=function(){if(e.value===""){this.value=t}}};if(!o){for(var i=0,c=a.length;i<c;i++){var s=a[i],r=s.getAttribute("placeholder");if(s.type==="text"&&r){n(s)}}}}catch(e){}$("form").find(":input").not(":hidden").first().focus()});$(window).scroll(function(){var e=$(window).scrollTop();if(e>=200){$(".scroll-to-top").addClass("active")}else{$(".scroll-to-top").removeClass("active")}});function searchMore(){$("#searchMore").click(function(){if($(".search-term .toggle").hasClass("hide")){$("#searchMore").text("收起筛选条件");$(".search-term .toggle").removeClass("hide")}else{$(".search-term .toggle").addClass("hide");$("#searchMore").text("更多筛选条件")}})}function refurbish(){$(".operate .reload").click(function(){$(".reload").find(".fa-refresh").addClass("fa-spin s02");setTimeout(function(){$(".reload i").removeClass("fa-spin s02")},800)})}function switchBtn(e,t){var a=new Array;a[0]=new Array("是","否");a[1]=new Array("开启","关闭");a[2]=new Array("允许","拒绝");var o=a[t];var n="#"+e;var i=i;if($(n).hasClass("open")){$(n).removeClass("open");$(n).html('<i class="fa fa-toggle-off"></i>'+o[1])}else{$(n).addClass("open");$(n).html('<i class="fa fa-toggle-on"></i>'+o[0])}}function popover(){$(".popover-box").hover(function(){$(this).find(".popover-info").fadeIn("fast")},function(){$(this).find(".popover-info").fadeOut("fast")})}ajax={};ajax.post=function(e){var t={type:"POST",async:true,dataType:"json",error:function(e){alert("失败"+e.status)}};t=$.extend(t,e);$.ajax(t)};ajax.get=function(e){var t={type:"GET",async:true,dataType:"json",error:function(e){alert("失败"+e.status)}};t=$.extend(t,e);$.ajax(t)};function AjaxRegion(e,t,a){var o=$("#"+t);$.ajax({type:"get",url:e,data:{parent_code:a},dataType:"json",success:function(e){if(e.code=="0"){var t=e.data;leve_text=regionLevel(t.level+1);o.html("<option value=''>"+leve_text+"</option>");$(t.list).each(function(e,t){o.append("<option value='"+t.region_code+"'>"+t.region_name+"</option>")})}else{$.msg("请求失败！",{icon:2})}},error:function(){$.msg("数据异常！",{icon:2})}})}function regionLevel(e){var t=new Array("国家","省","市","区/县","乡镇/街道");return t[e]}