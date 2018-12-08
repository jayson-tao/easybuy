package com.yaorange.mapper;

import com.yaorange.pojo.TPayCredit;
import com.yaorange.pojo.TPayCreditExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPayCreditMapper {
    int countByExample(TPayCreditExample example);

    int deleteByExample(TPayCreditExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPayCredit record);

    int insertSelective(TPayCredit record);

    List<TPayCredit> selectByExample(TPayCreditExample example);

    TPayCredit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPayCredit record, @Param("example") TPayCreditExample example);

    int updateByExample(@Param("record") TPayCredit record, @Param("example") TPayCreditExample example);

    int updateByPrimaryKeySelective(TPayCredit record);

    int updateByPrimaryKey(TPayCredit record);
}