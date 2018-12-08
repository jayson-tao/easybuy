package com.yaorange.mapper;

import com.yaorange.pojo.TCouponInfo;
import com.yaorange.pojo.TCouponInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponInfoMapper {
    int countByExample(TCouponInfoExample example);

    int deleteByExample(TCouponInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TCouponInfo record);

    int insertSelective(TCouponInfo record);

    List<TCouponInfo> selectByExample(TCouponInfoExample example);

    TCouponInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TCouponInfo record, @Param("example") TCouponInfoExample example);

    int updateByExample(@Param("record") TCouponInfo record, @Param("example") TCouponInfoExample example);

    int updateByPrimaryKeySelective(TCouponInfo record);

    int updateByPrimaryKey(TCouponInfo record);
}