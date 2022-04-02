package com.xhu.service;

import com.xhu.pojo.NewsComment;

import java.util.List;

public interface NewsCommentService {
    /**
     * 查询评论列表数据
     *
     * @return
     */
    List<NewsComment> findNewsCommentList();

    /**
     * 新增评论
     *
     * @param newsComment
     * @return
     */
    int insertNewsComment(NewsComment newsComment);

    List<NewsComment> findNewsCommentByNewsId(Long id);

    /**
     * 根据评论ID删除对象
     *
     * @param id 评论ID
     * @return
     */
    int deleteNewsCommentById(Long id);

    int findTotalComments();
}
