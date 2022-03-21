/*------------dp (MEMOIZATION----------------*/
class Solution {
    int memo[][][];
    public int maxProfit(int[] prices) {
      memo=new int[2][3][prices.length];
   //Initilization
        for(int i=0;i<2;i++)
            for(int j=0;j<3;j++)
                for(int k=0;k<prices.length;k++)
                {
                    memo[i][j][k]=-1;
                }
        int result=solve(prices,0,2,0);
        return result;
    }
    private int solve(int [] P,int pos,int tx,int bought)
    {
        if(pos>=P.length || tx==0)
            return 0;
        if(memo[bought][tx][pos]!=-1)
            return memo[bought][tx][pos];
        
        //Skip
        int result=solve(P,pos+1,tx,bought);
        
        //Buy
        if(bought==0)
            result=Math.max(result,solve(P,pos+1,tx,1)-P[pos]);
        else
            result=Math.max(result,solve(P,pos+1,tx-1,0)+P[pos]);//sell
        
        return memo[bought][tx][pos]=result;
    }
}
/*-------------------DIVIDE AND CONQUER--------------------*/
class Solution {
    public int maxProfit(int[] prices) {
         int n=prices.length;
      if(n==0)
         return 0;
      int left[]=new int[n];// For max Profit from left to right for each point
      int right[]=new int[n];// for 1 maxProfit from right to left for each point


     int minS=prices[0];
     for(int i=1;i<n;i++)
     {
       left[i]=Math.max(left[i-1],prices[i]-minS);//1 tx for left
       minS=Math.min(minS,prices[i]);
     }
     
     int maxS=prices[n-1];
     for(int i=n-2;i>=0;i--)
     {
       right[i]=Math.max(right[i+1],maxS-prices[i]);// 1 tx for right
       maxS=Math.max(maxS,prices[i]);
     }
     
     int maxProfit=0;
     for(int i=0;i<n;i++)
     {
       maxProfit=Math.max(maxProfit,left[i]+right[i]);
     }
     return maxProfit;
     
    }
}
/*-----------------------STATE-MACHINE---------------------*/
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)
            return 0;
        int s1=-prices[0],s2=0,s3=Integer.MIN_VALUE,s4=0;
        for(int i=1;i<n;i++)
        {
           s1=Math.max(s1,-prices[i]);
           s2=Math.max(s2,s1+prices[i]);
           s3=Math.max(s3,s2-prices[i]);
           s4=Math.max(s4,s3+prices[i]);
        }
        return s4;
       
    }
}
