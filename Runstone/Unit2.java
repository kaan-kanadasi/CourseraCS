class SomeClass {
    int someVar;
}
public class MainClass {
    public static void main(String[] args) {
        SomeClass x;
        System.out.println(x.someVar);
    }
}
// compile error - This will give an error that x has not been initialized. 
// It needs to be initialized with a call to the SomeClass constructor.


class SomeClass {
    int someVar;
}
public class MainClass {
    public static void main(String[] args)
    {
        SomeClass x = new SomeClass();
        System.out.println(x.someVar);
    }
}
// 0 - ints get initialized to 0 by default if not explicitly initialized.


System.out.println(5 + 7 + "4" + 2);
// 1242


String s1 = "4";
int num1 = 5;
int num2 = 4;
double num3 = 2.0;
s1 = num3 + s1 + num1 / num2;
// "2.041"  ?????


public class Test1 {
    public static void question(String name)
    {
        int commaIndex = name.indexOf(',');
        String lastName = name.substring(0, commaIndex);
        String firstName = name.substring(commaIndex + 1);
        int randID = Math.random()*999+1;

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(randID);
    }

    public static void main(String[] args) {
      String name = args[0]; 
      Test1.question(name);
    }
}


public class Tricky
{
  public static void main(String... args)
  {
    int a = 1;
    int b = 1;
    Integer c = new Integer(1);
    Integer d = new Integer(1);

    System.out.print((a == b) + " ");
    System.out.print((c == d) + " ");
    System.out.print((a == c) + " ");
    System.out.println(c.equals(d));
  }
}
// true false true true
/* When using == with a primitive and an object, Java automatically unboxes the Integer object to its primitive value and
compares the values. Therefore, it compares a (primitive int) and the unboxed value of c (also 1), resulting in true. */ 