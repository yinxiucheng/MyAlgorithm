package junior.dp.rangedp;

/**
 * 168 · 吹气球
 *
 * https://www.lintcode.com/problem/168/?fromId=161&_from=collection
 *
 * 描述
 * 有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。每次吹气球i可以得到的分数为 nums[left] * nums[i] * nums[right]，
 * left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。要求吹爆所有气球，得到最多的分数。
 */
public class MaxCoins {

    public int maxCoins(int[] nums) {
        if (null == nums || nums.length == 0){
            return 0;
        }
        int[] A = new int[nums.length + 2];
        int n = A.length;
        A[0] = A[n - 1] = 1;

        for (int i = 0; i < nums.length; i++) {
            A[i + 1] = nums[i];
        }

        // dp state :  吹爆 (i, j) 间气球 得分 最大值。
        int[][] dp = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = 0;
        }

        for (int len = 3; len <= n ; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                //最后一个吹爆 K号气球的 值。
                dp[i][j] = 0;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] +  A[i] * A[k] * A[j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
