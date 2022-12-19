package DP.区间型;

/**
 * https://www.lintcode.com/course/42/learn/430?chapterId=307&sectionId=2299&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 430 · 攀爬字符串
 *
 * 描述
 * 给定一个字符串 s1, 将其递归地分割成两个非空子字符串, 然后可以得到一棵二叉树.
 *
 * 下面是 s1 = "great" 可能得到的一棵二叉树:
 *
 */
public class 攀爬字符串 {

    public boolean isScramble(String S, String T) {
        int n = S.length();
        int m = T.length();
        if (n != m){
            return false;
        }
        //f[i][j][k] i、j表示起始位置，k表示子串的长度。
        boolean[][][] f = new boolean[n][n][n+1];

        //初始化 f[i][j][1] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = S.charAt(i) == T.charAt(j);
            }
        }

        for (int len = 2; len <= n ; len++) {
            for (int i = 0; i <= n - len ; i++) {  // i...i + len - 1
                for (int j = 0; j <= n - len; j++) {// j... j + len - 1

                    //broke into S1 跟 S2.
                    // S1的 长度w, S2的长度 len-w.
                    for (int w = 1; w < len; w++) {
                        if (f[i][j][w] && f[i + w][j + w][len - w]) { // no swap
                            f[i][j][len] = true;
                            break;
                        }

                        if (f[i][j + len - w][w] && f[i + w][j][len - w]) {
                            f[i][j][len] = true;
                            break;
                        }
                    }

                }
            }
        }

        return f[0][0][n];
    }
}
