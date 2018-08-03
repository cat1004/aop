package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : chenpeng
 * @date : 2018-07-25 09:47 此aop 用于检测用户输入的信息 是否满足3的条件.针对所有持有add 的方式进行增强 但不够灵活
 *
 * Proceedingjoinpoint 继承了 JoinPoint 。是在JoinPoint的基础上暴露出 proceed 这个方法。
 * proceed很重要，这个是aop代理链执行的方法。暴露出这个方法，就能支持 aop:around 这种切面 （而其他的几种切面只需要用到JoinPoint，这跟切面类型有关），
 * 能决定是否走代理链还是走自己拦截的其他逻辑。 建议看一下 JdkDynamicAopProxy的invoke方法，了解一下代理链的执行原理。这样你就能明白 proceed方法的重要性。
 *
 * Proceedingjoinpoint 继承了 JoinPoint 。是在JoinPoint的基础上暴露出 proceed 这个方法。
 * proceed很重要，这个是aop代理链执行的方法。暴露出这个方法，就能支持 aop:around 这种切面 （而其他的几种切面只需要用到JoinPoint，这跟切面类型有关），
 * 能决定是否走代理链还是走自己拦截的其他逻辑。 建议看一下 JdkDynamicAopProxy的invoke方法，了解一下代理链的执行原理。这样你就能明白 proceed方法的重要性。
 */

/**
 * Proceedingjoinpoint 继承了 JoinPoint 。是在JoinPoint的基础上暴露出 proceed 这个方法。
 * proceed很重要，这个是aop代理链执行的方法。暴露出这个方法，就能支持 aop:around 这种切面
 * （而其他的几种切面只需要用到JoinPoint，这跟切面类型有关）， 能决定是否走代理链还是走自己拦截的其他逻辑。
 * 建议看一下 JdkDynamicAopProxy的invoke方法，了解一下代理链的执行原理。这样你就能明白 proceed方法的重要性。
 */

/**
 * 实际开发中我们可以将"execution(public * com.example.demo.controller.HelloController.add*(..)) && @annotation(com.example.demo.controller.MyAnnotation)
 * "改为"execution(public * com.example.demo.controller.*.*(..)) && @annotation(com.example.demo.controller.MyAnnotation)"，
 * 这样在controller包下，只有我们加上@MyAnnotation注解的方法切面方法才会起作用。 */
@Aspect
@Component
public class MyAOP {

    //@Pointcut("execution(public * com.example.aop.HomeController.add*(..))")  //检测所有在本包下 持有add 前缀的方法
    //本方法更加灵活针对想要实现的方法 进行自定义的增强进行
    @Pointcut("execution(public * com.example.aop.HomeController.add*.*(..)) && @annotation(com.example.aop.MyAnnotation)")
    public void addAdvice() {
    }

    @Around("addAdvice()")  //此为环绕通知
    //ProceedingJoinPoint  获取当前的方法
    public Object Interfacten(ProceedingJoinPoint pjp) {
        Object result = null;
        Object[] args = pjp.getArgs();
        if (args != null && args.length > 0) {
            String deviceId = (String) args[0];
            if (!"3".equals(deviceId)) {
                return "no anthorization";
            }
        }
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }
}
