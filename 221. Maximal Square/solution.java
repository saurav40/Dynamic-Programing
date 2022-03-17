/*                         

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
example1:

1 0 1 0 0 
1 0 1 1 1
1 1 1 1 1 
1 0 0 1 0

1 1 | 1    1 | 1 1
1 1 | 1    1 | 1 1  
1st Square  2nd
LRow=Lcol=2   Lrow=Lcol=2
Area will be LRow*LRow or Lcol*Lcol

 
Just dry run //easy to understand

*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m+1][n+1];
        if(m==0)
            return 0;
        int largest=0;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    if(dp[i][j]>largest)
                        largest=dp[i][j];
                }
            }
        return largest*largest;
        
    }
}
