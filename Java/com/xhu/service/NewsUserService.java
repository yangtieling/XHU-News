package com.xhu.service;

import com.xhu.pojo.GraphBar;
import com.xhu.pojo.NewsUser;

import java.util.List;

public interface NewsUserService {
    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    NewsUser login(String userName, String password);

    /**
     * 用户列表
     *
     * @return
     */
    List<NewsUser> findUserList();

    /**
     * 新增用户
     *
     * @param newsUser
     * @return
     */
    int insertUser(NewsUser newsUser);

    /**
     * 根据用户ID查找用户对象
     *
     * @param id 用户ID
     * @return
     */
    NewsUser findNewsUserById(Long id);

    /**
     * 修改用户
     *
     * @param newsUser
     * @return
     */
    int updateNewsUser(NewsUser newsUser);

    /**
     * 根据用户ID删除对象
     *
     * @param id 主题ID
     * @return
     */
    int deleteNewsUserById(Long id);

    int findTotalUsers();
}
