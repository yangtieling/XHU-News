package com.xhu.service;

import com.xhu.pojo.GraphBar;
import com.xhu.pojo.NewsDetail;

import java.util.List;

public interface NewsDetailService {
    /**
     * 查询新闻详情列表
     *
     * @return
     */
    List<NewsDetail> findNewsDetailList();

    /**
     * 新增新闻详情
     *
     * @param newsDetail 详情对象
     * @return
     */
    int insertNewsDetail(NewsDetail newsDetail);


    /**
     * 更新新闻详情
     *
     * @param newsDetail
     * @return
     */
    int updateNewsDetail(NewsDetail newsDetail);

    /**
     * 根据详情id主键删除
     *
     * @param id
     * @return
     */
    int deleteNewsDetail(Long id);

    /**
     * 查询详情列表，包括主题名称
     *
     * @return
     */
    List<NewsDetail> findNewsCategoryNameList();

    /**
     * 根据详情id查询详情对象
     *
     * @param id 详情id
     * @return
     */
    NewsDetail findNewsDetailById(Long id);

    List<GraphBar> findGraphBarData();

    int findTotalDetails();
}
