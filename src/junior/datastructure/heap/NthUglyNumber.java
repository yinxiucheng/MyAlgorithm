package junior.datastructure.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/4/?fromId=161&_from=collection
 *
 * 描述
 * 如果一个数只有质数因子2，3，5 ，那么这个数是一个丑数。
 *
 * 前10个丑数分别为 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...设计一个算法，找出第N个丑数。
 *
 * 我们可以认为 1 也是一个丑数。
 */
public class NthUglyNumber {

    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public static int nthUglyNumber(int n) {
        int[] factors = new int[]{2, 3, 5};
        HashSet<Long> set = new HashSet<>();
        Queue<Long> heap = new PriorityQueue<>();
        long result = 1;
        heap.offer(1L);
        set.add(1L);
        for (int i = 0; i < n; i++) {
            result = heap.poll();
            if (i == n-1){
                return (int)result;
            }
            set.remove(result);
            for (int j = 0; j < 3; j++) {
                long temp = result * factors[j];
                if (!set.contains(temp)){
                    heap.offer(temp);
                    set.add(temp);
                }
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        int result = nthUglyNumber(9);
    }
}
