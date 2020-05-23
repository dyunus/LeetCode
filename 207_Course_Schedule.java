class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
        int[] inDegree = new int[numCourses];
        int count = 0;
        for(int[] prereq : prerequisites){
            int courseToTake = prereq[1];
            int courseUnlocked = prereq[0];
            List<Integer> coursesUnlockedList = adjList.getOrDefault(courseToTake, new ArrayList<Integer>());
            coursesUnlockedList.add(courseUnlocked);
            inDegree[courseUnlocked]++;
            adjList.put(courseToTake,coursesUnlockedList);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i< inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int courseTaken = q.poll();
            if(adjList.containsKey(courseTaken)){
                List<Integer> coursesUnlockedList = adjList.get(courseTaken);
                for(int courseUnlocked : coursesUnlockedList){
                    inDegree[courseUnlocked]--;
                    if(inDegree[courseUnlocked] == 0){
                        q.add(courseUnlocked);
                    }
                }
            }
            count++;
        }
        return count == numCourses;
    }
}
