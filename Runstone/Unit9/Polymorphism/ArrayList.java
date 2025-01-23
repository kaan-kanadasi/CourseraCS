import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
        Entertainer fred = new Entertainer("musician");
        System.out.println(fred.getTalent());

        // Error: System.out.println(fred.tellJoke());

        ArrayList<String> oneLiners = new ArrayList<String>();
        Entertainer sally = new Comedian("satire", oneLiners); 
        // polymorphism !!! -> Comedian object is assigned to an Entertainer reference
        System.out.println(sally.getTalent());
        /*
         * The Comedian class overrides the getTalent() method to provide a specific implementation. When you use polymorphism, 
         * and you have an Entertainer reference pointing to a Comedian object, calling getTalent() on that reference will invoke 
         * the overridden method in the Comedian class.
        */
        
        oneLiners.add("Joke1");
        oneLiners.add("Joke2");
        oneLiners.add("Joke3");
        // Compilation error: System.out.println(sally.tellJoke());
        System.out.println(((Comedian)sally).tellJoke()); // Polymorphism advantage: downcast example 
    }
}


public class Comedian extends Entertainer {
    private ArrayList<String> jokes;

    public Comedian(String t, ArrayList<String> jks) {
        super(t);
        jokes = jks;
    }
    public String getTalent() {
        return "Comedy style: " + super.getTalent();
    }
    public String tellJoke() {
        return jokes.get((int)(Math.random()*jokes.size()));
        // return "A";
    }
}


// Enterteiner is a common interface 
public class Entertainer {
    private String talent;

    public Entertainer(String t) {
        talent = t;
    }
    public String getTalent() {
        return talent;
    }
}