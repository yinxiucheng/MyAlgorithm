package DP.区间型;

/**
 * 168. 吹气球
 * https://www.lintcode.com/course/42/learn/168/solution?chapterId=307&sectionId=1860&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A42%22%7D&ac=false
 * 
 * 
 */
public class 吹气球 {

    public int maxCoins(int[] AA) {
        int n = AA.length;
        if (n == 0) {
            return 0;
        }

        int i, j, k, len;
        int[] A = new int[n + 2];
        A[0] = A[n + 1] = 1;// 两端加哼哈二将。
        for (i = 0; i < n; i++) {
            A[i + 1] = AA[i];
        }

        n += 2;
        //f[i][j]表示 i..j 之间气球扎破， i， j是墙不能被扎破。
        int[][] f = new int[n][n];
        for ( i = 1; i < n ; i++) {//初始化，只有两个气球时没法扎破。
            f[i-1][i] = 0;
        }

        //区间型动态规划枚举len, j是计算出来的。
        for ( len = 3; len <= n; len++) {
            for (i = 0; i <= n - len ; i++) {
                j = i + len - 1;
                f[i][j] = 0;
                for ( k = i+1; k < j ; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }

        return f[0][n-1];
    }
}
