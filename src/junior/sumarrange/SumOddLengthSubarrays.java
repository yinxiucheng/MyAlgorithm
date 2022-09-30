package junior.sumarrange;

public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        int[] numbs = new int[] {1, 4, 2, 5, 3};
        int sum = sumOddLengthSubArrays(numbs);
        System.out.print("sum is : " + sum);
    }

    public static int sumOddLengthSubArrays(int[] numbs){
        int n = numbs.length;
        int[] preSums = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            preSums[i] = preSums[i-1] + numbs[i - 1];
        }

        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n ; length  += 2) {
                int end = start + length - 1;
                sum += preSums[end + 1] - preSums[start];
            }
        }
        return sum;
    }
}
