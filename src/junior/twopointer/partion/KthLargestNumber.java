package junior.twopointer.partion;

/**
 * https://www.lintcode.com/problem/5/
 *
 * 描述
 * 在数组中找到第 k 大的元素。
 */
public class KthLargestNumber {

    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        if (null == nums || nums.length == 0) return -1;

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        return quickSelect(nums, left, right, len - k);
    }

    private int quickSelect(int[] nums, int left, int right, int index){
        if (left == right) return nums[left];

        int mid = (left + right) / 2;
        int pivot = nums[mid];
        int len = nums.length;

        while (left <= right) {
            while (left <= right && nums[right] > pivot){
                right --;
            }
            while (left <= right && nums[left] < pivot){
                left ++;
            }
            if (left <= right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right --;
                left ++;
            }
        }
        if (index > right) {
           return quickSelect(nums, right, len - 1, index - right);
        } else {
          return  quickSelect(nums, 0, left, index);
        }
    }
}
