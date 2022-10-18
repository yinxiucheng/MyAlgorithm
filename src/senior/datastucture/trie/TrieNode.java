package senior.datastucture.trie;

public class TrieNode {

    public TrieNode[] child;
    public boolean isWord;

    public TrieNode(){
        child = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            child[i] = null;
        }
        isWord = false;
    }
}
