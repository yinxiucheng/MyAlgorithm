package senior.扫描线;

import java.util.ArrayList;
import java.util.List;

/**
 * 821 · 时间交集
 *
 * https://www.lintcode.com/problem/821/?showListFe=true&page=1&problemTypeId=2&tagIds=389&pageSize=50
 *
 */
public class 时间交集 {

    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        int n = seqA.size();
        int m = seqB.size();
        int i = 0, j = 0;
        List<Interval> ans = new ArrayList<>();

        while (i < n && j < m){
            Interval intervalA = seqA.get(i);
            Interval intervalB = seqB.get(j);
            if (intervalA.end <= intervalB.start){
                i++;
            } else if (intervalA.start >= intervalB.end){
                j++;
            }else {
                int start = Math.max(intervalA.start, intervalB.start);
                int end = Math.min(intervalA.end, intervalB.end);
                ans.add(new Interval(start, end));
                if (intervalA.end < intervalB.end){
                    i++;
                }else if (intervalA.end > intervalB.end){
                    j++;
                }else {
                    i++;
                    j++;
                }
            }

        }
        return ans;
    }

}
