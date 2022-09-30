package junior.twopointer.merge;

import java.util.Arrays;

/**
 *  64 · 合并排序数组（简单版）
 *
 *  描述
 * 合并两个排序的整数数组 A 和 B 变成一个新的数组。
 * 原地修改数组 A 把数组 B 合并到数组 A 的后面。
 *
 * 样例 1：
 *
 * 输入：
 *
 * A = [1,2,3]
 * m = 3
 * B = [4,5]
 * n = 2
 */
public class MergeSortedArray {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        for (int i = m + 1; i <= m + n; i++) {
            A[i] = B[i - m - 1];
        }
        Arrays.sort(A);
    }
}
