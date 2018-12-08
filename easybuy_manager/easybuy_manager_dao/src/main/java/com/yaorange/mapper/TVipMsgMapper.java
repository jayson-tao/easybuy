package com.yaorange.mapper;

import com.yaorange.pojo.TVipMsg;
import com.yaorange.pojo.TVipMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipMsgMapper {
    int countByExample(TVipMsgExample example);

    int deleteByExample(TVipMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipMsg record);

    int insertSelective(TVipMsg record);

    List<TVipMsg> selectByExample(TVipMsgExample example);

    TVipMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipMsg record, @Param("example") TVipMsgExample example);

    int updateByExample(@Param("record") TVipMsg record, @Param("example") TVipMsgExample example);

    int updateByPrimaryKeySelective(TVipMsg record);

    int updateByPrimaryKey(TVipMsg record);
}