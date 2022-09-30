package junior.dfs;

import java.util.List;
import java.util.Map;

/**
 * https://www.lintcode.com/problem/270/?fromId=161&_from=collection
 *
 * 描述
 * 给一些不包含0和1的数字字符串和一个字典，对于每个数字字符串，每个数字代表一个字母，请返回字典中可以匹配的字母组合的数量。
 *
 * 如果可以用一个数字字符串可以表示出一个单词的前缀，我们认为他们之间是匹配的。
 *
 * 下图的手机按键图，就表示了每个数字可以代表的字母。
 */
public class LetterCombinationII {

    /**
     * @param queries: the queries
     * @param dict: the words
     * @return: return the queries' answer
     */
    public int[] letterCombinationsII(String[] queries, String[] dict) {
        Map<Character, List<String>> queryMap = createQueryMap();



        for (int i = 0; i < dict.length; i++) {
            String word = dict[i];

        }
        return new int[1];
    }

    private Map<Character, List<String>> createQueryMap(){
        return null;
    }
}
