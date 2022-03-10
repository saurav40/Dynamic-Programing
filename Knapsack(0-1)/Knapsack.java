class Solution 
{ 
    
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int t[][]=new int[n+1][W+1];
        for(int arr[]:t){
            Arrays.fill(arr,-1);
        }
        return Knapsack(n,W,wt,val,t);
    } 
    public static int Knapsack(int n,int W,int []wt,int []val,int t[][])
    {
        if(n==0 || W==0)
          return 0;
        if(t[n][W]!=-1)
           return t[n][W];
         
           if(wt[n-1]<=W)
           { 
             t[n][W]=Math.max(val[n-1]+Knapsack(n-1,W-wt[n-1],wt,val,t),Knapsack(n-1,W,wt,val,t));
           }
           else
              t[n][W]=Knapsack(n-1,W,wt,val,t);
            return t[n][W];
    }
}
