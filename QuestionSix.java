// Amalia Karaman
// Q6, draw circular graph using graphstream

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;

public class QuestionSix {

    static class Vertex {
        String name;
        int offset;

        Vertex(String name, int offset) {
            this.name = name;
            this.offset = offset;
        }
    }

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("graph from array");

        // input from assignment sample
        String input = "[(I,2),(A,5),(E,4),(F,2),(T,2),(S,3)]";
        input = input.replace("[", "")
                .replace("]", "")
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "");
        String[] rawPairs = input.split(",(?=[A-Z])"); // split pairs

        List<Vertex> vertices = new ArrayList<>();

        for (String pair : rawPairs) {
            String[] parts = pair.split(",");
            String name = parts[0];
            int offset = Integer.parseInt(parts[1]);
            vertices.add(new Vertex(name, offset));
        }

        int n = vertices.size();

        // add all vertices to the graph
        for (Vertex v : vertices) {
            if (graph.getNode(v.name) == null) {
                Node node = graph.addNode(v.name);
                node.setAttribute("ui.label", v.name);
            }
        }

        // connect each node to left and right circularly
        for (int i = 0; i < n; i++) {
            Vertex current = vertices.get(i);
            int leftIndex = (i - current.offset + n) % n;
            int rightIndex = (i + current.offset) % n;
            String from = current.name;
            String left = vertices.get(leftIndex).name;
            String right = vertices.get(rightIndex).name;

            // use unique edge ids
            String leftEdgeId = from + "->" + left;
            String rightEdgeId = from + "->" + right;

            if (graph.getEdge(leftEdgeId) == null)
                graph.addEdge(leftEdgeId, from, left, true);

            if (graph.getEdge(rightEdgeId) == null)
                graph.addEdge(rightEdgeId, from, right, true);
        }

        // display the final graph
        graph.display();
    }
}