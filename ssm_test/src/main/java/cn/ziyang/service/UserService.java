package cn.ziyang.service;

import cn.ziyang.domain.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    public User findOne(User user,HttpSession session);
}
