package junior.binarysearch;

/**
 * 183 · 木材加工
 *
 * 描述
 * 有一些原木，现在想把这些木头切割成一些长度相同的小段木头，需要得到的小段的数目至少为 k。给定L和k，你需要计算能够得到的小段木头的最大长度。
 *
 * 输入:
 * L = [232, 124, 456]
 * k = 7
 * 输出: 114
 * 说明: 我们可以把它分成 114 的 7 段，而 115 不可以
 * 而且对于 124 这根原木来说多余的部分没用可以舍弃，不需要完整利用
 *
 *
 * 输入:
 * L = [1, 2, 3]
 * k = 7
 * 输出: 0
 * 说明: 很显然我们不能按照题目要求完成。
 *
 */
public class WoodCut {

    public static void main(String[] args) {
        int[] l = {232,124,456};
        int len = woodCut(l, 7);
        System.out.print("len is " + len);
    }

    public static int woodCut(int[] l, int k) {
        if (null == l || l.length == 0){
            return 0;
        }
        int maxL = findMax(l);
        int start = 0;
        int end = maxL;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (getPieces(l, mid) >= k){// 木头比较少，长度太长了， 需要变短些
                start = mid;
            }else {
                end = mid;
            }
        }

        if (getPieces(l, end) <= k){
            return end;
        }
        return start;
    }

    private static int getPieces(int[] l , int len){
        int pieces = 0;
        for (int i = 0; i < l.length; i++) {
            pieces += l[i]/len;
        }
        return pieces;
    }

    private static int findMax(int[] l){
        int maxL = l[0];
        for (int i = 1; i < l.length; i++) {
           maxL = Math.max(maxL, l[i]);
        }
        return maxL;
    }
}
