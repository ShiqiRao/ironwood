package tech.dzion.rapier.p009;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/25 22:18
 * @Description TODO
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        return isPalindrome(String.valueOf(x));
    }

    boolean isPalindrome(String s) {
        int l = Math.max(s.length() / 2 - 1,0);
        int r = s.length() - l - 1;
        while (s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            if (l < 0 || r >= s.length() ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1));
    }

}
