package junior.twopointer.towsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57 · 三数之和
 *
 * 描述
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 *
 * 在三元组(a, b, c)，要求a \leq b \leq ca≤b≤c。结果不能包含重复的三元组。
 */
public class ThreeSum {

    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     *          we will sort your return value in output
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> results = new ArrayList<>();

        if (null == numbers || numbers.length < 3){
            return results;
        }
        Arrays.sort(numbers);
        int N = numbers.length;
        for (int i = 0; i < N - 2 ; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]){
                continue;
            }
            int a = numbers[i];
            int start = i+1;
            int end = N - 1;
            int target = -a;
            while (start < end){
                if (numbers[start] + numbers[end] < target){
                    start ++;
                }else if (numbers[start] + numbers[end] > target){
                    end --;
                }else {
                    List<Integer> result = new ArrayList<>();
                    result.add(a);
                    result.add(numbers[start]);
                    result.add(numbers[end]);
                    results.add(result);
                    start ++ ;
                    end --;
                    while (start < end && numbers[start] == numbers[start - 1]){
                        start ++ ;
                    }
                    while (start < end && numbers[end] == numbers[end + 1]){
                        end --;
                    }
                }
            }

        }
        return results;
    }
}
