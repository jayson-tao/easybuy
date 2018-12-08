package com.yaorange.mapper;

import com.yaorange.pojo.TOrderDetail;
import com.yaorange.pojo.TOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderDetailMapper {
    int countByExample(TOrderDetailExample example);

    int deleteByExample(TOrderDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderDetail record);

    int insertSelective(TOrderDetail record);

    List<TOrderDetail> selectByExample(TOrderDetailExample example);

    TOrderDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderDetail record, @Param("example") TOrderDetailExample example);

    int updateByExample(@Param("record") TOrderDetail record, @Param("example") TOrderDetailExample example);

    int updateByPrimaryKeySelective(TOrderDetail record);

    int updateByPrimaryKey(TOrderDetail record);
}