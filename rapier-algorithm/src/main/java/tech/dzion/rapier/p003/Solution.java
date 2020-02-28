package tech.dzion.rapier.p003;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/24 18:37
 * @Description TODO
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int tempCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Integer lastIndex = map.get(c);
            if (lastIndex == null) {
                map.put(c, i);
                tempCount++;
            } else {
                i = lastIndex;
                map.clear();
                tempCount = 0;
            }
            maxCount = Math.max(tempCount, maxCount);
        }
        return maxCount;
    }

    public static int lengthOfLongestSubstringWithArray(String s) {
        int maxCount = 0;
        Integer[] intArr = new Integer[128];
        char[] arr = s.toCharArray();
        for (int i = 0, j = 0; i < arr.length; i++) {
            char c = arr[i];
            Integer lastIndex = intArr[c];
            if (lastIndex != null) {
                j = Math.max(lastIndex + 1, j);
            }
            intArr[c] = i;
            maxCount = Math.max(i - j + 1, maxCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringWithArray("abba"));
    }

}