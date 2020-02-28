package tech.dzion.weaver;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @ClassName WeaverAspect
 * @Author Rao Shiqi
 * @Date 2020/1/30 20:41
 * @Description TODO
 */
@Slf4j
@Aspect
@Component
public class WeaverAspect {

    @Pointcut("execution(public * tech.dzion.weaver.WeaverComponent.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("doBefore" + Arrays.toString(joinPoint.getArgs()));
    }

    @After("log()")
    public void doAfter() {
        log.info("doAfter");
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object ret = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("运行时间" + (end - start));
        log.info("运行结果" + ret.toString());
        return ret;
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void afterReturning(Object ret) {
        log.info("afterReturning" + ret.toString());
    }

    @AfterThrowing("log()")
    public void afterThrowing() {
        log.info("afterThrowing");
    }
}
