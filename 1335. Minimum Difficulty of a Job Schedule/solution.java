class Solution {
    private int n,d;
    private int[] maxtill;
    private int[][] dp;
    private int[] diff;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n=jobDifficulty.length;
        if(n<d)
            return -1;
        this.d=d;
        this.diff=jobDifficulty;
        
        maxtill=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--)
        {    max=Math.max(max,jobDifficulty[i]);
            maxtill[i]=max;
        }
        
        dp=new int[n][d+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        
        return sol(0,1);
        
    }
    private int sol(int i,int day)
    {
        if(day==d)
            return maxtill[i];
        
        if(dp[i][day]==-1)
        {
            int answer=Integer.MAX_VALUE;
            int maxSofar=0;
            for(int j=i;j<(n-(d-day));j++)
            {
                maxSofar=Math.max(maxSofar,diff[j]);
                answer=Math.min(answer,maxSofar+sol(j+1,day+1));
            }
            dp[i][day]=answer;
        }
        return dp[i][day];
    }
}
