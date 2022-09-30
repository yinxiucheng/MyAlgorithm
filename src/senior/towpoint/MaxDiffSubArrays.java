package senior.towpoint;

/**
 * 45 · 最大子数组差
 * https://www.lintcode.com/problem/45/?fromId=164&_from=collection
 *
 * 描述
 * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|∣SUM(A)−SUM(B)∣最大。返回这个最大的差值。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 * 数组 = [1, 2, -3, 1]
 * 输出：
 *
 * 6
 * 解释：
 * 子数组是 [1,2] 和[-3].所以答案是 6.
 *
 */
public class MaxDiffSubArrays {

    public static void main(String[] args) {
        int[] nums =   {0,-2,0,-3,-4,0,0,0};
        int result =  maxDiffSubArrays(nums);
        System.out.println("the result is "+ result);
//        int[] subNums = {-4, 5,-4, 5, -4, 5, -4, 5,-4, 5,-4, 5,-4,5,-4,5,-4,5};
//        int resultLeft = getMaxRangeSum(nums, 0, nums.length - 2);
//        int resultRight = getMaxRangeSum(nums, nums.length -1, nums.length - 1);
//        int result = maxDiffSubArrays2(nums);
//        System.out.println("the result is "+ resultLeft + " rightResult " + resultRight);
    }

    public static int maxDiffSubArrays(int[] nums) {
        //隔板法，左右隔开，一个求区间和最大，一个求区间和最小。
        if (nums.length <= 1){
            return 0;
        }
        if (nums.length == 2){
            return computeResult(nums[0], nums[1]);
        }
        int result = 0;
        for (int i = 1; i < nums.length - 1; i++) { //[0, i] [i+1, nums.length - 1]
            int maxSum = getMaxRangeSum(nums, 0, i);
            int minSum = getMinRangeSum(nums, i + 1, nums.length - 1);
//            System.out.println("the result is "+ result + ", " + "minSum :" + minSum + "  maxSum:" + maxSum);
            result = Math.max(result, computeResult(maxSum, minSum));
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int minSum = getMinRangeSum(nums, 0, i);
            int maxSum = getMaxRangeSum(nums, i + 1, nums.length - 1);
//            System.out.println("the result is "+ result + ", " + "minSum :" + minSum + "  maxSum:" + maxSum);
            result = Math.max(result, computeResult(maxSum, minSum));
        }

        return result;
    }

    private static int computeResult(int maxSum, int minSum) {
        return Math.abs(maxSum - minSum);
    }


    //闭区间: [start, end]
    private static int getMaxRangeSum(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        int n = dp.length;
        dp[0] = nums[start];
        int max = dp[0];
        int ma = dp[0];
        for (int i = 1; i < n; i++) {
            ma = Math.max(nums[i], ma + nums[i]);
            max = Math.max(max, ma);
        }
       return  max;
    }

    //闭区间: [start, end]
    private static int getMinRangeSum(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        int n = dp.length;
        dp[0] = nums[start];
        int min = dp[0];
        int ma = dp[0];
        for (int i = 1; i < n; i++) {
            ma = Math.min(nums[i], ma + nums[i]);
            min = Math.min(min, ma);
        }
        return  min;
    }
}
