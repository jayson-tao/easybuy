package com.yaorange.service;

import java.util.Map;

public interface AreaService {
	 Map<String, Object> getRegionListMap(String regionCode);
	 Map<String, Object> getRegionChildrenListMap(String parentCode);
	 String getAreaFullNameByCode(String regionCode);
}
