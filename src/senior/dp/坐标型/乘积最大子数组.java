package senior.dp.坐标型;

/**
 * 191 · 乘积最大子数组
 *
 * https://www.lintcode.com/course/42/learn/191?chapterId=303&sectionId=1764&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 找出一个整数数组 nums 中乘积最大的非空连续子数组（至少包含一个数）。
 */
public class 乘积最大子数组 {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = min[0] = nums[0];

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            res = Math.max(max[i], res);
        }
        return res == Integer.MIN_VALUE? -1 : res;
    }
}
