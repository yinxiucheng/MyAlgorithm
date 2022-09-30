package senior.binarysearch;

/**
 * 633 · 寻找重复的数
 *
 * https://www.lintcode.com/problem/633/
 *
 * 描述
 * 给出一个数组 nums 包含 n + 1 个整数，每个整数是从 1 到 n (包括边界)，保证至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 *
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1};
        int result = findDuplicate(nums);
        System.out.println("the result is " + result);
    }

    public static int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        int mid;
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (count(nums, mid)){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (count(nums, start)){
            return end;
        }
        return start;
    }

    /**
     *
     * @param nums
     * @param value
     * @return
     *
     * 在数组 int[] nums 中， 大于等于 value的值出现的次数要 大于 value本身，则返回true.
     */
    private static boolean count(int[] nums, int value){
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= value){
                times ++;
            }
        }
        return times <= value;
    }
}
