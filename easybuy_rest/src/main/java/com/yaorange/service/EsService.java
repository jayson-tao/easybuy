package com.yaorange.service;

import java.util.List;
import java.util.Map;

import com.yaorange.query.ProductQuery;
import com.yaorange.util.Page;


public interface EsService {
	public Page<Map<String, Object>> queryFromEs(ProductQuery query);
	public void saveDataToEs(String id,String json);
	public void saveDataToEsBulk(List<Map<String,Object>> list);
	public long deleteFromEsBulk(Long[] ids);

}
