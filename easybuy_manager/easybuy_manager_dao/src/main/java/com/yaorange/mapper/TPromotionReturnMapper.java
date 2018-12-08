package com.yaorange.mapper;

import com.yaorange.pojo.TPromotionReturn;
import com.yaorange.pojo.TPromotionReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPromotionReturnMapper {
    int countByExample(TPromotionReturnExample example);

    int deleteByExample(TPromotionReturnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPromotionReturn record);

    int insertSelective(TPromotionReturn record);

    List<TPromotionReturn> selectByExample(TPromotionReturnExample example);

    TPromotionReturn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPromotionReturn record, @Param("example") TPromotionReturnExample example);

    int updateByExample(@Param("record") TPromotionReturn record, @Param("example") TPromotionReturnExample example);

    int updateByPrimaryKeySelective(TPromotionReturn record);

    int updateByPrimaryKey(TPromotionReturn record);
}