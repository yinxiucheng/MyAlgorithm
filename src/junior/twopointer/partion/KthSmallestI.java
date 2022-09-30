package junior.twopointer.partion;


/**
 * 461 · 无序数组K小元素
 *
 * 描述
 * 找到一个无序数组中第 K 小的数（K 从1开始）。
 *
 */
public class KthSmallestI {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (null == nums || nums.length < k){
            return -1;
        }
        return quickSelect(nums, 0, nums.length -1, k-1);
    }

    private int quickSelect(int[] nums, int start, int end, int k){
        if (start == end){
            return nums[start];
        }

        int i = start;
        int j = end;
        int pivot = nums[(i+j)/2];
        while (i <= j){
            while (i<= j && nums[i] < pivot){
                i++;
            }
            while (i <= j && nums[j] > pivot){
                j--;
            }
            if (i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        if (start + k - 1 <= j){
            return quickSelect(nums, start, j, k);
        }else if (start + k - 1 >= i){
            return quickSelect(nums, i, end, k - (i-start));
        }else {
            return nums[j+1];
        }

    }
}
