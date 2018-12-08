package com.yaorange.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.yaorange.service.QiNiuService;

/**
 * 七牛业务类
 */
@Service
public class QiNiuServiceImpl implements QiNiuService {

	@Value("${accessKey}")
	public String accessKey;
	@Value("${secretKey}")
	public String secretKey;
	@Value("${bucketName}")
	public String bucketName;

	@Override
	public Map<String, String> getUptoken() {
		String accessKey = "k2YDTmYW2_N2yI4msjJfzkIo9aMROxeO36E-gxS-";
		String secretKey = "f7eXd2-m3XboiB6v3Mr9YlsoF1Esou-2k90CnloN";
		String bucket = "easybuy";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);

		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("uptoken", upToken);
		return hashMap;
	}

	// 创建上传对象
	@Override
	public String uploadObject(byte[] data, String key) {
		try {
			// 构造一个带指定Zone对象的配置类
			/*
			 * 华东 Zone.zone0() 华北 Zone.zone1() 华南 Zone.zone2() 北美 Zone.zoneNa0()
			 */
			// Configuration cfg = new Configuration(Zone.zone2());
			Configuration cfg = new Configuration(Zone.autoZone());
			// 调用put方法上传
			UploadManager uploadManager = new UploadManager(cfg);
			Auth auth = Auth.create(accessKey, secretKey);
			String upToken = auth.uploadToken(bucketName, key, 3600, new StringMap().put("insertOnly", 0));

			Response res = uploadManager.put(data, key, upToken);
			// 解析上传成功的结果
			DefaultPutRet putRet = JSONObject.parseObject(res.bodyString(), DefaultPutRet.class);
			return putRet.key;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
