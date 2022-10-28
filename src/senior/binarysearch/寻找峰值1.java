package senior.binarysearch;

/**
 * 75 · 寻找峰值
 * https://www.lintcode.com/problem/75/description
 *
 */
public class 寻找峰值1 {

    public int findPeak(int[] A) {
        int len = A.length;
        int start = 0, end = len - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }
}
