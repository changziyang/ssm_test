package cn.ziyang.service.impl;

import cn.ziyang.domain.User;
import cn.ziyang.mapper.UserMapper;
import cn.ziyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findOne(User user) {
        User u = userMapper.findOne(user);
        return u;
    }
}
