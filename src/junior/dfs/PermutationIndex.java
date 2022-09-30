package junior.dfs;

/**
 * https://www.lintcode.com/problem/197/
 *
 * 描述
 * 给出一个不含重复数字的排列，求这些数字的所有排列按字典序排序后该排列的编号。其中，编号从1开始。
 *
 */
public class PermutationIndex {

    public long permutationIndex(int[] a){
        int len = a.length;
        long permutation = 1;
        long result = 0;

        for (int i = len - 2; i >= 0 ; --i) {
            int smaller = 0;
            for (int j = i + 1; j < len ; j++) {
                if (a[j] < a[i]){
                    smaller++;
                }
            }
            result += smaller * permutation;
            permutation *= len - i;
        }
        return result + 1;
    }
}
