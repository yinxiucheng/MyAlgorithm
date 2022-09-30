package junior.twopointer.partion;

/**
 * https://www.lintcode.com/problem/5/
 *
 * 描述
 * 在数组中找到第 k 大的元素。
 */
public class KthLargestNumberI {

    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        if (null == nums || nums.length == 0) return -1;

        int len = nums.length;
        int start = 0;
        int end = len - 1;
        return quickSelect(nums, start, end, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k){
        if (start == end) return nums[start];

        int i = start, j = end;
        int mid = (i + j) / 2;
        int pivot = nums[mid];

        while (i <= j){
            while (i <= j && nums[i] > pivot){
                i++;
            }
            while (i<= j && nums[j] < pivot){
                j--;
            }
            if (i <= j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            }
        }

        if (start + k - 1 <= j){// 左边找
            return quickSelect(nums, start, j, k);
        }

        if (start + k - 1 >= i){// 右边找
            return quickSelect(nums, i, end, k - (i-start));
        }
        return nums[j+1];
    }
}
