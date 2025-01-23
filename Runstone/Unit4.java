/*
 *  Use a while loop when you don't know how many times a loop needs to execute.
 *  Use a for loop when you know how many times a loop needs to execute.
 */


for (int j = 1; j <= 5; j++) {
    for (int k = 5; k >= j; k--) {
       System.out.print(j);
    }
    System.out.println();
 }
 /*
    11111
    2222
    333
    44
    5    
*/ 


int count = 0;
int x = (int)(Math.random()*10);
while (x != 0) {
    System.out.print(x + ", ");
    x = (int)(Math.random()*10);
    count++;
}
System.out.print(x + " ");
System.out.println("The sequence has a length of " + count);
/*
*   output: 
*   5, 7, 9, 0
*   The sequence has a length of 4.
*/


Scanner scan = new Scanner(System.in);
System.out.println("Enter a name: ");
String name = scan.nextLine();
scan.close();
        
int count = 0;
for(int i = 0; i < name.length(); i++) {
    char ch = Character.toLowerCase(name.c;
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        count++;
    }
}
System.out.println(count);
// Write a program that counts the number of vowels in a given string.


String phrase = "pay close attention";
int counter = 0;
while (counter < phrase.length()) {
   counter++;
   System.out.println( phrase.substring(counter, counter+1) );
}
// Counter increments too early and causes outOfBoundsError. Counter increment should be placed after the print statement.


int num = {some unknown number};
int var = 0;
for (int i = 0; i <= num; i+=2) {
  var += i;
}
System.out.println(var);
//  sums all of the even numbers from 0 to num ????????

for (int j = 1; j <= 5; j++) {
    for (int k = j; k <= 5; k++) {
       System.out.print(k);
    }
    System.out.println();
 }
 /*
    12345
    2345
    345
    45
    5
*/


public static boolean isInAlphabeticalOrder(String w) {
    String word = w;
    boolean alphabetical = true;

    for(int i = 0; i < w.length()-1; i++) { 
        char a = w.charAt(i);
        char b = w.charAt(i+1);
        if(Character.toLowerCase(a) > Character.toLowerCase(b)) {
            alphabetical = false;
        } 
    }
    return alphabetical;
}


for (int i = 1; i <= 4; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print(i);
    }
    System.out.println();
}
/*
1
22
333
4444
*/


for(int i = 1; i<=5; i++) {
    for(int j = 0; j<i; j++) {
        System.out.print("*");
    }
    System.out.println();
}
/*
*
**
***
****
*****
*/


public String crossOut(String word) {
   //write your code to cross out the letters in a word here
    String cross = "";
    for(int i = 0; i < word.length(); i++) { 
        cross += "-";
    } 
    return cross;
}
public String crossOutAll(String word, String phrase) {
   //write your code to cross out the word in the given phrase
   //you should use the crossOut method in here to help solve this problem
    String cross = phrase;
    int index = cross.indexOf(word);
    while (index != -1) {
        String dashes = crossOut(word); // Get a string of dashes of the same length as the word
        cross = cross.substring(0, index) + dashes + cross.substring(index + word.length());
        index = cross.indexOf(word, index + dashes.length()); // Look for the next occurrence of the word
    }
    return cross;
}
/*
#1 - write a method called crossOut that deals with a single word
    crossOut(“dog”) –> “—“;
    crossOut(“Hello”) –> “—–“;
    crossOut(“How are you?”) –> “————“;
#2 - write method called crossOutAll that removes the word from a phrase
    crossOutAll(“ate”, “I ate an apple for lunch and I hated it”)
    “I — an apple for lunch and I h—d it”
*/


public String reveal(String answer, String exposed, String guess) {
    char[] cross = exposed.toCharArray(); // Convert exposed string to a character array

    int index = answer.indexOf(guess);
    while (index != -1) {
        cross[index] = guess.charAt(0); // Replace the dash with the guessed letter
        index = answer.indexOf(guess, index + 1); // Look for the next occurrence of the guessed letter
    }
    return new String(cross); 
}
/*
reveal(“dominos”, “——-”, “s”) –> “——s”
reveal(“dominos”, “——s”, “o”) –> “-o—os”
reveal(“dominos”, “-o—os”, “t”) –> “-o—os”
*/


public boolean doubledUp(String word) {
    if (word.length() == 0) {
       return true; 
    }
    if (word.length() % 2 != 0) {
       return false;
    }
    for (int i = 0; i < word.length(); i += 2) {
        if (word.charAt(i) != word.charAt(i + 1)) {
            return false; 
        }
    }
    return true; 
}
/*
doubledUp(“aabbccdd”) –> true
doubledUp(“qqwweerrttyy”) –> true
doubledUp(“abcddcba”) –> false
doubledup(“sunshine”) –> false
*/


public String longestWord(String sentence) {
    String[] words = sentence.split(" "); 
    // splits the string at every space character (" ") and returns an array of words.
    String largest = "";
    for (int i = 0; i < words.length; i++) {
        String word = words[i];
        if (word.length() >= largest.length()) {
            largest = word;
        }
    }
    return largest;
}
/*
largestWord(“Roses are red violets are blue”) –> “violets”
largestWord(“Sugar is sweet and so are you”) –> “sweet”
*/


public String addCommas(String number) {
    int len = number.length();
    String result = "";
    for (int i = 0; i < len; i++) {
        result += number.charAt(i); // Concatenate each character from the original number
        int posFromRight = len - 1 - i;
        // len - 1 gives the index of the last character in the string since indices start from 0
        // len - 1 - i calculates the position of the digit from the right side of the number in the current loop
        if (posFromRight % 3 == 0 && posFromRight != 0) {
            result += ","; // Concatenate a comma after every third digit from the right
        }
    }
return result;
}
/*
addCommas(“1234567”) –> “1,234,567”
addCommas(“123”) –> “123”
addCommas(“123456”) –> “123,456”
*/


public static boolean isSelfDivisor(int number) {     
    int digit = 0;
    while (number > 0) {
        digit = number % 10; 
        if (digit == 0 || number % digit != 0) return false;
        number /= 10;
    }
    return true; 
}