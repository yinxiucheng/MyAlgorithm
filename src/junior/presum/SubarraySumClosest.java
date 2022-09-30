package junior.presum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 139 · 最接近零的子数组和
 *
 * https://www.lintcode.com/problem/139/?fromId=161&_from=collection
 *
 * 描述
 * 给定一个整数数组，找到一个和最接近于零的子数组。返回满足要求的子数组的起始位置和结束位置。
 *
 * 样例
 * 样例1
 *
 * 输入:
 * [-3,1,1,-3,5]
 * 输出:
 * [0,2]
 * 解释: 返回 [0,2], [1,3], [1,1], [2,2], [0,4] 中的任意一个均可。
 *
 * O(nlogn)的时间复杂度
 */
public class SubarraySumClosest {

    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        int N = nums.length;
        if(N == 1) {
            res[0] = res[1] = 0;
            return res;
        }

        Pair[] preSums = new Pair[N+1];
        preSums[0] = new Pair(0, 0);
        for (int i = 1; i <= N ; i++) {
            preSums[i] = new Pair(preSums[i-1].sum + nums[i-1], i);
        }

        Arrays.sort(preSums, Comparator.comparingInt(a -> a.sum));

        int diff = Integer.MAX_VALUE;
        Pair result = preSums[0];
        int minIndex = 0;
        for (int i = 1; i <= N; i++) {
            int temp = preSums[i].sum - preSums[i-1].sum;
            if (temp < diff){
                diff = temp;
                result = preSums[i];
                minIndex = i;
            }
        }
        int index1 = result.index;
        int index2 = preSums[minIndex - 1].index;
        if (index1 > index2) {
            res[0] = index2;
            res[1] = index1 - 1;
        } else {
            res[0] = index1;
            res[1] = index2 - 1;
        }
        return res;
    }

    class Pair{
        int sum;
        int index;
        Pair(int sum, int index){
            this.sum = sum;
            this.index = index;
        }
    }
}
