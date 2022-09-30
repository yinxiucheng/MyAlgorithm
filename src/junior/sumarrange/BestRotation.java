package junior.sumarrange;

public class BestRotation {
    /**
     * https://leetcode.cn/problems/smallest-rotation-with-highest-score/
     * 差分。
     *
     * @param nums
     * @return
     */
    public int bestRotation(int[] nums){
        int n = nums.length;
        int[] c = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = (i - (n - 1) + n) % n;
            int b = (i - nums[i] + n) % n;

            if (a <= b) {
                c[a] += 1;
                c[b + 1] -= 1;
            } else {
                c[0] += 1;
                c[b + 1] -= 1;
                c[a] += 1;
                c[n] -= 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            c[i] += c[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (c[i] > c[ans]) ans = i;
        }
        return ans;
    }
}
