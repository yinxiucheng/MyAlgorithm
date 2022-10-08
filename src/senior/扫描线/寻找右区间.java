package senior.扫描线;

import java.util.*;

/**
 * 1241 · 寻找右区间
 * https://www.lintcode.com/problem/1241/description?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 */
public class 寻找右区间 {

    public List<Integer> findRightInterval(List<Interval> intervals) {
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            pointList.add(new Point(i, interval.start, 1));
            pointList.add(new Point(i, interval.end, 0));
        }

        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int diff = o1.num - o2.num;
                if (diff == 0){
                    diff = o1.type - o2.type;
                }
                return diff;
            }
        };

        Collections.sort(pointList, comparator);

        Queue<Point> queue = new PriorityQueue<>(comparator);
        Integer[] ans = new Integer[intervals.size()];
        for (int i = pointList.size() - 1; i >= 0; i--) {
            Point point = pointList.get(i);
            if (point.type == 1){
                queue.offer(point);
            }else {
                if (queue.size() == 0){
                    ans[point.index] = -1;
                }else {
                    ans[point.index] = queue.peek().index;
                }
            }
        }
        return Arrays.asList(ans);
    }

    class Point{
        int index;
        int num;
        int type;
        public Point(int index, int num, int type){
            this.index = index;
            this.num = num;
            this.type = type;
        }
    }
}
