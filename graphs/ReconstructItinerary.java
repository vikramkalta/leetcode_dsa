import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    public static void main(String[] args) {
        // String[][] _tickets = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
        String[][] _tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> tickets = new ArrayList<>();
        for (int i = 0; i < _tickets.length; i++) {
            List<String> innerList = new ArrayList<>();
            innerList.add(_tickets[i][0]);
            innerList.add(_tickets[i][1]);
            tickets.add(innerList);
        }
        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        int len = tickets.size();
        for (int i = 0; i < len; i++) {
            List<String> curr = tickets.get(i);
            PriorityQueue<String> neighbors = graph.getOrDefault(curr.get(0), new PriorityQueue<>());
            neighbors.add(curr.get(1));
            graph.put(curr.get(0), neighbors);
        }
        dfs("JFK", graph, ans);
        Collections.reverse(ans);
        return ans;
    }
    public static void dfs(String source, HashMap<String, PriorityQueue<String>> graph, List<String> ans) {
        PriorityQueue<String> neighbors = graph.get(source);
        while (neighbors != null && !neighbors.isEmpty()) {
            String curr = neighbors.poll();
            dfs(curr, graph, ans);
        }
        ans.add(source);
    }
}
