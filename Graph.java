import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;
    private List<Vertex> vertices;

    public Graph() {
        adjList = new HashMap<>();
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        adjList.putIfAbsent(from, new ArrayList<>());
        adjList.putIfAbsent(to, new ArrayList<>());

        Vertex source = findVertexById(from);
        Vertex destination = findVertexById(to);

        if (source != null && destination != null) {
            adjList.get(from).add(new Edge(source, destination, weight));
        }
    }

    private Vertex findVertexById(int id) {
        for (Vertex v : vertices) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    public void printGraph() {
        for (int key : adjList.keySet()) {
            System.out.print(key + " -> ");
            for (Edge edge : adjList.get(key)) {
                System.out.print(edge.getDestination().getId() + "(w:" + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);
        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (Edge edge : adjList.getOrDefault(node, new ArrayList<>())) {
                int neighbor = edge.getDestination().getId();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (Edge edge : adjList.getOrDefault(node, new ArrayList<>())) {
            int neighbor = edge.getDestination().getId();
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
    public void dijkstra(int start) {
        int numVertices = vertices.size();

        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = -1;
            int minDistance = Integer.MAX_VALUE;
            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && distances[v] < minDistance) {
                    minDistance = distances[v];
                    u = v;
                }
            }

            if (u == -1) break;

            visited[u] = true;

            for (Edge edge : adjList.getOrDefault(u, new ArrayList<>())) {
                int vId = edge.getDestination().getId();
                int weight = edge.getWeight();

                if (!visited[vId] && distances[u] != Integer.MAX_VALUE
                        && distances[u] + weight < distances[vId]) {
                    distances[vId] = distances[u] + weight;
                }
            }
        }

        System.out.println();
        System.out.println("Dijkstra: Shortest paths from vertex " + start);
        System.out.println();
        System.out.println("Target Vertex \t Distance");
        System.out.println();
        for (int i = 0; i < numVertices; i++) {
            String distStr = (distances[i] == Integer.MAX_VALUE) ? "Unreachable" : String.valueOf(distances[i]);
            System.out.println(i + " \t\t\t " + distStr);
        }
        System.out.println();
    }
}