package senior.datastucture.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 团队通知 {

    public int teamNotification(int n, int[][] groups) {
        UnionFind_2 unionFind = new UnionFind_2(n);
        for (int[] group: groups) {
            for (int i = 0; i < group.length; i++) {
                if (i > 0){
                    unionFind.union(group[i], group[i-1]);
                }
            }
        }
        return unionFind.getUnion(0);
    }

    class UnionFind_2{
        Map<Integer, Integer> father;
        Map<Integer, Integer> sizeOfRoot;

        UnionFind_2(int n){
            father = new HashMap<>();
            sizeOfRoot = new HashMap<>();
            for (int i = 0; i < n; i++) {
                father.put(i, i);
                sizeOfRoot.put(i, 1);
            }
        }

        public void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                if (root_b > root_a) {
                    father.put(root_a, root_b);
                    sizeOfRoot.put(root_b, sizeOfRoot.get(root_a) + sizeOfRoot.get(root_b));
                } else {
                    father.put(root_b, root_a);
                    sizeOfRoot.put(root_a, sizeOfRoot.get(root_a) + sizeOfRoot.get(root_b));
                }
            }
        }

        public int find(int x){
          int root_x, fx = x, now = x;
          while (now != father.get(now)){
              now = father.get(now);
          }
          root_x = now;
          while (fx != root_x){
              father.put(fx, root_x);
              fx = father.get(fx);
          }
          return root_x;
        }

        public int getUnion(int x){
            int root_x = find(x);
            return sizeOfRoot.get(root_x);
        }
    }
}
