class Solution {
    public void rotate(int[][] matrix) {
        //rotation 90 degrees = reverse rows + swap along diagonal 
        
        //reverse the rows
        for(int i=0; i< (matrix.length / 2); i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-i-1];
            matrix[matrix.length-i-1] = temp;
        }
        
        //swap across diagonal
        for(int i=0; i< matrix.length; i++){
            for(int j=i+1; j < matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
