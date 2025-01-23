public class Animal {
    public void eat () 
        { /* implementation not shown */ }
}

public class Tiger extends Animal {
    public void roar ()
        { /* implementation not shown */ }
}

/* 
Assume that the following declaration appears in a client class.
    Animal a = new Tiger ();
Which of the following statements would compile without error?
    I. a.eat ();
    ll. a.roar ();
    III. ((Tiger) a) .roar () ;
*/

// I and III will compile without error while II will give error:
// The reference a is of type Animal, and the roar method is specific to the Tiger class. 