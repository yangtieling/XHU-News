package com.xhu.dao;

import com.xhu.pojo.NewsComment;

import java.util.List;

public interface NewsCommentMapper {
    /**
     * 新闻评论列表
     *
     * @return
     */
    List<NewsComment> selectNewsCommentList();

    /**
     * 根据评论id主键，删除评论
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增评论
     *
     * @param record 评论对象
     * @return
     */
    int insertSelective(NewsComment record);

    /**
     * 根据评论id查询评论对象
     *
     * @param id
     * @return
     */
    NewsComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsComment record);

    List<NewsComment> selectCommentListByNewsId(Long id);

    int countTotalComments();
}