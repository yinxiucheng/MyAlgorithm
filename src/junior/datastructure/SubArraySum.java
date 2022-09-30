package junior.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.lintcode.com/problem/138/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个整数数组，找到和为 00 的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] test = new int[]{4, 6, 3, -9, -5, 1, 3, 0, 2};
        List<Integer> result = subarraySum(test);
        System.out.print("[");
        for (int i = result.get(0); i <= result.get(1); i++) {
            if (i != result.get(1)) {
                System.out.print(test[i] + ",");
            } else {
                System.out.print(test[i]);
            }

        }
        System.out.print("]");
    }
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public static List<Integer> subarraySum(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        valueToIndex.put(0, 0);
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
            if (!valueToIndex.containsKey(sums[i + 1])) {
                valueToIndex.put(sums[i + 1], i + 1);
            } else {
                int start = valueToIndex.get(sums[i + 1]);
                list.add(start);
                list.add(i);
                return list;
            }
        }
        return null;
    }
}
