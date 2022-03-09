class Solution {
    // public int dp(int i)
    // {
    //     if(i<=2)
    //         return i;
    //     return dp(i-1)+dp(i-2);
    // }
    public int climbStairs(int n) {
        int dp[]=new int[n];
        if(n==1)
            return 1;
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}
