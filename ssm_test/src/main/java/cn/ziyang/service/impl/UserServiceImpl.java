package cn.ziyang.service.impl;

import cn.ziyang.domain.User;
import cn.ziyang.mapper.UserMapper;
import cn.ziyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findOne(User user,HttpSession session) {
        User u = userMapper.findOne(user);
        if (u!=null){
            session.setAttribute("userLogin",u);
        }
       //System.out.println(u);
        return u;
    }
}
