package cn.ziyang.controller;

import cn.ziyang.domain.Log;
import cn.ziyang.domain.User;
import cn.ziyang.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
@Aspect
public class LogAspect {
    @Autowired
    private LogService logService;
    @Autowired
    private HttpSession session;

    @Around("execution(* cn.ziyang.controller.*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Log log = new Log();
        log.setTime(new Date());
        long startTime = new Date().getTime();
        Object proceed = pjp.proceed();
        long endTime = new Date().getTime();
        String url = pjp.getTarget().getClass().getName();
        String methodName = pjp.getSignature().getName();
        User user = (User) session.getAttribute("loginUser");
        log.setName(user.getName());
        log.setUrl("url:"+url+"[方法名]"+methodName);
        log.setCost((int) (endTime-startTime));
        logService.save(log);
        return proceed;
    }
}
