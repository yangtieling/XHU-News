package com.xhu.service.impl;

import com.xhu.dao.NewsCommentMapper;
import com.xhu.pojo.NewsComment;
import com.xhu.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {
    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Override
    public List<NewsComment> findNewsCommentList() {
        return newsCommentMapper.selectNewsCommentList();
    }

    @Override
    public int insertNewsComment(NewsComment newsComment) {
        return newsCommentMapper.insertSelective(newsComment);
    }

    @Override
    public List<NewsComment> findNewsCommentByNewsId(Long id) {
        return newsCommentMapper.selectCommentListByNewsId(id);
    }

    @Override
    public int deleteNewsCommentById(Long id) {
        return newsCommentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int findTotalComments() {
        return newsCommentMapper.countTotalComments();
    }
}
