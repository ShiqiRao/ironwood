package tech.dzion.rapier.p322;

import java.util.Arrays;

/**
 * @ClassName Solution1
 * @Author Rao Shiqi
 * @Date 2020/3/8 15:09
 * @Description 动态规划 自下而上
 */
public class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] state = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(state, max);
        state[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    state[i] = Math.min(state[i], state[i - coin] + 1);
                }
            }
        }
        return state[amount] > amount ? -1 : state[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().coinChange(new int[]{1, 2, 5}, 11));
    }
}
