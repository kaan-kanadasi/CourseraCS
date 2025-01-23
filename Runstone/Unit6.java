public class ArrayFindSmallest {
    // return index of the last number smaller than target
    public static int getIndexOfLastElementSmallerThanTarget(int[] values, int target) {
        for (int index = values.length - 1; index >= 0; index--) {
            if (values[index] < target) 
               return index;
        }
        return -1;
    }

    /**
     * Add a method called getIndexOfLastElementGreaterThanTarget
     *
     * @param int array
     * @param int target
     * @return index of the last number greater than target
     */
    public static int getIndexOfLastElementGreaterThanTarget(int[] values, int target) { 
        for (int index = values.length - 1; index >= 0; index--) {
            if (values[index] > target) 
                return index;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] theArray = {-30, -5, 8, 23, 46};
        System.out.println(
                "Last index of element smaller than 50: "
                        + getIndexOfLastElementSmallerThanTarget(theArray, 50));
        System.out.println(
                "Last index of element smaller than 30: "
                        + getIndexOfLastElementSmallerThanTarget(theArray, 30));
        System.out.println(
                "Last index of element smaller than 10: "
                        + getIndexOfLastElementSmallerThanTarget(theArray, 10));
        System.out.println(
                "Last index of element smaller than 0: "
                        + getIndexOfLastElementSmallerThanTarget(theArray, 0));
        System.out.println(
                "Last index of element smaller than -20: "
                        + getIndexOfLastElementSmallerThanTarget(theArray, -20));
        System.out.println(
                "Last index of element smaller than -30: "
                        + getIndexOfLastElementSmallerThanTarget(theArray, -30));
    }
}


public class EvenLoop {
    public static void main(String[] args) {
        int[] values = {6, 2, 1, 7, 12, 5};
        // Rewrite this loop as a for each loop and run
        for (int value : values) {
            if (value % 2 == 0) {
                System.out.println(value + " is even!");
            }
        }
    }
}
