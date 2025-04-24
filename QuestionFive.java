// Amalia Karaman
// Q5, all simple paths of length 7

import java.util.*;

public class QuestionFive {
    // edge class to store destination and weight
    static class Edge {
        char dest;
        int weight;

        Edge(char dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // finds all simple paths of 7 edges from u to w
    public static void findPaths(Map<Character, List<Edge>> graph, char u, char w) {
        List<Character> path = new ArrayList<>();
        dfs(graph, u, w, path, 0);
    }

    // recursive dfs with backtracking
    private static void dfs(Map<Character, List<Edge>> graph, char current, char target, List<Character> path, int depth) {
        path.add(current);

        if (depth == 7) {
            if (current == target) {
                System.out.println(path);
            }
            path.remove(path.size() - 1);
            return;
        }

        if (!graph.containsKey(current)) {
            path.remove(path.size() - 1);
            return;
        }

        for (Edge edge : graph.get(current)) {
            if (!path.contains(edge.dest)) {
                dfs(graph, edge.dest, target, path, depth + 1);
            }
        }

        path.remove(path.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        Map<Character, List<Edge>> graph = new HashMap<>();
        graph.put('A', Arrays.asList(new Edge('B', 1)));
        graph.put('B', Arrays.asList(new Edge('C', 1)));
        graph.put('C', Arrays.asList(new Edge('D', 1)));
        graph.put('D', Arrays.asList(new Edge('E', 1)));
        graph.put('E', Arrays.asList(new Edge('F', 1)));
        graph.put('F', Arrays.asList(new Edge('G', 1)));
        graph.put('G', Arrays.asList(new Edge('H', 1)));
        graph.put('H', new ArrayList<>());

        System.out.println("test case: path of length 7 from A to H:");
        findPaths(graph, 'A', 'H');
    }
}