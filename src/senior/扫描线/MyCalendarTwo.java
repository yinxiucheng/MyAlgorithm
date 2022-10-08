package senior.扫描线;

import java.util.*;

/**
 *
 * 1064 · 我的日程表 II
 * https://www.lintcode.com/problem/1064/?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 *
 */
public class MyCalendarTwo {

    Queue<Boundary> tempQueue;
    List<Interval> intervalList;
    public MyCalendarTwo(){
        Comparator<Boundary> comparator = new Comparator<Boundary>() {
            @Override
            public int compare(Boundary o1, Boundary o2) {
                int diff = o1.num - o2.num;
                if (diff == 0){
                    diff = o1.type - o2.type;
                }
                return diff;
            }
        };
        tempQueue = new PriorityQueue<>(comparator);
        intervalList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        List<Interval> temp = new ArrayList<>(intervalList);
        temp.add(new Interval(start, end));
        tempQueue.clear();
        for (Interval interval : temp) {
            tempQueue.offer(new Boundary(interval.start, 1));
            tempQueue.offer(new Boundary(interval.end, -1));
        }

        int scanLine = 0;
        while (!tempQueue.isEmpty()){
            scanLine += tempQueue.poll().type;
            if (scanLine >= 3){
                return false;
            }
        }
        intervalList = new ArrayList<>(temp);
        return true;
    }
}
