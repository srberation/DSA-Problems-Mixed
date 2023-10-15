class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fun(n-1,nums,dp);
    }
    public int fun(int i, int[] nums, int[] dp){
        if(i < 0) return 0;
        if(i == 0) return nums[i];
        if(dp[i]!= -1) return dp[i];
        
        return dp[i] = Math.max(nums[i] + fun(i-2,nums,dp), fun(i-1, nums,dp)) ;
    }
}