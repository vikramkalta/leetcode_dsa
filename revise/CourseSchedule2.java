import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class CourseSchedule2 {
    public static void main(String[] args) {
        // int[][] prerequisites = {{0,1}};
        int[][] prerequisites = {{1,0},{1,2},{0,1}};
        System.out.println(findOrder(3, prerequisites));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0;i < numCourses; i++) {
            adjList.add(new ArrayList());
        }
        // Create graph
        for (int i = 0;i < prerequisites.length; i++) {
            int vertex = prerequisites[i][1];
            int neighbour = prerequisites[i][0];
            adjList.get(vertex).add(neighbour);
        }
        int[] indegree = new int[numCourses];
        int len = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            List<Integer> neighbours =  adjList.get(i);
            for (int j = 0; j < neighbours.size(); j++) {
                indegree[neighbours.get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i]==0) {
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int i = 0; i < adjList.get(node).size(); i++) {
                int x = adjList.get(node).get(i);
                indegree[x]--;
                if (indegree[x]==0){
                    q.add(x);
                }
            }
        }
        if (numCourses != ans.size()) {
            return new int[]{};
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) result[i]=ans.get(i);
        return result;
    }
}