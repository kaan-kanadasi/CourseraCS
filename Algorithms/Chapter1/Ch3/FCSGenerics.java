package Chapter1.Ch3;

// FixedCapacityStack using Generics 
public class FCSGenerics<Item> {
    private Item[] s;
    private int N = 0;

    public FCSGenerics(int capacity) 
    { s = (Item[]) new Object[capacity]; }

    public boolean isEmpty() 
    { return N == 0; }

    public void push(Item item) 
    { 
        if(N == s.length) 
        { throw new RuntimeException("Stack Overflow"); }
        s[N++] = item; 
    }

    public Item pop() 
    { 
        if(isEmpty()) 
        { throw new RuntimeException("Stack underflow"); }
        // return s[--N] -> this would allow loitering
        Item item = s[--N]; 
        s[N] = null;
        return item;
    } 
}

