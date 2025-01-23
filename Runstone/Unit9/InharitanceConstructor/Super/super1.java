class Main {
    public static void main(String[] args) {
        Pet pet1 = new Pet("Cat","Can");
        System.out.println(pet1);
   
        Dog dog1 = new Dog();
        System.out.println(dog1);
    }
}
    
public class Dog extends Pet { 
    private String breed;
}

public class Pet {
    private String type;
    private String name;
   
    /* 
     * default constructor - olmasaydı main method'da dog objesi yaratamazdık [compilation error]
     * when you create an instance of a subclass, the superclass must be properly initialized, and if there's no default constructor 
     * in the superclass, the compiler won't be able to automatically insert a call to it. 
    
     * eğer defualt constructor yapmak istemiyorsan Dog class'ında bir constructor yaratmalısın ve super() keyword'u ile 
     * superclass constructor'unu çağırmalısın
    
    public Dog(String t, String n, String b) {
        super(t, n);
        breed = b;
    }
    */
    
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