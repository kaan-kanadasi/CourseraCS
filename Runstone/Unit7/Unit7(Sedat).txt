/*
 * reference VS primitive types:
 * primitive types store the actual value, while reference types store a reference to the value's location in memory
*/

/*
 * Collections - are resizable and can dynamically grow or shrink to accommodate elements. They offer a rich set of methods 
 * (add, remove, contains, etc.) Collections can only store objects (references to objects)
 * ArrayList bir collection, array bir collection değil
*/

/*
 * ArrayList declare ederken sondaki () ne anlama geliyor ->
 * ArrayList<Integer> listOfIntegers = new ArrayList<>(); // Creating an ArrayList object using the default constructor
 * 
 * In this case, ArrayList<>(); calls the default constructor of the ArrayList class to create a new instance of ArrayList
 * 
 * The parentheses () in this context denote that a constructor is being invoked to create an instance of the ArrayList class 
 * without passing any arguments. However, constructors can take arguments to initialize the object with specific values.
 * 
 * you can pass arguments to specify initial capacity or to initialize it using elements from another collection:
 * ArrayList<Integer> listOfIntegers = new ArrayList<>(10); // initial capacity 10
 * ArrayList<String> copyOfStrings = new ArrayList<>(originalList); // copying elements from another collection
 * 
 * ArrayList<String> copyOfStrings = new ArrayList<>(List.of("Alex", "Alvin", "Eva"));
 * The List.of method allows you to create an IMMUTABLE list of elements, and by passing this immutable list to the 
 * ArrayList constructor, you create a new ArrayList initialized with the same elements.
 * immutable: you cannot directly add, remove, or change elements within that list. It's fixed in size and content.
*/

/*
 - new keyword is used to create an instance of a class
 * 
 * ArrayList<String> listOfStrings = new ArrayList<>(); 
 * listOfStrings is an object—an instance of the ArrayList class.
 * 
 * Strings in Java are treated as objects of the String class
 * The String class in Java has multiple constructors, and one of them accepts a String literal or another String object as an argument.
 * 
 * Using String as an object created with a constructor taking an argument
 * String greetingObject = new String("Hello");
 * 
 * Using String as a string literal
 * String greetingLiteral = "Hello";
*/




// Arraylist Basics
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
            // ArrayList<type> name = new ArrayList<type>();

            // Wrapper class - a class that wraps one or more primitive data types
            // Wrapper classes are used to treat primitive data types as objects

            ArrayList<String> list1 = new ArrayList<String>(); 
            ArrayList<Integer> list2 = new ArrayList<Integer>();

            //add elements
            list1.add("dog");
            list1.add("cat");
            list1.add("fish");

            //size
            System.out.println(list1.size()); // prints: 3
            System.out.println(list1); // prints [dog, cat, fish]

        // autoboxing (primitive int to Integer conversion)
        list2.add(7); 
        list2.add(5);
        list2.add(-3);
        list2.add(-6);
        list2.add(12);

        // auto-unboxing (Integer to primitive int conversion)
        int value = list1.get(0); 
        
        // prints: List 2 has 5 elements and they are [7, 5, -3, -6, 12]
        System.out.println("List 2 has " + list2.size() + " elements and they are" + list2);
    }
}




// Arraylist Methods
import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
        ArrayList<String> grocery = new ArrayList<String>();

        grocery.add("banana");
        grocery.add("apple");
        grocery.add("cheese");
        grocery.add("eggs");

        System.out.println("There are " + grocery.size() + " items on my grocery list" );
        System.out.println(grocery);
        System.out.println(grocery.add("milk")); //return true
        grocery.add(2,"yogurt"); // void method
        System.out.println(grocery);

        grocery.set(4,"bread");
        // System.out.println(grocery.set(4,"bread"));// returns what was replaced

        System.out.println(grocery);

        grocery.remove(3);
        // System.out.println(grocery.remove(3)); returns what you removed

        System.out.println(grocery);
        System.out.println(grocery.get(0)); //specific item
        System.out.println(grocery);
        System.out.println("The first item on my list is " + grocery.get(0) + "and the last item is " + 
        grocery.get(grocery.size()-1) );
    }
}




// ArrayList Loops
import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<String>();
        animals.add("cat");
        animals.add("dog");
        animals.add("snake");
        animals.add("fish");
        animals.add("snail");
        animals.add("squirrel");
        System.out.println(animals);

        //for loop - remove words that begin with the letter s
        for(int i = 0; i<animals.size();i++) {
            if(animals.get(i).substring(0, 1).equals("s")) {
                animals.remove(i);
                //i--;
            }
        }
        System.out.println(animals); //check size

        //for-each loop - print words that are less than 4 charectess
        for(String elem : animals) {
            if(elem.length() < 4) {
                System.out.println(elem + " ");
            }
        }
        System.out.println();

        //while loop - if value is below 50, changes value to 50
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(57);
        nums.add(28);
        nums.add(86);
        nums.add(70);
        nums.add(13);
        System.out.println(nums);

        int i = 0;
        while(i<nums.size()) {
            if(nums.get(i) < 50) {
                nums.set(i,50);
            }
            i++;
        }
        System.out.println(nums);
    }
}




// ArrayList Algorithms
import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Barb");
        names.add("Steph");
        names.add("Tara");
        names.add("Greg");
        names.add("Barb");
        names.add("Jon");
        System.out.println(names);

        ArrayList<Integer> ages = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            ages.add(i, (int) (Math.random() * 100));
        }
        System.out.println(ages);
        
        ArrayList newOne = combineTwoLists(names, ages);
        System.out.println(newOne);
    }

    // combine two lists
    public static ArrayList combineTwoLists(ArrayList a, ArrayList b) {
        ArrayList combinedList = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
            combinedList.add(i, a.get(i));
        }
        for (int j = 0; j < b.size(); j++) {
            combinedList.add(a.size() + j, b.get(j));
        }
        return combinedList;
    }

    // look for duplicates
    public static boolean dups(ArrayList a) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            for(int j = i+1; j<a.size();j++) {
                if(a.get(i) == a.get(j)) {
                    count++;
                }
            }
        }
        return (count > 0);
    }
}
