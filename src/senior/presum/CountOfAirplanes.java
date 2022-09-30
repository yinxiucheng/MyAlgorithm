package senior.presum;

import junior.datamodel.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 391 · 数飞机
 *
 * https://www.lintcode.com/problem/391/?fromId=178&_from=collection
 *
 * 描述
 * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
 *
 * 区间扫描线
 */
public class CountOfAirplanes {

    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes.size() ==0) {
            return 0;
        }
        List<Pair> list = new ArrayList<>();
        for (Interval interval: airplanes) {
            list.add(new Pair(interval.start, TYPE_START));
            list.add(new Pair(interval.end, TYPE_END));
        }
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Pair cur = list.get(i);
            if (cur.type == TYPE_START){
                count++;
            }else {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private static final int TYPE_START = 1;
    private static final int TYPE_END = 0;

    class Pair implements Comparable<Pair>{
        int val;
        int type;

        public Pair(int val, int type){
            this.val = val;
            this.type = type;
        }

        @Override
        public int compareTo(Pair o) {
            int diff = val - o.val;
            if (diff == 0){
                diff = type - o.type;
            }
            return diff;
        }
    }
}
