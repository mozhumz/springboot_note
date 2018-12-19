package com.hyj.demo.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Transactional;


/*
 * 上次万力写的用了外键关联了用户与业务表，导致重构后也必须存一份用户表
 * @author LiuBing
 * @date 2018/8/10 11:11
 */
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class UserAop {


    @Pointcut("execution(* com.hyj.demo.web.controller.demo.*(..)))")
    public void userControllerPoingtCut(){}

    /**
     * 拦截whut中的控制器，将当前用户写入数据库
     */
    @Before("userControllerPoingtCut()")
    @Transactional
    public void checkMutualEvaluAopAuther() {
//        //TODO hyj 测试时注释掉
//        User user = userRepository.findByUserName(SessionUtil.getCurrentmentSn());
//        if (user == null) {
//            userRepository.save(SessionUtil.getCurrentUser());
//        }
    }
}
