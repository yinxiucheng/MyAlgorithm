package senior.datastucture.unionfind;

import java.util.*;

/**
 * 444 · 图是否是树 II
 */
public class UnionFind4 {
    Map<Integer, Integer> father;
    int vertexNum = 0, edgeNum = 0;
    boolean hasCircle = false;

    public UnionFind4(){
        father = new HashMap<>();
    }

    public void addEdge(int a, int b) {
        if (!father.containsKey(a)){
            father.put(a, a);
            vertexNum ++;
        }
        if (!father.containsKey(b)){
            father.put(b, b);
            vertexNum ++;
        }
        edgeNum++;
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father.put(root_a, root_b);
        }else {
            hasCircle = true;
        }
    }

    private int find(int x){
        int root = x, fx;
        while (root != father.get(root)){
            root = father.get(root);
        }
        while (x != root){
            fx = father.get(x);
            father.put(x, root);
            x = fx;
        }
        return root;
    }


    /**
     * @return: check whether these edges make up a valid tree
     */
    public boolean isValidTree() {
        if (!hasCircle && edgeNum + 1 == vertexNum){
            return true;
        }
        return false;
    }
}
