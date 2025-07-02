package Chapter1.Ch3;

public class ResizingArrayStackOfString {
    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfString() 
    { s = new String[1]; }

    public boolean isEmpty() 
    { return N == 0; }

    public void push(String item) 
    { 
        // if array is full create a new array twice the size
        if(N == s.length) resize(2*s.length); 
        s[N++] = item; 
    }

    public String pop() 
    { 
        if(isEmpty()) 
        { throw new RuntimeException("Stack underflow"); }
        // shrink the array to half when it is quarter size 
        if(N > 0 && N == s.length/4) resize(s.length/2);
        String item = s[--N]; 
        s[N] = null; // avoids loitering
        return item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) 
            copy[i] = s[i];
        s = copy;
    }
}