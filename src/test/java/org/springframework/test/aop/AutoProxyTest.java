package org.springframework.test.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.service.WorldService;

/**
 * ClassName: AutoProxyTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 15:09
 * Version: 1.0
 */
public class AutoProxyTest {

    @Test(expected = RuntimeException.class)
    public void testAutoProxy() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");
        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        // 因为有环绕通知，所以是走到环绕通知，其余的可以自行测试（例如删掉配置aroundAdviceInterceptor）
        worldService.explode();
        WorldService worldServiceWithException = applicationContext.getBean("worldServiceWithException", WorldService.class);
        worldServiceWithException.explode();
    }
}
