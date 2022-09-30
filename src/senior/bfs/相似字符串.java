package senior.bfs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 1430 · 相似字符串组
 *
 * https://www.lintcode.com/problem/1430/?fromId=178&_from=collection
 *
 */
public class 相似字符串 {

    public int numSimilarGroups(String[] a) {
        int[] count = {0};
        int n = a.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                bfs(a[i], a, i, visited, count);
            }
        }
        return count[0];
    }

    private void bfs(String str, String[] list, int i, boolean[] visited, int[] count){
        Queue<String> queue = new ArrayDeque<>();
        visited[i] = true;
        queue.offer(str);

        while (!queue.isEmpty()){
            String curStr = queue.poll();
            Map<Integer, String> similarStr = findSimilarStr(curStr, list, visited);
            for (Map.Entry<Integer, String> entry : similarStr.entrySet()) {
                visited[entry.getKey()] = true;
                queue.offer(entry.getValue());
            }
        }
        count[0] ++;
    }


    private Map<Integer, String> findSimilarStr(String curStr, String[] list, boolean[] visited){
        Map<Integer, String> similarMap = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            if (visited[i]){
                continue;
            }
            if (isSimilar(curStr, list[i])){
                similarMap.put(i, list[i]);
            }
        }
        return similarMap;
    }

    private boolean isSimilar(String original, String compare){
        if (original.length() != compare.length()){
            return false;
        }
        int len = original.length();
        int dif1 = -1, dif2 = -1;
        int difCount = 0;
        for (int i = 0; i < len; i++) {
            if (original.charAt(i) != compare.charAt(i)) {
                difCount++;
                if (difCount > 2) {
                    return false;
                } else if (difCount == 1) {
                    dif1 = i;
                } else {
                    dif2 = i;
                }
            }
        }
        if (difCount == 0){
            return true;
        }else if (difCount == 1){
            return false;
        }else {
            if (original.charAt(dif1) == compare.charAt(dif2) && original.charAt(dif2) == compare.charAt(dif1)){
                return true;
            }
            return false;
        }
    }

}
