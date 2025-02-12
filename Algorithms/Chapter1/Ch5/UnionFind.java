package Chapter1.Ch5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int n) 
    {
        count = n;
        id = new int[n];
        for(int i  = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int count() 
    { return count; }

    public boolean connected(int p, int q)
    { return find(p) == find(q); }

    public int find(int p);
    public void union(int p, int q);

    public static void main(String[] args)
    {
        int n = StdIn.readInt();
        UnionFind uf = new UnionFind(n);
        while(!StdIn.isEmpty()) 
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components")
    } 

}
