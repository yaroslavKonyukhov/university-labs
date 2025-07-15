public class Main {
    public static void main(String[] args) {
        System.out.println("GraphAL:");
        GraphAL<Integer> g1 = new GraphAL<>();

        g1.addVertex(1);
        g1.addVertex(2);
        g1.addVertex(3);
        g1.addVertex(4);

        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);

        g1.printGraph();
        System.out.println("DFS "+ g1.dfs(1));
        System.out.println("BFS "+ g1.bfs(1));

        System.out.println();
        System.out.println("GraphAM:");
        GraphAM<Integer> g2 = new GraphAM<>(5);

        g2.addVertex(1);
        g2.addVertex(2);
        g2.addVertex(3);
        g2.addVertex(4);

        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 4);
        g2.addEdge(3, 4);

        g2.printGraph();
        System.out.println("DFS "+ g2.dfs(1));
        System.out.println("BFS "+ g2.bfs(1));

        System.out.println();
        g2.removeVertex(2);
        g2.printGraph();

        System.out.println();
        g2.addVertex(2);
        g2.printGraph();

        System.out.println();

        System.out.println("GraphEL:");
        GraphEL<Integer> g3 = new GraphEL<>();

        g3.addVertex(1);
        g3.addVertex(2);
        g3.addVertex(3);
        g3.addVertex(4);

        g3.addEdge(1, 2);
        g3.addEdge(1, 3);
        g3.addEdge(2, 4);
        g3.addEdge(3, 4);

        g3.printGraph();
        System.out.println("DFS "+ g3.dfs(1));
        System.out.println("BFS "+ g3.bfs(1));
    }
}