package com.example.dynamicproxy.jdk;

public class UserServiceImpl implements UserService{
    public void select() {
        System.out.println("查询 selectById");
    }
    public void update() {
        System.out.println("更新 update");
    }
}
