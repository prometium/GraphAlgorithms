import java.util.*;

public class Graph {
    private LinkedList[] adj;
    private boolean[] discovered;

    public Graph(int vertexQuantity) {
        adj = new LinkedList[vertexQuantity];
        for (int i = 0; i < vertexQuantity; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        discovered = new boolean[vertexQuantity];
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void DFS(int u) {
        discovered[u] = true;
        System.out.print(u + " ");

        Iterator<Integer> it = adj[u].listIterator();
        while (it.hasNext()) {
            int v = it.next();
            if (!discovered[v]) {
                DFS(v);
            }
        }
    }

    public void BFS(int u) {
        discovered = new boolean[adj.length];

        LinkedList<Integer> queue = new LinkedList<>();
        discovered[u] = true;
        queue.add(u);

        while (queue.size() != 0) {
            u = queue.poll();
            System.out.print(u + " ");

            Iterator<Integer> it = adj[u].listIterator();
            while (it.hasNext()) {
                int v = it.next();
                if (!discovered[v]) {
                    discovered[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
