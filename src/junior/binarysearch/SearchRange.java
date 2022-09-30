package junior.binarysearch;

public class SearchRange {

    /**
     * @param a: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] a, int target) {
        // write your code here
        int[] result = new int[2];

        if (null == a || a.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int leftIndex = binarySearch(a, target, true);
        result[0] = leftIndex;
        if (leftIndex != -1){
            result[1] = binarySearch(a, target, false);
        }else {
            result[1] = -1;
        }
        return  result;
    }

    private int binarySearch(int[] a, int target, boolean leftIndex){
        int left = 0, right = a.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (a[mid] == target){
                if (leftIndex){
                    right = mid;
                }else {
                    left = mid;
                }
            }else if (a[mid] > target){
                right = mid;
            }else {
                left = mid;
            }
        }

        if (leftIndex){
            if (target == a[left]) return left;
            else  if (target == a[right]) return right;
            else  return  -1;
        }else {
            if (target == a[right]) return right;
            else if (target == a[left] ) return left;
            else  return -1;
        }
    }
}
