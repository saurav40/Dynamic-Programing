class Solution {
    private int sol[][]=new int[1001][1001];
    public int maximumScore(int[] nums, int[] multi) {
       // int sol[][]=new int[multi.length+1][multi.length+1];
        return dp(nums,multi,0,0);
    }
    private int dp(int[] nums,int[] multi,int i,int left)
    {
        if(i==multi.length)
            return 0;
        int right=nums.length-1-(i-left);
        if(sol[i][left]==0){
           sol[i][left]=Math.max(nums[left]*multi[i]+dp(nums,multi,i+1,left+1),
                          nums[right]*multi[i]+dp(nums,multi,i+1,left)); 
        }
        return sol[i][left];
    }
}
