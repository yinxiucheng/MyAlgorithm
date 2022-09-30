package junior.twopointer.partion;

/**
 * 144 · 交错正负数
 *
 * 描述
 * 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。
 *
 *
 */
public class Rerange {

    public static void main(String[] args) {
        int[] test = new int[]{
                26,-31,10,-29,17,18,-24,-10
        };
        rerange(test);
    }

    /**
     * @param a: An integer array.
     * @return: nothing
     */
    public static void rerange(int[] a) {

        int positive = 0;
        int negative = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i]>0){
                positive ++;
            }else {
                negative ++;
            }
        }

        int start = 0;
        int end = a.length - 1;
        int flag = positive > negative ? 1 : -1;

        while (start <= end){
            while (start <= end && a[start] * flag < 0){
                start++;
            }

            while (start <= end && a[end] * flag > 0){
                end --;
            }

            if (start <= end){
                swap(a, start, end);
                start ++;
                end --;
            }
        }

        boolean b = (end + 1) % 2 == 0;  //前面偶数个。
        int i = 0;
        int j = b ? start + 1 : start;
        while (i < start) {
            swap(a, i, j);
            i += 2;
            j += 2;
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
