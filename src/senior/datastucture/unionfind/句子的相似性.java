package senior.datastucture.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class 句子的相似性 {

    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        Map<String, Integer> strToIndex = new HashMap<>();

        int index = 0;
        for (List<String>  pair: pairs) {
            for (String str: pair) {
                if (!strToIndex.containsKey(str)){
                    strToIndex.put(str, index ++);
                }
            }
        }

        UnionFind_8 unionFind = new UnionFind_8(strToIndex.size());
        for (List<String> pair: pairs) {
            int a = strToIndex.get(pair.get(0));
            int b = strToIndex.get(pair.get(1));
            unionFind.union(a, b);
        }

        for (int i = 0; i < words1.size(); i++) {
            String word1 = words1.get(i);
            String word2 = words2.get(i);
            if(word1.equals(word2)){
                continue;
            }
            if(!strToIndex.containsKey(word1) ||
                    !strToIndex.containsKey(word2)){
                return false;
            }
            int a = strToIndex.get(word1);
            int b = strToIndex.get(word2);
            if (unionFind.find(a) != unionFind.find(b)){
                return false;
            }
        }
        return true;
    }

    class UnionFind_8{
        int[] father;

        public UnionFind_8(int n){
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public void union(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                father[root_a] = root_b;
            }
        }

        public int find(int x){
            int root, now = x, fx = x;
            while (now != father[now]){
                now = father[now];
            }
            root = now;
            while (fx != root){
                father[fx] = root;
                fx = father[fx];
            }
            return root;
        }
    }
}
