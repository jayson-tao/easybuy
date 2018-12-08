package com.yaorange.mapper;

import com.yaorange.pojo.TVipGrowLog;
import com.yaorange.pojo.TVipGrowLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipGrowLogMapper {
    int countByExample(TVipGrowLogExample example);

    int deleteByExample(TVipGrowLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipGrowLog record);

    int insertSelective(TVipGrowLog record);

    List<TVipGrowLog> selectByExample(TVipGrowLogExample example);

    TVipGrowLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipGrowLog record, @Param("example") TVipGrowLogExample example);

    int updateByExample(@Param("record") TVipGrowLog record, @Param("example") TVipGrowLogExample example);

    int updateByPrimaryKeySelective(TVipGrowLog record);

    int updateByPrimaryKey(TVipGrowLog record);
}