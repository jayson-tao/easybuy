package com.yaorange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.mapper.*;
import com.yaorange.pojo.*;
import com.yaorange.service.EsService;
import com.yaorange.util.CodeGenerateUtils;
import com.yaorange.util.Page;
import com.yaorange.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaorange.service.ProductService;

import java.io.IOException;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private TProductMapper productMapper;
    @Autowired
    private TProductExtMapper productExtMapper;
    @Autowired
    private TProductMediaMapper productMediaMapper;
    @Autowired
    private TProductPropertyMapper productPropertyMapper;
    @Autowired
    private TProductTypeMapper productTypeMapper;
    @Autowired
    private TBrandMapper brandMapper;
    @Autowired
    private EsService esService;

    @Override
    public TProduct queryProductId(long id) {
        TProduct product = productMapper.selectByPrimaryKey(id);
        return product;
    }


    @Override
    public TProductExt findProductExtById(Long id) {
        TProductExtExample example = new TProductExtExample();
        example.createCriteria().andProductIdEqualTo(id);
        List<TProductExt> list = productExtMapper.selectByExample(example);
        return list.get(0);
    }

    /**
     * 保存商品
     *
     * @param tProduct
     * @param resources
     * @param propertyKeyIds
     */
    @Override
    public void save(TProduct tProduct, String[] resources, Long[] propertyKeyIds) {
        //保存商品基本信息
        tProduct.setCode(CodeGenerateUtils.generateProductCode());
        tProduct.setMaxPrice(100 * 100);
        tProduct.setMinPrice(79 * 100);
        tProduct.setState((byte) 0);
        tProduct.setCreateTime(System.currentTimeMillis());
        tProduct.setUpdateTime(System.currentTimeMillis());
        productMapper.insert(tProduct);
        //保存商品扩展信息
        TProductExt productExt = new TProductExt();
        productExt.setCreateTime(System.currentTimeMillis());
        productExt.setProductId(tProduct.getId());
        productExt.setDescription(tProduct.getProductExt().getDescription());
        productExt.setRichContent(tProduct.getProductExt().getRichContent());
        productExtMapper.insert(productExt);
        //保存图片信息
        if (resources != null && resources.length > 0) {
            List<TProductMedia> medias = new ArrayList<>();
            for (String resource : resources) {
                TProductMedia media = new TProductMedia();
                media.setProductId(tProduct.getId());
                media.setResource(resource);
                media.setCreateTime(System.currentTimeMillis());
                media.setUpdateTime(System.currentTimeMillis());
                medias.add(media);
            }
            productMediaMapper.insertMediaBatch(medias);
        }
        if (propertyKeyIds != null && propertyKeyIds.length > 0) {
            //保存商品属性
            List<TProductProperty> properties = new ArrayList<>();
            for (Long id : propertyKeyIds) {
                TProductProperty property = new TProductProperty();
                property.setCreateTime(System.currentTimeMillis());
                property.setProductId(tProduct.getId());
                property.setPropertyKeyId(id);
                properties.add(property);
            }
            productPropertyMapper.insertPropertyBatch(properties);
        }
        //模拟异常
       // int i = 1 / 0;

    }

    /**
     * 商品分页
     *
     * @param page 页号
     * @param rows 每页的大小
     * @return
     */
    @Override
    public Page<TProduct> findByPage(Integer page, Integer rows) {
        TProductExample example = new TProductExample();
        example.setOrderByClause("update_time desc");
        //使用pagehelper插件进行分页  age --当前页 rows --每页的大小
        PageHelper.startPage(page, rows);
        List<TProduct> productList = productMapper.selectByExample(example);
        //封装page对象
        Page<TProduct> pageBean = new Page<>();
        //使用pageInfo得到其他信息
        PageInfo<TProduct> pageInfo = new PageInfo<>(productList);
        pageBean.setRows(productList);
        pageBean.setTotal((int) pageInfo.getTotal());
        pageBean.setPageSize(rows);
        pageBean.setCurPage(page);
        return pageBean;
    }

    /**
     * 批量商品上架或下架
     * 1.修改商品状态  1-上架 0-下架
     * 2.封装数据为es需要的数据
     */
    @Override
    public Boolean updateProductState(String ids, Byte onSale) {
        Boolean success = false;
        Long[] productIds = StrUtils.splitToLong(ids);
        List<Long> list = Arrays.asList(productIds);
        //查询商品信息
        List<TProduct> productList = productMapper.selectByPrimaryKeyBatch(list);
        List<Long> updateIds = new ArrayList<>();
        List<TProduct> updateList = new ArrayList<>();
        Long time = System.currentTimeMillis();
        //修改商品状态
        if (onSale == 1) {
            //上架
            for (TProduct product : productList) {
                //如果传了已经上架了的id过来就不修改
                if (product.getState() == 0) {
                    //上架
                    updateIds.add(product.getId());
                    updateList.add(product);
                    product.setState((byte) 1);
                    product.setOnSaleTime(time);
                }
            }
            //修改商品状态
            productMapper.updateStateByIds(updateIds, onSale, time, null);
            //把商品更新到es或者从es移出
            List<Map<String, Object>> esData = buildEsData(updateList);
            try {
                esService.saveDataToEsBulk(esData);
                success = true;
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (onSale == 0) {
            //下架
            for (TProduct product : productList) {
                if (product.getState() == 1) {
                    updateIds.add(product.getId());
                    product.setState((byte) 0);
                    product.setOnSaleTime(time);
                }
            }
            productMapper.updateStateByIds(updateIds, onSale, null, time);
            //把数据从es删除
            esService.deleteFromEsBulk(updateIds);
            success = true;
        }
        return success;
    }

    public List<Map<String, Object>> buildEsData(List<TProduct> updateList) {
        List<Map<String, Object>> esList = new ArrayList<>(0);
        //查询商品类型
        //获取productTypeid
        List<Long> productTypeIds = new ArrayList<>();
        List<Long> productIds = new ArrayList<>();
        List<Long> brandIds = new ArrayList<>();
        for (TProduct product : updateList) {
            productIds.add(product.getId());
            productTypeIds.add(product.getProductType());
            brandIds.add(product.getBrandId());
        }
        //分别查询
        List<TProductType> typeList = productTypeMapper.selectByPrimaryKeyBatch(productTypeIds);
        //品牌信息
        List<TBrand> brandList = brandMapper.selectByPrimaryKeyBatch(brandIds);
        TProductExtExample example = new TProductExtExample();
        example.createCriteria().andProductIdIn(productIds);
        //扩展信息
        List<TProductExt> extList = productExtMapper.selectByExample(example);
        TProductMediaExample mediaExample = new TProductMediaExample();
        mediaExample.createCriteria().andProductIdIn(productIds);
        //媒体
        List<TProductMedia> mediaList = productMediaMapper.selectByExample(mediaExample);
        HashMap<Long, List<TProductMedia>> mediaMap = convertMediaByProductIds(mediaList, productIds);
        //封装es需要的数据
        for (int i = 0; i < updateList.size(); i++) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("id", updateList.get(i).getId());
            dataMap.put("name", updateList.get(i).getName());
            dataMap.put("subName", updateList.get(i).getSubName());
            dataMap.put("code", updateList.get(i).getCode());
            dataMap.put("onSaleTime", updateList.get(i).getOnSaleTime());
            dataMap.put("offSaleTime", updateList.get(i).getOffSaleTime());
            dataMap.put("brandId", updateList.get(i).getBrandId());
            dataMap.put("state", updateList.get(i).getState());
            dataMap.put("maxPrice", updateList.get(i).getMaxPrice());
            dataMap.put("minPrice", updateList.get(i).getMinPrice());
            dataMap.put("viewProperties", updateList.get(i).getViewProperties());
            dataMap.put("commentCount", updateList.get(i).getCommentCount());
            dataMap.put("saleCount", updateList.get(i).getSaleCount());
            dataMap.put("viewCount", updateList.get(i).getViewCount());
            // 拼接商品类型的信息
            for (TProductType productType : typeList) {
                if (productType.getId() == updateList.get(i).getProductType()) {
                    if (productType != null) {
                        // .266.267.270.
                        String path = productType.getPath();
                        path = path.substring(1, path.length() - 1);
                        Long[] parentsPath = StrUtils.splitToLong(path, "\\.");
                        dataMap.put("productType", parentsPath);
                        dataMap.put("productTypeName", productType.getName());
                    }
                }
            }
            //品牌信息
            for (TBrand brand : brandList) {
                if (brand.getId() == updateList.get(i).getBrandId()) {
                    dataMap.put("brandName", brand.getName());
                }
            }
            // 商品媒体信息的拼接
            List<TProductMedia> medias = mediaMap.get(updateList.get(i).getId());
            if (medias != null && medias.size() > 0) {
                ArrayList<String> images = new ArrayList<>();
                for (TProductMedia media : medias) {
                    String resource = media.getResource();
                    images.add(resource);
                }
                dataMap.put("images", images);
            }
            //简介
            TProductExt productExt = extList.get(i);
            String description = productExt.getDescription();
            dataMap.put("description", description);
            esList.add(dataMap);
        }
        return esList;
    }

    public HashMap<Long, List<TProductMedia>> convertMediaByProductIds(List<TProductMedia> mediaList, List<Long> productIds) {
        HashMap<Long, List<TProductMedia>> hashMap = new HashMap<>();
        for (int i = 0; i < productIds.size(); i++) {
            List<TProductMedia> list = new ArrayList<>(0);
            for (TProductMedia media : mediaList) {
                if (media.getProductId() == productIds.get(i)) {
                    list.add(media);
                }
            }
            hashMap.put(productIds.get(i), list);
        }
        return hashMap;
    }

}
