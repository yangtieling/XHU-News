package com.xhu.service.impl;

import com.xhu.dao.NewsDetailMapper;
import com.xhu.pojo.GraphBar;
import com.xhu.pojo.NewsDetail;
import com.xhu.service.NewsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsDetailServiceImpl implements NewsDetailService {
    @Autowired
    private NewsDetailMapper newsDetailMapper;

    @Override
    public List<NewsDetail> findNewsDetailList() {
        return newsDetailMapper.selectNewsList();
    }

    @Override
    public int insertNewsDetail(NewsDetail newsDetail) {
        return newsDetailMapper.insertSelective(newsDetail);
    }

    @Override
    public List<NewsDetail> findNewsCategoryNameList() {
        return newsDetailMapper.selectNewsCategoryNameList();
    }

    @Override
    public NewsDetail findNewsDetailById(Long id) {
        return newsDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNewsDetail(NewsDetail newsDetail) {
        return newsDetailMapper.updateByPrimaryKeySelective(newsDetail);
    }

    @Override
    public int deleteNewsDetail(Long id) {
        return newsDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GraphBar> findGraphBarData() {
        return newsDetailMapper.selectGraphBarData();
    }

    @Override
    public int findTotalDetails() {
        return newsDetailMapper.countTotalDetails();
    }
}
