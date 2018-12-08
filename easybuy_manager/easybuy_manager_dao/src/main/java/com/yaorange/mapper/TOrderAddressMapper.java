package com.yaorange.mapper;

import com.yaorange.pojo.TOrderAddress;
import com.yaorange.pojo.TOrderAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderAddressMapper {
    int countByExample(TOrderAddressExample example);

    int deleteByExample(TOrderAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderAddress record);

    int insertSelective(TOrderAddress record);

    List<TOrderAddress> selectByExample(TOrderAddressExample example);

    TOrderAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderAddress record, @Param("example") TOrderAddressExample example);

    int updateByExample(@Param("record") TOrderAddress record, @Param("example") TOrderAddressExample example);

    int updateByPrimaryKeySelective(TOrderAddress record);

    int updateByPrimaryKey(TOrderAddress record);
}