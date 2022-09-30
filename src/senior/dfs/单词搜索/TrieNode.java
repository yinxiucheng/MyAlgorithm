package senior.dfs.单词搜索;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    String word;
    Map<Character, TrieNode> child;

    public TrieNode(){
        child = new HashMap<>();
    }
}
