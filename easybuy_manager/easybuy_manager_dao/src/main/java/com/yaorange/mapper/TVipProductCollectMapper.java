package com.yaorange.mapper;

import com.yaorange.pojo.TVipProductCollect;
import com.yaorange.pojo.TVipProductCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipProductCollectMapper {
    int countByExample(TVipProductCollectExample example);

    int deleteByExample(TVipProductCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipProductCollect record);

    int insertSelective(TVipProductCollect record);

    List<TVipProductCollect> selectByExample(TVipProductCollectExample example);

    TVipProductCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipProductCollect record, @Param("example") TVipProductCollectExample example);

    int updateByExample(@Param("record") TVipProductCollect record, @Param("example") TVipProductCollectExample example);

    int updateByPrimaryKeySelective(TVipProductCollect record);

    int updateByPrimaryKey(TVipProductCollect record);
}