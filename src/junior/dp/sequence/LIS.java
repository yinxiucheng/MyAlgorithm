package junior.dp.sequence;

/**
 * 76 · 最长上升子序列
 * https://www.lintcode.com/problem/76/
 *
 * 描述
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 */
public class LIS {

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        // # state: dp[] 里存储以i结尾，最长的接龙值，初始为1，即为自己
        int[] dp = new int[n];

        // dp 初始化
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // dp function :  dp[i] = max{dp[j] + 1, dp[i]} 当 nums[j] < num[i];
                // dp 拆解
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        //dp 的答案求解
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
