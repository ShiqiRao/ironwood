package tech.dzion.rapier.p014;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/27 22:08
 * @Description TODO
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(commonPrefix) != 0) {
                if (commonPrefix.length() == 0) {
                    break;
                }
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
