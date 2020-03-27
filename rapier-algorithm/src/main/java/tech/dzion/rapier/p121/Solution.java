package tech.dzion.rapier.p121;

/**
 * @ClassName Solution
 * @Author Rao Shiqi
 * @Date 2020/3/9 22:28
 * @Description TODO
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > ret) {
                ret = price - minPrice;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{2, 1, 2, 1, 0, 1, 2}));
    }
}
