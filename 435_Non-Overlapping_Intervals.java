class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1){return 0;} //0 or 1 intervals are trviallly non overlapping
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); //sort by end points
        // | ------- |
        // | ------------- |  (Needs to be removed)
        //In the case of an overlap, removing the interval with the greater end point allows for more space for future intervals to begin without overlapping
        int removedCount = 0;
        int previousEnd = intervals[0][1];
        for(int i=1; i < intervals.length; i++){
            if(intervals[i][0] < previousEnd){ //if the current interval's start is less than the previous interval's end, overlap needs to be removed
                removedCount++;
            }
            else{ //no overlap, update the end
                previousEnd = intervals[i][1];
            }
        }
        return removedCount;
    }
}
