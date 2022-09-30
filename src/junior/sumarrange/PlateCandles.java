package junior.sumarrange;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/plates-between-candles/
 *
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串s，它只包含字符'*' 和'|'，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 *
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 *
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 *
 */
public class PlateCandles {

    public static void main(String[] args) {
        String s = "***";
        int[][] queries = new int[][] {{2, 2}};
        int[] result = platesBetweenCandles(s, queries);

        for (int i = 0; i < result.length; i++) {
            if (i == 0) System.out.print("[ ");
            System.out.print(result[i]);
            if (i != result.length - 1)  System.out.print(" , ");
            else {
                System.out.print(" ] ");
            }
        }
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int m = queries.length;
        int[] result = new int[m];

        char[] chartArray = s.toCharArray();
        int len = chartArray.length;
        int[] sum = new int[len + 1];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (chartArray[i] == '|') list.add(i);
            sum[i + 1] = sum[i] + (chartArray[i] == '*' ? 1 : 0);
        }

        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int leftCandleIndex = findLeftCandle(list, query[0]);
            int rightCandleIndex = findRightCandle(list, query[1]);
            int plates = 0;
            if (leftCandleIndex < rightCandleIndex){
                plates = sum[rightCandleIndex + 1] - sum[leftCandleIndex];
            }
            result[i] = plates;
        }
        return result;
    }

    /**
     * 寻找左端第一个大于等于 leftPivot 的坐标。
     * @param list
     * @param leftPivot
     * @return
     */
    private static int findLeftCandle(ArrayList<Integer> list, int leftPivot) {
        if (list.size() == 0){
            return 0;
        }
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < leftPivot) left = mid;
            else {
                right = mid;
            }
        }
        if (list.get(left) >= leftPivot) return list.get(left);
        return list.get(right);
    }

    /**
     *  寻找右端 第一个 小于等于 rightPivot的坐标。
     * @param list
     * @param rightPivot
     * @return
     */
    private static int findRightCandle(ArrayList<Integer> list, int rightPivot) {
        if (list.size() == 0){
            return 0;
        }
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > rightPivot) right = mid;
            else {
                left = mid;
            }
        }
        if (list.get(right) <= rightPivot) return list.get(right);
        return list.get(left);
    }


}
