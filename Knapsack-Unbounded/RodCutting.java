class Solution{
    int t[][]=new int[1001][1001];
    public int cutRod(int price[], int n) {
        int []len=new int[n];
        for(int i=0;i<n;i++)
             len[i]=i+1;
        for(int[] arr:t)
            Arrays.fill(arr,-1);
        return RodCutting(price,len,n,n);
    }
    private int RodCutting(int[] p,int []len,int L,int n)
    {
        if(n==0 || L==0)
           return 0;
        if(t[n][L]!=-1)
          return t[n][L];
        if(len[n-1]<=L)
        {
            t[n][L]=Math.max(p[n-1]+RodCutting(p,len,L-len[n-1],n),RodCutting(p,len,L,n-1));
        }
        return t[n][L]=Math.max(t[n][L],RodCutting(p,len,L,n-1));
    }
}

/*
    --------------------Bottom-up----------------------
    class Solution{
    //int t[][]=new int[1001][1001];
    public int cutRod(int price[], int n) {
        int []len=new int[n];
        for(int i=0;i<n;i++)
             len[i]=i+1;
        int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
          for(int j=1;j<=n;j++)
          {
              if(len[i-1]<=j)
              {
                  dp[i][j]=Math.max(price[i-1]+dp[i][j-len[i-1]],dp[i-1][j]);
              }
              else
                dp[i][j]=dp[i-1][j];
          }
        return dp[n][n];
    }
    
}
*/
