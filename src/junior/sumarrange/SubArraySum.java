package junior.sumarrange;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 */
public class SubArraySum {

    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            int s = sum[i] , d = s - k;
            ans += map.getOrDefault(d, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return ans;
    }
}
