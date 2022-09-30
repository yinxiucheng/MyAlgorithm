package junior.datastructure.heap;

/**
 *  https://www.lintcode.com/problem/463/
 *
 *  描述
 *  给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
 *  样例  1:
 * 	输入:  [3, 2, 1, 4, 5]
 * 	输出:  [1, 2, 3, 4, 5]
 *
 * 	样例解释:
 * 	返回排序后的数组。
 *
 *  样例 2:
 * 	输入:  [1, 1, 2, 1, 1]
 * 	输出:  [1, 1, 1, 1, 2]
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 4, 5};
        sortIntegers(a);
        System.out.print("[");
        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");

    }
    /**
     * @param a: an integer array
     * @return: nothing
     */
    public static void sortIntegers(int[] a) {
        heapify(a);
        for (int i = a.length - 1; i >= 0 ; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            siftDown(a, 0,  i - 1);
        }
    }

    private static void siftDown(int[] A, int left, int right){
        int k = left;
        while (2 * k + 1 <= right) {
            int son = 2 * k + 1;
            if (son + 1 <= right && A[son] < A[son + 1]) {
                son = 2 * k + 2;
            }
            if (A[son] <= A[k]){
                break;
            }
            int temp = A[k];
            A[k] = A[son];
            A[son] = temp;
            k = son;
        }
    }

    private static void heapify(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            siftDown(A, i, A.length - 1);
        }
    }
}
