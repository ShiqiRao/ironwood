package tech.dzion.mm;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @ClassName TestController
 * @Author Rao Shiqi
 * @Date 2020/2/22 16:23
 * @Description TODO
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/user")
    public Result<User> getUser(@ModelAttribute("userInfo") User user) {
        return new Result<User>().setValue(user).setCode(1);
    }

//    @PostMapping("/")
//    public Result<Date> getDate(@RequestBody BaseValueQuery<Date> query){
//
//    }

    @GetMapping("/str")
    public String getStr() {
        return "str";
    }


}
