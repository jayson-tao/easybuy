package com.yaorange.mapper;

import com.yaorange.pojo.TVipAddress;
import com.yaorange.pojo.TVipAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipAddressMapper {
    int countByExample(TVipAddressExample example);

    int deleteByExample(TVipAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipAddress record);

    int insertSelective(TVipAddress record);

    List<TVipAddress> selectByExample(TVipAddressExample example);

    TVipAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipAddress record, @Param("example") TVipAddressExample example);

    int updateByExample(@Param("record") TVipAddress record, @Param("example") TVipAddressExample example);

    int updateByPrimaryKeySelective(TVipAddress record);

    int updateByPrimaryKey(TVipAddress record);
}