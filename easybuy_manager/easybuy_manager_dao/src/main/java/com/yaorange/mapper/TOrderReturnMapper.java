package com.yaorange.mapper;

import com.yaorange.pojo.TOrderReturn;
import com.yaorange.pojo.TOrderReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderReturnMapper {
    int countByExample(TOrderReturnExample example);

    int deleteByExample(TOrderReturnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderReturn record);

    int insertSelective(TOrderReturn record);

    List<TOrderReturn> selectByExample(TOrderReturnExample example);

    TOrderReturn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderReturn record, @Param("example") TOrderReturnExample example);

    int updateByExample(@Param("record") TOrderReturn record, @Param("example") TOrderReturnExample example);

    int updateByPrimaryKeySelective(TOrderReturn record);

    int updateByPrimaryKey(TOrderReturn record);
}