package junior.dfs;

/**
 * https://www.lintcode.com/problem/52/
 *
 * 描述
 * 给定一个整数数组来表示排列，按升序找出其下一个排列。
 *
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2};
        int[] permutation =  nextPermutation(nums);
        for (int i = 0; i < permutation.length; i++) {
            if (i != permutation.length - 1){
                System.out.print(permutation[i] + '，');
            }
        }
    }

    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public static int[] nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }
        //  从右往左 找到第一个 升序点 例如{...6, 9, 7, 5} 中 6的位置
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i != 0) {
            int j = len - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {
                j--;
            }
            swapItem(nums, i - 1, j);
        }
        reverse(nums, i, len - 1);
        return nums;
    }

    private static void swapItem(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void reverse(int[] nums, int i, int j){
        while (i < j){
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }

}
