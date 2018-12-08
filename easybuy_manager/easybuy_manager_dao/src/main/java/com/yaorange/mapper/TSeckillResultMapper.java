package com.yaorange.mapper;

import com.yaorange.pojo.TSeckillResult;
import com.yaorange.pojo.TSeckillResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSeckillResultMapper {
    int countByExample(TSeckillResultExample example);

    int deleteByExample(TSeckillResultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSeckillResult record);

    int insertSelective(TSeckillResult record);

    List<TSeckillResult> selectByExample(TSeckillResultExample example);

    TSeckillResult selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSeckillResult record, @Param("example") TSeckillResultExample example);

    int updateByExample(@Param("record") TSeckillResult record, @Param("example") TSeckillResultExample example);

    int updateByPrimaryKeySelective(TSeckillResult record);

    int updateByPrimaryKey(TSeckillResult record);
}