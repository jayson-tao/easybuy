package com.yaorange.mapper;

import com.yaorange.pojo.TSkuProperty;
import com.yaorange.pojo.TSkuPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSkuPropertyMapper {
    int countByExample(TSkuPropertyExample example);

    int deleteByExample(TSkuPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSkuProperty record);

    int insertSelective(TSkuProperty record);

    List<TSkuProperty> selectByExample(TSkuPropertyExample example);

    TSkuProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSkuProperty record, @Param("example") TSkuPropertyExample example);

    int updateByExample(@Param("record") TSkuProperty record, @Param("example") TSkuPropertyExample example);

    int updateByPrimaryKeySelective(TSkuProperty record);

    int updateByPrimaryKey(TSkuProperty record);
    //批量插入
    int insertBatch(List<TSkuProperty> list);
}
