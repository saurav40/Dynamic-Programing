class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int t[][]=new int[N+1][W+1];
        
        for(int i=1;i<=N;i++)
          for(int j=1;j<=W;j++)
          {
              if(wt[i-1]<=j)
              {
                  t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]],t[i-1][j]);
              }
              else
              {
                  t[i][j]=t[i-1][j];
              }
          }
          return t[N][W];
    }
}

/*

class Solution{
    
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int t[][]=new int[N+1][W+1];
        for(int arr[]:t)
           Arrays.fill(arr,-1);
        return KnapSack(N,W,val,wt,t);
    }
    static int KnapSack(int n,int W,int[] val,int[] wt,int t[][])
    {
        if(n==0 || W==0)
          return 0;
         if(t[n][W]!=-1)
            return t[n][W];
        //int op1=t[n][W],op2;
         if(wt[n-1]<=W)
         {
             t[n][W]=Math.max(val[n-1]+KnapSack(n,W-wt[n-1],val,wt,t),KnapSack(n-1,W,val,wt,t));
         }
       
       return t[n][W]=Math.max(t[n][W],KnapSack(n-1,W,val,wt,t));
    }
}

*/
