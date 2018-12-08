package com.yaorange.mapper;

import com.yaorange.pojo.TSmsCode;
import com.yaorange.pojo.TSmsCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSmsCodeMapper {
    int countByExample(TSmsCodeExample example);

    int deleteByExample(TSmsCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSmsCode record);

    int insertSelective(TSmsCode record);

    List<TSmsCode> selectByExample(TSmsCodeExample example);

    TSmsCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSmsCode record, @Param("example") TSmsCodeExample example);

    int updateByExample(@Param("record") TSmsCode record, @Param("example") TSmsCodeExample example);

    int updateByPrimaryKeySelective(TSmsCode record);

    int updateByPrimaryKey(TSmsCode record);
}