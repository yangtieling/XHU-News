package com.xhu.dao;

import com.xhu.pojo.NewsUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface NewsUserMapper {
    /**
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    NewsUser selectUserByParam(@Param("userName") String userName,
                               @Param("password") String password);

    /**
     * 查询用户列表
     *
     * @return
     */
    List<NewsUser> selectUserList();

    /**
     * 根据主键删除用户
     *
     * @param id 用户ID
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新增用户
     *
     * @param record
     * @return
     */
    int insert(NewsUser record);

    int insertSelective(NewsUser record);

    /**
     * 根据用户ID查找用户对象
     *
     * @param id 用户ID
     * @return
     */
    NewsUser selectByPrimaryKey(Long id);

    /**
     * 修改用户
     *
     * @param record 用户对象
     * @return
     */
    int updateByPrimaryKeySelective(NewsUser record);

    int countTotalUsers();
}