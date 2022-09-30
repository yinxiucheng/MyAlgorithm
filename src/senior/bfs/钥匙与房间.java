package senior.bfs;

import java.util.*;

/**
 * 1428 · 钥匙和房间
 * https://www.lintcode.com/problem/1428/
 *
 */
public class 钥匙与房间 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);

        List<Integer> list3 = new ArrayList<>();
        list3.add(2);

        List<Integer> list4 = new ArrayList<>();
        list4.add(0);

        List<List<Integer>> results = new ArrayList<>();
        results.add(list1);
        results.add(list2);
        results.add(list3);
        results.add(list4);

       boolean canEntry =  canVisitAllRooms(results);

    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Set<Integer>> graph = buildGraph(rooms);

        int n = rooms.size();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int count = 1;
        while (!queue.isEmpty()){
            //取出 curRoom 去 curRoom 拿钥匙。
            Integer curRoom = queue.poll();
            for (Integer neighbor: graph.get(curRoom)) {
                if (visited[neighbor]){
                    continue;
                }
                visited[neighbor] = true;
                count ++;
                queue.offer(neighbor);//拿到 neighbor 门的钥匙。
            }
        }
        return count == n;
    }

    private static Map<Integer, Set<Integer>> buildGraph(List<List<Integer>> rooms){
        int n = rooms.size();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < rooms.size(); i++) {
            List<Integer> neighbors = rooms.get(i);
            graph.get(i).addAll(neighbors);
            graph.get(i).remove(i);
        }
        return graph;
    }
}
