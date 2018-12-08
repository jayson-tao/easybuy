package com.yaorange.mapper;

import com.yaorange.pojo.TCoupon;
import com.yaorange.pojo.TCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponMapper {
    int countByExample(TCouponExample example);

    int deleteByExample(TCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TCoupon record);

    int insertSelective(TCoupon record);

    List<TCoupon> selectByExample(TCouponExample example);

    TCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TCoupon record, @Param("example") TCouponExample example);

    int updateByExample(@Param("record") TCoupon record, @Param("example") TCouponExample example);

    int updateByPrimaryKeySelective(TCoupon record);

    int updateByPrimaryKey(TCoupon record);
}