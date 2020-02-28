package tech.dzion.weaver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {WeaverApplication.class})// 指定启动类
class WeaverApplicationTests {

	@Autowired
	WeaverComponent component;

	@Test
	void contextLoads() {
	}

	@Test
	void testAspect() {
		component.returnOne(2);
		try {
			component.justThrow();
		} catch (Exception e) {
			//do nothing
		}
	}
}
