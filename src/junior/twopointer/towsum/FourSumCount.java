package junior.twopointer.towsum;

import java.util.HashMap;

/**
 * 976 · 4数和 II
 * 描述
 * 给出 A, B, C, D 四个整数列表，计算有多少的tuple (i, j, k, l)满足A[i] + B[j] + C[k] + D[l]为 0。
 *
 * 为了简化问题，A, B, C, D 具有相同的长度，且长度N满足 0 ≤ N ≤ 500。所有的整数都在范围(-2^28, 2^28 - 1)内以及保证结果最多为2^31 - 1。
 *
 */
public class FourSumCount {
    /**
     * @param a: a list
     * @param b: a list
     * @param c: a list
     * @param d: a list
     * @return: how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero
     */
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = a[i] + b[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for (int l = 0; l < c.length; l++) {
            for (int k = 0; k < d.length; k++) {
                int sum = c[l] + d[k];
                ans += map.getOrDefault(-sum, 0);
            }
        }
        return ans;
    }
}
