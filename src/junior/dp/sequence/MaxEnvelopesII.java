package junior.dp.sequence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 602.俄罗斯套娃信封
 * https://www.lintcode.com/problem/602/solution?fromId=161&_from=collection
 *
 * 描述
 * 给一定数量的信封，带有整数对 (w, h) 分别代表信封宽度和高度。一个信封的宽高均大于另一个信封时可以放下另一个信封。
 * 求最大的信封嵌套层数。
 */
public class MaxEnvelopesII {

    public int maxEnvelopes(int[][] envelopes){
        if (null == envelopes || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                int diff = arr1[0] - arr2[0];
                if (diff == 0){
                    diff = arr2[1] - arr1[1];
                }
                return diff;
            }
        });

        int n = envelopes.length;
        //  minLast index 表示 接龙长度为 index对应的 龙，最后一个元素 == minLast[index]， 最小值。
        // 上面排好序的 第一个即可
        int[] minLast = new int[n + 1];
        minLast[0] = Integer.MIN_VALUE;

        for (int i = 1; i < minLast.length ; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < envelopes.length; i++) {
            int index = binarySearch(minLast, envelopes[i][1]);
            minLast[index] = envelopes[i][1];
        }

        for (int i = envelopes.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }
        return 0;
    }

    private int binarySearch(int[] minLast, int target){
        int n = minLast.length;
        int start = 0, end = n - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (minLast[mid] >= target){
                end = mid;
            }else {
                start = mid;
            }
        }

        if (minLast[start] == target){
            return start;
        }
        return end;
    }

}
