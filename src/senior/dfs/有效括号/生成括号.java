package senior.dfs.有效括号;

import java.util.ArrayList;
import java.util.List;

/**
 * 427 · 生成括号
 * https://www.lintcode.com/problem/427/?fromId=178&_from=collection
 *
 */
public class 生成括号 {

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();

        dfs(0, 0, n, "", results);
        return results;
    }

    /**
     *
     * @param leftCnt '('当前的数量
     * @param rightCnt ')'当前的数量
     * @param n
     * @param results 存储答案。
     */
    private void dfs(int leftCnt, int rightCnt, int n, String path, List<String> results){
        if (leftCnt == n && rightCnt == n){
            results.add(path);
            return;
        }

        if (leftCnt < n){
            dfs(leftCnt + 1, rightCnt, n, path + '(', results);
        }

        if (rightCnt < leftCnt){
            dfs(leftCnt, rightCnt + 1, n, path + ')', results);
        }
    }
}
