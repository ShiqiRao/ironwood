package tech.dzion.mm.aop;

import org.springframework.stereotype.Component;

@Component
public class AopComponent {

    public void doArgs(Param param){
        System.out.println("doArgs");
    }

    public void doArgs(AnnotationParam param){
        System.out.println("doAnnotationParam");
    }

}
