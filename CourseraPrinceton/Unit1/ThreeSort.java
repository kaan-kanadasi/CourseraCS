/**
 * Write a program that takes three integer command-line arguments 
 * and prints them in ascending order. Use Math.min() and Math.max().
 * @author Kaan Kanadasi - GPT
 * @since 20 nov 2023
 */

class ThreeSort {
    public static void main(String args[]) {
    int first = Integer.parseInt(args[0]);
    int second = Integer.parseInt(args[1]);
    int third = Integer.parseInt(args[2]);
    int max, min, middle;

    min = Math.min(first, Math.min(second, third));
    max = Math.max(first, Math.max(second, third));

    /* ilk başta bunu düşündüm (chatgpt daha iyisini önerdi):
    if(first != max && first != min) {
        middle = first;
    } else if(second != max && second != min) {
        middle = second;
    } else {
        middle = third;
    } */
    middle = first + second + third - min - max;
    System.out.println(min + ", " + middle  + ", " + max);
    }
}