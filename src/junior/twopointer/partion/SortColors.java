package junior.twopointer.partion;

/**
 * 148 · 颜色分类
 * 描述
 * 给定一个包含红，白，蓝且长度为 n 的数组，将数组元素进行分类使相同颜色的元素相邻，并按照红、白、蓝的顺序进行排序。
 *
 * 我们使用整数 0，1 和 2 分别代表红，白，蓝。
 *
 *
 */
public class SortColors {

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (null == nums || nums.length <= 1){
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            while (start <= end && nums[start] == 0){
                start ++ ;
            }
            while (start <= end && nums[start] > 0){
                end --;
            }
            if (start < end){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start ++ ;
                end --;
            }
        }

        end = nums.length - 1;
        while (start <= end){
            while (start <= end && nums[start] == 1){
                start ++;
            }
            while (start <= end && nums[start] == 2){
                end --;
            }
            if (start <= end){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end --;
                start ++;
            }
        }
    }
}
