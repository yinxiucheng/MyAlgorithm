package junior.binarysearch;

/**
 * https://www.lintcode.com/problem/585/
 *
 */
public class MountainSequence {

    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        int n = nums.length;
        int start = 0, end = n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.max(nums[start], nums[end]);
    }


}
