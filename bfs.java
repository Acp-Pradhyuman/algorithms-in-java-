
/**
 * bfs
 */
import java.util.*;

public class bfs {
    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 0, 6 }, { 3, 4 }, { 3, 5 },
                { 4, 5 }, { 6, 4 }, { 7, 8 },
                { 9, 10 }, { 9, 11 }, { 9, 12 }, { 11, 12 } };
        // int edges[][] = { { 0, 1 }, { 1, 2 } };
        Graph g = new Graph(13, edges);
        // Graph g = new Graph(3, edges);
        g.bfs();

        System.out.println();
        System.out.printf("number of connected components: %d", g.connectedComponent());

        System.out.println();
        g.printConnectedComponentArray();

        System.out.println();
        System.out.println("Bipartite graph: " + g.isBipartite());
    }
}

/**
 * Graph
 */
class Graph {
    // @SuppressWarnings("unchecked")
    // N: number of nodes, m: number of edges
    private int N;
    private Vector<Integer> adj[];
    private boolean[] marked;
    private int[] id;
    private int connectedComponent;

    public Graph(int N, int edges[][]) {
        adj = new Vector[N];
        this.N = N;

        // adj.length = N (number of vertices)
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Vector<Integer>();
        }

        // edge.length gives the number of edges and edges[i].length = 2
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            // for undirected graphs we have bidirections
            adj[edges[i][1]].add(edges[i][0]);
        }
    }

    void printGraph() {
        for (int i = 0; i < N; i++) {
            System.out.print(i + "->");
            for (int x : adj[i]) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }

    int degree(int n) {
        int degree = 0;
        for (int x : adj[n])
            degree++;
        return degree;
    }

    int maxDegree() {
        int max = 0;
        // adj.length = N (number of vertices)
        for (int i = 0; i < adj.length; i++) {
            if (degree(i) > max) {
                max = degree(i);
            }
        }

        return max;
    }

    double avgDegree() {
        // handshaking theorem
        // sum of degrees = 2*(edges)
        // n*avg_degree = 2*e
        // avg_degree = 2*e/n
        // adj.length = N (number of vertices)
        return 2.0 * adj.length / N;
    }

    int numberOfSelfLoops() {
        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            for (int x : adj[i]) {
                if (x == i)
                    count++;
            }
        }
        return count;
    }

    void bfs() {
        marked = new boolean[N];
        id = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!marked[i]) {
                System.out.print(i + " -> ");
                // id[i] = ++connectedComponent;
                connectedComponent = count++;
                bfsHelper(i);
                System.out.print(" dead-end");
                System.out.println();
            }
        }
    }

    int connectedComponent() {
        return connectedComponent + 1;
    }

    void resetMarker() {
        for (int i = 0; i < N; i++) {
            this.marked[i] = false;
        }
    }

    void bfsHelper(int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;

        while (!q.isEmpty()) {
            int v = q.remove();
            id[v] = connectedComponent;
            for (int x : adj[v]) {
                if (!marked[x]) {
                    // id[x] = connectedComponent;
                    q.add(x);
                    marked[x] = true;
                    System.out.print(x + " -> ");
                }
            }
        }
    }

    void printConnectedComponentArray() {
        for (int i = 0; i < N; i++) {
            System.out.printf("a[%d] = %d, \n", i, id[i]);
        }
    }

    boolean isBipartite() {
        // bfs
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        int colored[] = new int[N];
        for (int i = 0; i < N; i++)
            colored[i] = -1;

        while (!q.isEmpty()) {
            int u = q.remove();

            for (int v : adj[u]) {
                // a bipartite graph cannot have self loops
                if (u == v) {
                    return false;
                }
            }

            for (int v : adj[u]) {
                if (colored[v] == -1) {
                    colored[v] = 1 - colored[u];
                    q.add(v);
                } else if (colored[u] == colored[v]) {
                    // neigbour vertex is of same color hence not bipartite
                    return false;
                }
            }
        }

        return true;
    }
}