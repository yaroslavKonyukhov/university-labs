import java.util.*;

public class GraphAM<T>{
    private Map<T, Integer> mapInd = new HashMap<>();
    private List<T> vertices = new ArrayList<>();
    private Queue<Integer> freeIndexes = new LinkedList<>();
    private int capacity;
    private boolean[][] matrix;
    private int ind = 0;

    public GraphAM(int initialSize){
        this.capacity = initialSize;
        matrix = new boolean[capacity][capacity];
    }

    public void addVertex(T v)
    {
        if(mapInd.containsKey(v)) return;

        int targetIndex;
        if(!freeIndexes.isEmpty()){
            targetIndex = freeIndexes.poll();
            vertices.set(targetIndex, v);

            for(int j = 0; j < capacity; j++)
            {
                matrix[j][targetIndex] = false;
                matrix[targetIndex][j] = false;
            }
        }else{
            if(ind == capacity) grow();

            targetIndex = ind++;
            vertices.add(v);
        }

        mapInd.put(v, targetIndex);
    }

    private void grow()
    {
        int newCapacity = capacity*2;
        boolean[][] newMatrix = new boolean[newCapacity][newCapacity];
        for(int i = 0; i < capacity; i++) {
            for(int j = 0; j < capacity; j++) {
               newMatrix[i][j] = matrix[i][j];
            }
        }

        matrix = newMatrix;
        capacity = newCapacity;
    }

    public void addEdge(T v1, T v2)
    {
        Integer ind1 = mapInd.get(v1);
        Integer ind2 = mapInd.get(v2);

        if(ind1 == null || ind2 == null) return;

        matrix[ind1][ind2] = true;
        matrix[ind2][ind1] = true;
    }

    public boolean hasEdge(T from, T to)
    {
        Integer ind1 = mapInd.get(from);
        Integer ind2 = mapInd.get(to);

        if(ind1 == null || ind2 == null) return false;

        return matrix[ind1][ind2];
    }

    public void printGraph()
    {
        for(int i = 0; i < ind; i++)
        {
            T from = vertices.get(i);
            if(from == null) continue;
            System.out.print(from + " -> ");
            for(int j = 0; j < ind; j++){
                T to = vertices.get(j);
                if(to == null) continue;
                if(matrix[i][j]){
                    System.out.print(to + " ");
                }
            }
            System.out.println();
        }
    }

    public void removeVertex(T v)
    {
        if(mapInd.containsKey(v))
        {
            vertices.set(mapInd.get(v), null);
            freeIndexes.add(mapInd.get(v));
            mapInd.remove(v);
        }
    }

    public void removeEdge(T v1, T v2)
    {
        Integer ind1 = mapInd.get(v1);
        Integer ind2 = mapInd.get(v2);

        if(ind1 == null || ind2 == null) return;

        matrix[ind1][ind2] = false;
        matrix[ind2][ind1] = false;
    }

    public Set<T> dfs(T start)
    {
        Set<T> visited = new LinkedHashSet<>();
        Stack<Integer> stack = new Stack<>();
        Integer startIndex = mapInd.get(start);

        if(startIndex == null || vertices.get(startIndex) == null) return visited;

        stack.push(startIndex);
        while(!stack.isEmpty())
        {
            int currentIndex = stack.pop();
            T currentVertex = vertices.get(currentIndex);

            if(!visited.contains(currentVertex))
            {
                visited.add(currentVertex);
                for(int i = vertices.size()-1; i >= 0; i--)
                {
                    if(vertices.get(i) != null && matrix[currentIndex][i])
                    {
                        stack.push(i);
                    }
                }
            }
        }
        return visited;
    }

    public Set<T> bfs(T start)
    {
        Set<T> visited = new LinkedHashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Integer startIndex = mapInd.get(start);

        if(startIndex == null || vertices.get(startIndex) == null) return visited;

        visited.add(start);
        queue.add(startIndex);
        while(!queue.isEmpty())
        {
            int currentIndex = queue.poll();

            for(int i = 0; i < vertices.size(); i++)
            {
                if(vertices.get(i) != null && matrix[currentIndex][i])
                {
                    T neighbor = vertices.get(i);
                    if(!visited.contains(neighbor))
                    {
                        visited.add(neighbor);
                        queue.add(i);
                    }
                }
            }
        }
        return visited;
    }
}
