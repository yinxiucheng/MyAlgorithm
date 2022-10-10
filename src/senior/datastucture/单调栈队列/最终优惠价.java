package senior.datastucture.单调栈队列;


import java.util.Arrays;
import java.util.Stack;

/**
 *
 * 1852 · 最终优惠价
 *
 * https://www.lintcode.com/problem/1852/?fromId=178&_from=collection
 *
 * 输入:
 * Prices = [2, 3, 1, 2, 4, 2]
 * 输出:
 * [1, 2, 1, 0, 2, 2]
 * 解释：
 * 第0个和第1个物品右边第一个更低的价格都是1，所以实际售价需要在全价上减去1， 第3个物品右边第一个更低的价格是2，所以实际售价要在全价上面减去2。
 *
 */
public class 最终优惠价 {

    public int[] finalDiscountedPrice(int[] prices) {
        int[] result = Arrays.copyOf(prices, prices.length);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()] ){
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return result;
    }
}
