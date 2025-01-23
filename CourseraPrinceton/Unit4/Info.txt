/*
 * An abstraction is something that exists only as an idea.
 * This lecture. Abstractions for delivering input to or receiving output from our programs.
 * Terminal. An abstraction for providing input and output to a program.
 * Command-line input. An abstraction for providing arguments (strings) to a program
*/


/*
    • Strings you type after the program name are available as args[0], args[1], ... at run time.
    • Arguments are available when the program begins execution.
    • Need to call system conversion methods to convert the strings to other types of data.
*/
public class RandomInt {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double r = Math.random();
        int t = (int) (r * N);
        System.out.println(t);
    }
} 


/*
Standard output stream. An abstraction for an infinite output sequence.
    • Strings from System.out.println() are added to the end of the standard output stream.
    • Standard output stream is sent to terminal application by default.
*/
public class RandomSeq {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 0; i < N; i++)
            System.out.println(Math.random());
    }
}


/*
Standard input stream. An abstraction for an infinite input sequence.
Advantages over command-line input
    • Can provide new arguments while the program is executing.
    • No limit on the amount of data we can input to a program
*/

/*
boolean isEmpty() - true iff no more values
int readInt() - read a value of type int
double readDouble() - read a value of type double
long readLong() - read a value of type long
boolean readBoolean() - read a value of type boolean
char readChar() - read a value of type char
String readString() - read a value of type String
String readAll() - read the rest of the text
*/

public class AddTwo {
 public static void main(String[] args) {
    StdOut.print("Type the first integer: ");
    int x = StdIn.readInt();
    StdOut.print("Type the second integer: ");
    int y = StdIn.readInt();
    int sum = x + y;
    StdOut.println("Their sum is " + sum);
 }
}
/* % java AddTwo
Type the first integer:
Type the second integer:
Their sum is 3 */


public class Average {
 public static void main(String[] args) {
 double sum = 0.0; // cumulative total
 int n = 0; // number of values
 while (!StdIn.isEmpty()) {
    double x = StdIn.readDouble();
    sum = sum + x;
    n++;
 }
 StdOut.println(sum / n);
 }
}
/*
• No limit on the size of the input stream.
• Input and output can be interleaved.
% java Average
10.0 5.0 6.0
3.0 7.0 32.0
<Ctrl-d>
10.5
*/

/*
Piping. Connect standard output of one program to standard input of another.
% java RandomSeq 1000000 | java Average
0.4997970473016028
% java RandomSeq 1000000 | java Average
0.5002071875644842
*/
