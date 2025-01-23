/*
 * Superclasses are components of data inheritance where certain properties, attributes, or characteristics 
 * of an entity are inherited or passed down from a parent object to its child objects or entities. 
 *   -  Parent object - superclass
 *   -  Child object - subclass
 * 
 * Multiple inheritance means that a subclass can inherit from two or more superclasses. C++ allows multiple inheritance, but Java 
 * allows only single inheritance, that is, a subclass can inherit only one superclass.
*/

public class Vehicle {
    // private olduğundan dolayı subclassler Vehicle constructorunda koyduğumuz değerlere erişemiyor; bunun için getter metodu lazım
    private int maxSpeed;
    private String numberOfWheels; 

    public Vehicle(int maxSpeed, String numberOfWheels) {
        this.maxSpeed = maxSpeed;
        this.numberOfWheels = numberOfWheels;
    }

    /* 
    eğer @param maxSpeed methodun içinde bir parametre olmasaydı Vehicle class'ının içindeki maxSpeed variable'ına refer ederdi;
    buyüzden bir subclass oluşturduğumda maxSpeed variable'ı Vehicle class'ındaki value kadar olurdu 
    */ 
    public int maxDisplacement(int time, int maxSpeed) { 
        // if I put private in front of the method (encapsulation) the subclass couldn't reach out to the method
        return (time * maxSpeed);
    } 
}

public class Car extends Vehicle {
    private String brand;
    public Car(int maxSpeed, String numberOfWheels, String brand) {
        /*
        super() kullanmasaydım ve this.maxSpeed = maxSpeed; this.numberOfWheels = numberOfWheels; yapsaydım, compilation error verirdi 

        "Since the superclass constructor takes parameters, you must use super(maxSpeed, numberOfWheels); to provide the necessary,
        arguments for the superclass initialization. If you don't, the compiler will complain about a missing default constructor in 
        the superclass." - ChatGPT
        "super() ensures that the superclass is properly initialized before the subclass" - ChatGPT

        Eğer default constructor olsaydı super() kullanmadadan da kod çalışırdı
        */
        super(maxSpeed, numberOfWheels);
        this.brand = brand;
    }  

    // superclass'deki method'a erişebiliyorum
    public void p() {
        // method overriding (superclass'daki method'u çağırdın)
        System.out.println(maxDisplacement(10, 250)); 
    }
}