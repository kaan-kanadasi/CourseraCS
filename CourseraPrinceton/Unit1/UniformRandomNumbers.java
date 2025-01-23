/**
 * Write a program that prints five uniform random numbers between 0 and 1, their average value, 
 * and their minimum and maximum values. Use Math.random(), Math.min(), and Math.max().
 * @author Kaan Kanadasi
 * @since 20 nov 2023
 */
         /*                                      ilk başta yanlış düşündüm:
        for(int i = 0; i<5; i++) {        
            rand5.add(Math.random());
        }
        for(int j = 0; j<rand5.size(); j++) {  
            total += rand5[j];
            double min =  Math.min(rand5[j], rand5[j+1]);
            double max =  Math.max(rand5[j], rand5[j+1]); 
        } */
import java.util.ArrayList;

class UniformRandomNumbers {
    public static void main(String[] args) {
        ArrayList <Double> rand5 = new ArrayList <Double>();
        double total = 0;
        double min = 0.0;
        double max = 1.0;
        double num;

        for(int i = 0; i<5; i++) {        
            num = Math.random();
            rand5.add(num);
            total += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        double average = total / 5;
        System.out.println("Max is " + max + ", Min is " + min + ", Average is " + average); 
    }
}