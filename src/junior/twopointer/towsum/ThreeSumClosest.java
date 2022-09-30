package junior.twopointer.towsum;

import java.util.Arrays;

/**
 * 59 · 最接近的三数之和
 *
 * 描述
 * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
 *
 */
public class ThreeSumClosest {

    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        if (null == numbers || numbers.length < 3){
            return Integer.MIN_VALUE;
        }

        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end){
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (sum == target){
                    return target;
                }

                if (sum < target){
                    start ++;
                }else {
                    end --;
                }

                int tempDiff = Math.abs(sum - target);
                if (tempDiff < diff){
                    diff = tempDiff;
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
