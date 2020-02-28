package tech.dzion.mm;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName User
 * @Author Rao Shiqi
 * @Date 2020/2/22 16:16
 * @Description TODO
 */

@Accessors(chain = true)
@Data
public class User {

    private String name;

}
