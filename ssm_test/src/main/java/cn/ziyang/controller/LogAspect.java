package cn.ziyang.controller;

import cn.ziyang.domain.Log;
import cn.ziyang.domain.User;
import cn.ziyang.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect //标注该类是一个切面类
public class LogAspect {
    @Autowired
    private LogService logService;
    @Autowired
    HttpServletRequest request;
    /**
     * 操作的日志
     */
    @Around("execution(* cn.ziyang.controller.*.*(..))")
    public Object loginLog(ProceedingJoinPoint pjp) throws Throwable {
        Log log = new Log();
        log.setTime(new Date());

        long startTime = new Date().getTime();

        Object object = pjp.proceed();
        long endTime = new Date().getTime();
        //获取url
        String url = pjp.getTarget().getClass().getName();
        //获取方法名
        String methodName = pjp.getSignature().getName();
        //获取user
        User user = (User) request.getSession().getAttribute("userLogin");
        String username = "";
        if (user!=null){
            username = user.getName();
        }else {
            username= request.getParameter("name"+"[登陆失败]");
        }
        log.setName(username);
        log.setUrl(url + methodName);
        log.setCost((int) (endTime - startTime));
        logService.save(log);
        return object;
    }
}
