package tech.dzion.rapier.p1071;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/12 20:02
 * @Description TODO
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int length = Math.max(str1.length(), str2.length());
        while (length > 0) {
            if (str1.length() % length == 0 && str2.length() % length == 0) {
                break;
            }
            length--;
        }
        if (length == 0) {
            return "";
        }
        String ret = str1.substring(0, length);
        for (int i = 0; i < ret.length(); i++) {
            int indexStr1 = i + length;
            int indexStr2 = i + length;
            while (indexStr1 < str1.length()) {
                if (str1.charAt(indexStr1) != ret.charAt(i)) {
                    return "";
                }
                indexStr1 += length;
            }
            while (indexStr2 < str2.length()) {
                if (str2.charAt(indexStr1) != ret.charAt(i)) {
                    return "";
                }
                indexStr2 += length;
            }
        }
        return ret;
    }
}
