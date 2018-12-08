package com.yaorange.mapper;

import com.yaorange.pojo.TProductExt;
import com.yaorange.pojo.TProductExtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductExtMapper {
    int countByExample(TProductExtExample example);

    int deleteByExample(TProductExtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProductExt record);

    int insertSelective(TProductExt record);

    List<TProductExt> selectByExampleWithBLOBs(TProductExtExample example);

    List<TProductExt> selectByExample(TProductExtExample example);

    TProductExt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProductExt record, @Param("example") TProductExtExample example);

    int updateByExampleWithBLOBs(@Param("record") TProductExt record, @Param("example") TProductExtExample example);

    int updateByExample(@Param("record") TProductExt record, @Param("example") TProductExtExample example);

    int updateByPrimaryKeySelective(TProductExt record);

    int updateByPrimaryKeyWithBLOBs(TProductExt record);

    int updateByPrimaryKey(TProductExt record);
}