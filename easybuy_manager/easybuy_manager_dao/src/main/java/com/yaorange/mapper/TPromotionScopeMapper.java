package com.yaorange.mapper;

import com.yaorange.pojo.TPromotionScope;
import com.yaorange.pojo.TPromotionScopeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPromotionScopeMapper {
    int countByExample(TPromotionScopeExample example);

    int deleteByExample(TPromotionScopeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPromotionScope record);

    int insertSelective(TPromotionScope record);

    List<TPromotionScope> selectByExample(TPromotionScopeExample example);

    TPromotionScope selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPromotionScope record, @Param("example") TPromotionScopeExample example);

    int updateByExample(@Param("record") TPromotionScope record, @Param("example") TPromotionScopeExample example);

    int updateByPrimaryKeySelective(TPromotionScope record);

    int updateByPrimaryKey(TPromotionScope record);
}