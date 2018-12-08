package com.yaorange.mapper;

import com.yaorange.pojo.TSeckill;
import com.yaorange.pojo.TSeckillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSeckillMapper {
    int countByExample(TSeckillExample example);

    int deleteByExample(TSeckillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSeckill record);

    int insertSelective(TSeckill record);

    List<TSeckill> selectByExample(TSeckillExample example);

    TSeckill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSeckill record, @Param("example") TSeckillExample example);

    int updateByExample(@Param("record") TSeckill record, @Param("example") TSeckillExample example);

    int updateByPrimaryKeySelective(TSeckill record);

    int updateByPrimaryKey(TSeckill record);
}