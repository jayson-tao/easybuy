package com.yaorange.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yaorange.mapper.TProductExtMapper;
import com.yaorange.mapper.TProductMapper;
import com.yaorange.mapper.TProductMediaMapper;
import com.yaorange.mapper.TSkuMapper;
import com.yaorange.pojo.*;
import com.yaorange.service.ProductSkuService;
import com.yaorange.util.KV;
import com.yaorange.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;

/**
 * 商品详情页
 */
@Service
public class ProductSkuServiceImpl implements ProductSkuService {
    @Autowired
    private TSkuMapper skuMapper;
    @Autowired
    private TProductMapper productMapper;
    @Autowired
    private TProductMediaMapper productMediaMapper;
    @Autowired
    private TProductExtMapper productExtMapper;

    /**
     * 商品详情页面sku信息的显示 数据封装
     * keyNames -->销售属性名称列表
     * keyNameAndValueIdAndValueName --> 销售属性和对应value的map
     * skuListJson  -->sku信息列表
     * product
     * productExt
     * @param id
     */
    @Override
    public void findSkuByProductId(Long id, Model model) {
        TSkuExample example = new TSkuExample();
        example.createCriteria().andProductIdEqualTo(id);
        //根据商品id查出全部sku
        List<TSku> skuList = skuMapper.selectByExample(example);
        //封装数据
        //商品销售属性集合-->去重
        Set<String> keyNames = new HashSet<>(0);
        Map<String,Set<KV<String,String>>> keyNameAndValueIdAndValueName = new HashMap<>(0);
        //skuList
        List<Map<String,Object>> skuListData = new ArrayList<>(0);
        for (TSku sku : skuList) {
            //获取skuProperties-->36:颜色:72:宝蓝色_39:尺码:74:M
            String skuProperties = sku.getSkuProperties();
            //分割--得到keyValue的数组-->36:颜色:72:宝蓝色
            String[] keyValues = skuProperties.split("_");
            //一个sku的valueId拼接 ：65|75
            StringBuffer spec_ids = new StringBuffer();
            Map<String,Object> skuMap = new HashMap<>(0);
            for (String keyValue : keyValues) {
                //分割->keyId,keyName,valueId,valueName
                String[] split = keyValue.split(":");
                //获取keyName
                String keyName = split[1];
                keyNames.add(keyName);
                String valueId = split[2];
                //拼接spec_ids
                spec_ids.append("|"+valueId);
                String valueName = split[3];
                //valueId和value的对应关系
                KV<String,String> valueIdAndValueName = new KV<>(valueId,valueName);
                //属性和对应value的关系 一个属性多个value value包括valueId,vlaueName
                Set<KV<String, String>> valueAndValueNameSet = keyNameAndValueIdAndValueName.get(keyName);
                if(valueAndValueNameSet==null){
                    //如果没有就创建一个放进去
                    valueAndValueNameSet = new HashSet<>();
                    keyNameAndValueIdAndValueName.put(keyName,valueAndValueNameSet);
                }
                //放入set
                valueAndValueNameSet.add(valueIdAndValueName);
            }
            String spec_ids1 = spec_ids.substring(1);
            skuMap.put("sku_id", sku.getId());
            //设置
            skuMap.put("spec_ids", spec_ids1);
            skuMap.put("goods_number", sku.getAvailableStock());
            skuMap.put("goods_price", sku.getPrice());
            skuMap.put("sku_image", sku.getSkuMainPic());
            skuMap.put("sku_image_thumb", sku.getSkuMainPic());
            skuMap.put("market_price", sku.getMarketPrice());
            skuListData.add(skuMap);
        }
        //把skuListData ->json
        String skuListJson = JSONObject.toJSONString(skuListData);
        model.addAttribute("keyNames",keyNames);
        model.addAttribute("keyNameAndValueIdAndValueName",keyNameAndValueIdAndValueName);
        model.addAttribute("skuListJson",skuListJson);
        //商品信息
        //根据id查询商品信息
        TProduct product = productMapper.selectByPrimaryKey(id);
        TProductMediaExample example1 = new TProductMediaExample();
        example1.createCriteria().andProductIdEqualTo(id);
        List<TProductMedia> mediaList = productMediaMapper.selectByExample(example1);
        for (TProductMedia media : mediaList) {
            product.getImages().add(media.getResource());
        }
        model.addAttribute("product",product);
        //商品扩展信息
        TProductExtExample example2 = new TProductExtExample();
        example2.createCriteria().andProductIdEqualTo(id);
        List<TProductExt> extList = productExtMapper.selectByExampleWithBLOBs(example2);
        if(extList!=null&&extList.size()>0){
            TProductExt productExt = extList.get(0);
            model.addAttribute("productExt",productExt);
        }
    }
}
