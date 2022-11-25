package senior.dp.坐标型;

/**
 * 553 · 炸弹袭击
 *
 * https://www.lintcode.com/problem/553/description
 *
 */
public class 炸弹袭击 {

    public int maxKilledEnemies(char[][] A) {
       if (null == A || A.length == 0 || A[0].length == 0){
           return 0;
       }
        int n = A.length;
        int m = A[0].length;

        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        int[][] left = new int[n][m];
        int[][] right = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                up[i][j] = 0;
                if (A[i][j] != 'W'){
                    if (A[i][j] == 'E') {
                        ++up[i][j];
                    }
                    if (i > 0){
                        up[i][j] += up[i-1][j];
                    }
                }
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                down[i][j] = 0;
                if (A[i][j] != 'W'){
                    if (A[i][j] == 'E') {
                        ++down[i][j];
                    }
                    if (i < n - 1){
                        down[i][j] += down[i+1][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                left[i][j] = 0;
                if (A[i][j] != 'W'){
                    if (A[i][j] == 'E') {
                        ++left[i][j];
                    }
                    if (j - 1 >= 0){
                        left[i][j] += left[i][j-1];
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >= 0; j--) {
                right[i][j] = 0;
                if (A[i][j] != 'W'){
                    if (A[i][j] == 'E') {
                        ++right[i][j];
                    }
                    if (j + 1 < m){
                        right[i][j] += right[i][j+1];
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == '0'){
                    res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}
