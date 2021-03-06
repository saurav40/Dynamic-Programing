class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++)
        {
            sum+=arr[i];
        }
        if(sum%2==0){

        if(isSubsetSum(N,arr,sum/2))
            return 1;}
        
       return 0;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
           Boolean dp[][]=new Boolean[N+1][sum+1];
           for(int i=0;i<=sum;i++)
           {
               dp[0][i]=false;
           }
           for(int i=0;i<=N;i++)
           {
               dp[i][0]=true;
           }
           
           for(int i=1;i<=N;i++)
           {
               for(int j=1;j<=sum;j++)
               {
                   if(arr[i-1]<=j)
                   {
                       dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                   }
                   else
                     dp[i][j]=dp[i-1][j];
                   
               }
           }
           return dp[N][sum];
    }
}
