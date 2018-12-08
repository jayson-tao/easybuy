package com.yaorange.mapper;

import com.yaorange.pojo.TProductMedia;
import com.yaorange.pojo.TProductMediaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductMediaMapper {
    int countByExample(TProductMediaExample example);

    int deleteByExample(TProductMediaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProductMedia record);
    int insertMediaBatch(List<TProductMedia> list);

    int insertSelective(TProductMedia record);

    List<TProductMedia> selectByExample(TProductMediaExample example);

    TProductMedia selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProductMedia record, @Param("example") TProductMediaExample example);

    int updateByExample(@Param("record") TProductMedia record, @Param("example") TProductMediaExample example);

    int updateByPrimaryKeySelective(TProductMedia record);

    int updateByPrimaryKey(TProductMedia record);

}
