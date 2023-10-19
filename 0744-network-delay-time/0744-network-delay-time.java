import java.util.*;

class Pair implements Comparable<Pair> {
    int wt;
    int v;

    Pair(int v, int wt) {
        this.wt = wt;
        this.v = v;
    }

    public int compareTo(Pair that) {
        return this.wt - that.wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int source = time[0] - 1;
            int destination = time[1] - 1;
            int weight = time[2];
            adj.get(source).add(new Pair(destination, weight));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        Arrays.fill(ans, 10000000);
        ans[k - 1] = 0;
        pq.add(new Pair(k - 1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int vertex = curr.v;
            if (visited[vertex]) continue;
            visited[vertex] = true;
            List<Pair> neighbors = adj.get(vertex);
            for (Pair pair : neighbors) {
                int u = pair.v;
                int wt = pair.wt;

                if (ans[u] > ans[vertex] + wt) {
                    ans[u] = ans[vertex] + wt;
                    pq.add(new Pair(u, ans[u]));
                }
            }
        }

        int res = 0;
        for (int i = 0; i < ans.length; i++) {
            res = Math.max(res, ans[i]);
        }

        return res == 10000000 ? -1 : res;
    }
}
