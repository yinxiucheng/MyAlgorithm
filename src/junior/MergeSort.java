package junior;

public class MergeSort {

    public static void main(String[] args) {
        int[] testNumbers = new int[] {3, 7, 9, 2, 1, 0, 7, 8};
    }

    public static int[] integerSort(int[] nums){
        if (nums == null || nums.length <= 1){
            return nums;
        }
        int[] result = new int[nums.length];
        mergeSortInner(nums, 0, nums.length - 1, result);
        return result;
    }

    private static void mergeSortInner(int[] nums, int start, int end, int[] result){
        if (start >= end){
            return;
        }
        int middle = (start + end)/2;
        mergeSortInner(nums, start, middle, result);
        mergeSortInner(nums, middle + 1, end, result);
        merge(nums, start, end, result);
    }

    private static void merge(int[] nums, int start, int end, int[] result){
        int leftIndex = start;
        int middle = start + end;
        int rightIndex = middle + 1;
        int index = leftIndex;
        while (leftIndex <= middle && rightIndex <= end){
            if (nums[leftIndex] < nums[rightIndex]){
                result[index++] = nums[leftIndex++];
            }else {
                result[index++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= middle){
            result[index++] = nums[leftIndex++];
        }

        while (rightIndex <= end){
            result[index++] = nums[rightIndex++];
        }
    }
}
