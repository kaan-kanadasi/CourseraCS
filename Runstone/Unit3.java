if (x > 0)
   x = -x;
if (x < 0)
   x = 0;
// x = 0;


public boolean check(String s) {
    return s.length() >= 2 && (s.charAt(0) ==
       s.charAt(1) || check(s.substring(1)));
 }
 //  "s contains two or more of the same character in a row."
 // "s starting with two or more of the same characters" is not neccessary for the adjoining characters to be at the start 

if ((x == 10) && (y / 0) == 0)
    System.out.println("first case!");
else
    System.out.println("second case!");
// There will be a run-time error.

public boolean mystery(String s) {
   if (s.length() == 0 || s.length() == 1)
           return true;
   if (s.charAt(0) == s.charAt(s.length()-1))
           return mystery(s.substring(1, s.length() - 1));
   return false;
}
// Checks if s is a palindrome - ??? ama sadece bir kere kontrol ediyor for/while yok

double x =  0.0;
double y = -0.5;
boolean result =  (y > 0) && (x / (y+0.5) );
System.out.println(result);
// false - conditional false

double x = 2.5;
double y = 0.0;
boolean result =  (x / y < 1) || (x > y);
System.out.println(result);
// error - ilk statement