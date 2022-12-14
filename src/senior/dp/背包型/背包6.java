package senior.dp.背包型;

/**
 *
 * https://www.lintcode.com/course/42/learn/564?chapterId=306&sectionId=1814&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 564.背包6
 *
 * 描述
 * 给出一个都是正整数的数组 nums，其中没有重复的数。从中找出所有的和为 target 的组合个数。
 *
 * 输入: nums = [1, 2, 4] 和 target = 4
 * 输出: 6
 * 解释:
 * 可能的所有组合有：
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]
 *
 */
public class 背包6 {

    public int backPackVI(int[] nums, int target) {
        if (null == nums || nums.length == 0){
            return 0;
        }
        //dp[i]表示和为i的 组合次数。
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target ; i++) {
            dp[i] = 0;
            for (int j = 0; j < nums.length ; j++) {

                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
