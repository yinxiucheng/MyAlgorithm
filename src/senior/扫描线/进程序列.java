package senior.扫描线;

import java.util.*;

/**
 *
 * 833 · 进程序列
 * https://www.lintcode.com/problem/833/?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 *
 * 描述
 * 有一个进程序列，包含每一个进程的开始点和结束点。
 *
 * 有一个询问序列，询问某个时间点有多少个进程在跑。
 *
 * 请你返回询问序列的查询结果。
 *
 * 开始点算作有一个进程在跑，结束点不算。
 */
public class 进程序列 {

    public List<Integer> numberOfProcesses(List<Interval> logs, List<Integer> queries) {
        Queue<Boundary> queue = new PriorityQueue<>(new Comparator<Boundary>() {
            @Override
            public int compare(Boundary o1, Boundary o2) {
                int diff = o1.num - o2.num;
                if (diff == 0){
                    diff = o1.type - o2.type;
                }
                return diff;
            }
        });
        for (Interval interval: logs) {
            queue.offer(new Boundary(interval.start, 1));
            queue.offer(new Boundary(interval.end, -1));
        }

        for (Integer query: queries) {
            queue.offer(new Boundary(query, 2));
        }

        int processNum = 0;
        Map<Integer, Integer> timeToNum = new HashMap<>();
        while (!queue.isEmpty()){
            Boundary boundary = queue.poll();
            if (boundary.type != 2){
                processNum += boundary.type;
            }
            timeToNum.put(boundary.num, processNum);
        }
        List<Integer> ans = new ArrayList<>();
        for (Integer query :queries) {
            ans.add(timeToNum.get(query));
        }

        return ans;
    }
}
