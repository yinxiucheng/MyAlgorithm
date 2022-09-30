package senior.dp.坐标型;

public class 买卖股票2 {

    public int maxProfit(int[] A) {
        int n = A.length;
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            res += Math.max(0, A[i+1] - A[i]);
        }

        return res;
    }
}
