package com.yaorange.service;

import java.util.Map;

public interface QiNiuService {
	Map<String, String> getUptoken();

	String uploadObject(byte[] data, String key);
	
}
