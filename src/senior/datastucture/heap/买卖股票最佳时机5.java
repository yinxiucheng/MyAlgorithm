package senior.datastucture.heap;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 1691 · 买卖股票的最佳时机 V
 *
 * https://www.lintcode.com/problem/1691/description?fromId=178&_from=collection
 *
 *
 * 给出一个股票n天的价格，每天最多只能进行一次交易，可以选择买入一支股票或卖出一支股票或放弃交易，输出能够达到的最大利润值
 *
 * 给出 `a = [1,2,10,9]`, 返回 `16`
 * 输入:
 * [1,2,10,9]
 * 输出:
 * 16
 *
 * 解释:
 * 你可以在第一天和第二天买入股票，第三天和第四天卖出
 * 利润：-1-2+10+9 = 16
 */
public class 买卖股票最佳时机5 {

    public int getAns(int[] A) {

        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int k: A) {
            if (queue.size() > 0 && queue.peek() < k){
                result += k - queue.poll();
                queue.offer(k);
            }
            queue.offer(k);
        }
        return result;
    }
}
