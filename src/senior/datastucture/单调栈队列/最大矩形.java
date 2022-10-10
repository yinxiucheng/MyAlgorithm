package senior.datastucture.单调栈队列;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * https://www.lintcode.com/problem/510/?fromId=178&_from=collection
 *
 * 描述
 * 给你一个二维矩阵，权值为False和True，找到一个最大的矩形，使得里面的值全部为True，输出它的面积
 */
public class 最大矩形 {
    public static void main(String[] args) {
        boolean[][] matrix = {{true}};
        maximalRectangle(matrix);
    }

    public static int maximalRectangle(boolean[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!matrix[i][j]) {
                    heights[j] = 0;
                } else {
                    heights[j] = i==0? 1 : heights[j] + 1;
                }
            }
            int curMax = largestRectangleArea(heights);
            max = Math.max(max, curMax);
        }
        return max;
    }

    private static int largestRectangleArea(int[] heights) {
        //找到左边第一个比自己小的 leftIndex
        //找到右边第一个比自己小的 rightIndex
        //width = rightIndex - leftIndex - 1;
        //area = height * width;
        int[] left = new int[heights.length];
        Arrays.fill(left, -1);
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);

        Stack<Integer> leftStack = new Stack<>();
        for (int i = 0; i <= heights.length - 1; i++) {
            int cur = heights[i];
            while (!leftStack.isEmpty() && heights[leftStack.peek()] >= cur){
                leftStack.pop();
            }
            if (!leftStack.isEmpty()){
                left[i] = leftStack.peek();
            }
            leftStack.push(i);
        }

        Stack<Integer> rightStack = new Stack<>();
        for (int i = heights.length - 1; i >= 0 ; i--) {
            int cur = heights[i];
            while (!rightStack.isEmpty() && heights[rightStack.peek()] >= cur){
                rightStack.pop();
            }
            if (!rightStack.isEmpty()){
                right[i] = rightStack.peek();
            }
            rightStack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int width = right[i] - left[i] - 1;
            max = Math.max(max, width * h);
        }
        return max;
    }

}
