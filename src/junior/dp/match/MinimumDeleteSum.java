package junior.dp.match;

/**
 * 1076 · 两字符串ASCII的最小删除和
 * （匹配型DP）
 * 描述
 * 给定两个字符串s1，s2，找出最小的需要删除的字符ASCII之和，使得剩余两个字符串相等。
 *
 */
public class MinimumDeleteSum {

    /**
     * @param s1: a string
     * @param s2: a string
     * @return: the lowest ASCII sum of deleted characters to make two strings equal
     *
     * 转化成LCS问题。
     */
    public int minimumDeleteSum(String s1, String s2) {
        if (null == s1 || s1.length() == 0){
            return 0;
        }
        if (null == s2 || s2.length() == 0){
            return 0;
        }
        int N = s1.length();
        int M = s2.length();
        //前 i， j个字符 最长公共子序列的 ASCII的最大值。
        int[][] dp = new int[N+1][M+1];
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum += s1.charAt(i);
        }
        for (int j = 0; j < s2.length(); j++) {
            sum += s2.charAt(j);
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + s1.charAt(i-1), Math.max(dp[i-1][j], dp[i][j-1]));
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return sum - 2 * dp[N][M];
    }
}
