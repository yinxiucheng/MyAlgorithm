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
public class 攀爬字符串DFS {

    String SS;
    String TT;
    boolean[][][] f;
    boolean[][][] done;

    private void cal(int i, int j, int len) {
        if (done[i][j][len]){
            return;
        }
        //初始化 f[i][j][1] = true;
        if (len == 1){
            f[i][j][len] = SS.charAt(i) == TT.charAt(j);
            return;
        }
        //broke into S1 跟 S2.
        // S1的 长度w, S2的长度 len-w.
        for (int w = 1; w < len; w++) {
            cal(i, j, w);
            cal(i+w, j+w, len - w);
            if (f[i][j][w] && f[i + w][j + w][len - w]) { // no swap
                f[i][j][len] = true;
                break;
            }

            cal(i, j + len - w, w);
            cal(i+w, j, len-w);
            if (f[i][j + len - w][w] && f[i + w][j][len - w]) {
                f[i][j][len] = true;
                break;
            }
        }
        done[i][j][len] = true;
    }

    public boolean isScramble(String S, String T) {
        SS = S;
        TT = T;
        int n = S.length();
        int m = T.length();
        if (n != m){
            return false;
        }
        //f[i][j][k] i、j表示起始位置，k表示子串的长度。
        f = new boolean[n][n][n+1];
        done = new boolean[n][n][n+1];

        //初始化down 值，还未计算过。
        for (int len = 1; len <= n ; len++) {
            for (int i = 0; i <= n - len ; i++) {  // i...i + len - 1
                for (int j = 0; j <= n - len; j++) {// j... j + len - 1
                    done[i][j][len] = false;
                }
            }
        }
        cal(0, 0, n);
        return f[0][0][n];
    }
}
