/**
 * takes two names as command-line arguments and prints hello and goodbye messages with the names for the hello message 
 * in the same order as the command-line arguments and with the names for the goodbye message in reverse order
 * @author Kaan Kanadasi
 * @since 20 nov 2023
 */

public class HelloGoodbye {
    public static void main(String[] args) {
        String name1 = args[0];
        String name2 = args[1];

        System.out.println("Hello " + name1 + " and " + name2 + ".");
        System.out.println("Goodbye " + name2 + " and " + name1 + ".");
    }
}