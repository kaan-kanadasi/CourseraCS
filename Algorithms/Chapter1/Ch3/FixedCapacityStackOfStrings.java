package Chapter1.Ch3;

public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity) 
    { s = new String[capacity]; }

    public boolean isEmpty() 
    { return N == 0; }

    public void push(String item) 
    { 
        if(N == s.length) 
        { throw new RuntimeException("Stack Overflow"); }
        s[N++] = item; 
    }

    public String pop() 
    { 
        if(isEmpty()) 
        { throw new RuntimeException("Stack underflow"); }
        // return s[--N] -> this would allow loitering
        String item = s[--N]; 
        s[N] = null;
        return item;
    }
}