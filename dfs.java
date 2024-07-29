
/**
 * dfs
 */
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

public class dfs {
    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 0, 6 }, { 3, 4 }, { 3, 5 },
                { 4, 5 }, { 6, 4 }, { 7, 8 },
                { 9, 10 }, { 9, 11 }, { 9, 12 }, { 11, 12 } };
        // int edges[][] = { { 0, 1 }, { 1, 2 } };
        Graph g = new Graph(13, edges);
        // Graph g = new Graph(3, edges);
        g.dfs();
        g.resetMarker();

        System.out.println();
        System.out.print("path from 10: ");
        g.pathTo(10);

        System.out.println();
        System.out.print("path from 8: ");
        g.pathTo(8);

        System.out.println();
        System.out.println();
        g.resetMarker();
        g.dfs();
        System.out.println();
        System.out.println("number of connected components: " +
                g.connectedComponent());

        System.out.println();
        g.printConnectedComponentArray();

        System.out.println();
        System.out.println("Bipartite graph: " + g.isBipartite());

        System.out.println();
        g.resetMarker();
        System.out.println("Graph has a cycle: " + g.hasCycle());
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
        for (int i = 0; i < N; i++) { // i < adj.length
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
        for (int i = 0; i < N; i++) { // i < adj.length
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
        for (int i = 0; i < N; i++) { // i < adj.length
            for (int x : adj[i]) {
                if (x == i)
                    count++;
            }
        }
        return count;
    }

    void dfs() {
        marked = new boolean[N];
        id = new int[N];
        int count = 0;
        for (int i = 0; i < N; i++) { // // i < adj.length
            if (!marked[i]) {
                System.out.print(i + " -> ");
                // id[i] = ++connectedComponent;
                connectedComponent = count++;
                dfsHelper(i);
                System.out.print(" dead-end");
                System.out.println();
            }
        }
    }

    void dfsHelper(int node) {
        marked[node] = true;
        id[node] = connectedComponent;
        for (int x : adj[node]) {
            if (!marked[x]) {
                // id[x] = connectedComponent;
                System.out.print(x + " -> ");
                dfsHelper(x);
            }
        }
    }

    int connectedComponent() {
        return connectedComponent + 1;
    }

    void resetMarker() {
        for (int i = 0; i < N; i++) {
            this.marked[i] = false;
            this.id[i] = 0;
            this.connectedComponent = 0;
        }
    }

    void pathTo(int v) {
        // if (!marked[v])
        // return null;
        dfsHelper(v);
        System.out.print(v);
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

    boolean hasCycle() {
        // dfs
        for (int i = 0; i < N; i++) {
            if (!marked[i]) {
                if (cycleHelper(i, -1))
                    return true;
            }
        }
        return false;
    }

    boolean cycleHelper(int node, int parent) {
        marked[node] = true;
        for (int x : adj[node]) {
            // works only for undirected graph
            if (marked[x] && (parent != x))
                return true;
            else if (!marked[x]) {
                if (cycleHelper(x, node))
                    return true;
            }
        }

        return false;
    }
}
