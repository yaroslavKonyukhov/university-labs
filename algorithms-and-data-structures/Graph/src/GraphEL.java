import java.util.*;

public class GraphEL<T>{

    class Edge<T>{
        T from;
        T to;

        public Edge(T from, T to){
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Set<T> vertices = new HashSet<T>();
    private List<Edge<T>> edges = new ArrayList<>();

    public void addVertex(T v)
    {
        vertices.add(v);
    }

    public void addEdge(T from, T to)
    {
        if(!vertices.contains(from) || !vertices.contains(to)) return;
        edges.add(new Edge<>(from, to));
        edges.add(new Edge<>(to, from));
    }

    public void removeVertex(T v)
    {
        vertices.remove(v);
        edges.removeIf(e -> e.from.equals(v) || e.to.equals(v));
    }

    public void removeEdge(T from, T to)
    {
        edges.removeIf(e -> (e.from.equals(from) && e.to.equals(to)) || (e.from.equals(to) && e.to.equals(from)));
    }

    public boolean hasEdge(T from, T to)
    {
        return edges.stream().anyMatch(e -> e.from.equals(from) && e.to.equals(to));
    }

    public void printGraph()
    {
        for(T v : vertices)
        {
            System.out.print(v + " -> ");
            for(Edge<T> e : edges)
            {
                if(e.from.equals(v)) System.out.print(e.to + " ");
            }
            System.out.println();
        }
    }

    private List<T> getNeighbors(T v)
    {
        List<T> neighbors = new ArrayList<>();
        for(Edge<T> e : edges)
        {
            if(e.from.equals(v)) neighbors.add(e.to);
        }
        return neighbors;
    }

    public Set<T> dfs(T v)
    {
        Set<T> visited = new LinkedHashSet<>();
        Stack<T> stack = new Stack<>();

        if(!vertices.contains(v)) return visited;

        stack.push(v);
        while(!stack.isEmpty())
        {
            T curr = stack.pop();
            if(!visited.contains(curr))
            {
                visited.add(curr);
                for(T neighbor : getNeighbors(curr))
                {
                    if(!visited.contains(neighbor)) stack.push(neighbor);
                }
            }
        }
        return visited;
    }

    public Set<T> bfs(T v)
    {
        Set<T> visited = new LinkedHashSet<>();
        Queue<T> queue = new LinkedList<>();

        if(!vertices.contains(v)) return visited;

        visited.add(v);
        queue.add(v);
        while(!queue.isEmpty())
        {
            T curr = queue.poll();
            for(T neighbor : getNeighbors(curr))
            {
                if(!visited.contains(neighbor))
                {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }
}
