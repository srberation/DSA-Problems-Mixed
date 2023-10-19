// simply use dijikstra algo which will use Priority Queue,and form an array with nodes and minimum distance from the given source 

import java.util.*;

class Pair implements Comparable<Pair> {
    int time;
    int v;

    Pair(int v, int time) {
        this.time = time;
        this.v = v;
    }

    public int compareTo(Pair that) {
        return this.time - that.time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ele : times) {
            int source = ele[0];
            int destination = ele[1];
            int time = ele[2];
            adj.get(source).add(new Pair(destination, time));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] ans = new int[n + 1];
        Arrays.fill(ans, 10000000);
        ans[k] = 0;
        pq.add(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int vertex = curr.v;
            if (visited[vertex]) continue;
            visited[vertex] = true;
            List<Pair> neighbors = adj.get(vertex);
            for (Pair pair : neighbors) {
                int u = pair.v;
                int t = pair.time;

                if (ans[u] > ans[vertex] + t) {
                    ans[u] = ans[vertex] + t;
                    pq.add(new Pair(u, ans[u]));
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, ans[i]);
        }

        return res == 10000000 ? -1 : res;
    }
}

