package tech.dzion.rapier.p038;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/2 22:26
 * @Description TODO
 */
public class Solution {
    public String countAndSay(int n) {
        return f(String.valueOf(1), 1, n);
    }

    private String f(String s, int tick, int limit) {
        String ret;
        if (!"1".equals(s) || tick != 1) {
            StringBuilder sb = new StringBuilder();
            char temp = s.charAt(0);
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == temp) {
                    counter++;
                } else {
                    sb.append(counter).append(temp);
                    temp = s.charAt(i);
                    counter = 1;
                }
            }
            sb.append(counter).append(temp);
            ret = sb.toString();
        } else {
            ret = "1";
        }
        if (tick == limit) {
            return ret;
        }
        return f(ret, tick + 1, limit);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(new Solution().countAndSay(i));
        }
    }

}
