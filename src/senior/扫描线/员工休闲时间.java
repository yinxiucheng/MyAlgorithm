package senior.扫描线;

import java.util.*;

/**
 * 850 · 员工空闲时间
 *
 * https://www.lintcode.com/problem/850/?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 */
public class 员工休闲时间 {

    public List<Interval> employeeFreeTime(int[][] schedule) {
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

        for (int[] employee: schedule) {
            for (int i = 0; i < employee.length; i += 2) {
                queue.offer(new Boundary(employee[i], -1));
                queue.offer(new Boundary(employee[i + 1], 1));
            }
        }

        List<Interval> ans = new ArrayList<>();
        int count = 0;
        while (queue.size() > 1){
            Boundary left = queue.poll();
            Boundary right = queue.peek();
            count += left.type;
            if (left.type == 1 && right.type == -1 && count == 0){
                ans.add(new Interval(left.num, right.num));
            }
        }

        return ans;
    }
}
