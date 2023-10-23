class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp[i][j] the cheapest prices from src to i with at most j-1 stops
        int[][] dp = new int[n][k+2];

        // At first, set all price to be MAX_VALUE
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // From src to src with any k stops, the cheapest price would be 0
        for (int j = 0; j <= k+1; j++) {
            dp[src][j] = 0;
        }

        // From any other node, it is impossible to reach with j-1 stop with j = 0, so leave the cost to be MAX_VALUE; No other base cases

        for (int j = 1; j <= k+1; j++) {
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                // if from hasn't been reached yet, continue
                if (dp[from][j-1] == Integer.MAX_VALUE) continue;
                dp[to][j] = Math.min(dp[to][j], dp[from][j-1]+cost);
            }
        }

        return dp[dst][k+1] == Integer.MAX_VALUE ? -1 : dp[dst][k+1];
    }
}