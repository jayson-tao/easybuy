package com.yaorange.mapper;

import com.yaorange.pojo.TPayAccountFlow;
import com.yaorange.pojo.TPayAccountFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPayAccountFlowMapper {
    int countByExample(TPayAccountFlowExample example);

    int deleteByExample(TPayAccountFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPayAccountFlow record);

    int insertSelective(TPayAccountFlow record);

    List<TPayAccountFlow> selectByExample(TPayAccountFlowExample example);

    TPayAccountFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPayAccountFlow record, @Param("example") TPayAccountFlowExample example);

    int updateByExample(@Param("record") TPayAccountFlow record, @Param("example") TPayAccountFlowExample example);

    int updateByPrimaryKeySelective(TPayAccountFlow record);

    int updateByPrimaryKey(TPayAccountFlow record);
}