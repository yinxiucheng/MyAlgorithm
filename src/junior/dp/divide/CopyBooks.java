package junior.dp.divide;

/**
 * 437 · 书籍复印
 *
 * 划分型DP
 *
 * https://www.lintcode.com/problem/437/
 *
 * 描述
 * 给定n本书，第i本书有pages[i]页。有k个人来抄这些书。
 *
 * 这些书排成一行，每个人都可以索取连续一段的书。例如，一个抄书人可以连续地将书从第i册复制到第j册，但是他不能复制第1册、第2册和第4册（没有第3册）。
 *
 * 他们在同一时间开始抄书，每抄一页书都要花1分钟。为了让最慢的抄书人能在最早的时间完成书的分配，最好的策略是什么？
 *
 * 请返回最慢抄书人花费的最短时间。
 *
 *
 */
public class CopyBooks {

    public int copyBooks(int[] pages, int k) {

        int n = pages.length;

        int[] preSum = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            preSum[i] = preSum[i-1] + pages[i-1];
        }
        //dp state: 前i本书分给j个人去 抄写，最好需要多少时间。
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {//i本书给 0个人去抄，一辈子都抄不完。
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= k ; j++) {
            dp[0][j] = 0;//0本书给 j 个人去抄写，花费0的时间。
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= k ; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int pre = 0; pre < i; pre++) {
                    int cost = preSum[i] - preSum[pre];//最后一个人抄的时间。
                    //最后一个人花费 cost， 前j-1个人（0，1，2。。。pre)本书的 cost，两者取最大值。
                    int curMaxCost = Math.max(dp[pre][j-1], cost);
                    dp[i][j] = Math.min(dp[i][j], curMaxCost);
                }
            }
        }
        return dp[n][k];
    }
}
