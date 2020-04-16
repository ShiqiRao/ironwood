package top.lazyyy.sylla;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.lazyyy.bear.StarterService;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class Tester {

    @Autowired
    StarterService starterService;

    @Test
    public void testStarterService() {
        String[] ret = starterService.split("\\");
        System.out.println(Arrays.toString(ret));
    }

}
