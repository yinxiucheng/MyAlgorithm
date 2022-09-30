package junior.binarysearch;

/**
 * 447 · 在大数组中查找
 *
 * 描述
 * 给一个按照升序排序的非负整数数组。这个数组很大以至于你只能通过固定的接口 ArrayReader.get(k) 来访问第k个数(或者C++里是ArrayReader->get(k))，并且你也没有办法得知这个数组有多大。
 *
 * 找到给出的整数target第一次出现的位置。你的算法需要在O(logk)的时间复杂度内完成，k为target第一次出现的位置的下标。
 *
 * 如果找不到target，返回-1。
 *
 * 样例
 * 样例 1:
 *
 * 输入: [1, 3, 6, 9, 21, ...], target = 3
 * 输出: 1
 * 样例 2:
 *
 * 输入: [1, 3, 6, 9, 21, ...], target = 4
 * 输出: -1
 */
public class SearchBigSortedArray {

    public int searchBigSortedArray(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;
        while (reader.get(end) < target){
            end <<=  1;
        }

        while (start + 1 < end){
            int mid = (start + end)>>1;
            if (reader.get(mid) < target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if (reader.get(start) == target){
            return start;
        }

        if (reader.get(end) == target){
            return end;
        }

        return -1;
    }

    class ArrayReader{

        public int get(int K){
            return (int) (Math.random() * 1000/K);
        }
    }
}
