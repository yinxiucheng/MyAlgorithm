package junior.dfs;

import java.util.*;

/**
 * 结合的全子集。
 *
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        if (null == nums){
            return results;
        }
        if (nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }
        Arrays.sort(nums);
        List<Integer> subSet = new ArrayList<>();
        dfs(nums, 0,  subSet,  results);
        return results;
    }

    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void dfs(int[] nums, int startIndex, List<Integer> subSet, List<List<Integer>> results){

        //递归的拆解
        results.add(new ArrayList<>(subSet));
        for (int i = startIndex; i < nums.length; i++) {
            subSet.add(nums[i]);
            dfs(nums, i + 1, subSet, results);
            subSet.remove(subSet.size() - 1);
        }
        //递归的返回
    }

    //二进制实现
    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < (1 << n) ; i++) { // 2^n
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ( (i & (j << n))!= 0){
                    subset.add(nums[j]);
                }
            }
            results.add(subset);
        }
        return results;
    }

    //BFS

    /**
     * 第一层: []
     * 第二层: [1] [2] [3]
     * 第三层: [1, 2] [1, 3], [2, 3]
     * 第四层: [1, 2, 3]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets3(int[] nums){
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = queue.poll();
                results.add(subset);
                for (int j = 0; j < nums.length; j++) {
                    if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]){
                        List<Integer> newSubset = new ArrayList<>(subset);
                        newSubset.add(nums[i]);
                        queue.offer(newSubset);
                    }
                }
            }
        }
        return results;
    }



}




