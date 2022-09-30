package junior.presum;

import java.util.HashMap;

/**
 * 405 · 和为零的子矩阵
 *
 * https://www.lintcode.com/problem/405/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个整数矩阵，请找出一个子矩阵，使得其数字之和等于0.输出答案时，请返回左上数字和右下数字的坐标。
 *
 * 如果有多个答案, 你可以返回其中任意一个.
 *
 *
 * 输入:
 * [
 *   [1, 5, 7],
 *   [3, 7, -8],
 *   [4, -8 ,9]
 * ]
 * 输出: [[1, 1], [2, 2]]
 *
 * O(n3) 时间复杂度。
 *
 */
public class SubmatrixSum {

    /**
     *  二维矩阵上的前缀和 标准做法，
     *  求解子矩阵 和 为0， 求子矩阵的坐标。
     *
     * @param matrix
     * @return
     */
    public int[][] submatrixSum(int[][] matrix) {
        int[][] result = new int[2][2];
        int N = matrix.length;
        if (N == 0) return result;
        int M = matrix[0].length;
        if (M == 0) return result;

        int[][] sum = new int[N+1][M+1];
        for (int i = 0; i <= N; i++) {
            sum[i][0] = 0;
        }
        for (int j = 0; j <= M ; j++) {
            sum[0][j] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] + matrix[i][j] - sum[i][j];
            }
        }

        for (int l = 0; l < N; l++) {
            for (int h = l+1; h <= N; h++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j <= M; j++) {
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = l;
                        result[0][1] = k;
                        result[1][0] = h - 1;//注意这里要减1. 跟一维的 preSum 一样， preSum[j+1] - preSum[i] 表示（i， j）的区间和。
                        result[1][1] = j - 1;
                        return result;
                    }else {
                        map.put(diff, j);
                    }
                }
            }
        }
        return  result;
    }
}
