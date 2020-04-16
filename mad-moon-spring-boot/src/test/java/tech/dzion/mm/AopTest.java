package tech.dzion.mm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.dzion.mm.aop.AnnotationParam;
import tech.dzion.mm.aop.AopComponent;
import tech.dzion.mm.aop.Param;

public class AopTest extends BaseTest {

    @Autowired
    AopComponent aopComponent;

    @Test
    public void testArgs(){
        aopComponent.doArgs(new Param());
        aopComponent.doArgs(new AnnotationParam());
    }

}
