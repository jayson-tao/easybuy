package com.yaorange.mapper;

import com.yaorange.pojo.TGlobalInfo;
import com.yaorange.pojo.TGlobalInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TGlobalInfoMapper {
    int countByExample(TGlobalInfoExample example);

    int deleteByExample(TGlobalInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TGlobalInfo record);

    int insertSelective(TGlobalInfo record);

    List<TGlobalInfo> selectByExample(TGlobalInfoExample example);

    TGlobalInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TGlobalInfo record, @Param("example") TGlobalInfoExample example);

    int updateByExample(@Param("record") TGlobalInfo record, @Param("example") TGlobalInfoExample example);

    int updateByPrimaryKeySelective(TGlobalInfo record);

    int updateByPrimaryKey(TGlobalInfo record);
}