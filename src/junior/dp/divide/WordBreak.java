package junior.dp.divide;

import java.util.HashSet;
import java.util.Set;

/**
 * 107 · 单词拆分（一）
 * 划分型DP 实现。
 *
 * https://www.lintcode.com/problem/107/
 *
 * 描述
 * 给定字符串 s 和单词字典 dict，确定 s 是否可以分成一个或多个以空格分隔的子串，并且这些子串都在字典中存在。
 * 因为我们已经使用了更强大的数据，所以普通的DFS方法无法解决此题。
 *
 */
public class WordBreak {

    public static void main(String[] args) {
        String s = "a";
        Set<String> set = new HashSet<>();
        set.add("a");

        boolean result = wordBreak(s, set);
    }
    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public static boolean wordBreak(String s, Set<String> wordSet) {

        int n = s.length();

        //state : 前i 个字符是否能划分成 若干个单词。
        boolean[] dp = new boolean[n+1];
        dp[0]  = true;

        int maxLen = getMaxLength(wordSet);

        for (int i = 1; i <= n; i++) {
            dp[i] = false;
            for (int len = 1; len <= maxLen; len++) {
                if (i < len){
                    break;
                }
                int j = i - len;
                if (!dp[j]){
                    continue;
                }
                String substr = s.substring(j, i);
                dp[i] = dp[i] || wordSet.contains(substr);
                if (dp[i]){
                    break;
                }
            }
        }
        return dp[n];
    }

    private static int getMaxLength( Set<String> wordDict){
        int maxLength = Integer.MIN_VALUE;
        for (String str: wordDict) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }
}
