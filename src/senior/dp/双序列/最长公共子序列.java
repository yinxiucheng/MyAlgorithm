package senior.dp.双序列;

/**
 * 77.最长公共子序列
 * https://www.lintcode.com/course/42/learn/77?chapterId=308&sectionId=2300&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 *
 * 描述
 * 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。
 */
public class 最长公共子序列 {

    public int longestCommonSubsequence(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0){
                    f[i][j] = 0;
                }
                if (i > 0){
                    f[i][j] = f[i-1][j];
                }

                if (j > 0){
                    f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                }

                if (i > 0 && j > 0 && A.charAt(i-1) == B.charAt(j-1)){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }

            }

        }
        return f[m][n];
    }
}
