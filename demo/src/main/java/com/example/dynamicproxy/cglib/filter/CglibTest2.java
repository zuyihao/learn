package com.example.dynamicproxy.cglib.filter;

import com.example.dynamicproxy.cglib.LogCglibHandler;
import com.example.dynamicproxy.cglib.UserDao;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

public class CglibTest2 {
    public static void main(String[] args) {
        LogCglibHandler logInterceptor = new LogCglibHandler();
        LogCglibHandler2 logInterceptor2 = new LogCglibHandler2();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);   // 设置超类，cglib是通过继承来实现的
        enhancer.setCallbacks(new Callback[]{logInterceptor, logInterceptor2, NoOp.INSTANCE});   // 设置多个拦截器，NoOp.INSTANCE是一个空拦截器，不做任何处理
        enhancer.setCallbackFilter(new LogCglibHandlerFilter());

        UserDao proxy = (UserDao) enhancer.create();   // 创建代理类
        proxy.select();
        proxy.update();
    }
}
