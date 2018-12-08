package com.yaorange.mapper;

import com.yaorange.pojo.TPromotionScopeValue;
import com.yaorange.pojo.TPromotionScopeValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPromotionScopeValueMapper {
    int countByExample(TPromotionScopeValueExample example);

    int deleteByExample(TPromotionScopeValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPromotionScopeValue record);

    int insertSelective(TPromotionScopeValue record);

    List<TPromotionScopeValue> selectByExample(TPromotionScopeValueExample example);

    TPromotionScopeValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPromotionScopeValue record, @Param("example") TPromotionScopeValueExample example);

    int updateByExample(@Param("record") TPromotionScopeValue record, @Param("example") TPromotionScopeValueExample example);

    int updateByPrimaryKeySelective(TPromotionScopeValue record);

    int updateByPrimaryKey(TPromotionScopeValue record);
}