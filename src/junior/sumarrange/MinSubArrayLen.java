package junior.sumarrange;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = n + 10;
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int s = sum[i], d = s - target;
            int l = 0, r = i;
            while (l + 1 < r) {
                int mid = l + (r - l)/2 ;
                if(sum[mid] <= d) l = mid;
                else r = mid;
            }

            if (sum[r] <= d) ans = Math.min(ans, i - r);
            else if (sum[l] <= d) ans = Math.min(ans, i - l);
        }
        return ans == n + 10 ? 0 : ans;
    }
}
