package tech.dzion.rapier.p013;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/27 21:34
 * @Description TODO
 */
public class Solution {
    public int romanToInt(String s) {
        int ret = 0;
        int subI = 0;
        int subX = 0;
        int subC = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    ret += 1;
                    subI = 2;
                    break;
                case 'V':
                    ret += (5 - subI);
                    subI = 0;
                    break;
                case 'X':
                    ret += (10 - subI);
                    subI = 0;
                    subX = 2;
                    break;
                case 'L':
                    ret += (50 - 10 * subX);
                    subX = 0;
                    break;
                case 'C':
                    ret += (100 - 10 * subX);
                    subX = 0;
                    subC = 2;
                    break;
                case 'D':
                    ret += (500 - 100 * subC);
                    subC = 0;
                    break;
                case 'M':
                    ret += (1000 - 100 * subC);
                    subC = 0;
                    break;
                default:
                    break;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("IX"));
        System.out.println(new Solution().romanToInt("LVIII"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}
