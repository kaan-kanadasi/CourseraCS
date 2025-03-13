package Chapter1.Ch3;

public class LinkedStackOfStrings {
    private Node first = null;

    // 40 bytes per stack Node = 16(object overhead) + 8(inner class overhead) + 8(reference to String) + 8(refereance to Node)
    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void push(String item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst; 
    }

    public String pop()
    {
        if(isEmpty()) 
        { throw new RuntimeException("Stack underflow"); }
        String item = first.item;
        first = first.next;
        return item;
    }
}