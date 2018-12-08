package com.yaorange.mapper;

import com.yaorange.pojo.TVipBill;
import com.yaorange.pojo.TVipBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipBillMapper {
    int countByExample(TVipBillExample example);

    int deleteByExample(TVipBillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipBill record);

    int insertSelective(TVipBill record);

    List<TVipBill> selectByExample(TVipBillExample example);

    TVipBill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipBill record, @Param("example") TVipBillExample example);

    int updateByExample(@Param("record") TVipBill record, @Param("example") TVipBillExample example);

    int updateByPrimaryKeySelective(TVipBill record);

    int updateByPrimaryKey(TVipBill record);
}