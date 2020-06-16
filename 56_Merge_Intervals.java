class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]); //sort by starting time
        LinkedList<int[]> merged = new LinkedList<int[]>();
        for(int[] interval : intervals){
            if(merged.size() == 0 || interval[0] > merged.getLast()[1]){ //if the new interval starts after the end of the last interval, no overlap
                merged.add(interval);
            }
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]); //overlap, merge intervals
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
