<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="easyui-layout" data-options="fit:true">
     <div data-options="region:'north',border:false" style="height:235px">
                <div class="theme-user-info-panel">
                	<div class="left">
                    	<img src="/easyui/themes/insdep/images/avatar.86.jpg" width="86" height="86">
                    </div>
                    <div class="right">
                    	
                          <style>
						  .gauge {
							width: 130px;
							height: 130px;
						  }
						  </style>
                            <script>
							$(function(){
							
								var dflt = {
								  min: 0,
								  max: 2800,
								  donut: true,
								  gaugeWidthScale: 0.6,
								  counter: true,
								  hideInnerShadow: true
								}
								var gg1 = new JustGage({
								  id: 'gg1',
								  value: 125,
								  defaults: dflt
								});
							
								var gg2 = new JustGage({
								  id: 'gg2',
								  defaults: dflt
								});
								var gg3 = new JustGage({
								  id: 'gg3',
								  defaults: dflt
								});
								var gg4 = new JustGage({
								  id: 'gg4',
								  defaults: dflt
								});
							
							  });
							  </script>
                    	<ul>
                        	<li><div id="gg1" class="gauge"  data-value="280"></div><span>新增会员(人)</span></li>
                            <li><div id="gg2" class="gauge"  data-value="2025"></div><span>销售额(万元)</span></li>
                        	<li><div id="gg3" class="gauge"  data-value="115"></div><span>稳定运行(天)</span></li>
                            <li><div id="gg4" class="gauge"  data-value="68"></div><span>今日销售(万元)</span></li>
                        </ul>
                    </div>
                    <div class="center">
                        <h1>管理员<span class="color-success badge">认证</span></h1>
                        <h2>管理员</h2>
                        <dl>
                            <dt>nxh@yaorange.com</dt>
                            <dd>13000000000</dd>
                        </dl>
                    </div>
                	
                </div>
     </div>
     <div data-options="region:'center',border:false">

                <div id="user-info-more" class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder" data-options="tools:'#tab-tools',fit:true">

                    <div title="统计图" id="charts-layout">
                     	<!--统计开始-->
                       
                       <div id="charts" style="height:295px;"></div>
                       <script type="text/javascript">
								$(function () {
									
									Highcharts.setOptions({
									    lang:{
									       contextButtonTitle:"图表导出菜单",
									       decimalPoint:".",
									       downloadJPEG:"下载JPEG图片",
									       downloadPDF:"下载PDF文件",
									       downloadPNG:"下载PNG文件",
									       downloadSVG:"下载SVG文件",
									       drillUpText:"返回 {series.name}",
									       loading:"加载中",
									       months:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
									       noData:"没有数据",
									       numericSymbols: [ "千" , "兆" , "G" , "T" , "P" , "E"],
									       printChart:"打印图表",
									       resetZoom:"恢复缩放",
									       resetZoomTitle:"恢复图表",
									       shortMonths: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
									       thousandsSep:",",
									       weekdays: ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期天"]
									    }
									}); 
									
								  $('#charts').highcharts({
									  chart: {
										  type: 'spline',
										  events: {
                							load: function(){
												
											}
										}
									  },
									  title: {
										  text: '分时统计图'
									  },
									  subtitle: {
										  text: '易购网全品类实时销售统计报表'
									  },
									  xAxis: {
										  type: 'datetime',
										  dateTimeLabelFormats: {
										        year: '%Y',
										        month: '%Y-%m',
										        dat: '%Y-%m-%d',
										        second:"%Y-%m-%d %H:%M:%S"
										        // ...
										        // 当然还可以通过xAxis.labels.formatter 函数来格式化
										  }
									  },
									  yAxis: {
										  title: {
											  text: '销量（万件）'
										  },
										  min: 0,
										  minorGridLineWidth: 0,
										  gridLineWidth: 0,
										  alternateGridColor: null
									  },
									  tooltip: {
										  formatter:function(){
										      return '<strong>'+this.series.name+'</strong><br>'+
										         Highcharts.dateFormat('%Y-%m-%d %H:%M:%S',this.x)+'<br> '+this.y+' 万件';
										   }
									  },
									  plotOptions: {
										  spline: {
											  lineWidth: 4,
											  states: {
												  hover: {
													  lineWidth: 5
												  }
											  },
											  marker: {
												  enabled: false
											  },
											  pointInterval: 3600000, // one hour
											  pointStart: Date.UTC(2017, 3, 20, 0, 0, 0),
											  formatter: function(){ return this.x + 'mm'}
										  }
									  },
									  series: [{
										  name: '今日',
										  data: [4.3, 5.1, 4.3, 5.2, 5.4, 4.7, 3.5, 4.1, 5.6, 7.4, 6.9, 7.1,
											  7.9, 7.9, 7.5, 6.7, 7.7, 7.7, 7.4, 7.0, 7.1, 5.8, 5.9, 7.4,
											  8.2, 8.5, 9.4, 8.1, 10.9, 10.4, 10.9, 12.4, 12.1, 9.5, 7.5,
											  7.1, 7.5, 8.1, 6.8, 3.4, 2.1, 1.9, 2.8, 2.9, 1.3, 4.4, 4.2,
											  3.0, 3.0]
								
									  }, {
										  name: '昨日',
										  data: [2.3, 3.1, 4.8,6.2, 3.4, 6.7, 5.5, 3.1, 3.6, 7.7, 5.9, 1.1,
											  0.7, 0.9, 1.5, 1.2, 2.0, 3.95, 4.23, 5.0, 6.5, 6.0, 5.8, 6.5,
											  9.0, 0.6, 1.2, 1.7, 0.7, 2.9, 4.1, 2.6, 3.7, 3.9, 1.7, 2.3,
											  3.0, 3.3, 4.8, 5.0, 4.8, 5.0, 3.2, 2.0, 0.9, 0.4, 0.3, 0.5, 0.4]

									  }]
									  ,
									  navigation: {
										  menuItemStyle: {
											  fontSize: '10px'
										  }
									  }
								  });
								  
			
								  /*$('#user-info-more').tabs({
									  onSelect: function(){
										//重置宽度
										var chart = $('#charts').highcharts();
							   			chart.reflow();
									  }
									});
									*/
	
						

							});
															 
							document.addEventListener("DOMContentLoaded", function(){
							//完成所有页面处理后
							//重置宽度
							   var chart = $('#charts').highcharts();
							   chart.reflow();
							});
						</script>
                        
                        <!--统计结束-->   
                    </div>
                    <div title="帮助" data-options="closable:true" style="padding:10px">
                       	帮助信息
                    </div>
                </div>

            </div>
     </div>
</div>