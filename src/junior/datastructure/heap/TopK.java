package junior.datastructure.heap;

import java.util.Arrays;

/**
 *  https://www.lintcode.com/problem/544/?fromId=161&_from=collection
 *
 *  描述
 *  在一个数组中找到前K大的数
 */
public class TopK {
    public static void main(String[] args) {
       int[] test = new int[]{
               9,3,2,4,8
       };
       int[] result = topk(test, 3);

    }
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public static int[] topk(int[] nums, int k) {
        int[] result = new int[k];

        int minIndex = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (i < k){
                result[i] = nums[i];
                if (nums[i] < result[minIndex]){
                    minIndex = i;
                }
            }else {
                if (nums[i] < result[minIndex]){
                    continue;
                }else {
                    result[minIndex] = nums[i];
                    minIndex = findMin(result);

                }
            }
        }
        Arrays.sort(result);
        int i = 0;
        int j = result.length - 1;
        while (i < j){
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
            i ++;
            j --;
        }
        return result;
    }

    public static int[] topk2(int[] nums, int k) {
        int[] result = new int[k];
        Arrays.sort(nums);
        int index = 0;
        for (int i = nums.length - 1; i >= nums.length - k ; i--) {
            result[index++] = nums[i];
        }

        return result;
    }

    private static int findMin(int[] result){
        int minIndex = 0;
        for (int i = 0; i < result.length ; i++) {
            if (result[i] < result[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }


}
