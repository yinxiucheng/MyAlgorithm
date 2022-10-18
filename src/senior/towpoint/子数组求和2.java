package senior.towpoint;

/**
 * 404 · 子数组求和 II
 *
 * https://www.lintcode.com/problem/404/?fromId=178&_from=collection
 *
 *描述
 * 给定一个正整数数组 A 和一个区间. 返回和在给定区间范围内的子数组数量.
 *
 * 输入: A = [1, 2, 3, 4], start = 1, end = 3
 * 输出: 4
 * 解释: 所有可能的子数组: [1](和为1), [1, 2](和为3), [2](和为2), [3](和为3).
 *
 */
public class 子数组求和2 {

    public int subarraySumII(int[] A, int start, int end) {
        int len = A.length;
        int[] prefixSum = new int[len + 1];

        for (int i = 1; i <= len ; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i-1];
        }

        int count = 0;
        for (int i = 0; i <= len ; i++) {
            int j = i + 1;
            while (j <= len && prefixSum[j] - prefixSum[i] <= end){
                if (prefixSum[j] - prefixSum[i] >= start){
                    count++;
                }
                j++;
            }
        }
        return count;
    }
}
