package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: InitAndDestoryMethodTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/22 16:00
 * Version: 1.0
 */
public class InitAndDestoryMethodTest {

    @Test
    public void testInitAndDestroyMethod() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        applicationContext.close();  //或者手动关闭 applicationContext.close();
    }
}
