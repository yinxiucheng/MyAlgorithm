package senior.dp.序列型;

/**
 * 843 · 数字翻转
 * https://www.lintcode.com/course/42/learn/843?chapterId=305&sectionId=1796&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 给定一个01构成的数组。你可以翻转1变成0或者反转0变成1。
 *
 * 请问最少反转多少次可以使得数组满足以下规则：
 *
 * 1的后面可以是1或者0，而0的后面必须是0。
 */
public class 数字翻转 {

    public int flipDigit(int[] A) {
        if (null == A || A.length == 0){
            return 0;
        }

        int len = A.length;
        //dp[i][j] 表示 前i个 字符 最后一个字符为 j 的情况下的最小翻转次数。
        int[][] dp = new int[len + 1][2];
        dp[0][0] = dp[0][1] = 0;

        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int t = 0;
                if (A[i-1] != j){
                    t = 1;//需要翻转
                }

                for (int k = 0; k < 2; k++) {
                    if (k == 0 && j == 1){
                        continue;//不满足条件 (01)
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + t);
                }
            }
        }

        return Math.min(dp[len][0], dp[len][1]);
    }
}
