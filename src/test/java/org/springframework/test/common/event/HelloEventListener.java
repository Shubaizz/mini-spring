package org.springframework.test.common.event;

import org.springframework.context.ApplicationListener;

/**
 * ClassName: HelloEventListener
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/23 15:05
 * Version: 1.0
 */
public class HelloEventListener implements ApplicationListener<HelloEvent> {
    @Override
    public void onApplicationEvent(HelloEvent event) {
        System.out.println("收到：" + event.getSource() + "消息");
    }
}
