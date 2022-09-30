package junior.dp.match;

/**
 * 119 · 编辑距离
 *
 * https://www.lintcode.com/problem/119/
 *
 * 描述
 * 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
 * 你可进行三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // dp state ： word1前缀为i个字符 转为 word2前缀为j的最少编辑次数。
        int[][] dp = new int[n+1][m+1];

        dp[0][0] = 0;
        for (int i = 1; i <= n ; i++) {//需要将 word1 delete i 次 到""空串为止
            dp[i][0] = i;
        }

        for (int j = 1; j <= m ; j++) {//需要将""串一次添加 j 个字符跟 word2 的subString(0,j) till equals.
            dp[0][j] = j;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    //dp[i-1][j]: word1 删掉 前 i个字符的最后一个，然后跟 word2的 前j 个字符去匹配
                    //dp[i][j-1]: word1 增加一个字符跟 word2的前j 个字符去匹配。
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
                }else {
                    dp[i][j] = dp[i-1][j-1];// 最后一个字符相等时，编辑次数为0 所有 = dp[i-1][j-1] + 0;
                }
            }
        }

        return dp[n][m];
    }

}
