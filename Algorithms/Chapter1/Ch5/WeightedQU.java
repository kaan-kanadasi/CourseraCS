package Chapter1.Ch5;

public class WeightedQU
{
    private int[] id;  // parent link 
    private int[] sz;  // size of components for roots
    private int count; // number of componenets

    public WeightedQU(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }
    public int root(int i)
    {
        while (i != id[i]) i = id[i];
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
        id[i] = j;

        // Make smaller root point to the larger one 
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[j] += sz[i]; }
        count--;
    }
}