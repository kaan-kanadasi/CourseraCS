class Plant {
    String plantName;
    int plantHeight;
  
    public void waterPlant() {
        System.out.println("The " + plantName + " has been watered");
    }
    
    public Plant(String name, int height) {
        // We explicitly call the Object constructor even through we did not use the extends keyword
        super(); // Plant is a subclass of Object
        plantName = name;
        plantHeight = height;
        System.out.println("Plant constructor has been called");
    }
}
  
class Succulent extends Plant {
    public Succulent(String succulentName, int succulentHeight) {
        super(succulentName, succulentHeight); // ??? super(name, height) olması lazım değil mi
        System.out.println("Succulent constructor has been called");
    }
    public static void main(String[] args) {
        Succulent lithops = new Succulent("lithops", 1);
    }
}

/*
 * Output:
 * Plant constructor has been called
 * Succulent constructor has been called
 */