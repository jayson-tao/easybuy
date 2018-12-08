package com.yaorange.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaorange.mapper.TAreaMapper;
import com.yaorange.pojo.TArea;
import com.yaorange.pojo.TAreaExample;
import com.yaorange.pojo.TAreaExample.Criteria;
import com.yaorange.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private TAreaMapper areaMapper;

	@Override
	public Map<String, Object> getRegionChildrenListMap(String parentCode) {
		Map<String, Object> retMap = new HashMap<>();
		List<List<Map<String, Object>>> allList = new ArrayList<>();

		retMap.put("code", 0);
		if (StringUtils.isNotBlank(parentCode)) {
			List<TArea> areaList = getAreaList(parentCode);
			List<Map<String, Object>> areaMapList = convertToRegionPluginData(areaList);
			if (null != areaMapList) {
				allList.add(areaMapList);
			}
		}

		retMap.put("data", allList);
		String[] levelNames = { "", "省", "市", "区/县", "镇", "街道/村" };
		retMap.put("level_names", levelNames);
		return retMap;
	}

	@Override
	public Map<String, Object> getRegionListMap(String regionCode) {
		Map<String, Object> retMap = new HashMap<>();
		Map<String, Object> namesMap = new HashMap<>();
		List<List<Map<String, Object>>> allList = new ArrayList<>();

		retMap.put("code", 0);

		if (StringUtils.isNotBlank(regionCode)) {
			String[] reginCodeArr = regionCode.split(",");

			String parentCode = "0";
			List<TArea> provinceList = getAreaList(parentCode);
			List<Map<String, Object>> provinceMapList = convertToRegionPluginData(provinceList);
			allList.add(provinceMapList);
			for (TArea area : provinceList) {
				if (area.getCode().equals(reginCodeArr[0])) {
					namesMap.put(area.getCode(), area.getName());
				}
			}
			if (reginCodeArr.length >= 1) {
				parentCode = reginCodeArr[0];
				List<TArea> cityList = getAreaList(parentCode);
				List<Map<String, Object>> cityMapList = convertToRegionPluginData(cityList);
				allList.add(cityMapList);

				for (TArea area : cityList) {
					if (area.getCode().equals(reginCodeArr[0] + "," + reginCodeArr[1])) {
						namesMap.put(area.getCode(), area.getName());
					}
				}

				if (reginCodeArr.length >= 2) {
					parentCode = reginCodeArr[0] + "," + reginCodeArr[1];
					List<TArea> areaList = getAreaList(parentCode);
					List<Map<String, Object>> areaMapList = convertToRegionPluginData(areaList);
					allList.add(areaMapList);
					if (reginCodeArr.length >= 3) {
						for (TArea area : areaList) {
							if (area.getCode()
									.equals(reginCodeArr[0] + "," + reginCodeArr[1] + "," + reginCodeArr[2])) {
								namesMap.put(area.getCode(), area.getName());
							}
						}
					}
				}
			}
			retMap.put("region_names", namesMap);
		}

		retMap.put("data", allList);
		String[] levelNames = { "", "省", "市", "区/县", "镇", "街道/村" };
		retMap.put("level_names", levelNames);
		return retMap;
	}

	private List<TArea> getAreaList(String parentCode) {
		List<TArea> list = null;
		if ("0".equals(parentCode)) {
			TAreaExample example = new TAreaExample();
			Criteria criteria = example.createCriteria();
			criteria.andLevelEqualTo((byte) 1);
			list = areaMapper.selectByExample(example);
		} else {
			TAreaExample example = new TAreaExample();
			Criteria criteria = example.createCriteria();
			criteria.andCodeEqualTo(parentCode);
			List<TArea> result = areaMapper.selectByExample(example);
			List<Long> ids = new ArrayList<>();
			for (TArea area : result) {
				ids.add(area.getId());
			}
			TAreaExample childExample = new TAreaExample();
			Criteria childCriteria = childExample.createCriteria();
			childCriteria.andPidIn(ids);
			list = areaMapper.selectByExample(childExample);
		}
		return list;
	}

	/**
	 * 转换为jquery.region插件适配的格式
	 *
	 * @param areaList
	 * @return
	 */
	private List<Map<String, Object>> convertToRegionPluginData(List<TArea> areaList) {
		if (areaList == null || areaList.size() == 0)
			return null;
		List<Map<String, Object>> mapList = new ArrayList<>();
		for (TArea area : areaList) {
			Map<String, Object> areaMap = new HashMap<>();
			areaMap.put("region_id", area.getId());
			areaMap.put("region_code", area.getCode());
			areaMap.put("region_name", area.getName());
			if (area.getCode().contains(",")) {
				areaMap.put("parent_code", area.getCode().substring(0, area.getCode().lastIndexOf(",")));
			} else {
				areaMap.put("parent_code", "0");
			}
			areaMap.put("level", area.getLevel());
			mapList.add(areaMap);
		}
		return mapList;
	}

	@Override
	public String getAreaFullNameByCode(String regionCode) {
		if(StringUtils.isBlank(regionCode)) return "";
		String fullName = "";
		String[] codeArr = regionCode.split(",");
		if(codeArr.length>=0){
			long id = Long.parseLong(codeArr[0]+"0000");
			TArea area = areaMapper.selectByPrimaryKey(id);
			if(null!=area){
				fullName+=area.getName()+" ";
			}
		}
		if(codeArr.length>=1){
			long id = Long.parseLong(codeArr[0]+codeArr[1]+"00");
			TArea area = areaMapper.selectByPrimaryKey(id);
			if(null!=area){
				fullName+=area.getName()+" ";
			}
		}
		if(codeArr.length>=2){
			long id = Long.parseLong(codeArr[0]+codeArr[1]+codeArr[2]);
			TArea area = areaMapper.selectByPrimaryKey(id);
			if(null!=area){
				fullName+=area.getName()+" ";
			}
		}
		return fullName;
	}

}
