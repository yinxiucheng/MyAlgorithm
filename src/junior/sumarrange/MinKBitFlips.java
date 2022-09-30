package junior.sumarrange;

public class MinKBitFlips {

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int cur = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            cur = cur + d[i];
            if ((cur + nums[i]) % 2 == 0){
                if (i + k > n) return  -1;

                d[i] += 1;
                d[i + k]  -= 1;
                count ++ ;
                cur ++;
            }
        }
        return count;
    }
}
