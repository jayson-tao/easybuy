package com.yaorange.mapper;

import com.yaorange.pojo.TVipRealinfo;
import com.yaorange.pojo.TVipRealinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipRealinfoMapper {
    int countByExample(TVipRealinfoExample example);

    int deleteByExample(TVipRealinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipRealinfo record);

    int insertSelective(TVipRealinfo record);

    List<TVipRealinfo> selectByExample(TVipRealinfoExample example);

    TVipRealinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipRealinfo record, @Param("example") TVipRealinfoExample example);

    int updateByExample(@Param("record") TVipRealinfo record, @Param("example") TVipRealinfoExample example);

    int updateByPrimaryKeySelective(TVipRealinfo record);

    int updateByPrimaryKey(TVipRealinfo record);
}