package org.springframework.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.springframework.PointcutAdvisor;
import org.springframework.aop.Pointcut;

/**
 * ClassName: AspectJExpressionPointcutAdvisor
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/10/16 13:56
 * Version: 1.0
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
        pointcut = new AspectJExpressionPointcut(expression);
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
