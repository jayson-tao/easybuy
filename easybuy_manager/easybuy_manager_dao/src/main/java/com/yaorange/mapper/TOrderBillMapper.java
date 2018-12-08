package com.yaorange.mapper;

import com.yaorange.pojo.TOrderBill;
import com.yaorange.pojo.TOrderBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderBillMapper {
    int countByExample(TOrderBillExample example);

    int deleteByExample(TOrderBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderBill record);

    int insertSelective(TOrderBill record);

    List<TOrderBill> selectByExample(TOrderBillExample example);

    TOrderBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderBill record, @Param("example") TOrderBillExample example);

    int updateByExample(@Param("record") TOrderBill record, @Param("example") TOrderBillExample example);

    int updateByPrimaryKeySelective(TOrderBill record);

    int updateByPrimaryKey(TOrderBill record);
}