package com.yaorange.mapper;

import com.yaorange.pojo.TArea;
import com.yaorange.pojo.TAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAreaMapper {
    int countByExample(TAreaExample example);

    int deleteByExample(TAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TArea record);

    int insertSelective(TArea record);

    List<TArea> selectByExample(TAreaExample example);

    TArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TArea record, @Param("example") TAreaExample example);

    int updateByExample(@Param("record") TArea record, @Param("example") TAreaExample example);

    int updateByPrimaryKeySelective(TArea record);

    int updateByPrimaryKey(TArea record);
}