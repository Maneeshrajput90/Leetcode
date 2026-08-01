class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[2][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {               
                dp[i % 2][j] = grid[i][j];             
                int minPrev = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        minPrev = Math.min(minPrev, dp[(i - 1) % 2][k]);
                    }
                }
                dp[i % 2][j] += minPrev;
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, dp[(n - 1) % 2][j]);
        }
        
        return minSum;
    }
}
