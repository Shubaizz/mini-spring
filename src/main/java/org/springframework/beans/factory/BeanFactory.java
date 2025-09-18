package org.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BeanFactory
 * Description: 定义一个简单的bean容器BeanFactory，内部包含一个map用以保存bean，只有注册bean和获取bean两个方法
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/18 10:51
 * Version: 1.0
 */
public class BeanFactory {
    private static Map<String,Object> beanMap = new HashMap<>();

    public void registerBean(String name, Object bean){
        beanMap.put(name,bean);
    }

    public Object getBean(String name){
        return beanMap.get(name);
    }
}
