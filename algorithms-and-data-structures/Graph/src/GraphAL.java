import java.util.*;

public class GraphAL<T>{
    private Map<T, List<T>> map = new LinkedHashMap<>();

    public void addVertex(T data)
    {
        map.put(data, new LinkedList<>());
    }

    public void addEdge(T data1, T data2)
    {
        map.get(data1).add(data2);
        map.get(data2).add(data1);
    }

    public void removeEdge(T data1, T data2)
    {
        List<T> l1 = map.get(data1);
        List<T> l2 = map.get(data2);
        if(l1 != null) l1.remove(data2);
        if(l2 != null) l2.remove(data1);
    }

    public void removeVertex(T data)
    {
        if(!map.containsKey(data)) return;

        for(T key : map.keySet())
        {
            map.get(key).remove(data);
        }

        map.remove(data);
    }

    public boolean hasEdge(T data1, T data2)
    {
        List<T> l1 = map.get(data1);

        return l1 != null && l1.contains(data2);
    }

    public void printGraph()
    {
        for(Map.Entry<T, List<T>> entry : map.entrySet())
        {
            System.out.print(entry.getKey() + " -> ");
            for(T data : entry.getValue())
            {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    public Set<T> dfs(T data)
    {
        Set<T> visited = new LinkedHashSet<>();
        Stack<T> stack = new Stack<>();

        if(!map.containsKey(data)) return visited;

        stack.push(data);
        while(!stack.isEmpty())
        {
            T vertex = stack.pop();
            if(!visited.contains(vertex))
            {
                visited.add(vertex);
                for(T neighbor : map.get(vertex))
                {
                    stack.push(neighbor);
                }
            }
        }

        return visited;
    }

    public Set<T> bfs(T data)
    {
        Set<T> visited = new LinkedHashSet<>();
        Queue<T> queue = new LinkedList<>();

        if(!map.containsKey(data)) return visited;

        visited.add(data);
        queue.add(data);
        while(!queue.isEmpty())
        {
            T vertex = queue.poll();
            for(T neighbor : map.get(vertex))
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
