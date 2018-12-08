package com.yaorange.mapper;

import com.yaorange.pojo.TProductProperty;
import com.yaorange.pojo.TProductType;
import com.yaorange.pojo.TProductTypeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TProductTypeMapper {
    int countByExample(TProductTypeExample example);

    int deleteByExample(TProductTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProductType record);

    int insertSelective(TProductType record);

    List<TProductType> selectByExample(TProductTypeExample example);

    TProductType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProductType record, @Param("example") TProductTypeExample example);

    int updateByExample(@Param("record") TProductType record, @Param("example") TProductTypeExample example);

    int updateByPrimaryKeySelective(TProductType record);

    int updateByPrimaryKey(TProductType record);
    //批量查询
    List<TProductType> selectByPrimaryKeyBatch(List<Long> productTypeIds);
}
