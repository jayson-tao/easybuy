package com.yaorange.mapper;

import com.yaorange.pojo.TSso;
import com.yaorange.pojo.TSsoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSsoMapper {
    int countByExample(TSsoExample example);

    int deleteByExample(TSsoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSso record);

    int insertSelective(TSso record);

    List<TSso> selectByExample(TSsoExample example);

    TSso selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSso record, @Param("example") TSsoExample example);

    int updateByExample(@Param("record") TSso record, @Param("example") TSsoExample example);

    int updateByPrimaryKeySelective(TSso record);

    int updateByPrimaryKey(TSso record);
}