package com.xhu.controller;

import com.xhu.pojo.NewsCategory;
import com.xhu.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/newsCategory")
public class NewsCategoryController {
    @Autowired
    private NewsCategoryService newsCategoryService;

    /**
     * 查找主题列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/findCategoryList")
    public String findCategoryList(Model model) {
        List<NewsCategory> list = newsCategoryService.findNewsCategoryList();
        model.addAttribute("list", list);
        return "category_list";
    }

    /**
     * 跳转新增主题页面
     *
     * @return
     */
    @RequestMapping("/toCategoryAdd")
    public String toCategoryAdd() {
        return "category_add";
    }

    /**
     * 新增主题
     *
     * @param newsCategory
     * @return
     */
    @RequestMapping("insertCategory")
    public String insertCategory(NewsCategory newsCategory) {
        int result = newsCategoryService.insertNewsCategory(newsCategory);
        if (result > 0) {
            return "info_category";
        } else {
            return "category_add";
        }
    }

    /**
     * 根据新闻主题ID查询主题对象并转发到主题修改表单
     *
     * @param categoryId 主题ID
     * @return
     */
    @RequestMapping("/findCategoryById")
    public String findCategoryById(String categoryId, Model model) {
        Long id = Long.parseLong(categoryId);
        NewsCategory newsCategory = newsCategoryService.findNewsCategoryById(id);
        model.addAttribute("newsCategory", newsCategory);
        return "category_add_update";
    }

    /**
     * 修改主题
     *
     * @param newsCategory
     * @return
     */
    @RequestMapping("/updateCategory")
    public String updateCategory(NewsCategory newsCategory) {
        int result = newsCategoryService.updateNewsCategory(newsCategory);
        if (result > 0) {
            return "info_category";
        } else {
            return "category_list";
        }
    }

    /**
     * 删除主题
     *
     * @param categoryId
     * @return
     */
    @RequestMapping("/deleteCategory")
    public String deleyeCategory(String categoryId) {
        Long id = Long.parseLong(categoryId);
        int result = newsCategoryService.deleteNewsCategoryById(id);
        if (result > 0) {
            return "info_category";
        } else {
            return "category_list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), true));
    }

}
