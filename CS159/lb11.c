#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MAX_DIGITS 10 
#define SIZE 35
#define MAX_NUM 100000000

int get_seed(void);
int lower_lim(void);
int upper_lim(void);
void genvals(int *array, int lower_lim, int upper_lim);
void or_print(int *array);
void fin_print(int *array);

int find_x(int output_int[], int length);
int find_z(int output_int[], int index_y, int length);
void sort(int* output_int, int index_y, int length);
int arr_to_int(int output_int[], int length);
void swap(int* raw_int, int* digits);
void exchange(int raw_arr[], int* output_arr, int* digits);

int main(void)
{
    int raw_arr[SIZE]; //original value 
    int output_arr[SIZE];
    int digits[MAX_DIGITS];
    int seed_val; //seed value
    int ulim; //upper limit power of 10
    int llim; //lower limit power of 10

    seed_val = get_seed();
    llim = lower_lim();
    ulim = upper_lim();
    srand(seed_val);
    genvals(raw_arr, llim, ulim);
    exchange(raw_arr, output_arr, digits);
    or_print(raw_arr);
    fin_print(output_arr);
    return 0;
}

int get_seed(void)
{
  int value; //seed value
  int check = 0; //check if the seed value is valid
  while (check == 0)
  {
    printf("Enter desired seed value -> ");
    scanf("%d", &value);
    if (value > 0)
    {
      check = 1;
    }
    else
    {
      printf("Error! Seed value must be positive!\n");
    }
  }
  return value;
}//end function

int lower_lim(void)
{
  int value; //lower_lim value
  int check = 0; //check if the value is valid
  while (check == 0)
  {
    printf("Enter lower limit power of ten -> ");
    scanf("%d", &value);
    if (value > 0)
    {
      check = 1;
    }
    else
    {
      printf("Error! Minimum lower limit is 1!\n");
    }
  }
  return value;
}//end function

int upper_lim(void)
{
  int value; //upper_lim value
  int check = 0; //check if the value is valid
  while (check == 0)
  {
    printf("Enter upper limit power of ten -> ");
    scanf("%d", &value);
    if (value > 4)
    {
      check = 1;
    }
    else
    {
      printf("Error! Minimum upper limit is 5!\n");
    }
  }
  return value;
}//end function

void genvals(int *array, int lower_lim, int upper_lim)
{
  int i;//counter for itterating through array
  lower_lim = pow(10, lower_lim);
  upper_lim = pow(10, upper_lim);
  for(i = 0; i < 35; i++)
  {
    array[i] = (rand() % (upper_lim - lower_lim + 1)) + lower_lim;
  }
}

int find_x(int output_int[], int length)
{
    int i;
    int condition = 1;
    int index_x = -1;
    i = length - 1;
    while (i > 0 && condition)
    {
        if(output_int[i] > output_int[i - 1])
        {
            condition = 0;
            index_x = i - 1;
        }
        i--;
    }
    return index_x;
}

int find_z(int output_int[], int index_y, int length)
{
    int i;
    int index_z = -1;
    int min_max_val = MAX_NUM;
    i = index_y;
    int value_x = output_int[index_y - 1];
    while (i < length)
    {
        if(value_x < output_int[i] && min_max_val > output_int[i])
        {
            min_max_val = output_int[i];
            index_z = i;
        }
        i++;
    }
    return index_z;
}

void sort(int* output_int, int index_y, int length) 
{
    int i = index_y;
    int j = i + 1;
    int temp;
    while(i < length - 1)
    {
        j = i + 1;
        while(j < length)
        {
            if(output_int[j] < output_int[i])
            {
                temp = output_int[i];
                output_int[i] = output_int[j];
                output_int[j] = temp;
            }
            j++;
        }
        i++;
    }
}

int arr_to_int(int output_int[], int length)
{
    int num = 0;
    for (int i = 0; i < length; i++) {
        num = num * 10 + output_int[i];
    }
    return num;
}

void swap(int* raw_int, int* digits)
{
    int index_x;
    int index_y;
    int index_z;
    int x;
    int temp;
    int length = 0;
    int num = *raw_int;

    while (num > 0) {
        digits[length++] = num % 10;
        num /= 10;
    }

    for (int i = 0; i < length / 2; i++) {
        int temp = digits[i];
        digits[i] = digits[length - i - 1];
        digits[length - i - 1] = temp;
    }

    index_x = find_x(digits, length);
    if(index_x == -1)
    {
      *raw_int = arr_to_int(digits, length);
    }
    else 
    {
      index_y = index_x + 1;
      if(index_y == (length - 1)) 
      {
        index_z = index_y;
      } 
      else 
      {
        index_z = find_z(digits, index_y, length);
      }
      x = digits[index_x];
      temp = x;
      digits[index_x] = digits[index_z];
      digits[index_z] = temp;
      sort(digits, index_y, length);
  
      *raw_int = arr_to_int(digits, length);
    }
}

void exchange(int raw_arr[], int* output_arr, int* digits) 
{
    int i;
    for(i = 0; i < SIZE; i++) 
    {
        output_arr[i] = raw_arr[i];
        swap(&output_arr[i], digits);
    }
}

void or_print(int *array)
{
  int i; //loop counter
  for(i = 0; i < SIZE; i++)
  {
    if(i % 5 == 0) //check if there have been 5 iterations
    {
      printf("\nOriginal Data - ");
    }
    printf(" %d ", array[i]);
  }
}


void fin_print(int *array)
{
  int i; //counter for iterating through array
  for(i = 0; i < SIZE; i++)
  {
    if(i % 5 == 0)
    {
      printf("\nResults %d - %d",i+1,i+5);
    }
    printf(" %d ", array[i]);
  }
}

