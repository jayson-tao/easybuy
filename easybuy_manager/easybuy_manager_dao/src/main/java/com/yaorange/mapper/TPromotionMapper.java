package com.yaorange.mapper;

import com.yaorange.pojo.TPromotion;
import com.yaorange.pojo.TPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPromotionMapper {
    int countByExample(TPromotionExample example);

    int deleteByExample(TPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPromotion record);

    int insertSelective(TPromotion record);

    List<TPromotion> selectByExample(TPromotionExample example);

    TPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPromotion record, @Param("example") TPromotionExample example);

    int updateByExample(@Param("record") TPromotion record, @Param("example") TPromotionExample example);

    int updateByPrimaryKeySelective(TPromotion record);

    int updateByPrimaryKey(TPromotion record);
}