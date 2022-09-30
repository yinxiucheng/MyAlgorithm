package junior.sumarrange;

public class PivotIndex {

    public static void main(String[] args) {
        int[] numbs = new int[] {1, 7, 3, 5, 6, 5};
        int index = pivotIndex(numbs);
        System.out.print(" the pivot index is :" + index);
    }

    public static int pivotIndex(int[] numbs){
        int n = numbs.length;
        int[] preSum = new int[n +1];
        for (int i = 1; i <= n ; i++) {
            preSum[i] = preSum[i-1] + numbs[i-1];
        }

        int totalSum = preSum[n];
        for (int i = 0; i < n; i++) {
            if (numbs[i] == totalSum - 2 * preSum[i]){
                return i;
            }
        }
        return -1;
    }
}
