package senior.dp.背包型;


/**
 * 588 · 划分和相等的子集
 *
 * https://www.lintcode.com/problem/588/?showListFe=true&page=1&problemTypeId=2&tagIds=400&pageSize=50
 *
 * 描述
 * 给一 只含有正整数 的 非空 数组, 找到这个数组是否可以划分为 两个 元素和相等的子集。
 *
 */
public class 划分和相等的子集 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[len + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j <= target ; j++) {
                dp[i][j] = dp[i-1][j];//第i个数不取是否可以组成 j;
                if (j >= nums[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[len][target];
    }
}
