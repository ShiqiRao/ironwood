package tech.dzion.rapier.p057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/6 23:31
 * @Description TODO
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ret = new ArrayList<>();
        int i = 1;
        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] arr = new int[i];
                for (int k = target / i, j = 0; j < i; j++, k++) {
                    arr[j] = k;
                }
                ret.add(arr);
            }
        }
        Collections.reverse(ret);
        return ret.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findContinuousSequence(10)));
    }
}
