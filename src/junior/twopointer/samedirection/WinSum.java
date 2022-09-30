package junior.twopointer.samedirection;

/**
 *
 * 604 · 滑动窗口内数的和
 *
 * https://www.lintcode.com/problem/604/
 *
 * 描述
 * 给你一个大小为n的整型数组和一个大小为k的滑动窗口，将滑动窗口从头移到尾，输出从开始到结束每一个时刻滑动窗口内的数的和。
 *
 */
public class WinSum {

    public static void main(String[] args) {
        int[] test = new int[] {
                1,2,7,7,2
        };

       int[] result =  winSum(test, 3);
    }
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public static int[] winSum(int[] nums, int k) {

        if (null == nums || nums.length < k || k == 0){
            return new int[]{};
        }

        int i, j= 0;
        int winSum = 0;
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        for ( i = 0; i < nums.length ; i++) {
            while (j < nums.length && j - i < k){
                winSum += nums[j];
                j ++ ;
            }
            if (j < nums.length){
                if (j - i == k) {
                    result[count++] = winSum;
                }
                winSum -= nums[i];
            }else {
                result[count] = winSum;
                break;
            }
        }
        return result;
    }
}
