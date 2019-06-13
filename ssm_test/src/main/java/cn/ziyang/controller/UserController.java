package cn.ziyang.controller;

import cn.ziyang.domain.User;
import cn.ziyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentController studentController;

    @RequestMapping("/findOne")
    public ModelAndView findOne(User user, HttpSession session) {
        User userLogin = userService.findOne(user,session);
        if (userLogin != null) {
            return studentController.findAll();
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("msg", "用户名或密码错误");
            modelAndView.setViewName("login");
            return modelAndView;
        }

    }
}
