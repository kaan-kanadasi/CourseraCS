class Main {
    public static void main(String[] args) {
        Pet pet1 = new Pet("Cat","Can");
        System.out.println(pet1);
    
        Dog dog1 = new Dog("Dog","kino","no");
        System.out.println(dog1);
    
        Dog dog2 = new Dog("Scout","poodle");
        System.out.println(dog2);
        /* 
         * It implicitly calls the default constructor of the Dog class because you are not providing values for all three parameters. 
         * The default constructor of Dog then implicitly calls the default constructor of the superclass (Pet), as it contains the 
         * statement super(); So, this sets the type to "none" and the name to "n/a."
        */
    }
}


public class Dog extends Pet {
    private String breed;
    
    public Dog(String t ,String n, String b) {
        super(t,n); // bir alt satirda tanimlarsan ne olur? 
        /* 
         * The super keyword, which is used to call the constructor of the superclass, must be the first statement in the constructor 
         * body. If you move it below the breed = b; line, you'll get a compilation error. 
         *  -  This rule ensures that the initialization of the superclass's state happens before the subclass's state is initialized.
        */
        breed = b;
    }
    
    public Dog() {
        super();
        breed = "none";
    } 
}


public class Pet {
    private String type;
    private String name;
   
    public Pet() {
        type = "none";
        name = "n/a";
    }
   
    public Pet(String t, String n) {
        type = t;
        name = n;
    }
    
    public String toString() {
        return name + ": is a " + type;
    }
}
       