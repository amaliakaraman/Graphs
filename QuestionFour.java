// Amalia Karaman
// Q4, Directed graph checker

public class QuestionFour {
    // checks if the input matrix represents a directed graph
    public static boolean isDirected(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // if matrix is not symmetric, it's directed
                if (matrix[i][j] != matrix[j][i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] directed = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 0, 0}
        };

        int[][] undirected = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        System.out.println("is directed: " + isDirected(directed));     // true
        System.out.println("is directed: " + isDirected(undirected));   // false
    }
}
