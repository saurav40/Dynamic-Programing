class Solution {
    //private int[][] dp=new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr, - 1);
        }
        return LCS(text1,text2,n,m,dp);
    }
    private int LCS(String x,String y,int n,int m,int [][]dp)
    {
        if(n == 0 || m == 0){
            return 0;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(x.charAt(n - 1) == y.charAt(m - 1)){
            return dp[n][m] = 1 + LCS(x,y,n - 1,m - 1,dp);
        }
        else{
            return dp[n][m] = Math.max(LCS(x,y,n,m - 1,dp),
                           LCS(x,y,n - 1,m,dp));
        }  
    }
}
//-----------------------------------------------------------
/*

class Solution {
    //private int[][] dp=new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr, - 1);
        }
        return LCS(text1,text2,n,m,dp);
    }
    private int LCS(String x,String y,int n,int m,int [][]dp)
    {
        if(n == 0 || m == 0){
            return 0;
        }
        
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        
        if(x.charAt(n - 1) == y.charAt(m - 1)){
            return dp[n][m] = 1 + LCS(x,y,n - 1,m - 1,dp);
        }
        else{
            return dp[n][m] = Math.max(LCS(x,y,n,m - 1,dp),
                           LCS(x,y,n - 1,m,dp));
        }  
    }
}
*/
