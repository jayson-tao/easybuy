package com.yaorange.mapper;

import com.yaorange.pojo.TAdArea;
import com.yaorange.pojo.TAdAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAdAreaMapper {
    int countByExample(TAdAreaExample example);

    int deleteByExample(TAdAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TAdArea record);

    int insertSelective(TAdArea record);

    List<TAdArea> selectByExample(TAdAreaExample example);

    TAdArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TAdArea record, @Param("example") TAdAreaExample example);

    int updateByExample(@Param("record") TAdArea record, @Param("example") TAdAreaExample example);

    int updateByPrimaryKeySelective(TAdArea record);

    int updateByPrimaryKey(TAdArea record);
}