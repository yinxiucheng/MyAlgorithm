package senior.dp.坐标型;

/**
 * 76.
 */
public class 最长上升子序列 {
    public int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, f[i]);
        }

        return max;
    }
}
