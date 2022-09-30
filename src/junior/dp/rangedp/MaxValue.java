package junior.dp.rangedp;

/**
 * 719 · 计算最大值
 * https://www.lintcode.com/problem/719
 *
 * 描述
 * 给一个字符串类型的数字, 写一个方法去找到从前往后逐个计算的最大值, 你可以在两个数字间加 + 或 *
 *
 */
public class MaxValue {

    public static void main(String[] args) {
        String test = "01231";
        int result = calcMaxValue(test);
    }
    public static int calcMaxValue(String str) {
        if (null == str || str.length() == 0){
            return 0;
        }

        int n = str.length();
        // dp state : 表示（0，i)范围 内添加  + 或者 * 能获取的最大值。
        int[] dp = new int[n];
        int val0 = str.charAt(0) - '0';
        dp[0] = val0;

        for (int i = 1; i < n; i++) {
            int val = str.charAt(i) - '0';
            dp[i] = Math.max(dp[i - 1] + val, dp[i - 1]  * val);
        }
        return dp[n-1];
    }
}
