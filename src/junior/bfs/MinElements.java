package junior.bfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MinElements {
    /**
     * @param arr: an array of non-negative integers
     * @return: minimum number of elements
     */
    public int minElements(int[] arr) {
        List<List<Integer>> results = levelOrder(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // write your code here
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < results.size(); i++) {
            List<Integer> subSet = results.get(i);
            int subSum = 0;
            for (int j = 0; j < subSet.size(); j++) {
                subSum += subSet.get(j);
            }
            if (subSum > sum - subSum){
                minLength = Math.min(minLength, subSet.size());
            }
        }
        return minLength;
    }

    //找出所有的子集
    private List<List<Integer>> levelOrder(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }
}
