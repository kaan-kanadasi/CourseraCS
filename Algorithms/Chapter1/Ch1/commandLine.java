package Chapter1.Ch1;
public class commandLine {
    public static void main(String[] args) {
        if (args.length == 3) {
            int first = Integer.parseInt(args[0]);
            int second = Integer.parseInt(args[1]);
            int third = Integer.parseInt(args[2]);

            if (first == second && second == third) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }
        } else {
            System.out.println("Please input exactly 3 command-line arguments");
        }
    }
}
