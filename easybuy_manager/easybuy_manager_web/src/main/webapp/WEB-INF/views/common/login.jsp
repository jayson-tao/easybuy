<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="edge" />
<link rel="shortcut icon" href="favicon.ico" />

<title>易购网 - 平台管理登录</title>
<link href="/easyui/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/easyui_animation.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/easyui_plus.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/insdep_theme_default.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/icon.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
</head>

<body class="theme-login-layout">
		

		<div class="theme-login-header"></div>
		<div id="theme-login-form">
            <form id="form" class="theme-login-form" method="post">  
            <dl>
                <dt><img src="/easyui/themes/insdep/images/logo_110.png"></dt>
                        <dd><input id="username" name="username" value="admin" class="theme-login-text"  style="width:100%;"/></dd>
                        <dd><input id="password" name="password" value="123" class="theme-login-text"  style="width:100%;"/></dd>
                        <dd>&nbsp;</dd>
                        <dd><button class="submit">登录后台</button><a class="easyui-linkbutton button" href="javascript:;">忘记密码 ?</a></dd>

            </dl>
            </form>
        </div>

    	<div class="theme-login-footer">
        	<dl>
        		<dt><a>帮助手册</a> | <a>联系我们</a></dt>
        		<dd>&copy 2017 - <script>var year = new Date();document.write(year.getFullYear());</script> 强哥出品</dd>
        	</dl>
        </div>

    <script>

    	$(function(){		

    		$(".QRcode").on("click",function(){
    			$(".QRcode-layout").removeClass("hide");

    		});
    		$(".QRcode-layout-close").on("click",function(){
    			$(".QRcode-layout").addClass("hide");
    		});

			$.extend($.fn.validatebox.defaults.tipOptions, {
				onShow: function() {
					$(this).tooltip("tip").css({backgroundColor:"#ff7e00", border: "none",color: "#fff"});
					
				}
			})

			/*布局部分*/
			$('#theme-login-layout').layout({
				fit:true/*布局框架全屏*/
			});   
			
			$('#username').textbox({    
				prompt:'登录账号',
				required:true,
				missingMessage:"请输入用户名"
			});
			$('#password').textbox({    
				type:"password",
				prompt:'登录密码',
				required:true,
				missingMessage:"请输入密码"
			});
			
			$('.submit').linkbutton({}); 
			
			/*验证码tooltip*/
			$('#form').form({
				url:"/login/in",
				onSubmit:function(){
					var res=$(this).form('enableValidation').form('validate');
					return res;
				},
				success: function(data){
					try 
					{ 
						var data = eval('(' + data + ')');
						if (!data.success){
							$.messager.alert('提示',data.message,'error',function(){
								$('#username,#password').textbox('clear');
							});
						}else{
							window.location.href="/main";
						}
					}catch (e){ 
						$.insdep.error(data);
					} 

				}
			});	
			
			/*验证码tooltip*/
			
		})
    </script>


<script type="text/javascript">
var uploader = Qiniu.uploader({
    runtimes: 'html5,flash,html4',      // 上传模式，依次退化
    browse_button: 'pickfiles',         // 上传选择的点选按钮，必需
    uptoken_url: '/uptoken',            // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken
    domain: '<Your bucket domain>',     // bucket域名，下载资源时用到，必需
    container: 'container',             // 上传区域DOM ID，默认是browser_button的父元素
    max_file_size: '100mb',             // 最大文件体积限制
    flash_swf_url: 'path/of/plupload/Moxie.swf',  //引入flash，相对路径
    max_retries: 3,                     // 上传失败最大重试次数
    chunk_size: '4mb',                  // 分块上传时，每块的体积
    auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
    init: {
        'FilesAdded': function(up, files) {
            plupload.each(files, function(file) {
                // 文件添加进队列后，处理相关的事情
            });
        },
        'BeforeUpload': function(up, file) {
               // 每个文件上传前，处理相关的事情
        },
        'UploadProgress': function(up, file) {
               // 每个文件上传时，处理相关的事情
        },
        'FileUploaded': function(up, file, info) {
               // 每个文件上传成功后，处理相关的事情
               // 其中info是文件上传成功后，服务端返回的json字符串，形式如：
               // {
               //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
               //    "key": "gogopher.jpg"
               //  }
        },
        'Error': function(up, err, errTip) {
               //上传出错时，处理相关的事情
        },
        'UploadComplete': function() {
               //队列文件处理完毕后，处理相关的事情
        },
        'Key': function(up, file) {
            // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
            // 该配置必须要在unique_names: false，save_key: false时才生效
            var key = "";
            return key
        }
    }
});

</script>

</body>
</html>