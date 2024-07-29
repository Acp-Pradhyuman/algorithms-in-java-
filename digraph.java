
/**
 * digraph
 */
import java.util.*;

public class digraph {
    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 0, 5 }, { 2, 0 }, { 2, 3 }, { 3, 2 }, { 3, 5 },
                { 4, 3 }, { 4, 2 }, { 5, 4 },
                { 6, 0 }, { 6, 4 }, { 6, 8 }, { 6, 9 }, { 7, 6 }, { 7, 9 }, { 8, 6 }, { 9, 10
                }, { 9, 11 }, { 10, 12 },
                { 11, 4 }, { 11, 12 }, { 12, 9 } };
        // int edges[][] = { { 1, 2 }, { 2, 3 }, { 2, 4 }, { 3, 7 }, { 3, 8 },
        // { 5, 6 }, { 6, 4 }, { 8, 7 } }; // {4,5}
        // int edges[][] = { { 0, 1 }};
        // int edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 1, 4 }, { 3, 4 }, { 3, 6 },
        // { 5, 2 }, { 6, 0 }, { 6, 4 } };
        graph g = new graph(13, edges);
        // graph g = new graph(7, edges);
        g.printGraph();

        System.out.println();
        System.out.print("rechable nodes from 0: ");
        // reachable() is useful in analysis of dead code elmination of compilation
        // step
        // it detects an unreachable code and thus elminates dead code
        g.reachable(0);

        System.out.println();
        System.out.println();
        g.resetMarker();
        g.shortestPath(7, 4);

        System.out.println();
        System.out.println();
        g.resetMarker();
        g.shortestPath(7, 5);

        System.out.println();
        System.out.println();
        g.resetMarker();
        g.shortestPath(10, 12);

        System.out.println();
        System.out.println();
        g.resetMarker();
        g.shortestPath(8, 7);

        System.out.println();
        System.out.println();
        g.resetMarker();
        System.out.println("Cycle is present in graph: " + g.hasCycle());

        g.resetMarker();
        if (g.hasCycle())
            System.out.println("The given graph is not a directed acyclic graph (DAG)"
                    + " hence no topological sort");
        else {
            g.resetMarker();
            g.dfs();
            System.out.println();
            g.topologicalSort();
        }

        System.out.println();
        g.resetMarker();
        g.resetStack();
        g.dfs();
        g.resetMarker();
        g.reverseDfs();
        g.printStronglyConnectedComponents();

    }
}

class graph {
    private int N;
    private Vector<Integer> adj[];
    private Vector<Integer> reverseAdj[];
    private boolean[] marked;
    private boolean[] dfsVisited;
    private int[] path;
    private int[] id;
    private Stack<Integer> reversePost;
    private int connectedComponent;

    public graph(int N, int edges[][]) {
        adj = new Vector[N];
        path = new int[N];
        reverseAdj = new Vector[N];
        this.N = N;

        // adj.length = N (number of vertices)
        for (int i = 0; i < N; i++) { // i < adj.length
            adj[i] = new Vector<Integer>();
            reverseAdj[i] = new Vector<Integer>();
            path[i] = -1;
        }

        // edge.length gives the number of edges and edges[i].length = 2
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            reverseAdj[edges[i][1]].add(edges[i][0]);
        }

        // for (int i = 0; i < N; i++) {
        // for (int x : adj[i]) {
        // reverseAdj[x].add(i);
        // }
        // }
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

    void resetMarker() {
        for (int i = 0; i < N; i++) {
            this.marked[i] = false;
            this.dfsVisited[i] = false;
            // this.id[i] = 0;
            this.connectedComponent = 0;
            this.path[i] = -1;
            this.id[i] = 0;
        }
    }

    void resetStack() {
        int i = 0;
        while (reversePost.size() != 0) {
            reversePost.remove(reversePost.get(i));
        }
    }

    void reachable(int v) {
        // if (!marked[v])
        // return null;
        marked = new boolean[N];
        dfsVisited = new boolean[N];
        reversePost = new Stack<Integer>();
        id = new int[N];
        dfsHelper(v);
        System.out.print(v);
    }

    void dfs() {
        marked = new boolean[N];
        id = new int[N];
        reversePost = new Stack<Integer>();
        for (int i = 0; i < N; i++) { // // i < adj.length
            if (!marked[i]) {
                System.out.print(i + " -> ");
                // id[i] = ++connectedComponent;
                // connectedComponent = count++;
                dfsHelper(i);
                System.out.print(" dead-end");
                System.out.println();
            }
        }
    }

    void dfsHelper(int node) {
        marked[node] = true;
        // id[node] = connectedComponent;
        for (int x : adj[node]) {
            if (!marked[x]) {
                // id[x] = connectedComponent;
                System.out.print(x + " -> ");
                dfsHelper(x);
            }
        }
        reversePost.push(node);
    }

    void topologicalSort() {
        System.out.println("Topological sort: ");
        for (int i = reversePost.size() - 1; i >= 0; i--) {
            System.out.print(reversePost.get(i) + " -> ");
        }
    }

    void reverseDfs() {
        int count = 0;
        for (int i = reversePost.size() - 1; i >= 0; i--) {
            if (!marked[reversePost.get(i)]) {
                connectedComponent = count++;
                // connectedComponent++;
                reverseDfsHelper(reversePost.get(i));
            }
        }
    }

    void reverseDfsHelper(int node) {
        marked[node] = true;
        id[node] = connectedComponent;
        for (int x : reverseAdj[node]) {
            if (!marked[x]) {
                // id[x] = connectedComponent;
                // System.out.print(x + " -> ");
                reverseDfsHelper(x);
            }
        }
        // reversePost.push(node);
    }

    void printStronglyConnectedComponents() {
        System.out.println();
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.printf("a[%d] = %d\n", i, id[i]);
        }
    }

    void shortestPath(int s, int d) {
        if (!shortestPathHelper(s, d)) {
            System.out.printf("Given source %d and destination %d are not connected", s, d);
            return;
        }

        int x = d;
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(d);
        while (path[x] != -1) {
            x = path[x];
            l.add(x);
        }

        System.out.println("Shotest path from " + s + " to " + d);
        for (int i = l.size() - 1; i >= 0; i--) {
            System.out.print(l.get(i) + " -> ");
        }
    }

    boolean shortestPathHelper(int s, int d) {
        // bfs traversal
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        marked[s] = true;

        // System.out.print(s + " -> ");

        while (!q.isEmpty()) {
            int v = q.remove();
            // id[v] = connectedComponent;
            for (int x : adj[v]) {
                if (!marked[x]) {
                    // id[x] = connectedComponent;
                    q.add(x);
                    marked[x] = true;
                    // System.out.print(x + " -> ");
                    path[x] = v;

                    if (x == d) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean hasCycle() {
        marked = new boolean[N];
        // dfs
        dfsVisited = new boolean[N];
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
        dfsVisited[node] = true;

        for (int x : adj[node]) {
            // works for directed graph too
            // if (marked[x] && (parent != x))
            if (marked[x] && dfsVisited[x])
                return true;
            else if (!marked[x]) {
                if (cycleHelper(x, node))
                    return true;
            }
        }

        dfsVisited[node] = false;

        return false;
    }
}