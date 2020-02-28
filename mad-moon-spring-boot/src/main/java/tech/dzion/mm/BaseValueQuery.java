package tech.dzion.mm;

import lombok.Data;

/**
 * @ClassName BaseValue
 * @Author Rao Shiqi
 * @Date 2020/2/22 21:52
 * @Description TODO
 */
@Data
public class BaseValueQuery<T> {
    private T value;
}
