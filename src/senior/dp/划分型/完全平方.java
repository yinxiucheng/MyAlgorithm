package senior.dp.划分型;

import java.util.Arrays;

/**
 * 513 · 完美平方
 * https://www.lintcode.com/problem/513/
 *
 * 描述
 * 给一个正整数 n, 请问最少多少个完全平方数(比如1, 4, 9...)的和等于n。
 *
 */
public class 完全平方 {

    public int numSquares(int n) {

        int[] f = new int[n + 1];//f[i] 和为i的 最少完全平方数的个数。
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; ++i) {
            f[i * i] = 1;
        }
        int i, j;
        for (i = 0; i <= n; i++) {
            for (j = 1; j * j <= i; j++) {
                f[i]= Math.min(f[i], f[i - j*j] + 1);
            }
        }
        return f[n];
    }
}
