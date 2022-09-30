package junior.datastructure.heap;

import junior.datamodel.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 577 · 合并K个排序间隔列表
 *
 * https://www.lintcode.com/problem/577/?fromId=161&_from=collection
 *
 * 描述
 * 将K个排序的间隔列表合并到一个排序的间隔列表中，你需要合并重叠的间隔。
 */
public class MergeKSortedIntervalLists {

    public static void main(String[] args) {
        List<List<Interval>> test = new ArrayList<>();
        List<Interval> list1 = new ArrayList<>();
        Interval interval1 = new Interval(1, 3);
        list1.add(interval1);
        Interval interval2 = new Interval(4,7);
        list1.add(interval2);
        Interval interval3 = new Interval(6, 8);
        list1.add(interval3);

        List<Interval> list2 = new ArrayList<>();
        Interval interval4 = new Interval(1,2);
        Interval interval5 = new Interval(9, 10);
        list2.add(interval4);
        list2.add(interval5);

        test.add(list1);
        test.add(list2);

        List<Interval> result = mergeKSortedIntervalLists(test);

        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            Interval interval = result.get(i);
            System.out.print("(" + interval.start + "," + interval.end + ")");
            if (i != result.size() -1){
                System.out.print(",");
            }
        }
        System.out.print("]");

    }
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    public static List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {

        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));

        int n = intervals.size();
        for (int i = 0; i < n; i++) {
            List<Interval> list = intervals.get(i);
            if (list.size() == 0){
                intervals.remove(list);
                n = n - 1;
                i--;
                continue;
            }
            heap.offer(list.get(0));
            list.remove(0);
        }

        if (heap.isEmpty()) {
            return result;
        }
        Interval last = null, current;
        while (!heap.isEmpty()) {
            current = heap.poll();
            last = merge(result, last, current);
            Interval interval = getNextInterval(intervals);
            if (null != interval) {
                heap.offer(interval);
            }
        }

        if (null != last) {
            result.add(last);
        }
        return result;
    }

    private static Interval getNextInterval(List<List<Interval>> intervals) {
        Interval minInterval = null;
        int n = intervals.size();
        List<Interval> needDeleteList = null;
        for (int i = 0; i < n; i++) {
            List<Interval> list = intervals.get(i);
            if (list.size() == 0) {
                intervals.remove(list);
                n--;
                i--;
                continue;
            }
            if (minInterval == null) {
                minInterval = list.get(0);
                needDeleteList = list;
            } else {
                minInterval = getMinInterval(minInterval, list.get(0));
                if (minInterval == list.get(0)){
                    needDeleteList = list;
                }
            }
        }
        if (null != needDeleteList && needDeleteList.size() > 0){
            needDeleteList.remove(0);
        }
        return minInterval;
    }

    private static Interval getMinInterval(Interval interval1, Interval interval2){
        if (interval1.start < interval2.start){
            return interval1;
        }
        return interval2;
    }

    private static Interval merge(List<Interval> result, Interval last, Interval current){
        if (null == last){
            return current;
        }
        if (current.start > last.end){
            result.add(last);
            return current;
        }

        last.end = Math.max(last.end, current.end);
        return last;
    }

}
