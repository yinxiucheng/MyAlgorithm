package senior.datastucture.heap;

import java.util.*;

/**
 * 1512 · 雇佣K个人的最低费用
 *
 * https://www.lintcode.com/problem/1512/?fromId=178&_from=collection
 *
 */
public class 雇佣K个人的最低费用 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // Write your code here
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++) {
            workers[i] = new Worker(quality[i], (wage[i] * 1.0)/quality[i]);
        }

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Comparator<Worker> comparator = Comparator.comparing(o -> o.unitWage);
        Arrays.sort(workers, comparator);
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            Worker worker = workers[i];
            if (queue.size() == k){
                totalQuality -= queue.poll();
            }
            totalQuality += worker.quality;
            queue.offer(worker.quality);
            if (queue.size() == k){
                minCost = Math.min(minCost, totalQuality * worker.unitWage);
            }
        }
        return minCost;
    }

    class Worker{
        int quality;
        Double unitWage;
        public Worker(int quality, double unitWage){
            this.quality = quality;
            this.unitWage = unitWage;
        }
    }
}
