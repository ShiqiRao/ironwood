package tech.dzion.mm.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {


    @Pointcut("target(tech.dzion.mm.aop.AopComponent)  && args(tech.dzion.mm.aop.Param)")
    public void argsPoint(){}

    @Pointcut("target(tech.dzion.mm.aop.AopComponent)  && @args(tech.dzion.mm.aop.TestArg)")
    public void argsAnnotationPoint(){}

    @Before("argsPoint()")
    public void printArgs(){
        System.out.println("printArgs");
    }

    @Before("argsAnnotationPoint()")
    public void printAnnotationArgs(){
        System.out.println("printAnnotationArgs");
    }

}
