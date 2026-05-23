## Bonus Task: Dijkstra's Shortest Path Algorithm
Student: Serikkazy Akarys
Group: SE-2514


This project has been extended to support weighted graphs and find the shortest path from a given starting vertex to all other reachable vertices using **Dijkstra's Algorithm**.

## Requirements

• Extend your graph to support edge weights

<img width="353" height="101" alt="Снимок экрана 2026-05-23 120813" src="https://github.com/user-attachments/assets/c6625a74-d116-49d1-b262-5f8e3d830231" />

• Modify your Edge class to include weight field

<img width="538" height="413" alt="image" src="https://github.com/user-attachments/assets/9b57eb31-6696-445f-ab09-15ecbd5ae76d" />

• Update your graph structure to store weighted edges

<img width="547" height="501" alt="image" src="https://github.com/user-attachments/assets/11088ceb-43bc-483d-84ed-54aff1d5813c" />

• Implement the method: void dijkstra(int start)

<img width="577" height="667" alt="image" src="https://github.com/user-attachments/assets/caf5a255-b11a-4ae1-b54a-3b0bfc963036" />

• Output:

<img width="738" height="700" alt="Снимок экрана 2026-05-23 114622" src="https://github.com/user-attachments/assets/c618f3d9-a6cc-4ee6-bf6e-b0ea41734877" />
<img width="733" height="832" alt="Снимок экрана 2026-05-23 114644" src="https://github.com/user-attachments/assets/c06f9c37-5608-4d7f-8aa2-84e5b53c3cd7" />
<img width="740" height="849" alt="Снимок экрана 2026-05-23 114710" src="https://github.com/user-attachments/assets/3c6e966e-8550-499c-8cf4-da8c35e17cb3" />
<img width="735" height="832" alt="Снимок экрана 2026-05-23 114731" src="https://github.com/user-attachments/assets/7fe51ba1-c26e-4239-9316-a7c05abd9342" />
<img width="734" height="367" alt="Снимок экрана 2026-05-23 114750" src="https://github.com/user-attachments/assets/0c16a48a-8d53-4001-8ae5-ef7e879302c7" />


### Weighted Edges:
The structural components were updated by adding an inner `Edge` class to the Graph structure which contains both the `target` vertex and its integer `weight`.

### Adjacency List:
The graph maintains an adjacency list structure capable of mapping vertices to their respective weighted connections.

### Dijkstra without Priority Queue:
Following the assignment's implementation notes, the algorithm utilizes simple arrays to track minimum `distances` and `visited` states across vertices. Instead of a priority queue, a helper loop evaluates and extracts the unvisited vertex with the minimum distance at each iteration step.

