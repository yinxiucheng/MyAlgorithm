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
 * 给出一个无重叠的按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）
 *
 */
public class 插入区间2 {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> results = new ArrayList<>();
        int posIndex = 0;
        for (Interval interval: intervals) {
            if (interval.end < newInterval.start){
                results.add(interval);
                posIndex ++;
            }else if (interval.start > newInterval.end){
                results.add(interval);
            }else if (interval.end == newInterval.start){
                newInterval.start = interval.start;
            }else if (interval.start == newInterval.end){
                newInterval.end = interval.end;
            }
        }
        results.add(posIndex, newInterval);
        return results;
    }
}
