package org.springframework.test.service;

/**
 * ClassName: WorldServiceWithExceptionImpl
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 15:13
 * Version: 1.0
 */
public class WorldServiceWithExceptionImpl implements WorldService{

    @Override
    public void explode() {
        System.out.println("The Earth is going to explode with an Exception");
        throw new RuntimeException();
    }
}
