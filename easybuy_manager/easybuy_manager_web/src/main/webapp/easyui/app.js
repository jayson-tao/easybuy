$(function() {
	/* 布局部分 */
	$('#master-layout').layout({
		fit : true
	/* 布局框架全屏 */
	});

	var left_control_status = true;
	var left_control_panel = $("#master-layout").layout("panel", 'west');

	$(".left-control-switch").on("click", function() {
		if (left_control_status) {
			left_control_panel.panel('resize', {
				width : 100
			});
			left_control_status = false;
			$(".theme-left-normal").hide();
			$(".theme-left-minimal").show();
		} else {
			left_control_panel.panel('resize', {
				width : 200
			});
			left_control_status = true;
			$(".theme-left-normal").show();
			$(".theme-left-minimal").hide();
		}
		$("#master-layout").layout('resize', {
			width : '100%'
		})
	});

	$(".theme-navigate-user-modify").on("click", function() {
		$('.theme-navigate-user-panel').menu('hide');
		$.insdep.window({
			id : "personal-set-window",
			href : "user.html",
			title : "修改资料"
		});

	});
	// $.insdep.control("list.html");
});

function doSearch(value, name) {
	alert('You input: ' + value + '(' + name + ')');
}