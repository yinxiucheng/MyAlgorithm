package senior.datastucture.heap;

import java.util.*;
import java.util.stream.Collectors;

public class 滑动窗口的中位数 {

    public static void main(String[] args) {
//        int[] nums = {1980,534,251,1358,1779,732,787,1074,640,1392,1388,434,779,912,1123,94,1377,1540,1145,24,1321,526,443,485,671,1422,173,1261,256,834,30,1966,456,320,15,1881,1175,630,408,1536,16,1850,202,1438,157,732,638,913,1466,1921,1803,674,770,1268,853,1010,1149,492,1779,1379,331,1260,1265,871,3,484,1947,1932,1836,1652,1981,356,1435,585,563,1039,1977,1265,1263,171,1679,290,1072,610,598,855,154};
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,-2147483648,-2147483648};
        int k = 3;
       List<Integer> result = medianSlidingWindow(nums, k);
    }

    public static List<Integer> medianSlidingWindow(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        if (null == nums || nums.length < k || k < 0 ){
            return results;
        }
        if (k == 1) {
            for (int item : nums) {
                results.add(item);
            }
            return results;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.offer(nums[0]);
        int median = maxHeap.peek();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > median){
                minHeap.offer(nums[i]);
            }else {
                maxHeap.offer(nums[i]);
            }

            while (minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
            while (maxHeap.size() > minHeap.size() + 1){
                minHeap.offer(maxHeap.poll());
            }

            median = maxHeap.peek();
            if (minHeap.size() + maxHeap.size() == k){
                results.add(median);
                if (nums[i-k + 1] <= median){
                    maxHeap.remove(nums[i-k + 1]);
                }else {
                    minHeap.remove(nums[i-k + 1]);
                }
            }
        }
        return results;
    }
}
