package com.xhu.service;

import com.xhu.pojo.NewsCategory;

import java.util.List;

public interface NewsCategoryService {
    /**
     * 新闻主题列表
     *
     * @return
     */
    List<NewsCategory> findNewsCategoryList();

    /**
     * 新增新闻主题
     *
     * @param newsCategory
     * @return
     */
    int insertNewsCategory(NewsCategory newsCategory);

    /**
     * 根据主题ID查询对象
     *
     * @param id 主题ID
     * @return
     */
    NewsCategory findNewsCategoryById(Long id);

    /**
     * 修改新闻主题
     *
     * @param newsCategory
     * @return
     */
    int updateNewsCategory(NewsCategory newsCategory);

    /**
     * 根据主题ID删除对象
     *
     * @param id 主题ID
     * @return
     */
    int deleteNewsCategoryById(Long id);

    int findTotalCategories();
}
