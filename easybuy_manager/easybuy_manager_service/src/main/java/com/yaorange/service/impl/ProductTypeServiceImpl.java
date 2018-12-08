package com.yaorange.service.impl;

import com.yaorange.pojo.*;
import com.yaorange.mapper.TProductTypeMapper;
import com.yaorange.service.ProductTypeService;
import com.yaorange.util.Page;
import com.yaorange.util.VelocityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private TProductTypeMapper productTypeMapper;
    //获取配置模板的路径信息
    @Value("${STATIC_ROOT_DIR}")
    private String STATIC_ROOT_DIR;
    @Value("${STATIC_PRODUCT_TYPE_TEMPLATE}")
    private String STATIC_PRODUCT_TYPE_TEMPLATE;
    @Value("${STATIC_HOME_TEMPLATE}")
    private String STATIC_HOME_TEMPLATE;

    /**
     * 添加条目信息
     *
     * @param productType 条目
     */
    @Override
    public void save(TProductType productType) {
        productType.setCreateTime(System.currentTimeMillis());
        //添加条目
        productTypeMapper.insert(productType);
        //获取条目id  SELECT LAST_INSERT_ID()
        //获取pid条目的path
        TProductType ParentProductType = productTypeMapper.selectByPrimaryKey(productType.getPid());
        //修改path = path+id+.
        String path = ParentProductType.getPath() + productType.getId() + ".";
        productType.setPath(path);
        //更新条目
        productType.setUpdateTime(System.currentTimeMillis());
        productTypeMapper.updateByPrimaryKeySelective(productType);
        // 页面静态化
        List<TProductType> oringalData = getAllOringal();
        // 相当于freemarker
        VelocityUtils.staticByTemplate(oringalData, STATIC_ROOT_DIR+STATIC_PRODUCT_TYPE_TEMPLATE, STATIC_ROOT_DIR+STATIC_PRODUCT_TYPE_TEMPLATE+".html");
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("staticRoot", STATIC_ROOT_DIR);
        VelocityUtils.staticByTemplate(hashMap, STATIC_ROOT_DIR+STATIC_HOME_TEMPLATE, STATIC_ROOT_DIR+STATIC_HOME_TEMPLATE+"home.html");
    }

    /**
     * 返回所有商品条目
     *
     * @return
     */
    @Override
    public List<EUTreeNode> getAllProductType() {
        return getAll();
    }

    /**
     * 封装所有的条目信息为eutree需要的格式
     *
     * @return
     */
    public List<EUTreeNode> getAll() {
        List<EUTreeNode> nodes = new ArrayList<>(0);
        //查找出所有商品条目信息
        TProductTypeExample example = new TProductTypeExample();
        List<TProductType> productTypes = productTypeMapper.selectByExample(example);
        //把productTypes放进map中
        HashMap<Long, EUTreeNode> nodesMap = new HashMap<>();
        for (TProductType productType : productTypes) {
            EUTreeNode node = new EUTreeNode();
            node.setId(productType.getId());
            node.setPid(productType.getPid());
            node.setText(productType.getName());
            //把条目信息放进map
            nodesMap.put(productType.getId(), node);
        }
        Set<Map.Entry<Long, EUTreeNode>> entrySet = nodesMap.entrySet();
        for (Map.Entry<Long, EUTreeNode> nodeEntry : entrySet) {
            //获取节点
            EUTreeNode node = nodeEntry.getValue();
            if (node.getPid() == 0L) {
                //如果节点的父节点为0表示是根节点
                nodes.add(node);
            } else {
                //如果不为0 表示不是根节点 获取该父节点
                EUTreeNode currParentNode = nodesMap.get(node.getPid());
                List<EUTreeNode> childrenList = currParentNode.getChildren();
                childrenList.add(node);
                currParentNode.setChildren(childrenList);
            }
        }
        return nodes;
    }

    /**
     * 获取所有的条目信息（元数据）
     */
    public List<TProductType> getAllOringal() {
        ArrayList<TProductType> nodes = new ArrayList<>();
        TProductTypeExample example = new TProductTypeExample();
        List<TProductType> productTypes = productTypeMapper.selectByExample(example);
        HashMap<Long, TProductType> map = new HashMap<>();
        for (TProductType productType : productTypes) {
            //把条目放进map中便于进行分类处理
            map.put(productType.getId(), productType);
        }
        Set<Map.Entry<Long, TProductType>> entrySet = map.entrySet();
        for (Map.Entry<Long, TProductType> entry : entrySet) {
            TProductType node = entry.getValue();
            if (node.getPid() == 0L) {
                nodes.add(node);
            }else {
                TProductType tProductType = map.get(node.getPid());
                List<TProductType> children = tProductType.getChildren();
                children.add(node);
            }
        }
        return nodes;
    }
}
