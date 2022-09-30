package senior.dp.坐标型;

public class 买卖股票1 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int res = 0;

        for (int i = 1; i < n; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return res;
    }
}
