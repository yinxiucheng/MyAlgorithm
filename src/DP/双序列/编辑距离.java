package DP.双序列;

/**
 *  LintCode 119
 *
 *  最小编辑距离： Google 搜索条， 人工智能。
 *
 */
public class 编辑距离 {
    // 操作的动作很多，删除、添加、update.
    // 情况一： A在最后插入B[n-1]
    // case2: 替换
    // case3: 删掉，再说
    // case4: A、B最后相等。

    // 初始条件: f[i][0] = i;   f[0][j] = j;

    public int minDistance(String word1, String word2) {
        char[] A = word1.toCharArray();
        char[] B = word2.toCharArray();
        int n = A.length;
        int m = B.length;

        //dp[i][j] A的前i个字符转化成B的前 j个字符的最小编辑距离
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0){
                    dp[i][j] = j;
                    continue;
                }

                if (j == 0){
                    dp[i][j] = i;
                    continue;
                }
                //dp[i][j-1]: A 新增一个跟B最后一匹配。编辑距离 + 1
                //dp[i-1][j]: A 删除一个跟B 匹配。编辑距离 + 1
                //dp[i-1][j-1]: A 替换最后一个字符与 B匹配。 编辑距离 + 1
                dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;

                if (A[i-1] == B[j-1]){//最后一位相等时，免费的午餐。
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

}
