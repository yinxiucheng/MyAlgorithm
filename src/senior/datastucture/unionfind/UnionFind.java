package senior.datastucture.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnionFind {

    Map<Integer, Integer> father = new HashMap();
    Set<Integer> graph = new HashSet<>();

    public UnionFind(Set<Integer> dataList){
        for (Integer item: dataList) {
            father.put(item, item);
            graph.add(item);
        }
    }


    public void connect(Integer a, Integer b){
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b){
            father.put(root_a, root_b);
            graph.remove(root_a);
        }
    }

    public int query(){
        return graph.size();
    }

    private int find(int x){
        int j = x, fx;
        while (j != father.get(j)){
            j = father.get(j);
        }

        while (x != j){//路径压缩。
            fx = father.get(x);
            father.put(x, j);
            x = fx;
        }
        return j;
    }
}
