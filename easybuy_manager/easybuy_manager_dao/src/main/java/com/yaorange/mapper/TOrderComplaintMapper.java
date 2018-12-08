package com.yaorange.mapper;

import com.yaorange.pojo.TOrderComplaint;
import com.yaorange.pojo.TOrderComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderComplaintMapper {
    int countByExample(TOrderComplaintExample example);

    int deleteByExample(TOrderComplaintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrderComplaint record);

    int insertSelective(TOrderComplaint record);

    List<TOrderComplaint> selectByExample(TOrderComplaintExample example);

    TOrderComplaint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrderComplaint record, @Param("example") TOrderComplaintExample example);

    int updateByExample(@Param("record") TOrderComplaint record, @Param("example") TOrderComplaintExample example);

    int updateByPrimaryKeySelective(TOrderComplaint record);

    int updateByPrimaryKey(TOrderComplaint record);
}