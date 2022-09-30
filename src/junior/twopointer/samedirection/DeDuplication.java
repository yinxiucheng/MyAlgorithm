package junior.twopointer.samedirection;

import java.util.Arrays;

/**
 * https://www.jiuzhang.com/problem/remove-duplicate-numbers-in-array
 *
 * 描述
 * 给一个整数数组，去除重复的元素。
 *
 * 你应该做这些事
 *
 * 1.在原数组上操作
 * 2.将去除重复之后的元素放在数组的开头
 * 3.返回去除重复元素之后的元素个数
 */
public class DeDuplication {

    public static void main(String[] args) {
        int[] arrayTest = new int[]{3, 4, 2, 1, 2, 1, 1};
        int as = deduplication(arrayTest);
        System.out.print("answer is " + as + " arrays:" + arrayTest);

    }
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public static int deduplication(int[] nums) {
        // write your code here
        if (null == nums || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        System.out.print(nums);
        int i,  j = 1;
        for ( i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]){
                continue;
            }
            j = Math.max(j, i + 1);
            while (j < nums.length && nums[i] == nums[j]){ //找到 不相等数的 下表j.
                j ++ ;
            }
            if (j == nums.length) break;
            if (j < nums.length && i + 1 < j){
                nums[i + 1] = nums[j];
            }
        }
        return i + 1;
    }
}
