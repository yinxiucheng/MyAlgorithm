package senior.datastucture.trie;

public class WordDictionary {


    public static void main(String[] args) {
        addWord("runner");
        addWord("add");
        addWord("adds");
        addWord("adder");
        addWord("addee");
        System.out.println(search("add."));
        System.out.println(search("....e."));
    }

    static TrieNode root = new TrieNode();
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public static void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.child[c - 'a']== null){
                p.child[c - 'a'] = new TrieNode();
            }
            p = p.child[c - 'a'];
        }
        p.isWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public static boolean search(String word) {
        return find(word, 0, root);
    }

    private static boolean find(String word, int index, TrieNode now){
        if (index == word.length()){
            return now.isWord;
        }

        char c = word.charAt(index);
        if (c == '.'){
            for (int i = 0; i < 26; i++) {
                if (now.child[i] == null){
                    continue;
                }
                //todo 千万不能 这样写 return find(word, index + 1, now.child[i]) 直接跳出循环了。
                if (find(word, index + 1, now.child[i])){
                    return true;
                }
            }
            return false;
        }else {
            if (now.child[c - 'a'] == null){
                return false;
            }else {
                return find(word, index + 1, now.child[c - 'a']);
            }

        }
    }
}
