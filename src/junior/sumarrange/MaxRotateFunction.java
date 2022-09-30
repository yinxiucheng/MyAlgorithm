package junior.sumarrange;

import java.util.Arrays;

public class MaxRotateFunction {

//    F0 = 0 * nums[0] + 1 * nums[1] …… + （n-1） * nums[n-1]
//    F1 = 0 * nums[n-1] + 1 * nums[0] + …… + (n - 2) * nums[n -2]
//    F1 - F0 = Sum(nums[0] + …… + nums[n-1]) - n * nums[n-1]
//    F1 = F0 + sum - n * nums[n-1]
//    Fk = Fk-1 + sum - n * nums[n - k]
    public int maxRotateFunction(int[] nums){
        int n = nums.length;
        int f = 0;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }

        int res = f;
        for (int i = 1; i < n ; i++) {
            f += sum - n * nums[n - i];
            res = Math.max( res, f);
        }
        return  res;
    }
}
