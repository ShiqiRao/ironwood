package tech.dzion.rapier.p005;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/24 20:15
 * @Description TODO
 */
public class Solution {
    public static String longestPalindrome(String s) {
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = getString(s, i, i);
            ret = temp.length() > ret.length() ? temp : ret;
        }
        return ret;
    }

    private static String getString(String s, int l, int r) {
        if (l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) {
            return s.substring(l + 1, r);
        }
        int r2 = r + 1;
        while (r2 < s.length() && s.charAt(r2) == s.charAt(r)) {
            r2++;
        }
        return getString(s, l - 1, r2);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabaaaa"));
    }
}
