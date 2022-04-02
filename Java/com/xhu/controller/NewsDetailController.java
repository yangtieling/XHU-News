package com.xhu.controller;

import com.xhu.pojo.NewsCategory;
import com.xhu.pojo.NewsDetail;
import com.xhu.pojo.NewsUser;
import com.xhu.service.NewsCategoryService;
import com.xhu.service.NewsDetailService;
import com.xhu.service.NewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/newsDetail")
public class NewsDetailController {
    @Autowired
    private NewsDetailService newsDetailService;

    @Autowired
    private NewsCategoryService newsCategoryService;

    /**
     * 查询新闻详情列表,包含主题名称
     *
     * @param model
     * @return
     */
    @RequestMapping("/findNewsList")
    public String findNewsList(Model model) {
        List<NewsDetail> list = newsDetailService.findNewsCategoryNameList();
        model.addAttribute("list", list);
        return "news_list";
    }

    @RequestMapping("/findNewsList_Stuff")
    public String findNewsList_Stuff(Model model) {
        List<NewsDetail> list = newsDetailService.findNewsCategoryNameList();
        model.addAttribute("list", list);
        return "news_list_stuff";
    }

    /**
     * 跳转新闻详情新增页面
     *
     * @return
     */
    @RequestMapping("/toNewsAdd")
    public String toNewsAdd(Model model) {
        List<NewsCategory> list = newsCategoryService.findNewsCategoryList();
        model.addAttribute("list", list);
        return "news_release";
    }

    /**
     * 新增新闻详情
     *
     * @param newsDetail
     * @return
     */
    @RequestMapping("/insertNewsDetail")
    public String insertNewsDetail(NewsDetail newsDetail) {
        int result = newsDetailService.insertNewsDetail(newsDetail);
        if (result > 0) {
            return "info_detail";
        } else {
            return "news_release";
        }
    }

    /**
     * 查看新闻详情
     *
     * @param detailId 详情ID
     * @return
     */
    @RequestMapping("/viewDetailById")
    public String viewDetailById(String detailId, Model model) {
        Long id = Long.parseLong(detailId);
        NewsDetail newsDetail = newsDetailService.findNewsDetailById(id);
        List<NewsCategory> list = newsCategoryService.findNewsCategoryList();
        model.addAttribute("list", list);
        model.addAttribute("newsDetail", newsDetail);
        return "news_release_view";
    }

    /**
     * 查看新闻详情
     *
     * @param detailId 详情ID
     * @return
     */
    @RequestMapping("/viewDetailByIdStuff")
    public String viewDetailByIdStuff(String detailId, Model model) {
        Long id = Long.parseLong(detailId);
        NewsDetail newsDetail = newsDetailService.findNewsDetailById(id);
        List<NewsCategory> list = newsCategoryService.findNewsCategoryList();
        model.addAttribute("list", list);
        model.addAttribute("newsDetail", newsDetail);
        return "news_release_view_stuff";
    }

    /**
     * 根据详情ID查询详情对象并转发到详情修改表单
     *
     * @param detailId 详情ID
     * @param model
     * @return
     */
    @RequestMapping("/findDetailById")
    public String findDetailById(String detailId, Model model) {
        Long id = Long.parseLong(detailId);
        NewsDetail newsDetail = newsDetailService.findNewsDetailById(id);
        List<NewsCategory> list = newsCategoryService.findNewsCategoryList();
        model.addAttribute("list", list);
        model.addAttribute("newsDetail", newsDetail);
        return "news_release_update";
    }

    /**
     * 修改新闻详情
     *
     * @param newsDetail
     * @return
     */
    @RequestMapping("/updateDetail")
    public String updateDetail(NewsDetail newsDetail) {
        int result = newsDetailService.updateNewsDetail(newsDetail);
        if (result > 0) {
            return "info_detail";
        } else {
            return "news_list";
        }
    }

    /**
     * 删除详情
     *
     * @param detailId
     * @return
     */
    @RequestMapping("/deleteDetail")
    public String deleteDetail(String detailId) {
        Long id = Long.parseLong(detailId);
        int result = newsDetailService.deleteNewsDetail(id);
        if (result > 0) {
            return "info_detail";
        } else {
            return "news_list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), true));
    }
}
