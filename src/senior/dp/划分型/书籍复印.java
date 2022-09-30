package senior.dp.划分型;

/**
 * 437 · 书籍复印
 *
 */
public class 书籍复印 {

    //K 个抄写员抄写 N本书
    public int copyBooks(int[] A, int K) {
        // write your code here
        int N = A.length;
        if (N == 0){
            return 0;
        }

        int[][] dp = new int[K + 1][N+1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int k = 1; k <= K; k++) {
            dp[k][0] = 0;

            for (int i = 1; i <= N ; i++) {

                dp[k][i] = Integer.MAX_VALUE;
                int s = 0;
                for (int j = i; j >= 0 ; j--) {
                    if (dp[k-1][j] != Integer.MAX_VALUE){
                        //最后一个 抄  j ~ i - 1本书耗时  s.
                        dp[k][i] = Math.min(dp[k][i], Math.max(dp[k-1][j], s));
                    }
                    if (j > 0){
                        s += A[j - 1];
                    }
                }
            }
        }
        return dp[K][N];
    }
}
