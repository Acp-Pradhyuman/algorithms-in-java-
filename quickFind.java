/**
 * quickFind
 */

/**
 * worst case time complexity of O(n^2) to perform "n" union operations
 */

public class quickFind {
    public static void main(String[] args) {
        QuickFindUF quf = new QuickFindUF(10);
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
 * QuickFindUF
 */
class QuickFindUF {
    public int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }
}