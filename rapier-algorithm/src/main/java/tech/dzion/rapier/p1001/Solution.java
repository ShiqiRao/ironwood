package tech.dzion.rapier.p1001;

/**
 * @ClassName Solition
 * @Author Rao Shiqi
 * @Date 2020/3/3 22:23
 * @Description TODO
 */
public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        if (B.length == 0) {
            return;
        }
        int curr = A.length - 1;
        m--;
        n--;
        while (curr >= 0) {
            if (n < 0 || (m >= 0 && A[m] > B[n])) {
                A[curr] = A[m];
                m--;
            } else {
                A[curr] = B[n];
                n--;
            }
            curr--;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 0};
        int m = 1;
        int[] b = new int[]{1};
        int n = 1;
        new Solution().merge(a, m, b, n);
    }
}
