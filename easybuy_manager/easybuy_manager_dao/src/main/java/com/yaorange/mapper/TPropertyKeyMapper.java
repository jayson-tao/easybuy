package com.yaorange.mapper;

import com.yaorange.pojo.TPropertyKey;
import com.yaorange.pojo.TPropertyKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPropertyKeyMapper {
    List<TPropertyKey> findPropertyKeys(@Param("productId") Long productId,@Param("type") Byte type);
    int countByExample(TPropertyKeyExample example);

    int deleteByExample(TPropertyKeyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPropertyKey record);

    int insertSelective(TPropertyKey record);

    List<TPropertyKey> selectByExample(TPropertyKeyExample example);

    TPropertyKey selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPropertyKey record, @Param("example") TPropertyKeyExample example);

    int updateByExample(@Param("record") TPropertyKey record, @Param("example") TPropertyKeyExample example);

    int updateByPrimaryKeySelective(TPropertyKey record);

    int updateByPrimaryKey(TPropertyKey record);

}
