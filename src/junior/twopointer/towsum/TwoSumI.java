package junior.twopointer.towsum;

/**
 * 608 · 两数和 II-输入已排序的数组
 *
 * 描述
 * 给定一个已经 按升序排列 的数组，找到两个数使他们加起来的和等于特定数。
 * 函数应该返回这两个数的下标，index1必须小于index2。注意返回的值不是 0-based。
 */
public class TwoSumI {

    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (null == nums || nums.length < 2){
            return result;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            if (nums[start] + nums[end] < target){
                start ++;
            }else if (nums[start] + nums[end] > target){
                end --;
            }else {
                result[0] = start;
                result[1] = end;
                return result;
            }
        }
        return result;
    }
}
