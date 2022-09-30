package junior.twopointer.towsum;

import java.util.HashMap;

/**
 * https://www.lintcode.com/problem/607/?fromId=161&_from=collection
 * 描述
 * 设计并实现一个 TwoSum 类。他需要支持以下操作:add 和 find。
 * add -把这个数添加到内部的数据结构。
 * find -是否存在任意一对数字之和等于这个值
 *
 */
public class TowSum {
    HashMap<Integer, Integer> map = new HashMap<>();
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int num : map.keySet()) {
            int diff = value - num;
            if (map.containsKey(diff)) {
                if (diff != num || map.getOrDefault(diff, 0) > 1) return true;
            }
        }
        return false;
    }
}
