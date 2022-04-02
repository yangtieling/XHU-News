package com.xhu.dao;

import com.xhu.pojo.NewsCategory;

import java.util.List;

public interface NewsCategoryMapper {
    /**
     * 新闻主题列表
     *
     * @return
     */
    List<NewsCategory> selectCategoryList();

    /**
     * 根据主键删除新闻主题
     *
     * @param id 主题ID
     * @return
     */
    int deleteByPrimaryKey(Long id);

    int insert(NewsCategory record);

    /**
     * 新增新闻主题
     *
     * @param record 新闻主题对象
     * @return
     */
    int insertSelective(NewsCategory record);

    /**
     * 根据主题ID查询主题对象
     *
     * @param id 主题ID
     * @return
     */
    NewsCategory selectByPrimaryKey(Long id);

    /**
     * 修改新闻主题
     *
     * @param record 新闻主题对象
     * @return
     */
    int updateByPrimaryKeySelective(NewsCategory record);

    int countTotalCategories();
}