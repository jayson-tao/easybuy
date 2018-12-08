package com.yaorange.mapper;

import com.yaorange.pojo.TVipCart;
import com.yaorange.pojo.TVipCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipCartMapper {
    int countByExample(TVipCartExample example);

    int deleteByExample(TVipCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TVipCart record);

    int insertSelective(TVipCart record);

    List<TVipCart> selectByExample(TVipCartExample example);

    TVipCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TVipCart record, @Param("example") TVipCartExample example);

    int updateByExample(@Param("record") TVipCart record, @Param("example") TVipCartExample example);

    int updateByPrimaryKeySelective(TVipCart record);

    int updateByPrimaryKey(TVipCart record);
    //选中
    int selected(@Param("ssoId") Long ssoId, @Param("cartIdArr") Long[] cartIdArray);
    //不选中
    int deSelected(@Param("ssoId")Long ssoId,@Param("cartIdArr") Long[] cartIdArray);
}
