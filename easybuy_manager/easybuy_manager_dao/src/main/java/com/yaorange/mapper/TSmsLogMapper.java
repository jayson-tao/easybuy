package com.yaorange.mapper;

import com.yaorange.pojo.TSmsLog;
import com.yaorange.pojo.TSmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSmsLogMapper {
    int countByExample(TSmsLogExample example);

    int deleteByExample(TSmsLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSmsLog record);

    int insertSelective(TSmsLog record);

    List<TSmsLog> selectByExample(TSmsLogExample example);

    TSmsLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSmsLog record, @Param("example") TSmsLogExample example);

    int updateByExample(@Param("record") TSmsLog record, @Param("example") TSmsLogExample example);

    int updateByPrimaryKeySelective(TSmsLog record);

    int updateByPrimaryKey(TSmsLog record);
}