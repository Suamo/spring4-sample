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

    @Around("validateName()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        AopBeanImpl target = (AopBeanImpl)joinPoint.getTarget();

        target.addAction("Around Before");
        joinPoint.proceed();
        target.addAction("Around After");
    }


    @Pointcut(value = "execution(* ua.antonio.bean.AopBean.validateName())")
    private void validateName(){}
}
