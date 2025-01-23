import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println("Vehicle Class");
        Vehicle v = new Vehicle(5);
        System.out.println(v);
  
        System.out.println("\nCar Class Extends Vehicle");
        Car c = new Car("Tesla", "CyberTruck", 2);
        System.out.println(c);
  
        System.out.println("\nSports Car Extends Car");
        SportsCar s = new SportsCar(210,"Ferrari", "458 Italia", 2);
        System.out.println(s);
  
        // Sports car class doesn't have getMaxPassengers(), but Vehicle does
        // and since SportsCar extends Car which extends Vehicle the following call works
        int passengers = s.getMaxPassengers();
        System.out.println("\nThis is the maxmimum passengers of the sports car: " + passengers);


		Vehicle a = new Car("Chevy", "Impala", 4);
		Vehicle a2 = new SportsCar(210, "Ferrari", "Berlinetta", 2);

		ArrayList<Vehicle> aList = new ArrayList<Vehicle>();
		aList.add(new Vehicle()); // Super
		aList.add(a); // Sub
		aList.add(a2); // Sub-Sub
		
		// Becasue toString is defined in Vehicle we can call it from any class that extends Vehicle, however because
		// Car and Sports car Override the method, we get different behaviors. Pay close attention to differences in the output.
		for (Vehicle vehicle : aList){
			System.out.println("\n----\n" + vehicle);
		}
    }
}


public class Car extends Vehicle {
    private String make;
    private String model;
  
    public Car () {
        this("", "", 0);
    }
    public Car (String make, String model, int maxPassengers) {
        super(maxPassengers);
        this.make = make;
        this.model = model;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String toString() {
        return super.toString() + "\n" + "Make: "  + getMake() + "\n" + "Model: " + getModel();
    }
}
  
  
public class SportsCar extends Car {
    private double topSpeed;
  
    public SportsCar() {
        this(0,"","",0);
    }
    public SportsCar (double topSpeed, String make, String model, int maxPassengers) {
        super(make, model, maxPassengers);
        this.topSpeed = topSpeed;
    }
    public double getTopSpeed() {
        return topSpeed;
    }
    public String toString() {
        // toString() method of the superclass
        return super.toString() + "\n" + "Top Speed: " + getTopSpeed();
    }
}


public class Vehicle {
    private int maxPassengers;
  
    public Vehicle() {
        this(0); // initializes maxPassengers to 0
    }
    public Vehicle (int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
    public int getMaxPassengers() {
        return maxPassengers;
    }
    public String toString() {
        return "Maximum Passengers: " + maxPassengers;
    }
}