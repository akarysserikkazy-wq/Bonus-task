## Bonus Task: Dijkstra's Shortest Path Algorithm
Student: Serikkazy Akarys
Group: SE-2514


This project has been extended to support weighted graphs and find the shortest path from a given starting vertex to all other reachable vertices using **Dijkstra's Algorithm**.

Requirements

• Extend your graph to support edge weights
<img width="353" height="101" alt="Снимок экрана 2026-05-23 120813" src="https://github.com/user-attachments/assets/c6625a74-d116-49d1-b262-5f8e3d830231" />

• Modify your Edge class to include weight field
<img width="538" height="413" alt="image" src="https://github.com/user-attachments/assets/9b57eb31-6696-445f-ab09-15ecbd5ae76d" />

• Update your graph structure to store weighted edges
<img width="547" height="501" alt="image" src="https://github.com/user-attachments/assets/11088ceb-43bc-483d-84ed-54aff1d5813c" />

• Implement the method: void dijkstra(int start)
<img width="577" height="667" alt="image" src="https://github.com/user-attachments/assets/caf5a255-b11a-4ae1-b54a-3b0bfc963036" />

### Weighted Edges:
The structural components were updated by adding an inner `Edge` class to the Graph structure which contains both the `target` vertex and its integer `weight`.

### Adjacency List:
The graph maintains an adjacency list structure capable of mapping vertices to their respective weighted connections.

### Dijkstra without Priority Queue:
Following the assignment's implementation notes, the algorithm utilizes simple arrays to track minimum `distances` and `visited` states across vertices. Instead of a priority queue, a helper loop evaluates and extracts the unvisited vertex with the minimum distance at each iteration step.

