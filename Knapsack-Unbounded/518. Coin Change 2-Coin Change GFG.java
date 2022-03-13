class Solution {
    public int change(int amount, int[] coins) {
      int n=coins.length;
      int dp[][]=new int[n+1][amount+1];
     // amount=0 dp[i][0]=1
        for(int i=0;i<=n;i++)
            dp[i][0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(coins[i-1]<=j)
                {
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
}

/*
   class Solution {
    private int[][]t=new int[301][5001];
    public int change(int amount, int[] coins) {
        for(int [] arr:t)
             Arrays.fill(arr,-1);
        return countSS(coins,amount,coins.length);
    }
     private int countSS(int[] coins,int amount,int n)
    {
      if(amount==0)
            return 1;
        if(amount<0 || (n<=0 && amount>=1))
            return 0;
         if(t[n][amount]!=-1)
              return t[n][amount];
        if(coins[n-1]<=amount)
        {
            return t[n][amount]=countSS(coins,amount-coins[n-1],n)+countSS(coins,amount,n-1);
        }
        return t[n][amount]=countSS(coins,amount,n-1);  
    }
}
*/
