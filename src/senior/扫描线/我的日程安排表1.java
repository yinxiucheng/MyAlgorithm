package senior.扫描线;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class 我的日程安排表1 {

    class MyCalendar {

        List<Interval> intervalList;

        public MyCalendar() {
            intervalList = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            Interval interval = new Interval(start, end);
            List<Interval> temp = new ArrayList<>(intervalList);
            temp.add(interval);

            Collections.sort(temp, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    int diff = o1.start - o2.start;
                    if (diff == 0){
                        diff = o1.end - o2.end;
                    }
                    return diff;
                }
            });

            Interval pre = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                Interval cur = temp.get(i);
                if (cur.start < pre.end){
                    return false;
                }
                pre = cur;
            }
            intervalList = new ArrayList<>(temp);
            return true;
        }

    }
}
