package junior.twopointer.partion;

/**
 * 31 · 数组划分
 *
 * 描述
 * 给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
 *
 * 所有小于k的元素移到左边
 * 所有大于等于k的元素移到右边
 * 返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
 */
public class PartitionArray {

    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (null == nums || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            while (start <= end && nums[start] < k){
                start ++;
            }
            while (start <= end && nums[end] >= k){
                end --;
            }

            if(start <= end){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
}
