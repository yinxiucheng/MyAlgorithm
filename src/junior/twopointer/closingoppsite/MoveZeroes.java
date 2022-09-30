package junior.twopointer.closingoppsite;

/**
 * 539 · 移动零
 * 描述
 * 给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序
 *
 * 样例
 * 例1:
 *
 * 输入: nums = [0, 1, 0, 3, 12],
 * 输出: [1, 3, 12, 0, 0].
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

        int slow=0, fast = 0;
        while (fast < nums.length){
            if (nums[fast] != 0){
                if (slow != fast){//将 非0 元素都往上堆。
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast ++;
        }

        while (slow < nums.length){
            if (nums[slow] != 0){
                nums[slow] = 0;
            }
            slow ++;
        }
    }
}
