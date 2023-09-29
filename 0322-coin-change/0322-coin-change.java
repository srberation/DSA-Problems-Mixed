class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int[] rows: dp) Arrays.fill(rows, -1 );
        int ans =  fun(coins,0,amount,dp);
        return ans == Integer.MAX_VALUE? -1:ans;
    }
    public int fun(int[] coins, int ind, int amount,int[][] dp){
        if(ind>=coins.length || amount < 0) return Integer.MAX_VALUE;
        if(amount == 0) return 0;
        if(dp[ind][amount] != -1) return dp[ind][amount];

        int not_take = fun(coins,ind+1,amount,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= amount){
            take = fun(coins,ind,amount - coins[ind], dp);
             if(take != Integer.MAX_VALUE) {
                take = 1+take;
            }
        }

        return dp[ind][amount] = Math.min(take,not_take);
    }
}