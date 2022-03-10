
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
//----------------------------------------Memoization------------
/*
class Solution{

    int dp[][]=new int[101][100001];
    Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        for(int a[]:dp)
        {
            Arrays.fill(a,-1);
        }
        
        if(ss(N,arr,sum)!=1)
            return false;
        return true;
         
    }
   public int ss(int n,int [] arr,int sum)
   {
       if(sum==0)
         return 1;
       if(n<=0)
          return 0;
        if(dp[n][sum]!=-1)
           return dp[n][sum];
        if(arr[n-1]<=sum)
        {
            if(ss(n-1,arr,sum-arr[n-1])!=0 || ss(n-1,arr,sum)!=0)
               dp[n][sum]=1;
            else
              dp[n][sum]=0;
        }
        else
          dp[n][sum]=ss(n-1,arr,sum);
    return dp[n][sum];
   }
}*/
