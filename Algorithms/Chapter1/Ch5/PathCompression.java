package Chapter1.Ch5;

public class PathCompression
{
    private int[] id;  
    private int[] sz;  
    private int count; 

    public PathCompression(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }
    public int root(int i)
    {
        while (i != id[i]) {
            id[i] = id[id[i]]; // while we search for the root, connect the nodes that are parents to node i to the main root
            i = id[i];
        } 
        return i;
    }
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);

        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
        count--;
    }
}