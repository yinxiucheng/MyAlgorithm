package junior.dp.sequence;

/**
 * 76 · 最长上升子序列
 * https://www.lintcode.com/problem/76/
 *
 * 描述
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 */
public class LISI {

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        // # state: list index 表示 接龙长度为 index对应的 龙，最后一个元素 == list[index]
        int[] list = new int[n + 1];

        list[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            list[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int index = firstGet(list, nums[i]);
            list[index] = nums[i];
        }

        for (int i = nums.length; i >= 1; i--) {
            if (list[i] != Integer.MAX_VALUE) {
                return i;
            }
        }

        return 0;
    }

    private int firstGet(int[] list, int target){
        int n = list.length;
        int left = 0, right = n - 1;
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (list[mid] >= target){// 右边兜底
                right = mid;
            }else {
                left = mid;
            }
        }
        if (list[left] == target){ //找第一个，左边
            return left;
        }
        return right;
    }
}
