package ua.antonio.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import ua.antonio.bean.AopBeanImpl;

@Aspect
public class AopPointcutsBeanAspect {

    @Before("execution(* ua.antonio.bean.AopBean.checkPointcut(..))")
    public void executionByFullReferencePointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "executionByFullReferencePointcut");
    }

    @Before("execution(* *..checkPointcut(..))")
    public void executionByMethodNamePointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "executionByMethodNamePointcut");
    }

    @Before("execution(* *..checkPointcut(..,java.lang.Long,..))")
    public void executionByAllArgumentsPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "executionByAllArgumentsPointcut");
    }

    @Before("execution(* *..checkPointcut(int,java.lang.Long,java.util.Date))")
    public void executionByFirstArgumentPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "executionByFirstArgumentPointcut");
    }

    @Before("within(ua.antonio.bean.AopBeanImpl)")
    public void withinPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "withinPointcut");
    }

    @Before("target(ua.antonio.bean.AopBeanImpl)")
    public void targetPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "targetPointcut");
    }

    @Before("this(ua.antonio.bean.AopBean)")
    public void thisPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "thisPointcut");
    }

    @Before("@target(ua.antonio.bean.MyCustomClassAnnotation)")
    public void targetAnnotatedPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "targetAnnotatedPointcut");
    }

    @Before("@annotation(ua.antonio.bean.MyCustomMethodAnnotation)")
    public void annotatedPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "annotatedPointcut");
    }

    @Before("@annotation(ua.antonio.bean.MyCustomMethodAnnotation) && @target(ua.antonio.bean.MyCustomClassAnnotation)")
    public void andPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "andPointcut");
    }

    @Before("@annotation(org.junit.Test) || @annotation(ua.antonio.bean.MyCustomMethodAnnotation)")
    public void orPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "orPointcut");
    }

    @Before("!@annotation(org.junit.Test) && @annotation(ua.antonio.bean.MyCustomMethodAnnotation)")
    public void notPointcut(JoinPoint joinPoint) {
        tickPointcut(joinPoint, "notPointcut");
    }

    private void tickPointcut(JoinPoint joinPoint, String pointcut) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();
        target.addAction(pointcut);
    }
}
