package junior.datastructure.heap;

/**
 * https://www.lintcode.com/problem/130/
 *
 * 描述
 * 给出一个整数数组，把它变成一个最小堆数组，这称为堆化操作。
 *
 * 对于堆数组A，A[0]是堆的根，并对于每个A[i]，A [i * 2 + 1]是A[i]的左儿子并且A[i * 2 + 2]是A[i]的右儿子。
 *
 */
public class Heapify {

    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,4,5};
        heapify(A);
    }

    private static void siftUp(int[] A, int k){
        while (k != 0){
            int father = (k - 1)/2;
            if (A[father] < A[k]){
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;
            k = father;
        }
    }

    public static void heapify(int[] a) {
        for (int i = 0; i < a.length; i++) {
            siftUp(a, i);
        }
    }

    public void heapify2(int[] a) {
        for (int i = (a.length - 1)/2; i >= 0; i--) {
            siftDown(a, i);
        }
    }

    private void siftDown(int[] A, int k){
        while (2 * k + 1 < A.length) {
            int son = 2 * k + 1;
            int right = son + 1;
            if (right < A.length && A[right] < A[son]) {
                son = right;
            }
            if (A[k] < A[son]) {
                break;
            }
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }
}
