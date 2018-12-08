<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common-link.jsp" %>
		<title>抢购专区 - 购我所爱 I LOVE BUY</title>
	</head>

	<body class="pace-done">
		<%@include file="/WEB-INF/views/common-header-top.jsp" %>
		<%@include file="/WEB-INF/views/common-header.jsp" %>
		<%@include file="/WEB-INF/views/common-nav-other.jsp" %>

		<link rel="stylesheet" href="/static/snapup/a.css">
		<div class="adBg">
			<img alt="" src="/static/snapup/topic2.jpg" />
		</div>
		<div class="Navig clearfix">
		    <ul class="Nav_ul w1200">
		       <!-- <li><em>08:00场  已结束</em></li>
		       <li><em>14:00场  已结束</em></li>
		       <li class="Nav_hover"><em>20:00场  抢购中</em></li> -->
		    </ul>
		</div>

		<div class="Main mOfh">
		    <div class="main_con">
		      <!--  <ul secId="" secode="">
		          <li>
		              <a href="" class="Mi_img"><img src="/static/snapup/T1J.jpg"  height="290" width="290"></a>
		              <h2 class="Mi_title"><a href="">华帝（vatti）i11050+i10036B烟灶套餐</a></h2>
		              <div class="Mi_price">¥<span>1999.00</span><a href="javascript:;" secId="" secskuId="" class="disable">马上抢购</a></div>
		              <div class="Mi_num "><span>共 <num>26</num> 件 剩<b>16</b>件 </span><i>34%</i></div>
		              <div class="Mi_prop"><span style="width:34%"></span></div>
		          </li>
		        </ul> -->
		    </div>
		</div>
		<script type="text/javascript">
		$(function(){
			$('#nav').find('a[href="/snapup"]').addClass('current');
			$('.wrap-line').css('left','424px').css('width','104px');
		});

		$(function(){
			$('body').on('click','.Nav_ul li',function(){
				$('.Nav_ul li').removeClass('Nav_hover');
				var index = $(this).index();
				$('.Nav_ul li').eq(index).addClass('Nav_hover');
				$('.main_con').find('ul').hide();
				$('.main_con').find('ul').eq(index).show();
			});

			$('body').on('click','.Mi_price a',function(){
				if($(this).hasClass('disable')) return;
				//执行抢购请求
				var skuid = $(this).attr('secskuId');
				var secid = $(this).attr('secId');
				var secode = $(this).closest('ul').attr('secode');
				$.post('/seckill/hit',{secKillId:secid,secKillSkuId:skuid,code:secode},function(ret){
					if(ret.success){//如果抢购成功，则跳转到抢购成功页(查询当前用户是否抢购成功)
						$.msg('抢购成功');
						//前往抢购商品确认订单页面
						setTimeout(function(){location.href = '';},1000);
					}else{
						$.msg(ret.message+' '+ret.info);
						refreshStock();
					}
				});
			});
		});

		//获取页面数据
		$(function(){
			$.get('http://piixu6eeo.bkt.clouddn.com/jayson.json?_r='+new Date().getTime(),
					{},
					function(nameData){
						$.get('http://piixu6eeo.bkt.clouddn.com/'+nameData.secKillDetail+'.json',{},function(data){
							var currentDoIndex = -1;
							var currentWaitIndex = -1;
							for(var i=0;i<data.length;i++){
								var seckill = data[i];
								var emName = seckill.title;
								var beginTime = seckill.beginTime;
								var endTime = seckill.endTime;
								var currentTime = new Date().getTime();
								var runing = 0;
								var stateName = '';
								if(currentTime>=beginTime && currentTime<=endTime){
									currentDoIndex = i;
									stateName = '进行中';
									runing = 1;
								}else if(currentTime < beginTime){
									currentWaitIndex = i;
									stateName = '等待中';
								}else{
									stateName = '已结束';
									runing = 2;
								}
								$('.Nav_ul').append('<li><em>'+emName + ' ' +stateName+'</em></li>');
								var ulList = $('<ul secId="'+seckill.id+'" runing="'+runing+'" secode=""></ul>');
								var skuList = seckill.skuList;
								for(var j=0;j<skuList.length;j++){
									var sku = skuList[j];
									var seckillId = sku.seckillId;
									var skuName = sku.skuName;
									var productId = sku.productId;
									var skuId = sku.skuId;
									var skuPic = sku.skuPic;
									var price = sku.price;
									var totalCount = sku.totalCount;

									var li = '<li>';
						            li+='<a href="/p/'+productId+'" class="Mi_img"><img src="http://pijbgt8k2.bkt.clouddn.com/'+skuPic+'?imageView2/1/w/290/h/290"></a>';
						            li+='<h2 class="Mi_title"><a href="/p/'+productId+'">'+skuName+'</a></h2>';
						            li+='<div class="Mi_price">¥<span>'+(price*0.01)+'</span>';
						            if(stateName == '已结束'){
						            	li+='<a class="disable">已结束</a>';
						            }else if(stateName == '进行中'){
						            	li+='<a href="javascript:;" secId="'+seckill.id+'" secskuId="'+sku.id+'">马上抢购</a>';
						            }else{
						            	li+='<a class="disable">马上抢购</a>';
						            }
						            li+='</div>';
						            li+='<div class="Mi_num "><span>共 <num>'+totalCount+'</num> 件 剩<b>'+totalCount+'</b>件 </span><i>0%</i></div>';
						            li+='<div class="Mi_prop"><span style="width:0%"></span></div>';
						            li+='</li>';
						            ulList.append(li);
								}
								$('.main_con').append(ulList);
							}

							if(currentDoIndex>=0){
							}else if(currentWaitIndex >= 0){
								currentDoIndex = currentWaitIndex;
							}else{
								currentDoIndex = 0;
							}
							$('.Nav_ul').find('li').eq(currentDoIndex).addClass('Nav_hover');
							$('.main_con').find('ul').hide();
							$('.main_con').find('ul').eq(currentDoIndex).show();

							refreshStock();

							//已结束，设置剩余量为0
							$('.main_con').find('ul[runing=2]').each(function(){
								$(this).find('.Mi_num').find('b').text(0);
								$(this).find('.Mi_num').find('i').text('100%');
								$(this).find('.Mi_prop').find('span').css('width','100%');
							});

						});
			});
		});


		function refreshStock(){
			//进行中 ，请求抢购随机码
			$('.main_con').find('ul[runing=1]').each(function(){
				var secId = $(this).attr('secId');
				var secskuids = '';
				$(this).find('.Mi_price').find('a').each(function(){
					secskuids+=' '+$(this).attr('secskuId');
				});
				 $.post('/seckill/code',{secKillId : secId, secKillSkuIds : secskuids},function(ret){
					var secId = ret.data.seckillId;
					var code = ret.data.code;
					$('.main_con').find('ul[secId='+secId+']').attr('secode',code);

					var numList = ret.data.numList;
					for(var i=0;i<numList.length;i++){
						var skuid = numList[i].skuid;
						var num = numList[i].num;
						var li = $('.Mi_price').find('a[secskuId='+skuid+']').closest('li');
						if(num==0){
							li.find('.Mi_price').find('a').attr('href','javascript:;');
							li.find('.Mi_price').find('a').text('抢光啦');
							li.find('.Mi_price').find('a').addClass('disable');
						}
						li.find('.Mi_num').find('b').text(num);
						var total = parseInt(li.find('.Mi_num').find('num').text());
						var soldNum = total - num;
						var soldRate = ((soldNum*100) / total).toFixed(2);

						li.find('.Mi_num').find('i').text(soldRate+'%');
						li.find('.Mi_prop').find('span').css('width',soldRate+'%');
					}
				});
			});
		}

		function formatDateTime(inputTime) {
		    var date = new Date(inputTime);
		    var y = date.getFullYear();
		    var m = date.getMonth() + 1;
		    m = m < 10 ? ('0' + m) : m;
		    var d = date.getDate();
		    d = d < 10 ? ('0' + d) : d;
		    var h = date.getHours();
		    h = h < 10 ? ('0' + h) : h;
		    var minute = date.getMinutes();
		    var second = date.getSeconds();
		    minute = minute < 10 ? ('0' + minute) : minute;
		    second = second < 10 ? ('0' + second) : second;
		    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
		};

		</script>
		<%@include file="/WEB-INF/views/common-right-sidebar.jsp" %>
		<!-- 站点底部-->
		<%@include file="/WEB-INF/views/common-footer.jsp" %>
	</body>
</html>
