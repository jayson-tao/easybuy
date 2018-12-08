package com.yaorange.mapper;

import com.yaorange.pojo.TBrand;
import com.yaorange.pojo.TBrandExample;
import java.util.List;

import com.yaorange.pojo.TProductType;
import org.apache.ibatis.annotations.Param;

public interface TBrandMapper {
    int countByExample(TBrandExample example);

    int deleteByExample(TBrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TBrand record);

    int insertSelective(TBrand record);

    List<TBrand> selectByExample(TBrandExample example);

    TBrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TBrand record, @Param("example") TBrandExample example);

    int updateByExample(@Param("record") TBrand record, @Param("example") TBrandExample example);

    int updateByPrimaryKeySelective(TBrand record);

    int updateByPrimaryKey(TBrand record);
    //批量查询
    List<TBrand> selectByPrimaryKeyBatch(List<Long> brandIds);
}
