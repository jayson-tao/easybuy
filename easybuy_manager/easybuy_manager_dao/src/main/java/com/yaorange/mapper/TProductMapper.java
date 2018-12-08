package com.yaorange.mapper;

import com.yaorange.pojo.TProduct;
import com.yaorange.pojo.TProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductMapper {
    int countByExample(TProductExample example);

    int deleteByExample(TProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    List<TProduct> selectByExample(TProductExample example);

    TProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByExample(@Param("record") TProduct record, @Param("example") TProductExample example);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);
    //批量查询
    List<TProduct> selectByPrimaryKeyBatch(List<Long> list);
    //批量更新商品上架或下架
    int updateStateByIds(@Param("list") List<Long> updateIds, @Param("state") Byte onSale,@Param("onSale") Long onsale,@Param("offSale") Long offSale);
}
