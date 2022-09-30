package junior.sumarrange;

public class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = n == 0 ? 0 : matrix[0].length;
        sumMatrix = new int[m+1][n+1];

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <=n ; j++) {
                sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        row2 ++;
        col2 ++;
        return sumMatrix[row2][col2] - sumMatrix[row1][col2] - sumMatrix[row2][col1] + sumMatrix[row1][col1];
    }
}
