package senior.扫描线;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 会议室 {

    public boolean canAttendMeetings(List<Interval> intervals) {
        List<Boundary> boundaries = new ArrayList<>();
        for (Interval interval : intervals) {
            boundaries.add(new Boundary(interval.start, 1));
            boundaries.add(new Boundary(interval.end, -1));
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

        int meetings = 0;
        for (Boundary boundary: boundaries) {
            if (boundary.type == 1){
                meetings ++;
            }
            if (boundary.type == -1){
                meetings --;
            }
            if (meetings >= 2){
                return false;
            }
        }
        return true;
    }
}
