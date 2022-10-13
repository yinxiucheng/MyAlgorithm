package senior.datastucture.单调栈队列;

import java.util.Stack;

/**
 * 363 · 接雨水
 *
 * https://www.lintcode.com/problem/363
 *
 */
public class 接雨水 {

    public static void main(String[] args) {
        int[] heights = {100,0,100};
        trapRainWater(heights);
    }

    public static int trapRainWater(int[] heights) {
        if (null == heights || heights.length == 0){
            return 0;
        }
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int rightBoundary = 1; rightBoundary < heights.length; rightBoundary++) {
            int rightHeight = heights[rightBoundary];
            //维持单调增。
            while (!stack.isEmpty() && heights[stack.peek()] < rightHeight){
                 int curIndex =  stack.pop();
                 if (!stack.isEmpty()){ //求出左右边界
                     int leftBoundary = stack.peek();
                     //左右边界，墙最小的。
                     int minHeight = Math.min(heights[leftBoundary], rightHeight);
                     //算出可容纳雨水的高度。
                     int height = Math.max(0, minHeight - heights[curIndex]);
                     water += height * (rightBoundary - leftBoundary - 1);
                 }
            }
            stack.push(rightBoundary);
        }
        return water;
    }
}
