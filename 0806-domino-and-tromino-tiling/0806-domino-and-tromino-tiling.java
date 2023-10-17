class Solution {
    int MOD = (int)Math.pow(10 , 9) + 7;

    public int numTilings(int n) {
        /**
        n = 1__________1 way
        n = 2__________2 way
        n = 3__________5 way
        n = 4__________ f(4-1)*1 + f(n-2)*1 + f(n-3)*2..... = 11
        
        f(n) = f(n-1) + f(n-2) + 2f(n-3)+......+2f(0)
        f(n-1) = f(n-2)+f(n-3) + 2f(n-4)+......+2f(0)
        subtract_____________________________________________
            f(n)-f(n-1) = f(n-1)+f(n-3) => f(n) = f(n-1)*2 + f(n-3)
        ______________________________________________________
         */

        if(n<=2)  return n;
        long[] dp = new long[n + 1];
        
        dp[0]= 1;
        dp[1] = 1;
        dp[2] = 2;

       for(int i = 3; i<= n;i++){
           dp[i] = (2*dp[i-1] + dp[i-3]) % MOD;
       }

       return (int) dp[n];
    }


}