package tech.dzion.weaver;

import org.springframework.stereotype.Component;

/**
 * @ClassName BaseController
 * @Author Rao Shiqi
 * @Date 2020/1/30 19:42
 * @Description TODO
 */
@Component
public class WeaverComponent {

    public int returnOne(int arg){
        return 1;
    }

    public void justThrow() throws Exception {
        throw new Exception();
    }

}
