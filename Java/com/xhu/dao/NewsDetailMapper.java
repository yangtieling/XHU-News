package com.xhu.dao;

import com.xhu.pojo.GraphBar;
import com.xhu.pojo.NewsDetail;

import java.util.List;

public interface NewsDetailMapper {
    /**
     * 新闻详情列表
     *
     * @return
     */
    List<NewsDetail> selectNewsList();

    /**
     * 根据详情id主键删除详情
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增新闻详情
     *
     * @param record 详情对象
     * @return
     */
    int insertSelective(NewsDetail record);

    /**
     * 根据新闻内容主键查找新闻
     *
     * @param id 新闻ID
     * @return
     */
    NewsDetail selectByPrimaryKey(Long id);

    /**
     * 修改新闻详情
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(NewsDetail record);

    /**
     * 查询新闻详情列表，包括主题名称
     *
     * @return
     */
    List<NewsDetail> selectNewsCategoryNameList();

    List<GraphBar> selectGraphBarData();

    int countTotalDetails();
}