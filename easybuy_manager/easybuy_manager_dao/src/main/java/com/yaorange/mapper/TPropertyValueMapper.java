package com.yaorange.mapper;

import com.yaorange.pojo.TPropertyValue;
import com.yaorange.pojo.TPropertyValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPropertyValueMapper {
    int countByExample(TPropertyValueExample example);

    int deleteByExample(TPropertyValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPropertyValue record);

    int insertSelective(TPropertyValue record);

    List<TPropertyValue> selectByExample(TPropertyValueExample example);

    TPropertyValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPropertyValue record, @Param("example") TPropertyValueExample example);

    int updateByExample(@Param("record") TPropertyValue record, @Param("example") TPropertyValueExample example);

    int updateByPrimaryKeySelective(TPropertyValue record);

    int updateByPrimaryKey(TPropertyValue record);
}