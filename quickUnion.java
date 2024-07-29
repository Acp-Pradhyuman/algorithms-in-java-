/**
 * quickUnion
 */

/*
 * worst case time complexity of O(n) to perform one connected() function call
 * and this happens when we have a skewed tree
 * As for union operation the best case is when we have a flat tree whihc gives
 * O(n) time
 * and worst case is whe we have a skewed tree which takes O(n^2) time for "n"
 * union operations
 */
public class quickUnion {

    public static void main(String[] args) {
        QuickUnionUF quf = new QuickUnionUF(10);
        System.out.println("Initialized array");
        for (int i = 0; i < quf.id.length; i++) {
            System.out.print(quf.id[i] + " ");
        }
        System.out.printf("\n\n");

        quf.union(4, 3);
        System.out.println("union(4, 3)");
        for (int i = 0; i < quf.id.length; i++) {
            System.out.print(quf.id[i] + " ");
        }
        System.out.printf("\n\n");

        quf.union(3, 8);
        System.out.println("union(3, 8)");
        for (int i = 0; i < quf.id.length; i++) {
            System.out.print(quf.id[i] + " ");
        }
        System.out.printf("\n\n");

        quf.union(6, 5);
        System.out.println("union(6, 5)");
        for (int i = 0; i < quf.id.length; i++) {
            System.out.print(quf.id[i] + " ");
        }
        System.out.printf("\n\n");

        quf.union(9, 4);
        System.out.println("union(9, 4)");
        for (int i = 0; i < quf.id.length; i++) {
            System.out.print(quf.id[i] + " ");
        }
        System.out.printf("\n\n");

        quf.union(2, 1);
        System.out.println("union(2, 1)");
        for (int i = 0; i < quf.id.length; i++) {
            System.out.print(quf.id[i] + " ");
        }
        System.out.printf("\n\n");

        System.out.println("connected(8,9): " + quf.connected(8, 9));
        System.out.println("connected(5,0): " + quf.connected(5, 0));

        quf.union(5, 0);
        System.out.println("union(5, 0)");
        for (int i = 0; i < quf.id.length; i++) {
            System.out.print(quf.id[i] + " ");
        }
        System.out.printf("\n\n");
        System.out.println("connected(5,0): " + quf.connected(5, 0));
    }
}

/**
 * QuickUnionUF
 */
class QuickUnionUF {
    public int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
