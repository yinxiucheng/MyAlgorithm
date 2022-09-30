package junior.sumarrange;

/**
 * https://leetcode.cn/problems/xor-queries-of-a-subarray/
 *
 */
public class XorQueries {

    public int[] xorQueries(int[] arr, int[][] qs) {
        int len = arr.length, m = qs.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len ; i++) {
            sum[i] = sum[i-1]^arr[i-1];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = qs[i][0] + 1;  int r = qs[i][1] + 1;
            ans[i] = sum[l - 1] ^ sum[r];
        }
        return ans;
    }
}
