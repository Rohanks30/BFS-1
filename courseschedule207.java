// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] count = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] temp : prerequisites){
            int course = temp[0];
            int prereq = temp[1];
            count[course]++;
            if(!map.containsKey(prereq)){
                map.put(prereq,new ArrayList<>());
            }
            map.get(prereq).add(course);
        }
        for(int i = 0;i<numCourses;i++){
            if(count[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int current = q.poll();
            List<Integer> dep = map.get(current);
            if(dep!=null){
                for(int c: dep){
                    count[c]--;
                    if(count[c] == 0){
                        q.add(c);
                    }
                }
            }
            numCourses--;
        }
        return numCourses == 0;
    }
}