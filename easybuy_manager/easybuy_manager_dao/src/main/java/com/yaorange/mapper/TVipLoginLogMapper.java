package com.yaorange.mapper;

import com.yaorange.pojo.TVipLoginLog;
import com.yaorange.pojo.TVipLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipLoginLogMapper {
    int countByExample(TVipLoginLogExample example);

    int deleteByExample(TVipLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipLoginLog record);

    int insertSelective(TVipLoginLog record);

    List<TVipLoginLog> selectByExample(TVipLoginLogExample example);

    TVipLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipLoginLog record, @Param("example") TVipLoginLogExample example);

    int updateByExample(@Param("record") TVipLoginLog record, @Param("example") TVipLoginLogExample example);

    int updateByPrimaryKeySelective(TVipLoginLog record);

    int updateByPrimaryKey(TVipLoginLog record);
}