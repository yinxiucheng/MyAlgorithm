package senior.dp.坐标型;

public class 最长连续上升子序列 {

    public int longestIncreasingContinuousSubsequence(int[] A) {
        int maxInc = 0;
        int maxDec = 0;
        int n = A.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        for (int i = 0; i < n ; i++) {
            inc[i] = 1;
            if (i > 1 && A[i] > A[i - 1]){
                inc[i] = Math.max(inc[i], inc[i-1] + 1);
            }
            maxInc = Math.max(maxInc, inc[i]);
        }

        for (int i = 0; i < n ; i++) {
            dec[i] = 1;
            if (i > 1 && A[i] < A[i - 1]){
                dec[i] = Math.max(dec[i], dec[i-1] + 1);
            }
            maxDec = Math.max(maxDec, dec[i]);
        }
        return Math.max(maxInc, maxDec);
    }
}
