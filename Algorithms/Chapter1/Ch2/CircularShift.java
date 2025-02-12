/*
 * A string s is a circular shift of a string t if it matches when the characters are circularly shifted by and number of positions
 * e.g. ACTHACG is a circular shift of THACGAC 
 * Write a program that checks weather two given strings s and t are circular shifts of one anouther 
 * Hint: the solution is one liner with indexOf(), length(), and string concatination.
*/
package Chapter1.Ch2;
import java.util.Scanner;

public class CircularShift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        String check = s+s;
        boolean result = false;

        // chat: boolean result = (s.length() == t.length()) && ((s + s).contains(t));
        if(s.length() == t.length()) { 
            for(int i = 0; i < s.length(); i++) {
                if(t.equals(check.substring(i, s.length() + i))) {
                    result = true;
                    break;
                }
            }
        } 

        System.out.println("The result is " + result);
        scan.close();
    }
}