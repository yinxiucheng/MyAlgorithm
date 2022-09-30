package junior.dp.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 603 · 最大整除子集
 * https://www.lintcode.com/problem/603/solution/17878
 *
 * 描述
 * 给一个由 无重复的正整数 组成的集合，找出一个元素最多的子集，满足集合中任意两个元素 (Si, Sj) 都有 Si % Sj = 0 或 Sj % Si = 0
 */
public class LongestDivideSubset {
    /**
     * @param nums: a set of distinct positive integers
     * @return: the largest subset
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (null == nums || nums.length == 0){
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;
        //# state dp 表示 最长子集个数
        int[] dp = new int[n];
        //# 最邻近那个因子的位置信息
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {// 取因子优化时间。
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    pre[i] = j;
                }
            }
        }

        int maxIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // 找到dp 最大值，就是所求的路径来源，相应的Pre中存储了Index。
            if (dp[i] > maxValue){
                maxValue = dp[i];
                maxIndex = i;
            }
        }

        result.add(nums[maxIndex]);
        int currentIndex = maxIndex;
        while (pre[currentIndex] != -1){ //遍历路径，找出经历的值。
            currentIndex = pre[currentIndex];
            result.add(nums[currentIndex]);
        }
        Collections.reverse(result);
        return result;
    }

    private List<Integer> getFactors(int val){
        List<Integer> factors = new ArrayList<>();
        if (val == 1){
            return factors;
        }
        int factor = 1;
        while (factor * factor <= val){
            if (val % factor == 0){
                factors.add(factor);
                if (factor != 1 && factor * factor != val){
                    int factorPartner = val/factor;
                    factors.add(factorPartner);
                }
            }
            factor++;
        }
        return factors;
    }
}
