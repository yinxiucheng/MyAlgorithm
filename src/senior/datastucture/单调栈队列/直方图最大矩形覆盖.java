package senior.datastucture.单调栈队列;

import java.util.Arrays;
import java.util.Stack;

/**
 * 122 · 直方图最大矩形覆盖
 *
 * https://www.lintcode.com/problem/122/?fromId=178&_from=collection
 *
 *
 */
public class 直方图最大矩形覆盖 {

    public int largestRectangleArea(int[] heights) {
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
