class Solution {
    public void sortColors(int[] nums) {
        int placeToAddZero = 0;
        int placeToAddTwo = nums.length - 1;
        int i = 0;
        while(i <= placeToAddTwo){
            if(nums[i] == 0){
                swap(nums,i,placeToAddZero);
                placeToAddZero++;
            }
            else if(nums[i] == 2){ //swap with AddTwo, do not increment i
                swap(nums,i,placeToAddTwo);
                placeToAddTwo--;
                i--;
            }
            i++;
        }
        return;
    }
    
    public void swap(int nums[], int x, int y){
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
    }
}
