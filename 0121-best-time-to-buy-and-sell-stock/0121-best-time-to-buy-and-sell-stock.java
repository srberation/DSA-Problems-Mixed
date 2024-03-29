class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int maxProfit = Integer.MIN_VALUE;
       int minSoFar = prices[0];
       for(int i= 0; i<n;i++){
           minSoFar = Math.min(minSoFar, prices[i]);
           int profit = prices[i] - minSoFar;
           maxProfit = Math.max(maxProfit, profit);
       } 

       return maxProfit;
    }
}