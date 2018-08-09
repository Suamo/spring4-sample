package ua.antonio.spring4sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ua.antonio.spring4sample.domain.AopBean;
import ua.antonio.spring4sample.domain.AopBeanImpl;

@Aspect
@Component
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

    @Around("execution(* ua.antonio.spring4sample.domain.AopBean.validateName())")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();

        target.addAction("Around Before");
        joinPoint.proceed();
        target.addAction("Around After");
    }


    @Pointcut(value = "execution(* ua.antonio.spring4sample.domain.AopBean.validateName())")
    private void validateName(){}
}