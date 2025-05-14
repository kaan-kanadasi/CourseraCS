/*****+-*-**---*---*--*-**-*-*--*--**--**-*--*-*--**************************
*
*  Homework 5:
*
*  Academic Integrity Statement:
*
*  I have not used source code obtained from any other unauthorized source, 
*  either modified or unmodified.  Neither have I provided access to my code 
*  to another. The effort I am submitting is my own original work.
*
*  Program Description: The program evaluates a given number to determine if it is a circular prime, 
*  meaning all rotations of its digits are prime numbers, and prints the status of the number.
*  It checks weather the number is primal for each rotation and provides information about the number being a fully 
*  circular prime number, containing prime rotations, or having no prime rotations at all.
*
******+-*-**---*---*--*-**-*-*--*--**--**-*--*-*--*************************/

#include <stdio.h>
#include <math.h>

int get_number();
int one_rotation(int, int);
int is_prime(int);
int check_prime(int, int);
void print_prime(int, int);
void print_function(int, int, int);

int main()
{
  int input = get_number(); // integer user input 
  int iterations = (int) log10(input) + 1; // number of digits in the input, which determines the number of iterations in some functions
  int number_of_circular = check_prime(iterations, input); // integer value to store how many rotations are prime
  print_function(input, number_of_circular, iterations);
  return 0;
}

/*****+----*---*---**---******--*--**--**-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: get_number
 *
 *  Function Return Type: int
 *
 *  Parameters: NONE
 *
 *  Function Description: Forces the user to input a positive integer until the input is positive and returns the valid input
 *
 ******+----*---*---**---******--*--**--**-*--*-*--*************************/

int get_number()
{
  int num; // variable to store the user's input number
  do
  {
    printf("Enter a number to evaluate -> \n");
    scanf("%i", &num);
    if (num <= 0)
    {
      printf("Error! Number must be greater than zero.\n\n");
    }
  } while (num <= 0);
  return num;
}

/*****+----*---*---**---******--*--**--**-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: one_rotation
 *
 *  Function Return Type: int
 *
 *  Parameters:
 *    1.int input - integer user input 
 *    2.int number_of_digits - number of digits in the input
 *
 *  Function Description: Rotates the digits of the input number by one place and outputs the resulting number
 *
 ******+----*---*---**---******--*--**--**-*--*-*--*************************/

int one_rotation(int input, int number_of_digits)
{
  int last_digit = input % 10; // get the last digit of the number 
  int new_first_digit = pow(10, number_of_digits - 1) * last_digit; // create the new first digit
  int remaining = input / 10; // remove the last digit from the input number to find the remaining number
  return new_first_digit + remaining;
}

/*****+----*---*---**---******--*--**--**-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: is_prime
 *
 *  Function Return Type: int
 *
 *  Parameters:
 *    1.int number - integer number from one of the variations of the cycles of the input variable
 *
 *  Function Description: Checks if the given number is prime - returns 1 if it is, otherwise 0.
 *
******+----*---*---**---******--*--**--**-*--*-*--*************************/

int is_prime(int number)
{
  int output = 1; // assume number is prime - 1 if prime, 0 if not prime
  int i = 2; // initialize i to iterate and check for divisibility 
  if (number <= 1)
  {
    output = 0;
  }
  else if (number != 2)
  {
    while (i <= sqrt(number))
    {
      if (number % i == 0)
      {
        output = 0;
      }
      i++;
    }
  }
  return output;
}

/*****+----*---*---**---******--*--**--**-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: check_prime
 *
 *  Function Return Type: int
 *
 *  Parameters:
 *    1.int iterations - number of iterations for the while loop 
 *    2.int input - integer user input 
 *
 *  Function Description: Checks all rotations of the input number for number being primal, 
 *  returns number of prime rotations
 *
 ******+----*---*---**---******--*--**--**-*--*-*--*************************/

int check_prime(int iterations, int input)
 {
   int number_of_circular = 0; // Counter to track how many prime rotations exist
   int sequence = input; // variable to iterate the rotation cycles of the input variable, initialize sequence to the input number
   int i = 0; // initialize the iteration counter
   while(i < iterations)
   {
     if(is_prime(sequence) == 1)
     {
       number_of_circular++;
     }
     sequence = one_rotation(sequence, iterations);
     i++;
   }
   return number_of_circular;
 }
 
 /*****+----*---*---**---******--*--**--**-*--*-*--**************************
  *
  *  Function Information
  *
  *  Name of Function: print_prime
  *
  *  Function Return Type: void
  *
  *  Parameters:
  *    1.int iterations - number of iterations for the while loop 
  *    2.int input - integer user input 
  *
  *  Function Description: Checks all rotations of the input number for number being primal, 
  *  prints prime rotations
  *
  ******+----*---*---**---******--*--**--**-*--*-*--*************************/

void print_prime(int iterations, int input)
{
  int sequence = input; // variable to iterate the rotation cycles of the input variable, initialize sequence to the input number
  int i = 0; // initialize the iteration counter
  while(i < iterations)
  {
    if(is_prime(sequence) == 1)
    {
      printf("%i ", sequence);
    }
    sequence = one_rotation(sequence, iterations);
    i++;
  }
}

/*****+----*---*---**---******--*--**--**-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: print_function
 *
 *  Function Return Type: void
 *
 *  Parameters (list data type, name, and comment one per line):
 *    1.int input - integer user input 
 *    2.int number_of_circular - stores the number of prime rotations
 *    3.int iterations - number of iterations for function parameter of check_prime
 *
 *  Function Description: Prints the status of the input number, showing whether it is a circular prime or contains prime rotations
 *
 ******+----*---*---**---******--*--**--**-*--*-*--*************************/

void print_function(int input, int number_of_circular, int iterations)
{
  if(number_of_circular == (iterations + 1))
  {
    printf("Status: %i is a fully circular prime.\n", input);
  }
  else if(number_of_circular == 0)
  {
    printf("Status: %i is not a circular prime and no rotation is prime.\n", input);
  }
  else
  {
    printf("Status: %i contains primes in the following rotations: ", input);
    print_prime(iterations, input);
    printf("\n");
  }
}