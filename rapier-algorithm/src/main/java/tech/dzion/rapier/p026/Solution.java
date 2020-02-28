package tech.dzion.rapier.p026;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/2/28 18:43
 * @Description TODO
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int l = 0;
        for(int r = 1;r<nums.length;r++){
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }

    private void move(int[] arr, int index) {
        while (index < arr.length - 1) {
            arr[index] = arr[index + 1];
            index++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
