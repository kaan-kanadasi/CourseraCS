public class Person { // extends Object
    private String firstName;
    private String lastName;

    public Person(String f, String l) {
        firstName = f;
        lastName = l;
    }
}

class Main {
    public static void main(String[] args) {
        Person per1 = new Person();
        System.out.println(per1);
    }
}

/*
 * The output will be a reference to the object, not a meaningful representation of the person's information.
 * If you want to print meaningful information about the person, you should override the toString method in the Person class:

    @Override
    public String toString() {
        return "Person: " + firstName + " " + lastName;
    }

    class Main {
        public static void main(String[] args) {
            Person per1 = new Person("Ada","CS");
            System.out.println(per1);
        }
    }

 * You are telling the compiler that you are intentionally providing a new implementation for the toString() method that is already 
 * present in the Object class (since all Java classes implicitly extend Object). The Object class is the root class in the Java 
 * class hierarchy, and it provides certain methods that are inherited by all other classes unless explicitly overridden. So, 
 * it inherits methods like toString(), equals(), hashCode(), and others from Object.
 * 
 * This is why you can override the toString() method in the Person class, which is originally defined in the Object class.
*/

public class Student extends Person {
    private int ID;
    public Student(String f, String l, int idNum) {
        super(f,l);
        ID = idNum;
    }
}

/*
    class Main {
        public static void main(String[] args) {
            Student stu1 = new Student("Kal","Di", 1235);
            System.out.println(stu1);

            Person per2 = new Student("Ret","Think", 4543);
            System.out.println(per2); 

            // compilation error: Student stu2 = new Person("Stu2","STSur2"); 
            // you cannot directly create an instance of a subclass using the constructor of its superclass. [çocuktan baba yaratmak]

            // ClassCastException: Student stu2 = (Student) new Person("Stu2", "STSur2");
        }
    }
*/


/*
 * The super keyword is used to refer to the superclass, and super.toString() returns the string representation of the Person object, 
 * which is the concatenation of the first name and last name.

    public class Student extends Person {
        (...)
        public String toString() {
            return super.toString() + "ID# " + ID;
        }
    }
*/