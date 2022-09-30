package junior.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.lintcode.com/problem/680/?fromId=161&_from=collection
 *
 * 描述
 * 给一个字符串,你可以选择在一个字符或两个相邻字符之后拆分字符串,使字符串由仅一个字符或两个字符组成,输出所有可能的结果
 */
public class SlipStr {

    /**
     * @param s: a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (null == s) {
            return results;
        }
        if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        List<String> subStrs = new ArrayList<>();
        dfs(s, 0, subStrs, results);
        return results;
    }

    private void dfs(String s, int startIndex, List<String> subStrs, List<List<String>> results) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<>(subStrs));
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (startIndex + i > s.length()) {
                return;
            }
            String subStr = s.substring(startIndex, startIndex + i);
            subStrs.add(subStr);
            dfs(s, startIndex + i, subStrs, results);
            subStrs.remove(subStrs.size() - 1);
        }
    }
}
