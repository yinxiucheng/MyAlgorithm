package senior.dp.划分型;

/**
 * 108 · 分割回文串（二）
 *
 * https://www.lintcode.com/problem/108/
 *
 *
 */
public class 分隔回文串2 {

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean[][] isPalindrome = getPalindrome(chars);
        int[] f = new int[n + 1];// f[i] 长度为i的子串最少包含多少个子串。

        f[0] = 0;
        for (int i = 1; i <= n ; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i-1]){
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n] - 1;//最后求的是划分多少次。
    }

    private boolean[][] getPalindrome(char[] chars){
        int len = chars.length;
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                isPalindrome[i][j] = false;
            }
        }

        int i, j, mid;
        for (mid = 0; mid < len; mid++) {
            i = j = mid;
            while (i>= 0 && j < len && chars[i] == chars[j]){
                isPalindrome[i][j] = true;
                i--;
                j++;
            }

            i = mid; j = mid + 1;
            while (i >= 0 && j < len && chars[i] == chars[j]){
                isPalindrome[i][j] = true;
                i--;
                j++;
            }
        }

        return isPalindrome;

    }
}
