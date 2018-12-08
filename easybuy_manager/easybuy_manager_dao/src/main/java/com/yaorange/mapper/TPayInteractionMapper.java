package com.yaorange.mapper;

import com.yaorange.pojo.TPayInteraction;
import com.yaorange.pojo.TPayInteractionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPayInteractionMapper {
    int countByExample(TPayInteractionExample example);

    int deleteByExample(TPayInteractionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPayInteraction record);

    int insertSelective(TPayInteraction record);

    List<TPayInteraction> selectByExample(TPayInteractionExample example);

    TPayInteraction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPayInteraction record, @Param("example") TPayInteractionExample example);

    int updateByExample(@Param("record") TPayInteraction record, @Param("example") TPayInteractionExample example);

    int updateByPrimaryKeySelective(TPayInteraction record);

    int updateByPrimaryKey(TPayInteraction record);
}