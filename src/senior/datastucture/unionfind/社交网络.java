package senior.datastucture.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 *  1569 · 社交网络
 *  https://www.lintcode.com/problem/1569/?showListFe=true&page=1&problemTypeId=2&tagIds=399&pageSize=50
 */
public class 社交网络 {

    public String socialNetwork(int n, int[] a, int[] b) {
        UnionFind_1 unionFind = new UnionFind_1(n);
        for (int i = 0; i < a.length; i++) {
            unionFind.union(a[i], b[i]);
        }
        if (unionFind.setNumbers == 1){
            return "yes";
        }
        return "no";
    }

    class UnionFind_1{

        Map<Integer, Integer> father = new HashMap<>();
        int setNumbers = 0;

        UnionFind_1(int n){
            for (int i = 1; i <= n ; i++) {
                father.put(i, i);
                setNumbers ++;
            }
        }

        public void union(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                father.put(root_a, root_b);
                setNumbers --;
            }
        }

        public int find(int x){
            int now = x, j = x;
            int fx = x;
            while (j != father.get(now) ){
                j = father.get(now);
                now = j;
            }
            while (fx != j){
                father.put(fx, j);
                fx = father.get(fx);
            }
            return j;
        }
    }
}
