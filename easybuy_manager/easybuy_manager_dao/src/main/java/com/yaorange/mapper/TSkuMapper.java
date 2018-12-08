package com.yaorange.mapper;

import com.yaorange.pojo.TSku;
import com.yaorange.pojo.TSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSkuMapper {
    int countByExample(TSkuExample example);

    int deleteByExample(TSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TSku record);

    int insertSelective(TSku record);

    List<TSku> selectByExample(TSkuExample example);

    TSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TSku record, @Param("example") TSkuExample example);

    int updateByExample(@Param("record") TSku record, @Param("example") TSkuExample example);

    int updateByPrimaryKeySelective(TSku record);

    int updateByPrimaryKey(TSku record);
    //根据producId查找最大的code
    String selectMaxSkuCodeByProductId(Long productId);
    //更新商品最高最低价格
    int updateProductPrice(@Param("id") Long id, @Param("productId") Long productId);
}
