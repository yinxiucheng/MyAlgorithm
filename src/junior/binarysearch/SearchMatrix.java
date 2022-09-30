package junior.binarysearch;

/**
 * https://www.lintcode.com/problem/28/
 *
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,5}, {6,7,8}};
        int target = 8;
        boolean as = searchMatrix(matrix, target);
        System.out.print("answer is " + as);
    }
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(target == getValueFromMatrix(matrix, mid)){
                return true;
            }

            if (target < getValueFromMatrix(matrix, mid)) {
                right = mid;
            }

            if(target > getValueFromMatrix(matrix, mid)) {
                left = mid;
            }

        }
        if (getValueFromMatrix(matrix, left) == target) return true;
        if (getValueFromMatrix(matrix, right) == target) return true;

        return false;
        // write your code here
    }


    public static int getValueFromMatrix(int[][] matrix, int index) {
        int x = index / matrix[0].length;
        int y = index % matrix[0].length;
        return matrix[x][y];
    }
}
