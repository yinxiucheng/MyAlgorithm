package junior.binarysearch;

/**
 * 159 · 寻找旋转排序数组中的最小值
 *
 * https://www.lintcode.com/problem/159/?fromId=161&_from=collection
 *
 *  输入：[4, 5, 6, 7, 0, 1, 2]
 *  输出：0
 *  解释：
 *  数组中的最小值为0
 *
 *
 *  [ 6, 7, 0, 1, 2, 4, 5,]
 */
public class FindMin {

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (null == nums || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[end] ){
                start = mid;
            }else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
