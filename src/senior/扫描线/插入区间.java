package senior.扫描线;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 30 · 插入区间
 *
 * https://www.lintcode.com/problem/30/?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 *
 */
public class 插入区间 {

    public static void main(String[] args) {
        List<Interval>  intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(5, 9));

        Interval newInterval = new Interval(2, 5);
        List<Interval> results = insert(intervals, newInterval);

    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Boundary> boundaries = new ArrayList<>();
        intervals.add(newInterval);
        for (Interval interval: intervals) {
            boundaries.add(new Boundary(interval.start, -1));
            boundaries.add(new Boundary(interval.end, 1));
        }

        Collections.sort(boundaries, new Comparator<Boundary>() {
            @Override
            public int compare(Boundary o1, Boundary o2) {
                int diff = o1.num - o2.num;
                if (diff == 0){
                    diff = o1.type - o2.type;
                }
                return diff;
            }
        });

        int scanLine = 0;
        List<Interval> results = new ArrayList<>();
        int start = 0;
        for (Boundary boundary: boundaries) {
            if (scanLine == 0){
                start = boundary.num;
            }
            scanLine += boundary.type;
            if (scanLine == 0){
                results.add(new Interval(start, boundary.num));
            }
        }

        return results;
    }
}
