package com.yaorange.mapper;

import com.yaorange.pojo.TProductProperty;
import com.yaorange.pojo.TProductPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductPropertyMapper {
    int countByExample(TProductPropertyExample example);

    int deleteByExample(TProductPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProductProperty record);

    int insertSelective(TProductProperty record);
    int insertPropertyBatch(List<TProductProperty> list);

    List<TProductProperty> selectByExample(TProductPropertyExample example);

    TProductProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProductProperty record, @Param("example") TProductPropertyExample example);

    int updateByExample(@Param("record") TProductProperty record, @Param("example") TProductPropertyExample example);

    int updateByPrimaryKeySelective(TProductProperty record);

    int updateByPrimaryKey(TProductProperty record);
}
