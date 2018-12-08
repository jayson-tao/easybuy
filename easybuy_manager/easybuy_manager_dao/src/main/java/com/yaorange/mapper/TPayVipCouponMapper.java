package com.yaorange.mapper;

import com.yaorange.pojo.TPayVipCoupon;
import com.yaorange.pojo.TPayVipCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPayVipCouponMapper {
    int countByExample(TPayVipCouponExample example);

    int deleteByExample(TPayVipCouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TPayVipCoupon record);

    int insertSelective(TPayVipCoupon record);

    List<TPayVipCoupon> selectByExample(TPayVipCouponExample example);

    TPayVipCoupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TPayVipCoupon record, @Param("example") TPayVipCouponExample example);

    int updateByExample(@Param("record") TPayVipCoupon record, @Param("example") TPayVipCouponExample example);

    int updateByPrimaryKeySelective(TPayVipCoupon record);

    int updateByPrimaryKey(TPayVipCoupon record);
}