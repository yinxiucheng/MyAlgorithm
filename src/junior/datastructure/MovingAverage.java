package junior.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    int size;
    long sum;
    Queue<Integer> queue;
    /*
     * @param size: An integer
     */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        if (queue.size() < size) {
            sum += val;
            queue.offer(val);
            return (sum * 1.0) / queue.size();
        }

        sum -= queue.peek();
        sum += val;
        queue.poll();
        queue.offer(val);
        return (sum * 1.0) / queue.size();
    }
}
