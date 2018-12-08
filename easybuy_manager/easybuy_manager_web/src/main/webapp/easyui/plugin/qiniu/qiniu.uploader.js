MXF=MXF||{};
MXF.QINIU = {
		SWFURL:'http://cdn.staticfile.org/plupload/2.1.1/Moxie.swf',
		TOKENURL : '/plugin/qiniu/uptoken',
		DOMAIN   : 'http://pijbgt8k2.bkt.clouddn.com/'
		//DOMAIN   : 'http://piixu6eeo.bkt.clouddn.com/'

};

MXF.uuid = function (len, radix) {
	  var CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
	  var chars = CHARS, uuid = [], i;
	  radix = radix || chars.length;

	  if (len) {
	    // Compact form
	    for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
	  } else {
	    // rfc4122, version 4 form
	    var r;

	    // rfc4122 requires these characters
	    uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
	    uuid[14] = '4';

	    // Fill in random data.  At i==19 set the high bits of clock sequence as
	    // per rfc4122, sec. 4.1.5
	    for (i = 0; i < 36; i++) {
	      if (!uuid[i]) {
	        r = 0 | Math.random()*16;
	        uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
	      }
	    }
	  }
	  var uuids= uuid.join('');
	  uuids = uuids.replace(/-/g,'');
	  return uuids;
};

