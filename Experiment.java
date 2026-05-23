public class Experiment {
    private long bfsTime;
    private long dfsTime;
    private long dijkstraTime;

    public void runTraversals(Graph g, int start) {
        long startBFS = System.nanoTime();
        g.bfs(start);
        long endBFS = System.nanoTime();
        bfsTime = endBFS - startBFS;

        long startDFS = System.nanoTime();
        g.dfs(start);
        long endDFS = System.nanoTime();
        dfsTime = endDFS - startDFS;

        long startDijkstra = System.nanoTime();
        g.dijkstra(start);
        long endDijkstra = System.nanoTime();
        dijkstraTime = endDijkstra - startDijkstra;
    }

    public void runMultipleTests() {
        System.out.println("Running multiple graph experiments...");
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            Graph g = new Graph();

            for (int i = 0; i < size; i++) {
                g.addVertex(new Vertex(i));
            }

            java.util.Random random = new java.util.Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 3; j++) {
                    int target = random.nextInt(size);
                    if (i != target) {
                        int weight = random.nextInt(10) + 1;
                        g.addEdge(i, target, weight);
                    }
                }
            }
            runTraversals(g, 0);

            printCustomResults(bfsTime, dfsTime, dijkstraTime, size);
        }
    }

    public void printResults() {
        System.out.println("\nPerformance Results");
        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
        System.out.println("Dijkstra Time: " + dijkstraTime + " ns");
    }

    public void printCustomResults(long bfsTime, long dfsTime, long dijkstraTime, int size) {
        System.out.println("\n[Graph Size: " + size + " vertices]");
        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
        System.out.println("Dijkstra Time: " + dijkstraTime + " ns");
        System.out.println();
    }
}