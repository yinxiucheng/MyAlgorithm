package senior.dp.双序列;

/**
 * 29.交叉字符
 *
 * https://www.lintcode.com/course/42/learn/29?chapterId=308&sectionId=1833&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 *
 */
public class 交叉字符 {

    public boolean isInterleave(String A, String B, String X) {
        int m = A.length();
        int n = B.length();
        if (m + n != X.length()){
            return false;
        }
        // f[s][i][j] X的前s个字符是由A的前i个，B的前j个字符组成的
        // s = i + j
        //降维 f[i][j] = f[i-1][j] And S[i+j-1] == A[i-1]  Or f[i][j-1] And S[i+j -1] == B[j-1]
        boolean[][] f = new boolean[2][n + 1];//
        f[0][0] = true;
        int old, now = 0;
        for (int i = 0; i <= m; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0){
                    f[now][j] = true;
                    continue;
                }

                f[now][j] = false;
                if (i > 0 && X.charAt(i+j-1) == A.charAt(i-1) && f[old][j]){
                    f[now][j] =  true;
                }

                if (j > 0 && X.charAt(i+j-1) == B.charAt(j-1) && f[now][j-1]){
                    f[now][j] =  true;
                }
            }
        }
        return f[now][n];
    }
}
