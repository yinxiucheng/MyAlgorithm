package junior.dp;

import junior.datamodel.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 839 · 合并两个排序的间隔列表
 *
 * 描述
 * 合并两个已排序的区间列表，并将其作为一个新的有序区间列表返回。新的区间列表应该通过拼接两个列表的区间并按升序排序。
 */
public class MergeTwoInterval {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        if (null == list1 && null == list2){
            return result;
        }
        int len1 = list1.size();
        int len2 = list2.size();

        int i = 0, j = 0;
        Interval last = null, current;
        while (i < len1 && j < len2) {
            if (list1.get(i).start > list2.get(j).start) {
                current = list2.get(j);
                j++;
            } else {
                current = list1.get(i);
                i++;
            }
            last = merge(result, last, current);
        }

        while (i < len1){
            last = merge(result, last, list1.get(i));
            i++;
        }

        while (j < len2){
            last = merge(result, last, list2.get(j));
            j++;
        }

        if (last != null){
            result.add(last);
        }
        return result;
    }


    private Interval merge(List<Interval> result, Interval last, Interval current){
        if (last == null){
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
