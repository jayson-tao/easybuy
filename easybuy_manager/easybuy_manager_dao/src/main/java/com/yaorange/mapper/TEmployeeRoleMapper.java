package com.yaorange.mapper;

import com.yaorange.pojo.TEmployeeRole;
import com.yaorange.pojo.TEmployeeRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEmployeeRoleMapper {
    int countByExample(TEmployeeRoleExample example);

    int deleteByExample(TEmployeeRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TEmployeeRole record);

    int insertSelective(TEmployeeRole record);

    List<TEmployeeRole> selectByExample(TEmployeeRoleExample example);

    TEmployeeRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TEmployeeRole record, @Param("example") TEmployeeRoleExample example);

    int updateByExample(@Param("record") TEmployeeRole record, @Param("example") TEmployeeRoleExample example);

    int updateByPrimaryKeySelective(TEmployeeRole record);

    int updateByPrimaryKey(TEmployeeRole record);
}