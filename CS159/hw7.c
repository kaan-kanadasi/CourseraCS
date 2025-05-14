/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Homework 7:
*
*  Academic Integrity Statement:
*
*  I have not used source code obtained from any other unauthorized source, 
*  either modified or unmodified.  Neither have I provided access to my code 
*  to another. The effort I am submitting is my own original work.
*
*  Program Description: Generates random numbers between the lower and the upper bound 
*  which sum of their digits divides the number and counts the total count of numbers generated.
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#define SIZE 40 

int get_seed(void);
int lower_lim(void);
int get_ulim(int);
int genvals(int, int);
int sum_of_int(int);
int check(int, int);
void get_into_arr(int, int, int[], int*);
void sort_odd_even(int[]);
int num_odd(int[]);
void bubblesort(int[], int, int);
void print_arr(int[], int);

int main()
{
    int seed; // seed value for the srand function 
    int lower_l; // lower bound forhe randomly generated numbers
    int upper_l;// upper bound for the randomly generated numbers
    int arr[SIZE]; // array that contains the randomly generated numbers
    int total_num = 0; //total numbers generated to create data set

    seed = get_seed();
    srand(seed);
    lower_l = lower_lim();
    upper_l = get_ulim(lower_l);

    get_into_arr(lower_l, upper_l, arr, &total_num);
    sort_odd_even(arr);
    print_arr(arr, total_num);

    return 0;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: get_seed
*
*  Function Return Type: int 
*
*  Parameters: NONE
*
*  Function Description: input function htat gets the a positive seed value
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

int get_seed()
{
    int value; // user input for seed value

    do
    {
        printf("Enter desired seed value -> ");
        scanf("%d", &value);

        if(value <= 0)
        {
            printf("\nError! Seed value must be positive!\n\n");
        }
    } while (value <= 0);
    return value;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: lower_lim
*
*  Function Return Type: int
*
*  Parameters: NONE
*
*  Function Description: input function that gets the positive lower limite 
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

int lower_lim()
{
    int value; // user input for lower limit

    do
    {
    printf("Enter lower limit power of ten -> ");
    scanf("%d", &value);

    if(value <= 0)
    {
        printf("\nError! Minimum lower limit is 1!\n\n");
    }
    } while (value <= 0);

    return value;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: get_ulim
*
*  Function Return Type: int
*
*  Parameters:
*    1.int llim - lower limit variable 
*
*  Function Description: input function that gets the positive upper limit
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

int get_ulim(int llim)
{
  int value; // user input for lower limit

  do
  {
    printf("Enter upper limit power of ten -> ");
    scanf("%d", &value);

    if(value <= llim)
    {
        printf("\nError! Minimum upper limit is %d!\n\n", llim + 1);
    }
  } while (value <= llim);
  return value;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: genvals
*
*  Function Return Type: int
*
*  Parameters (list data type, name, and comment one per line):
*    1.int lower_lim - lower limit varibale
*    2.int upper_lim - upper limit variable 
*
*  Function Description: function that generates the random number based on the upper and lower limit
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

int genvals(int lower_lim, int upper_lim)
{
    int num; // randomly generated number
    int actual_llim; // calculated lower bound
    int actual_ulim; // calculated upper bound

    actual_llim = pow(10, lower_lim);
    actual_ulim = pow(10, upper_lim);

    num = (rand() % (actual_ulim - actual_llim + 1)) + actual_llim;
    return num;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: sum_of_int
*
*  Function Return Type: int 
*
*  Parameters:
*    1.int num - randomly generated random number 
*
*  Function Description: returns the sumation of the digits of the number num
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

int sum_of_int(int num) 
{
    int sum = 0; // sum of the digits of the input number 

    while (num > 0)
    {
      sum += num % 10;
      num /= 10;
    }

    return sum;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: check
*
*  Function Return Type: int
*
*  Parameters:
*    1.int sum - sumation of the integers of the randomly generated number 
*    2.int num - randomly generated number 
*
*  Function Description: checks weatehr sum is a multiplier of num, returns 1 if so, else returns 0
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

int check(int sum, int num)
{
    int check = 0; // flag variable for checking the division between the num and sum variable 

    if (num % sum == 0)
    {
       check = 1;
    }
    return check;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: get_into_arr
*
*  Function Return Type: void
*
*  Parameters:
*    1.int lower_lim - lower limit variable 
*    2.int upper_lim - upper limit variable 
*    3.int arr[] - array that contains the randomoly generated numbers 
*    4.int *total_num - total numbers generated to create data set
*
*  Function Description: stores random numbers in the array only those numbers for which the sum of their digits is a factor of the number itself while keeping track of the total number of numbers created to creaste the data set
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

void get_into_arr(int lower_lim, int upper_lim, int arr[], int *total_num)
{
    int sum; // sum of the digits of the number
    int num; // randomly generated number 
    int i; // loop counter 
    int flag; // flag variable to check if sum is a factor of the num 
    *total_num = 0;

    for(i = 0; i < SIZE; i++)
    {
        do 
        {
            num = genvals(lower_lim, upper_lim);
            sum = sum_of_int(num);
            flag = check(sum, num);
            (*total_num)++;
        } while(flag == 0);
        arr[i] = num;
    }
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: sort_odd_even
*
*  Function Return Type: void
*
*  Parameters:
*    1.int arr[]- array that contains the randomoly generated numbers 
*
*  Function Description: sorts the array so that all odd numbers appear before even  numbers.
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

void sort_odd_even(int arr[]) 
{
    int i; // loop counter 
    int j = 0; // index for the odd number to be placed
    int temp; // temporary variabkle for swapping 
    int odd_len; // numbe rof odd numbers of array 
    odd_len = num_odd(arr); 

    for (i = 0; i < SIZE; i++) 
    {
        if (arr[i] % 2 != 0)
        {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j++;
        }
    }
    
    bubblesort(arr, odd_len, 0);
    bubblesort(arr, SIZE, odd_len);
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: num_odd
*
*  Function Return Type: int
*
*  Parameters:
*    1.int arr[] - array that contains the randomoly generated numbers 
*
*  Function Description: counts the odd numbers in array arr that contains the random numbers 
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

int num_odd(int arr[]) 
{
    int i; // loop control variable 
    int count = 0; // count variable to count the number of odd numbers 

    for(i = 0; i < SIZE; i++)
    {
        if(arr[i] % 2 != 0)
        {
            count++;
        }
    }
    return count;
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: bubblesort
*
*  Function Return Type: void
*
*  Parameters:
*    1.int arr[] - array that contains the randomoly generated numbers 
*    2.int length_odd - length of the odd numbered values inside arr 
*    3.int start_index - starting index for the sort algorithm
*
*  Function Description: sorts the array arr based on starting index length_odd and starting index start_index
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

void bubblesort(int arr[], int length_odd, int start_index) 
{
    int i; //inner loop control variable
    int j; // outer loop control variable 
    int temp; // temprary variable for swapping 
    for(i = start_index; i < length_odd - 1; i++) {
        for(j = start_index; j < length_odd - 1 - (i - start_index); j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

/*****+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: print_arr
*
*  Function Return Type: void
*
*  Parameters:
*    1.int arr[] - array that contains the randomoly generated numbers 
*    2.int total_num -total numbers generated to create data set
*
*  Function Description: prints the sorted array arr and gives out the total numbers generated to create the array 
*
******+-*--*---*---**-*-**-*-**-*-***--*--*--*-*--*************************/

void print_arr(int arr[], int total_num)
{
    int i; // iterative variable for the for loop

    printf("\nTotal numbers generated to create data set: %d\n", total_num);

    for(i = 0; i < SIZE; i++)
    {
        if(i % 5 == 0)
        {
            printf("\nResults %d - %d:", i + 1, i + 5);
        }
        printf(" %d", arr[i]);
    }
    printf("\n");
}