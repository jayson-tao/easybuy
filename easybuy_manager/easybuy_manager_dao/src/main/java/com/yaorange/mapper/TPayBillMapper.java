package com.yaorange.mapper;

import com.yaorange.pojo.TPayBill;
import com.yaorange.pojo.TPayBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPayBillMapper {
    int countByExample(TPayBillExample example);

    int deleteByExample(TPayBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPayBill record);

    int insertSelective(TPayBill record);

    List<TPayBill> selectByExample(TPayBillExample example);

    TPayBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPayBill record, @Param("example") TPayBillExample example);

    int updateByExample(@Param("record") TPayBill record, @Param("example") TPayBillExample example);

    int updateByPrimaryKeySelective(TPayBill record);

    int updateByPrimaryKey(TPayBill record);
}