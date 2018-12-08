package com.yaorange.mapper;

import com.yaorange.pojo.TPayAccount;
import com.yaorange.pojo.TPayAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPayAccountMapper {
    int countByExample(TPayAccountExample example);

    int deleteByExample(TPayAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPayAccount record);

    int insertSelective(TPayAccount record);

    List<TPayAccount> selectByExample(TPayAccountExample example);

    TPayAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPayAccount record, @Param("example") TPayAccountExample example);

    int updateByExample(@Param("record") TPayAccount record, @Param("example") TPayAccountExample example);

    int updateByPrimaryKeySelective(TPayAccount record);

    int updateByPrimaryKey(TPayAccount record);
}