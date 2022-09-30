package senior.recursion;

import java.util.List;

/**
 * 297 · 寻找最大值
 * https://www.lintcode.com/course/43/learn/297?chapterId=290&sectionId=1688&extraParams=%7B%22moduleSource%22%3A%22lc-course%3A43%22%7D&ac=false
 *
 */
public class MaxNum {

    public int maxNum(List<Integer> nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i));
        }
        return max;
    }

    public int maxNum1(List<Integer> nums){
       return maxNumsInner(nums, 0, nums.size() - 1);
    }

    //递归的写法
    public int maxNumsInner(List<Integer> nums, int start, int end){
        if (start > end){
            return Integer.MIN_VALUE;
        }
        return Math.max(nums.get(start), maxNumsInner(nums, start+1, end));
    }


    public int maxNumsTail(List<Integer> nums, int start, int end, int result){
        if (start > end){
            return result;
        }
        result = Math.max(result, nums.get(start));
        return maxNumsTail(nums, start + 1, end, result);
    }


    public int maxNums2(List<Integer> nums, int start, int end, int result){
        while (true){
            if (start > end){
                return result;
            }
            int newEnd = end;
            int newStart = start + 1;
            int newResult = Math.max(result, nums.get(start));
            List<Integer> newNums = nums;

            nums = newNums;
            start = newStart;
            end = newEnd;
            result = newResult;
        }
    }



}
