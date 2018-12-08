package com.yaorange.mapper;

import com.yaorange.pojo.TOrderReturnItem;
import com.yaorange.pojo.TOrderReturnItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderReturnItemMapper {
    int countByExample(TOrderReturnItemExample example);

    int deleteByExample(TOrderReturnItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderReturnItem record);

    int insertSelective(TOrderReturnItem record);

    List<TOrderReturnItem> selectByExample(TOrderReturnItemExample example);

    TOrderReturnItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderReturnItem record, @Param("example") TOrderReturnItemExample example);

    int updateByExample(@Param("record") TOrderReturnItem record, @Param("example") TOrderReturnItemExample example);

    int updateByPrimaryKeySelective(TOrderReturnItem record);

    int updateByPrimaryKey(TOrderReturnItem record);
}