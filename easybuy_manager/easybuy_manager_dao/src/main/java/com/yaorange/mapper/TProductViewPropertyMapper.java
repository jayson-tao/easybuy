package com.yaorange.mapper;

import com.yaorange.pojo.TProductViewProperty;
import com.yaorange.pojo.TProductViewPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductViewPropertyMapper {
    int countByExample(TProductViewPropertyExample example);

    int deleteByExample(TProductViewPropertyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProductViewProperty record);

    int insertSelective(TProductViewProperty record);

    List<TProductViewProperty> selectByExample(TProductViewPropertyExample example);

    TProductViewProperty selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProductViewProperty record, @Param("example") TProductViewPropertyExample example);

    int updateByExample(@Param("record") TProductViewProperty record, @Param("example") TProductViewPropertyExample example);

    int updateByPrimaryKeySelective(TProductViewProperty record);

    int updateByPrimaryKey(TProductViewProperty record);
}