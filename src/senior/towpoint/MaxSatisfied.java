package senior.towpoint;

/**
 * 1849 · 爱生气的书店老板
 * https://www.lintcode.com/problem/1849/?fromId=178&_from=collection
 *
 *
 * 描述
 * 有一个书店，在接下来的nn天中的第ii天会有customer[i]个顾客到来，并且在这一天结束后离开。
 *
 * 但是书店老板的脾气时好时坏，我们用一个数组grumpygrumpy表示他每一天的脾气好坏，若grumpy[i]=1, 则表示第ii天老板的脾气很不好；若grumpy[i]=0, 则表示第ii天老板的脾气很好。
 *
 * 若某一天书店老板的脾气不好，则会导致所有当天来的所有顾客会给书店差评。但如果某一天脾气好，那么当天所有顾客都会给书店好评。
 *
 * 老板想要尽量增加给书店好评的人数数量，想了一个方法。他可以保持连续XX天的好脾气。但这个方法只能使用一次。
 *
 * 那么在这nn天这个书店最多能有多少人离开时给书店好评？
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int sum = 0;
        int len = customers.length;
        //初始化
        for (int i = 0; i < len; i++) {
            if (i < x){
                sum += customers[i];
            }else {
                sum += customers[i] * (1 - grumpy[i]);
            }
        }

        int ans = sum;
        //滑动窗口。
        for (int i = x; i < len ; i++) {
            if (grumpy[i - x] == 1){
                sum -= customers[i - x];
            }
            if (grumpy[i] == 1){
                sum += customers[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
