# Graph
- Graph is a non-linear data structure. It consists of verteces and edges between them. It can be directional(edges have start and end points) or non-directional. Also the graph can be weighted or unweighted.
- There are three ways to implement graph:
  1) Adjacency list
  2) Adjacency matrix
  3) Edges list
- Each approach has its own characteristics and is preferred depending on the needs of the task or data conditions.
- My implementations of the graphs are non-directional and unweighted. It could be necesarry for graph to be directional or weighted for special tasks/algorithms. We just need to add flag for directional/non-directional(or make it directional by default) and change the functionality and we need to add additional field for weight for edge and also change the functionality of the methods.
## GraphAL - Adjacency List
- The graph is represented as a map: each vertex maps to a list of its adjacent(connected) vertices.
- Space complexity: O(v + e), v - number of vertices, e - number of edges.
- It's preferred to use when graph is loose(number of edges is much less than v^2).
- When to use:
  1) the graph is loose;
  2) the frequent traversal(dfs/bfs) is expected;
  3) fast iteration over neighbors is needed.
## GraphAM - Adjacency Matrix
- The graph is represented as a 2D boolean matrix. If the value of the intersection cell of two vertices is true, then the two vertices have an edge between them.
- To keep track of the indexes of the values I use Map<T, Integer>.
- Space complexity: O(v^2), v - number of vertices, regardles of edge count.
- It's preferred to use when graph is dense(many edges).
- When to use:
  1) the graph is dense;
  2) fast edge checks are critical;
  3) implementing certain algorithms.
## GraphEL - Edges List
- The graph is stored as a list of all edges. There is also separate set of vertices.
- Edge is represented as a pair of vertices.
- Space complexity: O(e), e - number of edges.
- When to use:
  1) the number of edges is small;
  2) edges are main focus;
  3) implementing edge-centric algorithms.
## DFS and BFS methods
- They are used to traverse a graph. We start from a certain vertex and move along its adjacent vertices.
- Both methods have their own unique way to traverse a graph.
### DFS - Depth-First Search
- Method goes as far as possible along one branch of vertices. As soon as the path ends, it returns to the previous fork and goes along a new path. This is called backtracking. Thus, it traverses the graph as if in depth from the beginning.
### BFS - Breadth-First Search
- Method explores a graph level by level, visiting all the vertices at the present depth before moving on to the next level.
