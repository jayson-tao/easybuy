package com.yaorange.service;

import java.util.Map;

import com.yaorange.query.ProductQuery;
import com.yaorange.util.Page;

public interface EsService {
	public Page<Map<String, Object>> queryFromEs(ProductQuery query);
}
