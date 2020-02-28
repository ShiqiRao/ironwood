package tech.dzion.mm;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName Result
 * @Author Rao Shiqi
 * @Date 2020/2/22 16:33
 * @Description TODO
 */
@Accessors(chain = true)
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T value;
}
