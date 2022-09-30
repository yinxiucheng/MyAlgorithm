package junior.sumarrange;

/**
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 *
 */
public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        char[] csn = s.toCharArray();
        int n = csn.length, ans = n;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            sum[i] = sum[i - 1] + (csn[i - 1] - '0');
        }

        for (int i = 1; i <= n ; i++) {
            int l = sum[i - 1], r = (n - i) - (sum[n] - sum[i]);
            ans = Math.min(ans, l + r);
        }

        return ans;
    }
}
