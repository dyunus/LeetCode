class numPair{
    int val;
    int index; 
    numPair(int newVal, int newIndex){
        this.val = newVal;
        this.index = newIndex;
    }
    numPair(numPair toCopy){
        this.val = toCopy.val;
        this.index = toCopy.index;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        //make a numPair array
        if(nums.length == 0) return new ArrayList<Integer>();
        numPair[] pairArr = new numPair[nums.length];
        for(int i =0; i < nums.length; i++){
            pairArr[i] = new numPair(nums[i],i);
        }
        
        //arr to store smaller count for each num
        int[] countArr = new int[nums.length];
        
        pairArr = mergeSort(pairArr,countArr);
        
        //convert int[] to List<Integer>
        List<Integer> res = new ArrayList<Integer>();
        for(int count : countArr){
            res.add(count);
        }
        return res;
    }
    
    public numPair[] mergeSort(numPair[] pairArr, int[] countArr){
        if(pairArr.length == 1) return pairArr; //base csae
        
        //copy left half into a separate array
        numPair[] leftHalf = new numPair[pairArr.length/2]; 
        for(int i = 0; i < pairArr.length/2; i++){
            leftHalf[i] = new numPair(pairArr[i]);
        }
        
        
        //copy right half into a separate array
        numPair[] rightHalf = new numPair[pairArr.length-pairArr.length/2];
        for(int i = pairArr.length/2; i < pairArr.length; i++){
            rightHalf[i-pairArr.length/2] = new numPair(pairArr[i]);
        }
        
        //recursive call for mergeSort on both arrays
        numPair[] leftSorted = mergeSort(leftHalf,countArr);
        numPair[] rightSorted = mergeSort(rightHalf,countArr);
        
        //merge sort both halves
        int leftIndex  = 0, rightIndex = 0; //pointers for each sorted half
        while(leftIndex < leftSorted.length || rightIndex < rightSorted.length){
            if(rightIndex == rightSorted.length || leftIndex < leftSorted.length && leftSorted[leftIndex].val <= rightSorted[rightIndex].val){
                pairArr[leftIndex + rightIndex] = leftSorted[leftIndex];
                countArr[leftSorted[leftIndex].index] += rightIndex; //when a number from the left is added, increment its countIndex by the current rightIndex, since #rightIndex elements from the RIGHT were moved in front of it 
                leftIndex++;
            }
            else{
                pairArr[leftIndex + rightIndex] = rightSorted[rightIndex];
                rightIndex++;
            }
        }
        return pairArr;
    }
}


//Whenver adding an element from the left, we know that j elements from the right were added first
//since j corresponds to the right half of the array, this means that those j elemnts moved in front of the new left element to be added were
// 1) to the right of it (since they from right half of array)
// 2) smaller than it (they were added before and j was incremented because of this)



//Example
//1 5 7
//2 4 6

//i = 0; j = 0;
// 1 | i = 1; j = 0;
// 1 2 | i = 1; j = 1;
// 1 2 4 | i = 1; j = 2;
// 1 2 4 5 | i = 2; j = 2;  (j == 2 means two elements from the right were smaller than five and moved in front of it at some point in time)
