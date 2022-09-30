package junior.binarysearch;

/**
 * https://www.lintcode.com/problem/65/?fromId=161&_from=collection
 *
 * 寻找中位数 两个数组的zz *
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] a = new int[0];
        int[] b = new int[]{1};
        double result = findMedianSortedArrays(a, b);
    }
    /**
     * @param a: An integer array
     * @param b: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int length = a.length + b.length;
        if (length % 2 == 1){
            return findKth(a, 0, b, 0, length/2 + 1);
        }

        return ( (findKth(a, 0, b, 0, length/2) + findKth(a, 0, b, 0, length/2 + 1))/2.0);
        // write your code here
    }

    private static int findKth(int[] a, int aStart, int[] b, int bStart, int k){
        if (aStart >= a.length){
            return b[bStart + k - 1];
        }

        if (bStart >= b.length){
            return a[aStart + k - 1];
        }

        if (k == 1){
            return Math.min(a[aStart], b[bStart]);
        }

        int aIndex = aStart + k/2 - 1 < a.length ? a[aStart + k/2 - 1] : Integer.MAX_VALUE;
        int bIndex = bStart + k/2 - 1 < b.length ? b[bStart + k/2 - 1] : Integer.MAX_VALUE;

        if (aIndex > bIndex) {
            return findKth(a, aStart, b, bStart + k / 2, k - k / 2);
        } else {
            return findKth(a, aStart + k / 2, b, bStart, k - k / 2);
        }
    }
}
