package junior.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.lintcode.com/problem/425/?fromId=161&_from=collection
 *
 * 描述
 * 给一个不包含0和1的数字字符串，每个数字代表一个字母，请返回其所有可能的字母组合。
 *
 * 下图的手机按键图，就表示了每个数字可以代表的字母。
 *
 * 1	2
 *     ABC	3
 *         DEF
 *     4
 *    GHI	5
 *         JKL	6
 *             MNO
 *    7
 *   PQRS	 8
 *         TUV	 9
 *             WXYZ
 */
public class LetterCombinations {

    /**
     * @param digits: A digital string
     * @return: all possible letter combinations
     *          we will sort your return value in output
     */
    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (null == digits || digits.length() == 0){
            return  results;
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");

        StringBuilder builder = new StringBuilder();
        dfs(builder, digits, map, results);
        return results;
    }

    private static void dfs(StringBuilder builder, String digits,HashMap<Integer, String> map, List<String> results){
        if (builder.length() == digits.length()){
            results.add(builder.toString());
            return;
        }

        char c = digits.charAt(builder.length());
        int num = c - '0';
        String patchStr = map.get(num);
        int strLength = patchStr.length();

        for (int j = 0; j < strLength; j++) {
            builder.append(patchStr.charAt(j));
            dfs( builder, digits, map, results);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        String phoneNum = "23";
        List<String> results = letterCombinations(phoneNum);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

}
