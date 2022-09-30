package junior.sumarrange;

public class ImageSmoother {

    public int[][] imageSmooth(int[][] matrix){
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] ret = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0, count = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = 0; y <= j + 1; y++) {
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        sum += matrix[x][y];
                        count++;
                    }
                }
                ret[i][j] = sum / count;
            }
        }
        return  ret;
    }
}
