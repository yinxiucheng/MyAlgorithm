package senior.扫描线;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {

    public List<Interval> merge(List<Interval> intervals) {
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
        List<Boundary> boundaries = new ArrayList<Boundary>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            boundaries.add(new Boundary(interval.start, -1));
            boundaries.add(new Boundary(interval.end, 1));
        }
        Collections.sort(boundaries, comparator);
        List<Interval> results = new ArrayList<>();
        int sumType = 0;
        int left = 0, right = 0;
        for (int i = 0; i < boundaries.size(); i++) {
            Boundary boundary = boundaries.get(i);
            if (sumType == 0 && boundary.type == 1){
                left = boundary.num;
            }
            sumType += boundary.type;
            if (sumType == 0 && boundary.type == -1){
                right = boundary.num;
                results.add(new Interval(left, right));
            }
        }
        return results;
    }

}
