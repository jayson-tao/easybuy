<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="edge" />
<link rel="shortcut icon" href="favicon.ico" />
<title>易购网 - 平台管理</title>
<link href="/easyui/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/easyui_animation.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/easyui_plus.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/insdep_theme_default.css" rel="stylesheet" type="text/css">
<link href="/easyui/themes/insdep/icon.css" rel="stylesheet" type="text/css">
<link href="/easyui/plugin/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="/easyui/my/core.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/easyui/themes/insdep/jquery.insdep-extend.min.js"></script>
<!-- 后台首页js -->
<script type="text/javascript" src="/easyui/app.js"></script>
<script type="text/javascript" src="/easyui/my/core.js"></script>
	
<!--第三方插件加载-->
<script src="/easyui/plugin/justgage-1.2.2/raphael-2.1.4.min.js"></script>
<script src="/easyui/plugin/justgage-1.2.2/justgage.js"></script>
</head>

<body>
	<div id="loading" style="position:absolute;z-index:1000;height:100%;text-align:center; background:#fff;width:100%;">
	<img style="margin-top:270px;" src="/easyui/themes/insdep/images/ring.svg" /></div>
	<div id="master-layout">
        <div data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
        	<div class="theme-navigate">
                <div class="left">
                    <a href="#" class="easyui-linkbutton left-control-switch"><i class="fa fa-bars fa-lg"></i></a>
                    <a href="#" class="easyui-menubutton theme-navigate-user-button" data-options="menu:'.theme-navigate-user-panel'">管理员</a>
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm1',hasDownArrow:false">快捷入口</a>
                    <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',hasDownArrow:false">消息<span class="badge color-default">15</span></a>


                    <div id="mm1" class="theme-navigate-menu-panel">
                    	<div>字典设置</div>
                        <div>商品管理</div>
                        <div class="menu-sep"></div>
                        <div data-options="disabled:true,iconCls:'icon-save'">财务管理</div>
                        <div>订单查询</div>
                        <div class="menu-sep"></div>
                        <div>
                            <span>营销</span>
                            <div>
                                <div>促销设置</div>
                                <div>秒杀管理</div>
                            </div>
                        </div>
                    </div>
                    
                    <div id="mm3" class="theme-navigate-menu-panel" style="width:180px;">
                        <div>订单消息<span class="badge color-success">5</span></div>
                        <div>安全消息<span class="badge color-important">10</span></div>
                        <div>服务消息</div>
                        <div class="menu-sep"></div>
                        <div>查看历史消息</div>
                        <div class="menu-sep"></div>
                        <div>清除消息提示</div>
                    </div>
                    
                    
                    <div class="theme-navigate-user-panel">
                       <dl>
                       		<dd>
                            	<img src="/easyui/themes/insdep/images/avatar.86.jpg" width="86" height="86">
                                <b class="badge-prompt">管理员<i class="badge color-important">10</i></b>
                                <span>nxh@yaorange.com</span>
                                <p>安全等级：<i class="text-success">高</i></p>
                            </dd>
                            <dt>
                            	<a class="theme-navigate-user-modify">修改资料</a>
                                <a class="theme-navigate-user-logout" href="/login">注销</a>
                            </dt>
                       </dl>
                    </div>
                </div>
                
                
                <div class="right">
                    <input class="easyui-searchbox theme-navigate-search" data-options="prompt:'输入搜索的关键词..',menu:'#mm',searcher:doSearch" style="width:300px"></input>
                    <div id="mm" class="theme-navigate-menu-panel">
                        <div data-options="name:'all'">全部内容</div>
                        <div data-options="name:'sports'">标题</div>
                        <div data-options="name:'sports'">作者</div>
                        <div data-options="name:'sports'">内容</div>
                    </div>
                </div>
            </div>
        
        </div>

        <!--开始左侧菜单-->
        <div data-options="region:'west',border:false,bodyCls:'theme-left-layout'" style="width:200px;">

            <!--正常菜单--> 
            <div class="theme-left-normal">
                <!--theme-left-switch 如果不需要缩进按钮，删除该对象即可-->    
                <div class="left-control-switch theme-left-switch"><i class="fa fa-chevron-left fa-lg"></i></div>

                <!--start class="easyui-layout"-->
                <div class="easyui-layout" data-options="border:false,fit:true"> 
                    <!--start region:'north'-->
                    <div data-options="region:'north',border:false" style="height:100px;">
                        <!--start theme-left-user-panel-->
                        <div class="theme-left-user-panel">
                            <dl>
                                <dt>
                                    <img src="/easyui/themes/insdep/images/avatar.86.jpg" width="43" height="43">
                                </dt>
                                <dd>
                                    <span class="badge-prompt">管理员 <i class="badge color-important">10</i></span>
                                    <span>nxh@yaorange.com</span>
                                    <p>安全等级：<i class="text-success">高</i></p>
                                </dd>

                            </dl>
                        </div>
                        <!--end theme-left-user-panel-->
                    </div>   
                    <!--end region:'north'-->

                    <!--start region:'center'-->
                    <div data-options="region:'center',border:false">
                        <!--start easyui-accordion--> 
                        <div id="mainMenu" class="easyui-accordion" data-options="border:false,fit:true">   
							<%@ include file="/WEB-INF/views/common/menu.jsp"%>
                        </div>
                        <!--end easyui-accordion--> 

                    </div>
                    <!--end region:'center'-->
                </div>  
                <!--end class="easyui-layout"-->

            </div>
            <!--最小化菜单--> 
            <div class="theme-left-minimal">
                <ul class="easyui-datalist" data-options="border:false,fit:true">
                    <li><i class="fa fa-home fa-2x"></i><p>主题</p></li>
                    <li><i class="fa fa-book fa-2x"></i><p>组件</p></li>
                    <li><i class="fa fa-pencil fa-2x"></i><p>编辑</p></li>
                    <li><i class="fa fa-cog fa-2x"></i><p>设置</p></li>
                    <li><a class="left-control-switch"><i class="fa fa-chevron-right fa-2x"></i><p>打开</p></a></li>
                </ul>
            </div>

        </div>
        <!--结束左侧菜单--> 

        <div data-options="region:'center',border:false,href:'/main/dashbord'"  id="control">
             
        </div>
    </div>
    
    
	<!--global Modal -->
	<div id="globalMsgPane" class="globalPane bg-primary">
		<div class="globalContent">消息</div>
	</div>
	<div id="globalErrMsgPane" class="globalPane bg-danger">
		<div class="globalContent">消息</div>
	</div>
	<!--global Modal -->
	<div id="globalConfirmPane" class="globalPane bg-gradient">
		<div class="globalContent">消息</div>
		<div class="globalButtons">
		<a class="easyui-linkbutton button-warning btn-confirm"><i class="fa fa-warning"></i> <span>确定</span></a>
		<a class="easyui-linkbutton  btn-cancel"><i class="fa fa-reply"></i> <span>取消</span></a></div>
	</div>
	<div id="globalAjaxing" class="globalPane"><div class="globalContent">加载中...</div></div>

    <script src="/easyui/plugin/Highcharts-5.0.0/js/highcharts.js"></script>

    <script type="text/javascript" src="/easyui/plugin/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="/easyui/plugin/ueditor/ueditor.all.min.js"></script>

    <link href="/easyui/plugin/cropper-2.3.4/dist/cropper.min.css" rel="stylesheet" type="text/css">
    <script src="/easyui/plugin/cropper-2.3.4/dist/cropper.min.js"></script>
    
    <!-- 七牛云上传 -->
	<script type="text/javascript" src="http://cdn.staticfile.org/plupload/2.1.1/plupload.full.min.js"></script>
	<script type="text/javascript" src="http://cdn.staticfile.org/plupload/2.1.1/i18n/zh_CN.js"></script>
	<script type="text/javascript" src="/easyui/plugin/qiniu/qiniu.js"></script>
	<script type="text/javascript" src="/easyui/plugin/qiniu/qiniu.uploader.js"></script>
	<link rel="stylesheet" href="/easyui/plugin/qiniu/qiniu.uploader.css" type="text/css" />
    <!--第三方插件加载结束-->

</body>
</html>