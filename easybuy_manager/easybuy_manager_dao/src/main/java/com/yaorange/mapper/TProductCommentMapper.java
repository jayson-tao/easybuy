package com.yaorange.mapper;

import com.yaorange.pojo.TProductComment;
import com.yaorange.pojo.TProductCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProductCommentMapper {
    int countByExample(TProductCommentExample example);

    int deleteByExample(TProductCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TProductComment record);

    int insertSelective(TProductComment record);

    List<TProductComment> selectByExample(TProductCommentExample example);

    TProductComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TProductComment record, @Param("example") TProductCommentExample example);

    int updateByExample(@Param("record") TProductComment record, @Param("example") TProductCommentExample example);

    int updateByPrimaryKeySelective(TProductComment record);

    int updateByPrimaryKey(TProductComment record);
}