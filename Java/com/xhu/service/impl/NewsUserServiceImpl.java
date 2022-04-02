package com.xhu.service.impl;

import com.xhu.dao.NewsUserMapper;
import com.xhu.pojo.NewsUser;
import com.xhu.service.NewsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsUserServiceImpl implements NewsUserService {
    @Autowired
    private NewsUserMapper newsUserMapper;

    @Override
    public NewsUser login(String username, String password) {

        return newsUserMapper.selectUserByParam(username, password);
    }

    @Override
    public List<NewsUser> findUserList() {
        return newsUserMapper.selectUserList();
    }

    @Override
    public int insertUser(NewsUser newsUser) {
        return newsUserMapper.insert(newsUser);
    }

    @Override
    public NewsUser findNewsUserById(Long id) {
        return newsUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNewsUser(NewsUser newsUser) {
        return newsUserMapper.updateByPrimaryKeySelective(newsUser);
    }

    @Override
    public int deleteNewsUserById(Long id) {
        return newsUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int findTotalUsers() {
        return newsUserMapper.countTotalUsers();
    }
}
