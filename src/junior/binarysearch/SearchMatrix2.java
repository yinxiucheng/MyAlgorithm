package junior.binarysearch;

/**
 * https://www.lintcode.com/problem/38/
 *
 * 描述
 * 写出一个高效的算法来搜索m×n矩阵中的值，返回这个值出现的次数。这个矩阵具有以下特性：每行中的整数从左到右是排序的。每一列的整数从上到下是排序的。在每一行或每一列中没有重复的整数。
 */
public class SearchMatrix2 {

    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0){
            return 0;
        }

        if (null == matrix[0] || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        int count = 0;
        while (i > -1 && j < n){
            if (matrix[i][j] == target){
                i --;
                j ++;
                count ++;
            }else if (matrix[i][j] > target){
                i --;
            }else {
                j ++;
            }
        }
        return count;
    }
}
