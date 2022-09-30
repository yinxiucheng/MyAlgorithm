package junior.twopointer.partion;

/**
 * 539 · 移动零
 *
 * 描述
 * 给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序
 *
 */
public class MoveZeroes {

    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length <= 1){
            return;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            while (start <= end && nums[start] != 0){
                start++;
            }
            while (start<=end && nums[end] == 0){
                end --;
            }
            if (start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
    }
}
