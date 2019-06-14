package cn.ziyang.service.impl;

import cn.ziyang.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getName() {

        return "ziyang";
    }
}
