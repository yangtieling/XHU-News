package com.xhu.controller;

import com.alibaba.fastjson.JSON;
import com.xhu.pojo.NewsComment;
import com.xhu.pojo.NewsUser;
import com.xhu.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/newsComment")
public class NewsCommentController {
    @Autowired
    private NewsCommentService newsCommentService;

    /**
     * 查找评论列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/findCommentList")
    public String findCommentList(Model model) {
        List<NewsComment> list = newsCommentService.findNewsCommentList();
        model.addAttribute("list", list);
        return "comment_list";
    }

    /**
     * 评论新闻后插入数据库中
     *
     * @param contentVal
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insertComment",produces = "application/json;charset=utf-8")
    public String insertComment(String contentVal,
                                String newsId,
                                HttpSession session,
                                HttpServletRequest req) {
        try {
            contentVal =  new String(contentVal.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        NewsUser user = (NewsUser) session.getAttribute("user");
        Long id = Long.parseLong(newsId);
        NewsComment newsComment = new NewsComment();
        //通过session获取作者
        newsComment.setContent(contentVal);
        newsComment.setAuthor(user.getUsername());
        newsComment.setCreatedate(new Date());
        newsComment.setIp(req.getRemoteAddr());
        newsComment.setNewsid(id);
        int result = newsCommentService.insertNewsComment(newsComment);
        if (result > 0) {
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * 这里返回值用Object因为返回的是一个JSON数据格式
     * AJAX的异步请求查询指定新闻的所有评论
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findCommentsByParam", produces = "application/json;charset=utf-8")
    public Object findCommentsByParam(String newsId) {
        Long id = Long.parseLong(newsId);
        List<NewsComment> list = newsCommentService.findNewsCommentByNewsId(id);
        String result = JSON.toJSONString(list);
        return result;
    }

    /**
     * 删除评论
     *
     * @param commentId
     * @return
     */
    @RequestMapping("/deleteComment")
    public String deleteComment(String commentId) {
        Long id = Long.parseLong(commentId);
        int result = newsCommentService.deleteNewsCommentById(id);
        if (result > 0) {
            return "info_comment";
        } else {
            return "comment_list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"), true));
    }
}
