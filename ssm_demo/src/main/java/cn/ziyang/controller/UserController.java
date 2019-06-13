package cn.ziyang.controller;

import cn.ziyang.domain.User;
import cn.ziyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;
    @RequestMapping("/findOne")
    public String findOne(User user){
        User u = userService.findOne(user);
        if (u!=null){
            session.setAttribute("loginUser",u);
            return "redirect:/student/findAll";
        }else {
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:/login.jsp";
        }

    }
}
