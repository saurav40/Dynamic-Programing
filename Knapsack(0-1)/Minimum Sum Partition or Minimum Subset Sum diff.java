class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int range=0;
	    for(int i=0;i<n;i++)
	       range+=arr[i];
	       
	  boolean dp[][]=new boolean[n+1][range+1];
	   for(int i=0;i<=n;i++)
	     dp[i][0]=true;
	   for(int i=1;i<=n;i++)
	     for(int j=1;j<=range;j++)
	     {
	         if(arr[i-1]<=j)
	         {
	             dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
	         }
	         else
	            dp[i][j]=dp[i-1][j];
	     }
	     int min=range;
	     for(int i=0;i<=range/2;i++)
	     {
	         if(dp[n][i])
	         {
	             min=Math.min(range-2*i,min);
	         }
	     }
	     return min;
	} 
}
