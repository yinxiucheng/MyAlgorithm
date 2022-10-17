package senior.datastucture.unionfind;

import junior.datamodel.Interval;

import java.util.*;

/**
 * 1280 · 将数据流变为多个不相交区间
 *
 * https://www.lintcode.com/problem/1280/
 *
 *
 */
public class Intervals {

    Map<Integer, Integer> farther;
    Map<Integer, Interval> intervalMap;

    public Intervals(){
        farther = new HashMap<>();
        intervalMap = new HashMap<>();
    }

    /**
     * @param val: An integer.
     * @return: nothing
     */
    public void addNum(int val) {
        if (farther.containsKey(val)){
            return;
        }
        farther.put(val, val);
        intervalMap.put(val, new Interval(val, val));
        if (farther.containsKey(val - 1)) {
           merge(val - 1, val);
        }

        if (farther.containsKey(val + 1)){
            merge(val + 1, val);
        }
    }

    private void merge(int a, int b){
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b){
            farther.put(a, root_b);
            int leftEnd = Math.min(intervalMap.get(root_a).start, intervalMap.get(root_b).start);
            int rightEnd = Math.max(intervalMap.get(root_a).end, intervalMap.get(root_b).end);
            intervalMap.put(root_b, new Interval(leftEnd, rightEnd));
        }
    }

    private int find(int x){
        int j = x, fx;
        while (j != farther.get(j)){
            j = farther.get(j);
        }

        while (x != j){
            fx = farther.get(x);
            farther.put(fx, j);
            x = fx;
        }
        return j;
    }

    /**
     * @return: A list of intervals.
     */
    public List<Interval> getIntervals() {
        List<Interval> results = new ArrayList<>();
        Set<Integer> resultSet = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry: farther.entrySet()) {
            int item = entry.getKey();
            int root_item = find(item);
            if (!resultSet.contains(root_item)){
                resultSet.add(root_item);
                results.add(intervalMap.get(root_item));
            }
        }
        Collections.sort(results, Comparator.comparingInt(o -> o.start));
        return results;
    }

}
