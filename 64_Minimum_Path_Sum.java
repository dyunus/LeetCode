class Solution {
    public int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i>0 && j == 0) //only has an upper neighbor
                    grid[i][j] += grid[i-1][j];
                if(i == 0 && j > 0) //only has a left neighbor
                    grid[i][j] += grid[i][j-1];
                if(i > 0 && j > 0) //has an upper and left neighbor
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);                
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
