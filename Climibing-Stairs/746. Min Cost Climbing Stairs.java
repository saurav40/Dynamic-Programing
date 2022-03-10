class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int n=cost.length;
      
   if(n==1)
    return cost[0];
  int prev2=cost[0];
  int prev1=cost[1];
  
  for(int i=2;i<n;i++)
  {
    int curr=cost[i]+Math.min(prev1,prev2);
    prev2=prev1;
    prev1=curr;
  }
  return Math.min(prev1,prev2);
 }
}

      
/*

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1)
          return cost[0];
      int dp[]=new int[n];
   if(n==1)
       return cost[0];
   
   dp[0]=cost[0];
   dp[1]=cost[1];
   for(int i=2;i<n;i++)
   {
      dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
   }
   return Math.min(dp[n-1],dp[n-2]);
    }
}

      
*/
