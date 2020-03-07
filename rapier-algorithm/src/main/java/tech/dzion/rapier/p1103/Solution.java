package tech.dzion.rapier.p1103;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/5 11:52
 * @Description TODO
 */
public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int curr = 1;
        int[] ret = new int[num_people];
        while (candies > curr) {
            ret[(curr-1)%num_people] += curr;
            candies -= curr;
            curr++;
        }
        ret[(curr-1)%num_people] += candies;
        return ret;
    }

    public static void main(String[] args) {
        for (int i : new Solution().distributeCandies(60, 4)) {
            System.out.print(i + "   ");
        }
    }
}
