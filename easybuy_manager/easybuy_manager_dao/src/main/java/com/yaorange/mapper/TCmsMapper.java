package com.yaorange.mapper;

import com.yaorange.pojo.TCms;
import com.yaorange.pojo.TCmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCmsMapper {
    int countByExample(TCmsExample example);

    int deleteByExample(TCmsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TCms record);

    int insertSelective(TCms record);

    List<TCms> selectByExampleWithBLOBs(TCmsExample example);

    List<TCms> selectByExample(TCmsExample example);

    TCms selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TCms record, @Param("example") TCmsExample example);

    int updateByExampleWithBLOBs(@Param("record") TCms record, @Param("example") TCmsExample example);

    int updateByExample(@Param("record") TCms record, @Param("example") TCmsExample example);

    int updateByPrimaryKeySelective(TCms record);

    int updateByPrimaryKeyWithBLOBs(TCms record);

    int updateByPrimaryKey(TCms record);
}