/*
* re-sizable arrays that allow adding and removing items to change their size during run time
* ArrayList object contains object references and is mutable, meaning it can change 
* ArrayList constructor ArrayList() constructs an empty list of size 0.
* When ArrayList<E> is specified, the types of the reference parameters and return type when using its methods are type E.
* ArrayLists cannot hold primitive types like int or double, so you must use the wrapper classes Integer or Double 

array - know how many items will be in the array, the items in the array won’t change in order or number
ArrayList - don’t know how many items you will need in the list, to remove/add items to the list while the program is running

array.length - list.size()
value = array[index]; - value = list.get(index);
array[index] = value; - list.set(index,value);

- int size() : Returns the number of elements in the list
- boolean add(E obj) : Appends obj to end of list; returns true
- void add(int index, E obj) : Inserts obj at position index, moving 
  elements at position index and higher to the right and adds 1 to size
- remove(int index) — Removes element from position index, moving elements at position index + 1 
  and higher to the left and subtracts 1 from size; returns the element formerly at position index
- E get(int index) : Returns the element at position index in the list
- E set(int index, E obj) : Replaces the element at position index with obj; returns the element formerly at position index
*/

/*
 * Changing the size of an ArrayList while traversing it using an enhanced for loop can result in a 
 * ConcurrentModificationException being thrown. Therefore, when using an enhanced for loop to traverse an ArrayList, 
 * you should not add or remove elements.
 */



import java.util.ArrayList;
import java.util.Collections;

public class Digits {
    /** A list of digits */
    private ArrayList<Integer> digitList;

    /** Constructs a list of digits from the given number */
    public Digits(int number) {
        // initialize digitList to an empty ArrayList of Integers
        digitList = new ArrayList<Integer>();

        // Use a while loop to add each digit in number to digitList
        while(number > 0) {
            int digit = number % 10;
            digitList.add(digit);
            number /= 10;
        }

        // Use Collections.reverse(digitList); to reverse the digits
        Collections.reverse(digitList);
    }

    /** returns the string representation of the digits list */
    public String toString() {
        return digitList.toString();
    }

    public static void main(String[] args) {
        Digits d1 = new Digits(154);
        System.out.println(d1);
    }
}



// obj = listName.get(index)
// listName.set(index,obj)
List<Integer> list1 = new ArrayList<Integer>();
list1.add(1);
list1.add(2);
list1.add(3);
list1.set(2, 4);
list1.add(2, 5);
list1.add(6);
System.out.println(list1);
// [1, 2, 5, 4, 6]

// arrayName.remove(index) removes that element in the specified index



public class ToDoList {
    public static void main(String[] args) {  
        // String[] toDoList = new String[3];
        ArrayList<String> toDoList = new ArrayList<String>();
        // toDoList[0] = "Do homework";
        toDoList.add("Do homework");
        // toDoList[1] = "Help make dinner";
        toDoList.add("Help make dinner");
        // toDoList[2] = "Call grandma";
        toDoList.add("Call grandma");

        // toDoList[1] = "Order pizza";
        toDoList.set(1, "Order pizza");

        // System.out.println(toDoList.length + " things to do!");
        System.out.println(toDoList.size() + " things to do!");
        // System.out.println("Here's the first thing to do: " + toDoList[0]);
        System.out.println("Here's the first thing to do: " + toDoList.get(0));

        // toDoList[0] = toDoList[1];
        // toDoList[1] = toDoList[2];
        // toDoList[2] = "";
        toDoList.remove(0);

        // System.out.println("Here's the next thing to do: " + toDoList[0]);
        System.out.println("Here's the next thing to do: " + toDoList.get(0));
    }
}



// [0, 0, 4, 2, 5, 0, 3, 0]
ArrayList<Integer> list1 = new ArrayList<Integer>();
private ArrayList<Integer> nums;
// precondition: nums.size() > 0;
// nums contains Integer objects
public void numQuest() {
   int k = 0;
   Integer zero = new Integer(0);
   while (k < nums.size()) {
      if (nums.get(k).equals(zero))
         nums.remove(k);
      k++;
   }
}
/*
 *  [0, 4, 2, 5, 3]
 *  Incrementing the index each time through the loop will miss when there are two zeros in a row
 */