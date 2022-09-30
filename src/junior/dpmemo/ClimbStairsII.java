package junior.dpmemo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/272/?fromId=161&_from=collection
 * 描述
 * 一个小孩爬一个 n 层台阶的楼梯。他可以每次跳 1 步， 2 步 或者 3 步。实现一个方法来统计总共有多少种不同的方式爬到最顶层的台阶。
 */
public class ClimbStairsII {

    /**
     * @param n: An integer
     * @return: An Integer
     */
    public List<List<Integer>> climbStairs(int n) {
        // write your code here
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, path, result);
        return result;
    }

    private void dfs(int n, List<Integer> path, List<List<Integer>> result){
        if (sum(path) == n){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= 3; i++) {
            path.add(i);
            if (sum(path) > n){
                break;
            }
            dfs(n - sum(path), path, result);
            path.remove(path.size() - 1);
        }
    }

    private int sum(List<Integer> path){
        int sum = 0;
        for (int item: path) {
            sum += item;
        }
        return sum;
    }


}
