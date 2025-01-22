import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoursesSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int len = prerequisites.length;
        for (int i = 0; i < len; i++) {
            int v = prerequisites[i][0];
            int e = prerequisites[i][1];
            adjList.get(v).add(e);
        }
        int[] indegrees = new int[numCourses];
        // for (int i = 0;i<numCourses;i++){
        //     indegrees[i] = adjList.get(i).size();
        // }
        for (int i = 0; i < numCourses; i++) {
            for (int it : adjList.get(i)) {
                indegrees[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i =0;i<numCourses;i++){
            if (indegrees[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            for (int it: adjList.get(node)) {
                indegrees[it]--;
                if (indegrees[it]==0) {
                    q.add(it);
                }
            }

        }
        if (topo.size()==numCourses) return true;
        return false;
    }
}
