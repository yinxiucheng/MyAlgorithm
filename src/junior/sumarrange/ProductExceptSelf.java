package junior.sumarrange;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len ; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        int[] R = new int[len];
        R[len - 1] = 1;
        for (int i = len-2; i >= 0 ; i--) {
            R[i] = R[i+1] * nums[i+1];
        }

        for (int i = 0; i < len; i++) {
            answer[i] = answer[i] * R[i];
        }
        return answer;
    }
}
