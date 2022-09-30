package junior.datastructure.set;

import java.util.HashSet;

/**
 * https://www.lintcode.com/problem/124/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个未排序的整数数组num，找出最长连续序列的长度。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * num = [100, 4, 200, 1, 3, 2]
 * 输出：
 *
 * 4
 * 解释：
 *
 * 这个最长的连续序列是 [1, 2, 3, 4]. 返回所求长度 4
 */
public class LongestConsecutive {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<>();
        for (int val: num) {
            set.add(val);
        }
        int longestLength = 0;
        for (int i = 0; i < num.length; i++) {
            int val = num[i];
            int currentLength = 1;
            if (!set.contains(val - 1)){
                while (set.contains(val + 1)){
                    currentLength++;
                    val += 1;
                }
                longestLength = Math.max(currentLength, longestLength);
            }
        }
        return  longestLength;
    }
}
