package com.yaorange.mapper;

import com.yaorange.pojo.TSeckillSku;
import com.yaorange.pojo.TSeckillSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSeckillSkuMapper {
    int countByExample(TSeckillSkuExample example);

    int deleteByExample(TSeckillSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSeckillSku record);

    int insertSelective(TSeckillSku record);

    List<TSeckillSku> selectByExample(TSeckillSkuExample example);

    TSeckillSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSeckillSku record, @Param("example") TSeckillSkuExample example);

    int updateByExample(@Param("record") TSeckillSku record, @Param("example") TSeckillSkuExample example);

    int updateByPrimaryKeySelective(TSeckillSku record);

    int updateByPrimaryKey(TSeckillSku record);
}