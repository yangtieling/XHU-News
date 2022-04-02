package com.xhu.service.impl;

import com.xhu.dao.NewsCategoryMapper;
import com.xhu.pojo.NewsCategory;
import com.xhu.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCategoryServiceImpl implements NewsCategoryService {
    @Autowired
    private NewsCategoryMapper newsCategoryMapper;

    @Override
    public List<NewsCategory> findNewsCategoryList() {
        return newsCategoryMapper.selectCategoryList();
    }

    @Override
    public int insertNewsCategory(NewsCategory newsCategory) {
        return newsCategoryMapper.insertSelective(newsCategory);
    }

    @Override
    public NewsCategory findNewsCategoryById(Long id) {
        return newsCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteNewsCategoryById(Long id) {
        return newsCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int findTotalCategories() {
        return newsCategoryMapper.countTotalCategories();
    }

    @Override
    public int updateNewsCategory(NewsCategory newsCategory) { return newsCategoryMapper.updateByPrimaryKeySelective(newsCategory);  }


}
