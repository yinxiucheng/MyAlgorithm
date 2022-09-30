package junior.dpmemo;

import java.util.*;

/**
 * https://www.lintcode.com/problem/582
 *
 * 描述
 * 给一字串s和单词的字典dict,在字串中增加空格来构建一个句子，并且所有单词都来自字典。
 * 返回所有有可能的句子。
 *
 * 分治的方法 递归。
 */
public class WordBreakI {

    /**
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     *          we will sort your return value in output
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {

        int maxLength = getMaxLength(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return  dfs(s, wordDict, maxLength, memo);
    }

    private List<String> dfs(String s, Set<String> wordDict, int maxLength, Map<String, List<String>> memo){
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String preStr = s.substring(0, i);
            if (preStr.length() > maxLength){
                break;
            }
            if (!wordDict.contains(preStr)){
                continue;
            }
            if (i == s.length() - 1){
                ans.add(preStr);
            }else {
                String subStr = s.substring(i);
                List<String> subList = dfs(subStr, wordDict, maxLength, memo);
                for (String sub: subList) {
                    ans.add(preStr + " " + sub);
                }
            }
        }
        memo.put(s, ans);
        return ans;
    }



    private int getMaxLength( Set<String> wordDict){
        int maxLength = Integer.MIN_VALUE;
        for (String str: wordDict) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }


}
