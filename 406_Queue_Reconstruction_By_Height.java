class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> cmp = new Comparator<int[]>(){
            @Override
            public int compare(int[] newEntry, int[] existingEntry){
                if(newEntry[0] != existingEntry[0]){ //if their heights are not the same
                    return existingEntry[0] - newEntry[0]; //shorter height comes after
                }
                else{ //heights are equal so compare k values, larger k value goes later
                    return newEntry[1] - existingEntry[1];
                }
            }
        };
        
        Arrays.sort(people, cmp);

        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);  
        }
        return res.toArray(new int[people.length][]);
    }
}



/*
Pick out tallest group of people and sort them in a subarray (S).
Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
Later people that are added in front of them cannot be taller than them and thus teh relative order is presreved. See NOTE below for example
For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
*/


/*

[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]   INITIAL ARRAY

[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]     SORTING BASED ON HEIGHT & LARGER K VALUE IN CASE OF TIE 

INSERT INTO NEW LIST USING K VALUE AS INDEX, NOTICE RELATIVE ORDERING IS PRESERVED

[7,0]

[7,0],[7,1]

[7,0],[6,1],[7,1]

[5,0],[7,0],[6,1],[7,1]

[5,0],[7,0],[5,2],[6,1],[7,1]   NOTE: [5,2] is added nefore [6,1] but [6,1] is still in correct position since 5 is shorter than 6

[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]

*/
