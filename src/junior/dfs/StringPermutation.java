package junior.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class StringPermutation {

    /**
     * @param str: A string
     * @return: all permutations
     *          we will sort your return value in output
     */
    public List<String> stringPermutation2(String str) {
        List<String> results = new ArrayList<>();
        if (null == str){
            return results;
        }
        if (str.length() == 0){
            results.add("");
            return results;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[chars.length];
        dfs(chars,visited, builder, results);
        return results;
    }

    private void dfs(char[] chars, boolean[] visited, StringBuilder builder, List<String> results){
        if (builder.length() == chars.length){
            results.add(builder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]){
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]){
                continue;
            }
            builder.append(chars[i]);
            visited[i] = true;
            dfs(chars, visited, builder, results);
            visited[i] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
