package junior.sumarrange;

public class ConsecutiveNumberSum {
    //   ( A1 + An) * K/2 =  sum;
    //  (A1 + A1 + K - 1) * K/2 = sum;
    //  (2A1 + K - 1) * K = 2sum;
    //
    //  K 个连续的数 和 sum； 要求 sum = n;
    //  so,  (2A1 + K - 1) * K = 2n;
    //  (2A1 + K - 1)=2n/k 为整数，且 A1 = (2n/k - k + 1)/2 >0 且为整数；
    // 2n/k 为 Integer 则 2n%k == 0
    //    (2n/k - k + 1)/2 >0 为整数 则  (2n/k - k + 1)%2 == 0


    // K的长度 ： K连续的数据 最小和  K(K+1)/2 ,  n 必须 大于等于 最小值 ， 所以
    // K(K+1)<=2n ,  k < sqr(2n)

    public int consecutiveNumberSum(int n){
        int sum = 0;
        int temp = 2*n;
        int len = (int) Math.sqrt(temp);
        //
        for (int k = 1; k <= len; k++) {
            boolean b1 = temp % k == 0;
            boolean b2 = ((temp / k - k + 1) % 2) == 0;
            if (b1 && b2) sum++;
        }
        return sum;
    }


}
