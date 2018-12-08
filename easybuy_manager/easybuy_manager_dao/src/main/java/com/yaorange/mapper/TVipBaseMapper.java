package com.yaorange.mapper;

import com.yaorange.pojo.TVipBase;
import com.yaorange.pojo.TVipBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipBaseMapper {
    int countByExample(TVipBaseExample example);

    int deleteByExample(TVipBaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipBase record);

    int insertSelective(TVipBase record);

    List<TVipBase> selectByExample(TVipBaseExample example);

    TVipBase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipBase record, @Param("example") TVipBaseExample example);

    int updateByExample(@Param("record") TVipBase record, @Param("example") TVipBaseExample example);

    int updateByPrimaryKeySelective(TVipBase record);

    int updateByPrimaryKey(TVipBase record);
}