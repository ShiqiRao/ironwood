package tech.dzion.rapier.sw;

/**
 * @ClassName SomethingWrong
 * @Author Rao Shiqi
 * @Date 2020/3/2 17:25
 * @Description TODO
 */
public class SomethingWrong {

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }

    public static void main(String[] args){
        f();
    }

}
