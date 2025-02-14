package Chapter1.Ch5;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private int[] parent;
    private int[] rank;
    private boolean[] bit;
    private int count;
    private int virtualTop;
    private int virtualBottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) 
    {
        this.n = n;
        this.count = 0;
        this.virtualTop = 0;
        this.virtualBottom = 0;
        for(int i = 0; i < n*n; i++) {
            parent[i] = i;
            rank[i] = 0;
            bit[i] = false;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        if(!bit[row * n + col]) {
            bit[row * n + col] = true;
            count++;
        } 

        // connect the neigbouring sites and connect if they are conencted
        if(isOpen(row,col-4)) {
            parent[row * n + col] = row * n + col - 4;
        } else if(isOpen(row,col+4)) {

        } else if(isOpen(row+1,col)) {

        } else if(isOpen(row-1,col)) {

        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if(0 <= row && row < n && 0 <= col && col < n) {
            return bit[row * n + col];
        } else {
            throw new IllegalArgumentException("Row and col must be between 0 and n");
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if(isOpen(row, col) && ((parent[row * n + col] != row * n + col) || rank[row * n + col] != 0)) {
            return true;
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return count;
    }

    // does the system percolate?
    public boolean percolates()
    {
        return true;
    }

    // test client (optional)
    public static void main(String[] args)
    {

    }
}