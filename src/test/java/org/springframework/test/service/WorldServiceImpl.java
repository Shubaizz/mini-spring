package org.springframework.test.service;

/**
 * ClassName: WorldServiceImpl
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:56
 * Version: 1.0
 */
public class WorldServiceImpl implements WorldService{

    @Override
    public void explode() {
        System.out.println("The Earth is going to explode");
    }

    @Override
    public void doSomething() {
        System.out.println("do something");
    }
}
