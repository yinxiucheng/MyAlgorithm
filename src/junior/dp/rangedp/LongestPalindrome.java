package junior.dp.rangedp;

/**
 * 200 · 最长回文子串 (DP 区间动态规划)
 *
 * https://www.lintcode.com/problem/200/description
 *
 * 描述
 * 给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。
 *
 *
 */
public class LongestPalindrome {

    public String longestPalindrome(String s){
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();

        //# 区间(i, j) 是不是 Palindrome

        boolean[][] isPalindrome = new boolean[n][n];

        int longest = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            isPalindrome[i-1][i] = s.charAt(i-1)== s.charAt(i);
            if (isPalindrome[i-1][i]){
                start = i-1;
                longest = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                isPalindrome[i][j] = isPalindrome[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                if (isPalindrome[i][j]){
                    int temLen = j - i + 1;
                    if (temLen > longest){
                        longest = temLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + longest);
    }
}
