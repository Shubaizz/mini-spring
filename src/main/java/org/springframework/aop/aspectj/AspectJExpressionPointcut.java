package org.springframework.aop.aspectj;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: AspectJExpressionPointcut
 * Description:
 * <p>
 * Author: shubaizz
 * DateTime: 2025/9/24 13:29
 * Version: 1.0
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {

    private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<PointcutPrimitive>();

    static {
        // 表明该组件仅支持方法执行（method execution）类型的切点
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }

    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression) {
        // 主要作用是解析 AOP 中的切点表达式
        // SUPPORTED_PRIMITIVES：指定该解析器支持的切点类型集合 (这里仅验证execution类型)
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
        // 使用前面创建的PointcutParser实例解析字符串形式的切点表达式，生成可用于后续匹配操作的PointcutExpression对象
        pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }

    @Override
    public boolean matches(Class<?> clazz) {
        // 用于判断当前切点表达式是否有可能匹配指定类（clazz）中的任何连接点（Join Point）
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 用于精确判断某个方法是否完全匹配切点表达式的调用链
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }
}
