class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //matrix given is a Young Tableau
    
    //check if the matrix is vaid 
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1){
            return false;
        }
        
        //initialize a search cursor to the top right corner
        int row = 0;
        int column = matrix[0].length -1;
        
        while(row < matrix.length && column >= 0){ //iterate while the search cursor is in a valid index 
            if(matrix[row][column] == target){
                return true;
            }
            else if(matrix[row][column] > target){ //if the current cursor value is greater than the target, move a column left  
                column--;
            }
            else if(matrix[row][column] < target){ //if the current cursor value is less than the target, move a row down 
                row++;
            }
        }
        return false;
    }
}
