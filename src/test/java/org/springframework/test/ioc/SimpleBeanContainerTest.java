package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * ClassName: SimpleBeanContainerTest
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 10:54
 * Version: 1.0
 */
public class SimpleBeanContainerTest {

    @Test
    public void testGetBean(){
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertThat(helloService).isNotNull();
        assertThat(helloService.sayHello()).isEqualTo("hello world");
    }

    class HelloService{
        public String sayHello(){
            System.out.println("hello world");
            return "hello world";
        }
    }

}
