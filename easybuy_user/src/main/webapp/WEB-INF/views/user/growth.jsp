<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/top.jsp" %>
<%@include file="/WEB-INF/views/left.jsp" %>

<!-- 正文，由view提供 -->
					
				
				<div class="con-right fr">
					<div class="con-right fr">
						<div class="con-right-text">
							<div class="tabmenu">
								<div class="user-status">
									<span class="active" id="status1" onclick="setTab(&#39;status&#39;,1,2)">
					<a href="javascript:;" target="_self">
						<span>成长值规则</span>
									<span class="vertical-line">|</span>
									</a>
									</span>
									<span class="" id="status2" onclick="setTab(&#39;status&#39;,2,2)">
					<a href="javascript:;" target="_self">
						<span>我的成长值</span>
									</a>
									</span>
								</div>
								<div class="user-tab-right">
									<span>
					我的成长值：
					<font class="second-color">0</font>
				</span>
									<span>
					会员级别：
					<font class="second-color">初级会员一级</font>
				</span>
									<span>
					再积累
					<font class="second-color">2</font>
					成长值可升级初级会员二级
				</span>
								</div>
							</div>
							<div class="content-info">
								<div id="con_status_1">
									<div class="growth-value-text">
										<h2 class="text-title">
						<span>成长值介绍</span>
					</h2>
										<ul class="text-info">
											<li>1、成长值是商城会员通过购物获得</li>
											<li>2、累积的成长值总额决定会员等级，成长值越高，会员等级越高。会员成长值 ≈ 累计购物金额</li>
											<li>3、成长值：购物获得的成长值是根据确认收货时间计算，成长值按照交易金额的个位数取整计算：例如会员的订单是88.2元，则确认收货后并且无退款退货，即可以得到88点成长值</li>
											<li>4、确认收货后退款退货，会扣减成长值，扣除的成长值与当时获得的值相同</li>
										</ul>
									</div>
									<div class="growth-value-text">
										<h2 class="text-title">
						<span>升级条件</span>
					</h2>
										<table class="growth-table">
											<thead>
												<tr>
													<th>会员等级</th>
													<th>成长值</th>
													<th>等级图标</th>
												</tr>
											</thead>
											<tbody>
												
												<tr>
													<td>初级会员一级</td>
													
													<td>0--1</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788627664630.gif">
													</td>
												</tr>
												
												<tr>
													<td>初级会员二级</td>
													
													<td>2--9</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788627989037.gif">
													</td>
												</tr>
												
												<tr>
													<td>初级会员三级</td>
													
													<td>10--19</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788628296382.gif">
													</td>
												</tr>
												
												<tr>
													<td>初级会员四级</td>
													
													<td>20--49</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788628553558.gif">
													</td>
												</tr>
												
												<tr>
													<td>初级会员五级</td>
													
													<td>50--99</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788629373006.gif">
													</td>
												</tr>
												
												<tr>
													<td>高级会员一级</td>
													
													<td>100--159</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788633113082.gif">
													</td>
												</tr>
												
												<tr>
													<td>高级会员二级</td>
													
													<td>160--229</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788633692312.gif">
													</td>
												</tr>
												
												<tr>
													<td>高级会员三级</td>
													
													<td>230--309</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788633984479.gif">
													</td>
												</tr>
												
												<tr>
													<td>高级会员四级</td>
													
													<td>310--399</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788634665294.gif">
													</td>
												</tr>
												
												<tr>
													<td>高级会员五级</td>
													
													<td>400--499</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788636761576.gif">
													</td>
												</tr>
												
												<tr>
													<td>顶级会员一级</td>
													
													<td>500--699</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788639952002.gif">
													</td>
												</tr>
												
												<tr>
													<td>顶级会员二级</td>
													
													<td>700--999</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788640236370.gif">
													</td>
												</tr>
												
												<tr>
													<td>顶级会员三级</td>
													
													<td>1000--1399</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788640497564.gif">
													</td>
												</tr>
												
												<tr>
													<td>顶级会员四级</td>
													
													<td>1400--1899</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788640738775.gif">
													</td>
												</tr>
												
												<tr>
													<td>顶级会员五级</td>
													
													<td>1900--2499</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788641181736.gif">
													</td>
												</tr>
												
												<tr>
													<td>贵宾vip（优先处理）</td>
													
													<td>2500--9999</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788642381109.gif">
													</td>
												</tr>
												
												<tr>
													<td>钻石会员（单独接待）</td>
													
													<td>10000--99999</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788642893022.gif">
													</td>
												</tr>
												
												<tr>
													<td>土豪会员（单独接待）</td>
													
													<td>&gt;=100000</td>
													
													<td class="rank-img">
														<img src="/static/img/test/14788643649974.gif">
													</td>
												</tr>
												
											</tbody>
										</table>
									</div>
								</div>

								<div id="con_status_2" style="display: none;">
									<div class="growth-value-text">
										<table class="table">
											<thead>
												<tr>
													<th style="width: 35%;">来源/用途</th>
													<th style="width: 15%;">订单号/退款编号</th>
													<th style="width: 15%;">实付款</th>
													<th style="width: 10%;">成长值</th>
													<th style="width: 25%;">获取时间</th>
												</tr>
											</thead>
										</table>
										<div class="no-data">
											<i class="fa fa-exclamation-circle"></i> 暂无成长值
										</div>
									</div>
									<div class="growth-value-text">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			
				<script type="text/javascript">
					var tablelist = null;
					$().ready(function() {
						tablelist = $("#table_list").tablelist({
							params: $("#searchForm").serializeJson()
						});
						$("#searchForm").submit(function() {
							// 序列化表单为JSON对象
							var data = $(this).serializeJson();
							console.info(data);
							// Ajax加载数据
							tablelist.load(data);
							// 阻止表单提交
							return false;
						});
				
					});
				</script>
					
				<!-- 正文结束，由view提供 -->

<%@include file="/WEB-INF/views/footer.jsp"%>