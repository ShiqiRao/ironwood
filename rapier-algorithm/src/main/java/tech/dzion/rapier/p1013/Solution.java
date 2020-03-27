package tech.dzion.rapier.p1013;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/11 22:01
 * @Description TODO
 */
public class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int group = sum / 3;
        int count = 0;
        int groupSum = 0;
        for (int i : A) {
            groupSum += i;
            if (groupSum == group) {
                count++;
                groupSum = 0;
            }
        }
        return count >= 3;
    }

    public static void main(String[] args) {
        new Solution().canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1});
    }
}
