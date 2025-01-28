/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
*/


public class valid_paranthesis {
    public static boolean open_b;
    public static boolean closed_b;
    public static boolean curly_b;

    public boolean isValid(String s) {
        boolean open_b_s = false;
        boolean open_b_e = false;
        boolean closed_b_s = false;
        boolean closed_b_e = false;
        boolean curly_b_s = false;
        boolean curly_b_e = false;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                open_b_s = true;
            } else if(s.charAt(i) == ')') {
                open_b_e = true;
            }
            open_b = (open_b_s ^ open_b_e);

            if(s.charAt(i) == '[') {
                closed_b_s = true;
            } else if(s.charAt(i) == ']') {
                closed_b_e = true;
            }
            closed_b = (closed_b_s ^ closed_b_e);

            if(s.charAt(i) == '{') {
                curly_b_s = true;
            } else if(s.charAt(i) == '}') {
                closed_b_e = true;
            }
            curly_b = (curly_b_s ^ curly_b_e);
        }
        return (open_b && closed_b && curly_b);
    }

}