package com.yaorange.mapper;

import com.yaorange.pojo.TDictionaryValue;
import com.yaorange.pojo.TDictionaryValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDictionaryValueMapper {
    int countByExample(TDictionaryValueExample example);

    int deleteByExample(TDictionaryValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDictionaryValue record);

    int insertSelective(TDictionaryValue record);

    List<TDictionaryValue> selectByExample(TDictionaryValueExample example);

    TDictionaryValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDictionaryValue record, @Param("example") TDictionaryValueExample example);

    int updateByExample(@Param("record") TDictionaryValue record, @Param("example") TDictionaryValueExample example);

    int updateByPrimaryKeySelective(TDictionaryValue record);

    int updateByPrimaryKey(TDictionaryValue record);
}