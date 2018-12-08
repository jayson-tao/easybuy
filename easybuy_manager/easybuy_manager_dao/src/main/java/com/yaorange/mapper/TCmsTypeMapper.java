package com.yaorange.mapper;

import com.yaorange.pojo.TCmsType;
import com.yaorange.pojo.TCmsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCmsTypeMapper {
    int countByExample(TCmsTypeExample example);

    int deleteByExample(TCmsTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TCmsType record);

    int insertSelective(TCmsType record);

    List<TCmsType> selectByExample(TCmsTypeExample example);

    TCmsType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TCmsType record, @Param("example") TCmsTypeExample example);

    int updateByExample(@Param("record") TCmsType record, @Param("example") TCmsTypeExample example);

    int updateByPrimaryKeySelective(TCmsType record);

    int updateByPrimaryKey(TCmsType record);
}