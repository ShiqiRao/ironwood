package tech.dzion.rapier.p007;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/25 21:34
 * @Description TODO
 */
public class Solution {
    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
        if(x < 0){
            return 0;
        }
        long ret = getRet(0, x);
        if (ret > Integer.MAX_VALUE || (ret == Integer.MAX_VALUE && negative)) {
            return 0;
        }
        return (int) (negative ? -ret : ret);
    }

    static long getRet(long y, int x) {
        if (x < 10) {
            return y + x % 10;
        }
        return getRet(10 * (y + x % 10), x / 10);
    }

    public static void main(String[] args) {
        System.out.println(reverse(2147483647));
    }
}
