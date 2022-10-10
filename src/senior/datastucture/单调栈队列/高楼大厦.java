package senior.datastucture.单调栈队列;

import java.util.Arrays;
import java.util.Stack;

/**
 * 285 · 高楼大厦
 *
 * https://www.lintcode.com/problem/285/
 *
 * 输入:[5,3,8,3,2,5]
 * 输出:[3,3,5,4,4,4]
 * 解释:
 * 当小Q处于位置0时，他能看到位置0，1，2的3栋高楼。
 * 当小Q位于位置1时，他能看到位置0，1，2的3栋高楼。
 * 当小Q处于位置2时，他可以向前看到位置0，1处的楼，向后看到位置3,5处的楼，加上第3栋楼，共可看到5栋楼。
 * 当小Q处于位置3时，他能看到位置2，3，4，5的4栋高楼。
 * 当小Q处于位置4时，他能看到位置2，3，4，5的4栋高楼。
 * 当小Q处于位置5时，他能看到位置2，3，4，5的4栋高楼。
 *
 */
public class 高楼大厦 {

    public int[] tallBuilding(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, 1);

        //从左到右单调栈处理一遍,
        Stack<Integer> leftStack = new Stack<>();
        for (int i = 0; i < result.length; i++) {
            result[i] += leftStack.size();
            //站内所有比当前值小的都弹出。
            while (!leftStack.isEmpty() && arr[leftStack.peek()] <= arr[i]){
                leftStack.pop();
            }
            leftStack.push(i);
        }

        //从右到左单调栈处理一遍
        Stack<Integer> rightStack = new Stack<>();
        for (int i = result.length - 1; i >= 0 ; i--) {
            result[i] += rightStack.size();
            while (!rightStack.isEmpty() && arr[rightStack.peek()] <= arr[i]){
                rightStack.pop();
            }
            rightStack.push(i);
        }
        return result;
    }
}
