package com.yaorange.mapper;

import com.yaorange.pojo.TVipProductView;
import com.yaorange.pojo.TVipProductViewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipProductViewMapper {
    int countByExample(TVipProductViewExample example);

    int deleteByExample(TVipProductViewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipProductView record);

    int insertSelective(TVipProductView record);

    List<TVipProductView> selectByExample(TVipProductViewExample example);

    TVipProductView selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipProductView record, @Param("example") TVipProductViewExample example);

    int updateByExample(@Param("record") TVipProductView record, @Param("example") TVipProductViewExample example);

    int updateByPrimaryKeySelective(TVipProductView record);

    int updateByPrimaryKey(TVipProductView record);
}