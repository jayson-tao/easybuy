package com.yaorange.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yaorange.mapper.TBrandMapper;
import com.yaorange.pojo.TBrand;
import com.yaorange.pojo.TBrandExample;
import com.yaorange.service.BrandService;
import com.yaorange.util.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TBrandMapper brandMapper;


    /**
     * 分页
     *
     * @param page 页号
     * @param rows 每页的大小
     * @return
     */
    @Override
    public Page<TBrand> findByPage(Integer page, Integer rows) {
        TBrandExample example = new TBrandExample();
        example.setOrderByClause("update_time desc");
        //使用pagehelper插件进行分页  age --当前页 rows --每页的大小
        PageHelper.startPage(page, rows);
        List<TBrand> brandList = brandMapper.selectByExample(example);
        Page<TBrand> pageBean = new Page<>();
        //使用pageInfo得到其他信息
        PageInfo<TBrand> pageInfo = new PageInfo<>(brandList);
        pageBean.setRows(brandList);
        pageBean.setTotal((int) pageInfo.getTotal());
        pageBean.setPageSize(rows);
        pageBean.setCurPage(page);
        return pageBean;
    }

    @Override
    public void save(TBrand brand) {
        brand.setCreateTime(System.currentTimeMillis());
        brand.setUpdateTime(System.currentTimeMillis());
        brand.setFirstLetter(brand.getEnglishName().charAt(0)+"");
        brandMapper.insert(brand);
    }

    @Override
    public void update(TBrand brand) {
        brand.setUpdateTime(System.currentTimeMillis());
        TBrandExample example = new TBrandExample();
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public TBrand findById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 品牌根据英文名模糊查询
     *
     * @param q1
     */
    @Override
    public List<TBrand> findByKeyword(String q1) {
        String q = "%" + q1 + "%";
        TBrandExample example = new TBrandExample();
        //如果传了关键字
        if (q1 != null && StringUtils.isNotEmpty(q1)) {
            TBrandExample.Criteria criteria = example.createCriteria();
            criteria.andEnglishNameLike(q);
            TBrandExample.Criteria or = example.or();
            or.andNameLike(q);
        }
        return brandMapper.selectByExample(example);
    }



}
