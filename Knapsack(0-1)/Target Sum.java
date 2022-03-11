class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        // code here
        int sum=0;
        for(int i=0;i<N;i++)
           sum+=A[i];
        if((sum+target)%2!=0)
              return 0;
        sum=(target+sum)/2;
     
        int dp[][]=new int[N+1][sum+1];
        for(int i=0;i<=N;i++)
          dp[i][0]=1;
        for(int i=1;i<=N;i++)
         for(int j=1;j<=sum;j++)
         {
             if(A[i-1]<=j)
             {
                 dp[i][j]=dp[i-1][j-A[i-1]] + dp[i-1][j];
             }
             else
                dp[i][j]=dp[i-1][j];
         }
         return dp[N][sum];
    }
};
