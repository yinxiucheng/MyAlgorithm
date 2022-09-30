package junior;

public class QuickSort {

    public static void main(String[] args) {
        int[] testArray = new int[] {3, 2, 1, 5, 9, 0, 8, 6, 7};
        quickSort(testArray);
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
    }

    public static void quickSort(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }
        int start = 0;
        int end = nums.length -1;
        quickSortInner(nums, start, end);
    }

    private static void quickSortInner(int[] nums, int start, int end){
        if (start >= end){
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[(start + end)/2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSortInner(nums, start, right);
        quickSortInner(nums, left, end);
    }

}
