package senior.扫描线;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1397 · 覆盖数字
 *
 * https://www.lintcode.com/problem/1397/solution/26367?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 *
 */
public class 覆盖数字 {

    public int digitalCoverage(List<Interval> intervals) {
        List<Boundary> boundaries = new ArrayList<>();
        for (Interval interval: intervals) {
            boundaries.add(new Boundary(interval.start, 0));
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

        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        int maxEle = -1;
        for (int i = 0; i < boundaries.size(); i++) {
            Boundary cur = boundaries.get(i);
            if (cur.type == 0){
                count ++;
            }else {
                count --;
            }
            if (count > maxCount){
                maxCount = count;
                maxEle = cur.num;
            }
        }
        return maxEle;
    }
}
