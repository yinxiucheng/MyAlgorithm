package junior.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * https://www.lintcode.com/problem/657/?fromId=161&_from=collection
 * 设计一个数据结构实现在平均 O(1) 的复杂度下执行以下所有的操作。
 *
 * insert(val): 如果这个元素不在set中，则插入。
 *
 * remove(val): 如果这个元素在set中，则从set中移除。
 *
 * getRandom: 随机从set中返回一个元素。每一个元素返回的可能性必须相同。
 */
public class RandomizedSet {
    private List<Integer> list;
    private HashMap<Integer, Integer> valueToIndex;
    private Random random;

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        set.getRandom();
        set.remove(1);
        set.insert(2);
        set.getRandom();
    }

    public RandomizedSet() {
        list = new ArrayList<>();
        valueToIndex = new HashMap<>();
        random = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (!valueToIndex.containsKey(val)){
            list.add(val);
            valueToIndex.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (valueToIndex.containsKey(val)){
            int last = list.get(list.size() - 1);
            int index = valueToIndex.get(val);
            list.set(index, last);
            valueToIndex.put(last, index);
            list.remove(list.size() - 1);
            return true;
        }
        return false;
        // write your code here
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        int index =  random.nextInt(list.size());
        return list.get(index);
    }
}
