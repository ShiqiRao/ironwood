package tech.dzion.mm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName GlobalHandler
 * @Author Rao Shiqi
 * @Date 2020/2/22 16:09
 * @Description TODO
 */
@Slf4j
@RestControllerAdvice
public class GlobalHandler {

    @ModelAttribute("userInfo")
    public User userInfo() {
        return new User().setName("test");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @ExceptionHandler(Exception.class)
    public Result<Boolean> exceptionHandler(Exception e) {
        log.error("application error", e);
        return new Result<Boolean>().setCode(-1).setMsg("网络繁忙,请稍后再试").setValue(false);
    }


}
