class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return fun(n-1,m-1,text1,text2,dp);
    }

    static int fun(int ind1, int ind2, String text1, String text2, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] = 1+fun(ind1-1, ind2-1, text1, text2,dp);
        }
        else{
            return dp[ind1][ind2] = Math.max(fun(ind1, ind2-1, text1, text2,dp), fun(ind1 - 1, ind2, text1, text2,dp));
        }

    }
}