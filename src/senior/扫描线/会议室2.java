package senior.扫描线;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.lintcode.com/problem/919/?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 *
 * 描述
 * 给定一系列的会议时间间隔intervals，包括起始和结束时间[[s1,e1],[s2,e2],...] (si < ei)，找到所需的最小的会议室数量。
 *
 */
public class 会议室2 {

    public int minMeetingRooms(List<Interval> intervals) {
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
        int maxMeetings = 0;
        for (Boundary boundary: boundaries) {
            if (boundary.type == 1){
                meetings ++;
            }
            if (boundary.type == -1){
                meetings --;
            }
            maxMeetings = Math.max(meetings, maxMeetings);
        }

        return maxMeetings;
    }
}