MXF.initQiniuUploader = function(box){
	var loadPageTime = new Date().getTime();
	var targets = [];
	if($(box).hasClass('qiniuUploader')){// class属性
		targets = $(box);
	}else{
		targets = $(box).find(".qiniuUploader");
	}

	var appendImgSpan = function(url,containerId,inputName){
			var imageView = $('#'+containerId).find('.qiniuImageView');
			var imgSpan = $('<span title="点击预览"></span>');
	 	    imgSpan.append('<a title="删除">&times;</a>');
	 	    var imgSrc = url;
	 	    if(url.indexOf('http://')>=0 || url.indexOf('https://')>=0){
	 	    	imgSrc = url;
	 	    }else{
	 	    	imgSrc = MXF.QINIU.DOMAIN+url;
	 	    }
	 	    imgSpan.append('<img key="'+url+'" src="'+imgSrc+'?imageView2/1/w/80/h/80"/>');
	 	    imageView.append(imgSpan);
	 	    imgSpan.click(function(){
	 	    	var key = $(this).find('img').attr('key');
	 	    	var imgKeyUrl = '';
	 	    	if(key.indexOf('http://')>=0 || key.indexOf('https://')>=0){
	 	    		imgKeyUrl = key;
		 	    }else{
		 	    	imgKeyUrl = MXF.QINIU.DOMAIN+key;
		 	    }
	 	    	var imgTag = '<img src="'+imgKeyUrl+'"/>';
	 	    	var imageViewDialog = $('<div></div>');
	 	    	imageViewDialog.appendTo('body');
	 	    	$(imageViewDialog).dialog({
	 	    	    title: '图片预览',
	 	    	    closed: false,
	 	    	    fit : true,
	 	    	    maximized : true,
	 	    	    content : imgTag,
	 	    	    modal: true,
	 	    	    onClose : function(){
	 	    		  imageViewDialog.dialog('destroy');
	 	    	   }
	 	    	});
	 	    });
	 	    imgSpan.find('a').click(function(){
	 	    	$(this).parent().remove();
	 	    	var imgs = $('#'+containerId).find('.qiniuImageView').find('img');
	 	    	var existUrls = '';
	 	    	for(var i=0;i<imgs.length;i++){
	 	    		existUrls+=','+$(imgs[i]).attr('key');
	 	    	}
	 	    	if(existUrls.length>0){
	 	    		existUrls = existUrls.substring(1);
	 	    	}
	 	    	$('#'+containerId).find('input[name="'+inputName+'"]').val(existUrls);
	 	    });
	 	    return imgSpan;
	}

	var defaultConfig = {
		runtimes : 'html5,flash,html4',
		max_file_size : '10mb',
		flash_swf_url : MXF.QINIU.SWFURL,
		dragdrop : true,
		chunk_size : '4mb',
		multi_selection :false,
		uptoken_url : MXF.QINIU.TOKENURL,
		domain : MXF.QINIU.DOMAIN,
		get_new_uptoken : false,
		auto_start : true,
		log_level : 5,
		init : {
			'FilesAdded': function(up, files) {},
			'BeforeUpload': function(up, file) {},
			'UploadProgress': function(up, file) {},
			'UploadComplete' : function() {},
			'FileUploaded' : function(up, file, info) {console.debug(info);},
			'Error' : function(up, err, errTip) {MXF.alert('上传失败',false);},
            'Key': function(up, file) {var key = "";key = MXF.uuid(); return key;}
			   }
		}

	for(var i=0;i<targets.length;i++){

		var $this = $(targets[i]);

		var isInit = $this.attr('init');
		if(isInit && 'done'==isInit) continue;

		var inputName = $this.attr('name');
		if(inputName && inputName!=''){;}else{inputName="file";};

		var isMulti = $this.attr('multiply'); //multiply属性
		var multiSelect = false;
		if(isMulti &&('true'==isMulti || 'multiply'==isMulti)){
			multiSelect = true;
		}

		maxFileCount = 1;
		if(multiSelect){
			var maxFiles = $this.attr('maxFiles');
			if(maxFiles && $.isNumeric(maxFiles)){
				maxFileCount = parseInt(maxFiles);
				if(maxFileCount<2) maxFileCount = 2;
			}
		}

		var uploaderId = loadPageTime+''+i;
		var buttonId = 'pickfiles'+uploaderId;
		var containerId = 'qiniuContainer'+uploaderId;

		$this.attr('type','hidden');
		$this.attr('name',inputName);
		$this.wrap('<div id="'+containerId+'"></div>');

		var container = $this.parent();
		var uploadButton = $('<a href="javascript:;" class="btn btn-primary btn-sm "><i class="glyphicon glyphicon-plus"></i><span>添加文件</span></a>');
		uploadButton.attr('id',buttonId);
		container.append(uploadButton);
		if(multiSelect){
			container.append('<span> '+maxFileCount+'个(含)文件以内</span>');
		}
		container.append($('<div class="qiniuImageView"></div>'));

		//初始化预览图
		var initUrls = $this.val();
	    if(initUrls.length>0){
	    	var urlArr = initUrls.split(',');
	    	for(var i=0;i<urlArr.length;i++){
	    		var url = urlArr[i];
	    		appendImgSpan(url,containerId,inputName);
	    	}

	    }

		var myConfig = {
				multi_selection: multiSelect,
				maxFileCount : maxFileCount,
				inputName : inputName,
				browse_button : buttonId,
				container : containerId,
				init : {
					'FilesAdded': function(up, files) {
						var _containerId = up.settings.container;
						var _buttonId = $(up.settings.browse_button).attr('id');
						var existPicCount = $('#'+_containerId).find('.qiniuImageView').find('span').length;

							if(up.settings.multi_selection){
								if(existPicCount<up.settings.maxFileCount){
									plupload.each(files, function(file) {
									   if (up.files.length > up.settings.maxFileCount-existPicCount) {
										   up.removeFile(file);
									   }
									});
									if(up.files.length>0){
										$('#'+_buttonId).find('span').text('上传中...');
										$('#'+_buttonId).removeClass('btn-primary').addClass('btn-danger');
									}
								}else{//已达到最大上传数，清除待上传文件列表
									MXF.alert('已达到最大上传数，不能继续上传！');
									plupload.each(files, function(file) {
										up.removeFile(file);
									});
									/*for (var i = up.files.length - 1; i >= 0; i--) {
										up.splice(i, 1);
									}*/
								}
							}else{
								$('#'+_containerId).find('input[name="'+up.settings.inputName+'"]').val('');
								$('#'+_containerId).find('.qiniuImageView').empty();
								$('#'+_buttonId).find('span').text('上传中...');
								$('#'+_buttonId).removeClass('btn-primary').addClass('btn-danger');
							}
					},
					'UploadComplete' : function(up, files) {
						var _buttonId = $(up.settings.browse_button).attr('id');
						$('#'+_buttonId).removeClass('btn-danger').addClass('btn-primary');
						$('#'+_buttonId).find('span').text('添加文件');
						if(up.settings.multi_selection){
							for (var i = up.files.length - 1; i >= 0; i--) {
								up.splice(i, 1);
							}
						}
					},
					'FileUploaded' : function(up, file, info) {
						var _containerId = up.settings.container;
						var res = $.parseJSON(info);
					    var url='';
					    if (res.key) url = res.key;
					    var existUrl = $('#'+_containerId).find('input').val();
					    var newUrls = '';
					    if(existUrl && existUrl!=''){
					    	newUrls = existUrl + ','+url;
					    }else{
					    	newUrls = url;
					    }
					    var fileinput = $('#'+_containerId).find('input[name="'+up.settings.inputName+'"]');
					    fileinput.val(newUrls);

					    var itemname = up.settings.inputName;
						var form = $(fileinput).closest('form');
					    appendImgSpan(url,_containerId,up.settings.inputName);
					},
					'Key': function(up, file) {var key = "";key = MXF.uuid(); return key;}
				}
		};
		var qiniuConfig = $.extend({},defaultConfig,myConfig);
		var QiniuObject = new QiniuJsSDK();
		QiniuObject.uploader(qiniuConfig);
		$this.attr('init','done');
	}
};
