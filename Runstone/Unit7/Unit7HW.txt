public class Unit7HW {
    public static void main(String[] args) {
    // Intro to ArrayList && ArrayList Methods
    /*
    * <E> the E inside dimond brackets specify the ArrayList's type. ArrayList is mutable which means it can change its size 
    * after beaing decleared. ArrayList can only take referance types, not primitive types. Before assinging any values the 
    * values inside the ArrayList are null. ArrayList class is called to create an instance of ArrayList class (ex1 object)
    */
    ArrayList<String> ex1 = new ArrayList<String>();
    ArrayList<Integer> ex2 = new ArrayList<Integer>();

    // NAME.add() method adds an element to the ArrayList to the index at index[NAME.size()+1], so the size increases 
    ex1.add("Kaan");
    ex1.add("Sedat");
    ex1.add("YSC2");

    /* 
    * array deki NAME.length bir method değil, it is a propert of array as arrays have a fixed size
    * Arraylist deki NAME.size() collection'larda kullanılan bir method, () bunu en açık gösteren syntax
    */ 
    System.out.println(ex1.size());

    // removes the String from index 0, other elements shift one row to the left
    ex1.remove(0); 
    // gets the value on index 0
    String firstElement = ex1.get(0); 

    // autoboxing (primitive int to Integer conversion)
    ex2.add(-6);
    ex2.add(2);
    // replaces the element at index 1 with 4
    ex2.set(1, 4); 

    // Traversing ArrayList Loop
    for(Integer element : ex2) {
        System.out.println(element);
    }

    }
}