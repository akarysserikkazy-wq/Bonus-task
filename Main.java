import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("GRAPH TRAVERSAL SYSTEM\n");

        System.out.println(">>> SMALL GRAPH (10 vertices)");
        runTest(10, 0);

        System.out.println("\n>>> MEDIUM GRAPH (30 vertices)");
        runTest(30, 1);

        System.out.println("\n>>> LARGE GRAPH (100 vertices)");
        runTest(100, 2);
    }

    private static void runTest(int size, int startNode) {
        Graph graph = new Graph();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        int edges = size * 2;

        for (int i = 0; i < edges; i++) {
            int from = rand.nextInt(size);
            int to = rand.nextInt(size);
            int weight = rand.nextInt(10) + 1;

            graph.addEdge(from, to, weight);
        }

        if (size == 10) {
            System.out.println("\nGraph structure:");
            graph.printGraph();
        }

        Experiment exp = new Experiment();

        long bfsStart = System.nanoTime();
        graph.bfs(startNode);
        long bfsEnd = System.nanoTime();
        long bfsTime = bfsEnd - bfsStart;

        long dfsStart = System.nanoTime();
        graph.dfs(startNode);
        long dfsEnd = System.nanoTime();
        long dfsTime = dfsEnd - dfsStart;

        long dijkstraStart = System.nanoTime();
        graph.dijkstra(startNode);
        long dijkstraEnd = System.nanoTime();
        long dijkstraTime = dijkstraEnd - dijkstraStart;

        System.out.println("\nPerformance Results");
        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
        System.out.println("Dijkstra Time: " + dijkstraTime + " ns");

        exp.printCustomResults(bfsTime, dfsTime, dijkstraTime, size);
    }
}