package org.springframework.aop;

/**
 * ClassName: TargetSource
 * Description: 被代理的目标对象
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:42
 * Version: 1.0
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
