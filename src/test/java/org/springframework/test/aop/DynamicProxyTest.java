package org.springframework.test.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.*;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.CglibAopProxy;
import org.springframework.aop.framework.JdkDynamicAopProxy;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.common.*;
import org.springframework.test.service.WorldService;
import org.springframework.test.service.WorldServiceImpl;
import org.springframework.test.service.WorldServiceWithExceptionImpl;

/**
 * ClassName: DynamicProxyTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:58
 * Version: 1.0
 */
public class DynamicProxyTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new AdvisedSupport();
        // 设置目标对象
        TargetSource targetSource = new TargetSource(worldService);
        // 设置拦截器 (通知)
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        // 匹配方法 (切点)
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setMethodMatcher(methodMatcher);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println(proxy.getClass());
        proxy.explode();
    }
    @Test
    public void testCglibDynamicProxy() throws Exception {
        WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
        System.out.println(proxy.getClass());
        proxy.explode();
    }

    @Test
    public void testProxyFactory() throws Exception {
        // 使用JDK动态代理
        advisedSupport.setProxyTargetClass(false);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println(proxy.getClass());
        proxy.explode();

        // 使用CGLIB动态代理
        advisedSupport.setProxyTargetClass(true);
        proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println(proxy.getClass());
        proxy.explode();
    }


    @Test
    public void testBeforeAdvice() throws Exception {
        AdvisedSupport support = new AdvisedSupport();

        // 目标对象
        WorldService worldService = new WorldServiceImpl();
        TargetSource targetSource = new TargetSource(worldService);

        // 拦截器(通知)
        WorldServiceBeforeAdvice worldServiceBeforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(worldServiceBeforeAdvice);

        // 切面
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.WorldService.explode(..))").getMethodMatcher();

        support.setTargetSource(targetSource);
        support.setMethodInterceptor(methodInterceptor);
        support.setMethodMatcher(methodMatcher);

        WorldService proxy = (WorldService) new ProxyFactory(support).getProxy();
        System.out.println(proxy.getClass());
        proxy.explode();

        AspectJExpressionPointcutAdvisor aspectJExpressionPointcutAdvisor = new AspectJExpressionPointcutAdvisor() ;
        aspectJExpressionPointcutAdvisor.setExpression("execution(* org.springframework.test.service.WorldService.explode(..))");

        AdvisedSupport support2 = new AdvisedSupport();
        support2.setTargetSource(targetSource);
        support2.setMethodInterceptor(methodInterceptor);
        support2.setMethodMatcher(aspectJExpressionPointcutAdvisor.getPointcut().getMethodMatcher());
        support2.setProxyTargetClass(true);
        WorldService proxy2 = (WorldService) new ProxyFactory(support2).getProxy();
        System.out.println(proxy2.getClass());
        proxy2.explode();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beforeAdvice.xml");
        WorldService proxy3 = (WorldService) context.getBean("worldService");
        System.out.println(proxy3.getClass());
        proxy3.explode();

        proxy3.doSomething();
    }

    @Test
    public void testAfterAdvice() throws Exception {
        //设置AfterAdvice
        WorldServiceAfterAdvice afterAdvice = new WorldServiceAfterAdvice();
        CombineAdviceInterceptor methodInterceptor = new CombineAdviceInterceptor();
        methodInterceptor.setAfterAdviceInterceptor(new MethodAfterAdviceInterceptor(afterAdvice));
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setProxyTargetClass(true);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        System.out.println(proxy.getClass());
        proxy.explode();
    }

    @Test
    public void testAfterReturningAdvice() throws Exception {
        //设置AfterReturningAdvice
        WorldServiceAfterReturningAdvice afterReturningAdvice = new WorldServiceAfterReturningAdvice();
        CombineAdviceInterceptor methodInterceptor = new CombineAdviceInterceptor();
        methodInterceptor.setAfterReturningAdviceInterceptor(new MethodAfterReturningAdviceInterceptor(afterReturningAdvice));
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testThrowsAdvice() throws Exception {
        WorldService worldService = new WorldServiceWithExceptionImpl();
        //设置ThrowsAdvice
        WorldServiceThrowsAdvice throwsAdvice = new WorldServiceThrowsAdvice();
        CombineAdviceInterceptor methodInterceptor = new CombineAdviceInterceptor();
        methodInterceptor.setThrowsAdviceInterceptor(new MethodThrowsAdviceInterceptor(throwsAdvice));
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setTargetSource(new TargetSource(worldService));

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAllAdvice() throws Exception {
        //设置before、after、afterReturning
        CombineAdviceInterceptor methodInterceptor = new CombineAdviceInterceptor();
        methodInterceptor.setBeforeAdviceInterceptor(new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice()));
        methodInterceptor.setAfterAdviceInterceptor(new MethodAfterAdviceInterceptor(new WorldServiceAfterAdvice()));
        methodInterceptor.setAfterReturningAdviceInterceptor(new MethodAfterReturningAdviceInterceptor(new WorldServiceAfterReturningAdvice()));
        advisedSupport.setMethodInterceptor(methodInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAllAdviceWithException() throws Exception {
        WorldService worldService = new WorldServiceWithExceptionImpl();
        //设置before、after、throws
        CombineAdviceInterceptor methodInterceptor = new CombineAdviceInterceptor();
        methodInterceptor.setBeforeAdviceInterceptor(new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice()));
        methodInterceptor.setAfterAdviceInterceptor(new MethodAfterAdviceInterceptor(new WorldServiceAfterAdvice()));
        methodInterceptor.setThrowsAdviceInterceptor(new MethodThrowsAdviceInterceptor(new WorldServiceThrowsAdvice()));
        advisedSupport.setMethodInterceptor(methodInterceptor);
        advisedSupport.setTargetSource(new TargetSource(worldService));

        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAroundAdvice() throws Exception {
        WorldServiceAroundAdvice aroundAdvice = new WorldServiceAroundAdvice();
        MethodAroundAdviceInterceptor methodInterceptor = new MethodAroundAdviceInterceptor(aroundAdvice);
        advisedSupport.setMethodInterceptor(methodInterceptor);
        WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor() throws Exception {
        WorldService worldService = new WorldServiceImpl();

        //Advisor是Pointcut和Advice的组合
        String expression = "execution(* org.springframework.test.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        advisor.setAdvice(methodInterceptor);

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(true);
            WorldService proxy = (WorldService) new ProxyFactory(advisedSupport).getProxy();

            System.out.println(proxy.getClass());
            proxy.explode();
        }
    }
}
