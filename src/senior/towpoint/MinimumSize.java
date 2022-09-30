package senior.towpoint;

/**
 * 406 · 和大于S的最小子数组
 *
 * https://www.lintcode.com/course/7/learn/406?chapterId=42&sectionId=2042&ac=false
 *
 * 描述
 * 给定一个由 n 个正整数组成的数组和一个正整数 s ，请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 -1。
 *
 *
 */
public class MinimumSize {

    //1. 求前缀和数组。
    //2. for i 循环，累加求和， 大于等于s, 打擂台记住 minLen.
    //3.
    public int minimumSize(int[] nums, int s) {
        int sum = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if (sum >= s){
                minLen = Math.min(minLen, j - i);
            }
            sum -= nums[i];
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

}
