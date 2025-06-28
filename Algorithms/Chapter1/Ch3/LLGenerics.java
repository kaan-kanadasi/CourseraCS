package Chapter1.Ch3;
// Linked Lists using Generics 
public class LLGenerics<Item> { // using generics allws other types to be used and check for mismatched types in compile time
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst; 
    }

    public Item pop()
    {
        if(isEmpty()) 
        { throw new RuntimeException("Stack underflow"); }
        Item item = first.item;
        first = first.next;
        return item;
    }
}