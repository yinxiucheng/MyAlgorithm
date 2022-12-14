package DP;

/**
 * https://www.lintcode.com/course/42/learn/92?chapterId=306&sectionId=1816&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 *描述
 * 在 n 个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A_{i}A
 * i
 * ​
 *
 * （每个物品只能选择一次且物品大小均为正整数）
 *
 */
public class 背包问题 {

    public int backPack(int m, int[] A) {
        if (null == A || A.length == 0){
            return 0;
        }
        int len = A.length;

        //dp[i][j] 表示前 i 个物品能否组成j 大小
        boolean[][] dp = new boolean[len + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = false;
        }
        dp[0][0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - A[i-1] >= 0){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                }
            }
        }

        int result = 0;
        for (int i = m; i >= 0 ; i--) {
            if (dp[len][i]){
                result = i;
                break;
            }
        }
        return result;
    }
}
