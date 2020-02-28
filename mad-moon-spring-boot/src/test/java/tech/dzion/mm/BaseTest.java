package tech.dzion.mm;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName BaseTest
 * @Author Rao Shiqi
 * @Date 2020/2/22 16:28
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MmApp.class})// 指定启动类
public class BaseTest {
}
