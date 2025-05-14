/*****+---**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Homework 6:
*
*  Academic Integrity Statement:
*
*  I have not used source code obtained from any other unauthorized source, 
*  either modified or unmodified.  Neither have I provided access to my code 
*  to another. The effort I am submitting is my own original work.
*
*  Program Description: The function generates six random numbers between one and sixty that has no duplicates
*  for the lottery numbers. It then generats a distinct set of six nnumbers for each simulation in which the 
*  simulation amount is given by the user. The function compares these simulated numbers to the lottery numbers
*  and counts how many numbers match with percentage of simulations each match counted. 
*
******+---**--***--*-----*-***-----**-**--*--*-*--*************************/

#include <stdio.h>
#include <stdlib.h>
#define LENGTH 6

int get_seed(void);
int get_simulation(void);
void random_six(int*);
int find_duplicate(int*, int , int);
void random_simulation(int*, int*, int);
int number_duplicate(int*, int);
void lottery_num(int*);
void rand_simulation(int*);
int match_counter(int*, int*);

int main()
{
    int seed; // seed value that is given as the first input by the user to be used in the srand function
    int simulation; // simulation integer that is given as the second input by the user to compute the number of simulations
    int arr_six[LENGTH]; // integer array of size 6 that stores the random lottery numbers 
    int arr_simulated[LENGTH]; // integer array of size 6 that stores the simulated numbers 

    seed = get_seed();
    simulation = get_simulation();
    srand(seed);
    random_six(arr_six);
    random_simulation(arr_six, arr_simulated, simulation);

    return 0;
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: get_seed
*
*  Function Return Type: int
*
*  Parameters: NONE
*
*  Function Description: Get function that gets user input for the seed integer and requires seed to be a positive number
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

int get_seed()
{
    int seed; // output value for seed integer
    do 
    {
        printf("Enter seed value -> ");
        scanf("%d", &seed);
        if(seed <= 0)
        {
            printf("\nError! Please enter a positive integer value!\n\n");
        } 
    } while (seed <= 0);

    return seed;
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: get_simulation
*
*  Function Return Type: int
*
*  Parameters: NONE
*
*  Function Description: Get function that gets user input for the simulation integer and requires simulation to be greater than zero
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

int get_simulation()
{
    int simulation; // output value for number of simulations to run 

    do 
    {
        printf("Enter number of simulations to run -> ");
        scanf("%d", &simulation);
        if(simulation <= 0)
        {
            printf("\nError! Please enter a positive integer value!\n\n");
        } 
    } while (simulation <= 0);

    return simulation;
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: random_six
*
*  Function Return Type: void
*
*  Parameters:
*    1.int* arr_six - array that stores the lottery numbers
*
*  Function Description: Generates and assigns the random lottery values between 1 and 60 (inclusive without duplicates) to the array arr_six
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

void random_six(int* arr_six)
{
    int i; // integer loop vontrol variable i
    int rand_num; // integer number that is used to store the random number generated for the lottery array

    for(i = 0; i < LENGTH; i++)
    {
        rand_num = (int) (rand() % 60) + 1;

        if(i > 0 && find_duplicate(arr_six, rand_num, i))
        {
            do
            {
                rand_num = (int) (rand() % 60) + 1;
            } while(i > 0 && find_duplicate(arr_six, rand_num, i));
        }
        arr_six[i] = rand_num;
    }
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: find_duplicate
*
*  Function Return Type: int
*
*  Parameters (list data type, name, and comment one per line):
*    1.int *arr_six - array that is used to campare to the integer varaible num to see if there are any duplicates 
*    2.int num - integer that is compared by to the arr_six array to see if there are any duplicates 
*    3.int iteration_count - integer variable that sets the max number of iterations in the for loop
*
*  Function Description: function that returns 1 of a duplicate is found between arr_six array and num variable, else returns 0
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

int find_duplicate(int *arr_six, int num, int iteration_count) 
{
    int output; // integer that is 1 of there is a duplicate value between arr_six array and the integer variable num, else is 0
    int i; // integer loop vontrol variable i
    output = 0;

    for(i = 0; i < iteration_count; i++)
    {
        if(num == arr_six[i])
        {
            output = 1;
        }
    }
    return output;
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: random_simulation
*
*  Function Return Type: void
*
*  Parameters (list data type, name, and comment one per line):
*    1.int *arr_six - array storing lottery numbers
*    2.int *arr_simulated - array storing the simulated numbers
*    3.int simulation_limit - number of simulations that is inputted by the user
*
*  Function Description: Prints the lottery numbers and prints how often a number of match between the lottery and simulated number occur with its percentage for number of duplicates vs number of simulated numbers
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

void random_simulation(int *arr_six, int *arr_simulated, int simulation_limit)
{
    int i; // integer loop control variable i
    int zero_match = 0; // integer storing the number of cases for zero matches between the duplicates found between arr_six and arr_simulated
    int one_match = 0; // integer storing the number of cases for one match between the duplicates found between arr_six and arr_simulated
    int two_match = 0; // integer storing the number of cases for two matches between the duplicates found between arr_six and arr_simulated
    int three_match = 0; // integer storing the number of cases for three matches between the duplicates found between arr_six and arr_simulated
    int four_match = 0; // integer storing the number of cases for four matches between the duplicates found between arr_six and arr_simulated
    int five_match = 0; // integer storing the number of cases for five matches between the duplicates found between arr_six and arr_simulated
    int six_match = 0; // integer storing the number of cases for six matches between the duplicates found between arr_six and arr_simulated
    double percentage; // double variable to calcualte the percentage of each match for the number of simulations
    int count; // counts the number of duplicates between the lottery and simulated numbers using the function match_counter for each simulation
 
    for(i = 0; i < simulation_limit; i++)
    {
        rand_simulation(arr_simulated);
        count = match_counter(arr_six, arr_simulated);

        switch(count)
        {
            case 0:
                zero_match++;
                break;
            case 1:
                one_match++;
                break;
            case 2:
                two_match++;
                break;
            case 3:
                three_match++;
                break;
            case 4:
                four_match++;
                break;
            case 5:
                five_match++;
                break;
            case 6:
                six_match++;
                break;         
        }
    }

    lottery_num(arr_six);

    if(zero_match != 0)
    {
        percentage = (double) zero_match / simulation_limit * 100;
        printf("Number of tickets with 0 matches: %d (%.2lf%%)\n", zero_match, percentage);
    }
    if(one_match != 0)
    {
        percentage = (double) one_match / simulation_limit * 100;
        printf("Number of tickets with 1 matches: %d (%.2lf%%)\n", one_match, percentage);
    }
    if(two_match != 0)
    {
        percentage = (double) two_match / simulation_limit * 100;
        printf("Number of tickets with 2 matches: %d (%.2lf%%)\n", two_match, percentage);
    }
    if(three_match != 0)
    {
        percentage = (double) three_match / simulation_limit * 100;
        printf("Number of tickets with 3 matches: %d (%.2lf%%)\n", three_match, percentage);
    }
    if(four_match != 0)
    {
        percentage = (double) four_match / simulation_limit * 100;
        printf("Number of tickets with 4 matches: %d (%.2lf%%)\n", four_match, percentage);
    }
    if(five_match != 0)
    {
        percentage = (double) five_match / simulation_limit * 100;
        printf("Number of tickets with 5 matches: %d (%.2lf%%)\n", five_match, percentage);
    }
    if(six_match != 0)
    {
        percentage = (double) six_match / simulation_limit * 100;
        printf("Number of tickets with 6 matches: %d (%.2lf%%)\n", six_match, percentage);
    }
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: number_duplicate
*
*  Function Return Type: int
*
*  Parameters:
*    1.int *arr_six - array that is used to compare to the integer variable num to find the number of duplicates between
*    2.int num - integer value that is compared by the function to find the number of duplicates
*
*  Function Description: counts and returns the number of duplicates in arr_six array in comparison to integer variable num
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

int number_duplicate(int *arr_six, int num) 
{
    int i; // integer loop control variable i
    int count; // counter variable to count how many duplicates there are in arr_six array for the variable num
    count = 0;
    for(i = 0; i < LENGTH; i++)
    {
        if(num == arr_six[i])
        {
            count++;
        }
    }
    return count;
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: lottery_num
*
*  Function Return Type: void
*
*  Parameters:
*    1.int *arr_six - array that stores the lottery numbers
*
*  Function Description: Function that prints the lottery numbers that are stored inside array arr_six
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

void lottery_num(int *arr_six)
{
    int i; // integer loop vontrol variable i
    printf("\nYour lottery numbers: ");     
    for(i = 0; i < LENGTH; i++) 
    {         
        printf("%d ", arr_six[i]);     
    }     
    printf("\n");
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: number_duplicate
*
*  Function Return Type: int
*
*  Parameters:
*    1.int *arr_simulated - array that stores the simulated values
*
*  Function Description: void function that generates the arr_simulated array for the randomly generated integer values between 1 and 60 (inclusive) 
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

void rand_simulation(int *arr_simulated)
{
    int j; // integer loop control variable j
    int rand_num; // random number between 1 and 60 inclusive
    for(j = 0; j < LENGTH; j++)
    {
        rand_num = (int) (rand() % 60) + 1;

        if(j > 0 && find_duplicate(arr_simulated, rand_num, j))
        {
            do
            {
                rand_num = (int) (rand() % 60) + 1;
            } while(j > 0 && find_duplicate(arr_simulated, rand_num, j));
        }
        arr_simulated[j] = rand_num;
    }
}

/*****+-*-**--***--*-----*-***-----**-**--*--*-*--**************************
*
*  Function Information
*
*  Name of Function: match_counter
*
*  Function Return Type: int
*
*  Parameters:
*    1.int *arr_six - array that stores the lottery numbers
*    2.int *arr_simulated - array that stores the simulated values
*
*  Function Description: counts and returns how many duplicates there are between the lottery array and simulated numbers using number_duplicate function
*
******+-*-**--***--*-----*-***-----**-**--*--*-*--*************************/

int match_counter(int *arr_six, int *arr_simulated)
{
    int n; // integer loop control variable n
    int count; // variable to count how many duplicates there are between the lottery array and simulated numbers
    count = 0;
    for(n = 0; n < LENGTH; n++)
    {
        if(number_duplicate(arr_six, arr_simulated[n]) > 0)
        {
            count++;
        }
    }
    return count;
}