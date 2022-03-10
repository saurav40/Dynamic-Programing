class Solution {
    public int deleteAndEarn(int[] nums) {
       
        int count[]=new int[10005];
        for(int i=0;i<nums.length;i++)
        {
          count[nums[i]]+=nums[i]; 
        }
       int dp[]=new int[10005];
        dp[1]=count[1];
        dp[2]=Math.max(count[1],count[2]);
        for(int i=3;i<10005;i++)
        {
            dp[i]=Math.max(count[i]+dp[i-2],dp[i-1]);
        }
        return Math.max(dp[10003],dp[10004]);
    }
}
