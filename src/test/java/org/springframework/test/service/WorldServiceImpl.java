package org.springframework.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.stereotype.Component;

/**
 * ClassName: WorldServiceImpl
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:56
 * Version: 1.0
 */
@Component
public class WorldServiceImpl implements WorldService{

    @Value("${brand}")
    private String name;

    @Autowired
    private MyService myService;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void explode() {
        System.out.println("The "+ name +" is going to explode");
    }

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    public void doSomethingElse() {
        myService.doSomething();
    }
}
