package onehundred;

/**
 * https://www.lintcode.com/problem/1835/description?fromId=164&_from=collection
 *
 *  有一个长度为 arrLenarrLen 的数组，开始有一个指针在索引 00 处
 */
public class 停在原地的方案数1 {

    public int numWays(int steps, int arrLen) {
        return dfs(steps, arrLen, 0);
    }

    private int dfs(int left, int arrLen, int cur) {
        //length is arrLen, so the last index is arrLen - 1;
        if (cur >= arrLen || cur < 0){
            return 0;
        }

        if (left == 0){
            if (cur == 0) return 1;
            return 0;
        }
        if (cur > left) return 0;//剪枝，回不去了。

        //向左，向右、不动。
        return dfs(left-1, arrLen, cur + 1) + dfs(left - 1, arrLen,  cur) + dfs(left -1, arrLen, cur - 1);
    }
    private int SIZE = 1000000007;
    public int numWays1(int steps, int arrLen) {

        //dp[i][j] 第i步 停留在 j处的方案总数。
        int[][] dp = new int[2][arrLen];
        arrLen = Math.min(steps, arrLen - 1);

        dp[0][0] = 1;//
        for (int i = 1; i <= steps ; i++) {
            for (int j = 0; j <= arrLen; j++) {
                dp[i%2][j] = dp[(i-1)%2][j];
                if (j > 0){
                    dp[i%2][j] += dp[(i-1)%2][j-1]%SIZE;
                }

                if (j < arrLen){
                    dp[i%2][j] += dp[(i-1)%2][j+1]%SIZE;
                }
            }
        }
        return dp[steps%2][0]%SIZE;//最后求停留在 0处的方案总数。
    }
}
