package com.yaorange.mapper;

import com.yaorange.pojo.TPayRecharge;
import com.yaorange.pojo.TPayRechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPayRechargeMapper {
    int countByExample(TPayRechargeExample example);

    int deleteByExample(TPayRechargeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPayRecharge record);

    int insertSelective(TPayRecharge record);

    List<TPayRecharge> selectByExample(TPayRechargeExample example);

    TPayRecharge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPayRecharge record, @Param("example") TPayRechargeExample example);

    int updateByExample(@Param("record") TPayRecharge record, @Param("example") TPayRechargeExample example);

    int updateByPrimaryKeySelective(TPayRecharge record);

    int updateByPrimaryKey(TPayRecharge record);
}