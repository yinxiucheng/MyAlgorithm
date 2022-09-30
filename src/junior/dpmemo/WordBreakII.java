package junior.dpmemo;

import java.util.*;

/**
 *
 * https://www.lintcode.com/problem/582/?fromId=161&_from=collection
 * 描述
 * 给一字串s和单词的字典dict,在字串中增加空格来构建一个句子，并且所有单词都来自字典。
 * 返回所有有可能的句子。
 */
public class WordBreakII {
    /**
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     *          we will sort your return value in output
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> path = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int maxLength = getMaxLength(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        dfs(s, wordDict, 0, maxLength, memo, path, result);
        return result;
    }

    private void dfs(String s, Set<String> wordDict, int index, int maxLength, Map<Integer, Boolean> memo, List<String> path, List<String> result){
        if (index == s.length()){
            result.addAll(new ArrayList<>(path));
            return;
        }

        if (!isPossible(s, wordDict, index, maxLength, memo)){
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (subStr.length() > maxLength){
                break;
            }
            if (!wordDict.contains(subStr)){
                continue;
            }
            path.add(subStr);
            dfs(s, wordDict, i+1, maxLength, memo, path, result);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPossible(String s, Set<String> wordDict, int index, int maxLength, Map<Integer, Boolean> memo) {
        if (index == s.length()) {
            return true;
        }
        memo.put(index, false);
        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (subStr.length() > maxLength) {
                break;
            }
            if (!wordDict.contains(subStr)) {
                continue;
            }
            if (isPossible(s, wordDict, i + 1, maxLength, memo)) {
                memo.put(index, true);//index 之后都是 可以拆分成功。
                break;
            }
        }
        return memo.get(index);
    }

    private int getMaxLength(Set<String> wordDict){
        int maxLength = Integer.MIN_VALUE;
        for (String str: wordDict) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }

}
