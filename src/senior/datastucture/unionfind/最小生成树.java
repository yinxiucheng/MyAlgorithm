package senior.datastucture.unionfind;

import java.util.*;

/**
 * 629 · 最小生成树
 *
 * https://www.lintcode.com/problem/629/description?fromId=178&_from=collection
 *
 */
public class 最小生成树 {

    public class Connection {
        public String city1, city2;
        public int cost;

        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public List<Connection> lowestCost(List<Connection> connections) {
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                int diff = o1.cost - o2.cost;
                if (diff == 0){
                    diff = o1.city1.compareTo(o2.city1);
                }
                if (diff == 0){
                    diff = o1.city2.compareTo(o2.city2);
                }
                return diff;
            }
        });

        Map<String, Integer> cityToId = new HashMap<>();
        int n = 0;
        for (Connection connection: connections) {
            if (!cityToId.containsKey(connection.city1)){
                cityToId.put(connection.city1, n);
                n++;
            }
            if (!cityToId.containsKey(connection.city2)){
                cityToId.put(connection.city2, n);
                n++;
            }
        }

        UFS unionFind = new UFS(n);
        List<Connection> result = new ArrayList<>();
        for (Connection connection: connections) {
            if (unionFind.add(cityToId.get(connection.city1), cityToId.get(connection.city2))){
                result.add(connection);
            }
        }

        if (result.size() != n - 1){
            return new ArrayList<>();
        }
        return result;
    }

    public class UFS{
        Map<Integer, Integer> father;

        public UFS(int n){
            father = new HashMap<>();
            for (int i = 0; i < n; i++) {
                father.put(i, i);
            }
        }

        public boolean add(int a, int b){
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b){
                father.put(root_a, root_b);
                return true;
            }
            return false;
        }

        public int find(int x){
            int j = x, fx;
            while (j != father.get(j)){
                j = father.get(j);
            }
            while (x != j){
                fx = father.get(x);
                father.put(x, j);
                x = fx;
            }
            return j;
        }
    }

}
