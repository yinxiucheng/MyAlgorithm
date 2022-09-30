package senior.presum;

/**
 * 1310 · 数组除了自身的乘积
 *
 *  https://www.lintcode.com/problem/1310/?fromId=178&_from=collection
 */
public class 数组除了自身的乘积 {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        productExceptSelf(nums);
    }

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] results = new int[n];
        results[0] = 1;
        for (int i = 1; i < results.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = results.length - 1; i >= 0; i--) {
            results[i] *= R ;
            R = R * nums[i];
        }

        return  results;
    }
}
