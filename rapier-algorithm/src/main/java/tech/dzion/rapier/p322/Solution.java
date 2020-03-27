package tech.dzion.rapier.p322;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/8 14:23
 * @Description 动态规划 自上而下
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int amount, int[] state) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (state[amount - 1] != 0) {
            return state[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            int rest = coinChange(coins, amount - c, state);
            if (rest >= 0 && rest < min) {
                min = rest + 1;
            }
        }
        state[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return state[amount - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
    }
}