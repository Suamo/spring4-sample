package ua.antonio.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import ua.antonio.bean.AopBeanImpl;

@Aspect
public class AopBeanAspect {

    @Before("validateName()")
    public void before(JoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();
        target.addAction("Before");
    }

    @After("validateName()")
    public void after(JoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();
        target.addAction("After");
    }

    @AfterReturning("validateName()")
    public void afterReturning(JoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();
        target.addAction("After Returning");
    }

    @Around("validateName()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();

        target.addAction("Around Before");
        joinPoint.proceed();
        target.addAction("Around After");
    }

    @Before("callMethodWithException()")
    public void beforeException(JoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();
        target.addAction("Before");
    }

    @After("callMethodWithException()")
    public void afterException(JoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();
        target.addAction("After");
    }

    @Around("callMethodWithException()")
    public void aroundException(ProceedingJoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();

        target.addAction("Around Before");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            target.addAction("Around After (Exception caught)");
            return;
        }
        target.addAction("Around After");
    }

    @AfterReturning("callMethodWithException()")
    public void afterReturningException(JoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();

        target.addAction("After Returning");
    }

    @AfterThrowing("callMethodWithException()")
    public void afterThrowingException(JoinPoint joinPoint) {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();
        target.addAction("After Throwing");
    }

    @Pointcut(value = "execution(* ua.antonio.bean.AopBean.callMethodWithException())")
    private void callMethodWithException(){}

    @Pointcut(value = "execution(* ua.antonio.bean.AopBean.validateName())")
    private void validateName(){}

}
