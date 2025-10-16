package org.springframework.test.common;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodAfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class WorldServiceAfterReturningAdvice implements MethodAfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturningAdvice: do something after the earth explodes return");
    }
}
