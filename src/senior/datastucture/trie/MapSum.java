package senior.datastucture.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1090 · 映射配对之和
 *
 * https://www.lintcode.com/problem/1090/?showListFe=true&page=1&problemTypeId=2&tagIds=397&pageSize=50
 *
 */
public class MapSum {

    TrieNode root;
    public MapSum() {
        root = new TrieNode();
    }

    /**
     * @param key:
     * @param val:
     * @return: nothing
     */
    public void insert(String key, int val) {
        TrieNode now = root;
        for (Character ch: key.toCharArray()) {
            if (!now.child.containsKey(ch)){
                now.child.put(ch, new TrieNode());
            }
            now = now.child.get(ch);
        }
        now.isWord = true;
        now.value = val;
    }

    /**
     * @param prefix:
     * @return: nothing
     */
    public int sum(String prefix) {
        TrieNode now = root;
        for (Character ch: prefix.toCharArray()){
            if (now.child.containsKey(ch)){
                now = now.child.get(ch);
            }else {
                return 0;
            }
        }

        int result = 0;
        //BFS 剩下的树：找到值。
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(now);
        while (!queue.isEmpty()){
            TrieNode curNode = queue.poll();
            if (curNode.isWord){
                result += curNode.value;
            }
            for (TrieNode child: curNode.child.values()) {
                queue.offer(child);
            }
        }
        return result;
    }


    class TrieNode{
        Map<Character, TrieNode> child;
        boolean isWord;
        int value;
        TrieNode(){
            child = new HashMap<>();
        }
    }
}
