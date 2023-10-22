/**
import java.util.*;

class Pair {
    int city;
    int price;

    Pair(int city, int price){
        this.city = city;
        this.price = price;
    }
}

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        this.buildGraph(adj,flights,n);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, 0));
        int steps = 0;
        
        while(!q.isEmpty() && steps <= k){
            int size = q.size();
            while(size-- > 0){
                Pair curr = q.poll();
                int u = curr.city;
                int d = curr.price;
                for(Pair next : adj.get(u)){
                    int v = next.city;
                    int price = next.price;
                    if(dist[u] + price < dist[v]){
                        dist[v] = dist[u] + price;
                        q.offer(new Pair(v, dist[v]));
                    }
                }
            }
            steps++;
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public void buildGraph(List<List<Pair>> adj, int[][] flights, int n){
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }
}
Used BFS
 */
import java.util.*;

class Solution {
    static class Pair {
        int val;
        int price;

        public Pair(int val, int price) {
            this.val = val;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        buildGraph(adj, flights, n); // Removed 'this' as it is a static method call

        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(src, 0));
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE); // Initialize the distance array
        int res = Integer.MAX_VALUE;
        int lvl = k + 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair node = queue.poll();
                if (node.val == dst) {
                    res = Math.min(res, node.price);
                }
                for (Pair neighbor : adj.get(node.val)) { // Changed adj.get(node) to adj.get(node.val)
                    if (distance[neighbor.val] > node.price + neighbor.price) { // Fixed the condition
                        distance[neighbor.val] = node.price + neighbor.price;
                        queue.offer(new Pair(neighbor.val, distance[neighbor.val]));
                    }
                }
            }
            if (lvl == 0) {
                break;
            }
            lvl--;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void buildGraph(List<List<Pair>> adj, int[][] flights, int n) { // Made buildGraph method static
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
    }
}

// class Solution {
//     public int findCheapestPrice(int n, int[][] a, int src, int dst, int k) {
       
//     }
//     public int dfs(List<List<List<Integer>>> graph,int src,int dst,int k,int dp[][])
//     {
       
//     }
// }
