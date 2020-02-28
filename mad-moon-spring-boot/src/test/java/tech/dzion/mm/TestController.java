package tech.dzion.mm;

import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

/**
 * @ClassName TestController
 * @Author Rao Shiqi
 * @Date 2020/2/22 16:35
 * @Description TODO
 */
public class TestController extends BaseTest{

    @Test
    public void testUser() {
        get("/test/user").then().assertThat().body("value.name", equalTo("test"));
    }

}
