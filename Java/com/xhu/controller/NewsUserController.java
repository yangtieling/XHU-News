package com.xhu.controller;

import com.xhu.pojo.NewsUser;
import com.xhu.service.NewsCategoryService;
import com.xhu.service.NewsCommentService;
import com.xhu.service.NewsDetailService;
import com.xhu.service.NewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class NewsUserController {
    @Autowired
    private NewsUserService newsUserService;
    @Autowired
    private NewsDetailService newsDetailService;
    @Autowired
    private NewsCategoryService newsCategoryService;
    @Autowired
    private NewsCommentService newsCommentService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/user/toLogin";        //表示重定向，默认转发
    }

    @RequestMapping("/login")
    public String login(String userName, String userPassword, HttpSession session) {
        NewsUser newsUser = newsUserService.login(userName, userPassword);
        int totalDetails = newsDetailService.findTotalDetails();
        int totalCommnets = newsCommentService.findTotalComments();
        int toltalCategories = newsCategoryService.findTotalCategories();
        int totalUsers = newsUserService.findTotalUsers();

        if (newsUser != null) {
            if (newsUser.usertype == 0) {
                session.setAttribute("user", newsUser);
                session.setAttribute("totalUsers", totalUsers);
                session.setAttribute("totalDetails", totalDetails);
                session.setAttribute("totalCommnets", totalCommnets);
                session.setAttribute("toltalCategories", toltalCategories);
                return "index";
            } else {
                session.setAttribute("user", newsUser);
                session.setAttribute("totalUsers", totalUsers);
                session.setAttribute("totalDetails", totalDetails);
                session.setAttribute("totalCommnets", totalCommnets);
                session.setAttribute("toltalCategories", toltalCategories);
                return "stuff_index";
            }
        }
        return "login";
    }

    @RequestMapping("/toindex")
    public String toindex() {
        return "index";
    }

    @RequestMapping("/findUserLiset")
    public String findUserLiset(Model model) {
        List<NewsUser> list = newsUserService.findUserList();
        model.addAttribute("list", list);
        return "user_list";
    }

    @RequestMapping("/toUserAdd")
    public String toUserAdd() {
        return "user_add";
    }

    @RequestMapping("/insertUser")
    public String insertUser(NewsUser newsUser) {
        int result = newsUserService.insertUser(newsUser);
        if (result > 0) {
            return "info_user";
        } else {
            return "user_list";
        }
    }

    /**
     * 根据用户ID查询主题对象并转发到主题修改表单
     *
     * @param userId 用户ID
     * @return
     */
    @RequestMapping("/findUserById")
    public String findUserById(String userId, Model model) {
        Long id = Long.parseLong(userId);
        NewsUser newsUser = newsUserService.findNewsUserById(id);
        model.addAttribute("newsUser", newsUser);
        return "user_add_update";
    }

    /**
     * 修改用户
     *
     * @param newsUser
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(NewsUser newsUser) {
        int result = newsUserService.updateNewsUser(newsUser);
        if (result > 0) {
            return "info_user";
        } else {
            return "user_list";
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(String userId) {
        Long id = Long.parseLong(userId);
        int result = newsUserService.deleteNewsUserById(id);
        if (result > 0) {
            return "info_user";
        } else {
            return "user_list";
        }
    }
}
