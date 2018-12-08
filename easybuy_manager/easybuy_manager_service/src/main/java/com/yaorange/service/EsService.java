package com.yaorange.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public interface EsService {
	public void saveDataToEs(String id, String json);
	public void saveDataToEsBulk(List<Map<String, Object>> list) throws IOException;
	public long deleteFromEsBulk(List<Long> list);

}
