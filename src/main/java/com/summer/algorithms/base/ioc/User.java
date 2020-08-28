package com.summer.algorithms.base.ioc;

/**
 * @author adminstor
 */
@MyBean("user")
public class User {
    private String name;
    public User() {
        this.name = "我是测试的";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
