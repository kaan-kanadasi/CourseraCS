/*****+---*------*----*-*---*----*-*--***-*--*-*--**************************
 *
 *  Lab 8:
 *
 *  Academic Integrity Statement:
 *
 *  We have not used source code obtained from any other unauthorized source,
 *  either modified or unmodified.  Neither have we provided access to our code
 *  to another. The effort we are submitting is our own original work.
 *
 *  Program Description: The program calculates and displays the dates of user entered days 
 *  of the week starting from a given day in a user entered year. It handles leap years, 
 *  month transitions, and correct day-week assignments. Program prints the dates after a 
 *  user entered start day until the end of the given year or month.
 *
 ******+---*------*----*-*---*----*-*--***-*--*-*--*************************/

#include<stdio.h>
#include<math.h>

int input_year(void);
int input_day(int);
int input_month(int, int, int);
int leap_year(int);
void day_week(int, int);
int days(int, int, int);
int month(int, int);
int day_month(int, int);
void dates(int, int, int, int, int, int, int);
void month_print(int);
int day_current_month(int, int);

int main()
{
    int current_year = input_year(); // get current year from input
    int leap = leap_year(current_year); // check if it's a leap year
    int current_day = input_day(leap); // get current day of the year
    int day_m = day_month(current_day, leap); // get day of the month
    int current_month = month(current_day, leap); // calculate current month
    int display_month = input_month(current_year, current_day, current_month); // get display end month
    int total_days = days(leap, current_month, current_day); // calculate total days passed

    dates(day_m, current_year, leap, current_day, total_days, current_month, display_month); // displays all dates that fall on the same day of the week through the end month 

    return(0);
}

/*****+-*---*-*--**-*-*-*-------****--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: input_year
 *
 *  Function Return Type: int
 *
 *  Parameters: NONE 
 *
 *  Function Description: Receives input value from user for current year and returns to main function
 *
 ******+-*---*-*--**-*-*-*-------****--***-*--*-*--*************************/

int input_year()
{
    int year; // holds value for current year 

    printf("Enter current year -> ");
    scanf("%d", &year);

    return year;
}

/*****+-----*-*--**-*-*-*-------****--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: input_day
 *
 *  Function Return Type: int
 *
 *  Parameters:
 *    1.int leap_year - has value of 1 if leap year has value of 0 if not
 *
 *  Function Description: Receives input from the user for the current day of the year
 *
 ******+-----*-*--**-*-*-*-------****--***-*--*-*--*************************/

int input_day(int leap)
{
    int day; // store input for the current day in numerical form
    int max_d = (leap == 1) ? 366 : 365; // max day in year based on if it is a leap year

    do
    { 
        printf("Enter day number [1 - %d] -> ", max_d);
        scanf("%d", &day);
        if(day <  1 || day > max_d) // invalid case, error
        {
            printf("\nError! Day number must be in range indicated!!\n\n");
        } 
    } while(day < 1 || day > max_d); // checks for invalid days, if invalid recurses

    return day;
}

/*****+-------*-**----*-*-*---*--***--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: input_month
 *
 *  Function Return Type: int
 *
 *  Parameters: 
 *    1.int year - current year
 *    2.int day - current day of the year
 *    3.int current_month - current month of the year
 * 
 *  Function Description: Function receives input value from user for end month and returns to main function
 *
 ******+-------*-**----*-*-*---*--***--***-*--*-*--*************************/

int input_month(int year, int day, int current_month)
{
    int d_month; // store input for the end month in numerical form

    do
    {
        printf("Enter month to end the display of ");
        day_week(year, day);
        printf(" dates -> ");
        scanf("%d", &d_month);

        if(d_month < current_month || d_month > 12) // invalid case, error
        {
            printf("\nError! Month cannot be prior to ");
            month_print(current_month);
            printf("!\n\n");
        }
    } while(d_month < current_month || d_month > 12);  // checks for invalid months, if invalid recurses

    return(d_month);
}

/*****+-------*-**----*-*-*---*--***--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: leap_year
 *
 *  Function Return Type: int
 *
 *  Parameters:
 *    1.int year - current year
 *
 *  Function Description: Function will return a value of 1 if it is a leap year and a value of 0 if not
 *
 ******+-------*-**----*-*-*---*--***--***-*--*-*--*************************/

int leap_year(int year)
{
    int n = 0; // will hold value 1 if there is a leap year. If not, there will be a value of 0.

    if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
    {
        n = 1; // will change n to 1 if parameters met
    }

    return n;
}

/*****+-*-*-----**----*-*-*---*--***--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: day_week
 *
 *  Function Return Type: NONE
 *
 *  Parameters:
 *    1.int year - current year 
 *    2.int day - amount of days passed in the year
 *
 *  Function Description: Function calculates and prints the current day of the week
 *
 ******+-*-*-----**----*-*-*---*--***--***-*--*-*--*************************/

void day_week(int year, int day)
{
    int week; // will hold value for current week number

    week = ((year - 1) * 365 + ((year - 1) / 4) - ((year - 1) / 100) + ((year - 1) / 400)) % 7; // calculates current week
    week = (week + day) % 7; // calculates current day of week 
    
    switch(week)
    {
        case 1: printf("Monday");
            break;
        case 2: printf("Tuesday");
            break;
        case 3: printf("Wednesday");
            break;
        case 4: printf("Thursday");
            break;
        case 5: printf("Friday");
            break;
        case 6: printf("Saturday");
            break;
        case 7: printf("Sunday");
            break;
        case 0: printf("Sunday");
    }
}

/*****+-----*---**----*-*-*---*--***--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: days 
 *
 *  Function Return Type: int
 *
 *  Parameters:
 *    1.int n - value of 1 if leap year value of 0 if not 
 *    2.int month - current month in the year 
 *    3.int day - current day of month 
 *
 *  Function Description: Function will calculate how many days have passed in the year and return to main function
 *
 ******+-----*---**----*-*-*---*--***--***-*--*-*--*************************/

 int days(int n, int month, int day)
 {
   int t_days; //holds value for total days passed in the year

   switch(month)
   {
     case 1: t_days = day;
             break; 
     case 2: t_days = 31 + day;
             break; 
     case 3: t_days = 31 + 28 + n + day;
             break; 
     case 4: t_days = 31 + 28 + n + 31 + day;
             break;
     case 5: t_days = 31 + 28 + n + 31 + 30 + day;
             break; 
     case 6: t_days = 31 + 28 + n + 31 + 30 + 31 + day;
             break; 
     case 7: t_days = 31 + 28 + n + 31 + 30 + 31 + 30 + day;
             break; 
     case 8: t_days = 31 + 28 + n + 31 + 30 + 31 + 30 + 31 + day;
             break;
     case 9: t_days = 31 + 28 + n + 31 + 30 + 31 + 30 + 31 + 31 + day;
             break;
     case 10: t_days = 31 + 28 + n + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
            break; 
     case 11: t_days = 31 + 28 + n + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
            break; 
     case 12: t_days = 31 + 28 + n + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + day;
            break;
   }

   return(t_days);
 }

/*****+---*---*--**-*-*-*-------****--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: month
 *
 *  Function Return Type: NONE
 *
 *  Parameters:
 *    1.int day - current day of year 
 *    2.int n - value of 1 if leap year 0 if not
 *
 *  Function Description: Function determines the month of the year, which depends on what day of the year it is and whether or not it is a leap year
 *
 ******+---*---*--**-*-*-*-------****--***-*--*-*--*************************/

int month(int day, int n)
{
   int m; // holds the current month in numerical form

   if(day < 32)
   {
        m = 1;
   }
   else if(day < 60 + n && day > 31)
   {
        m = 2;
   }
   else if(day < 91 + n && day > 59 + n)
   {
        m = 3;
   }
   else if(day < 121 + n && day > 90 + n)
   {
        m = 4;
   }
   else if(day < 152 + n && day > 120 + n)
   {
        m = 5;
   }
   else if(day < 182 + n && day > 151 + n)
   {
        m = 6;
   }
   else if(day < 213 + n && day > 181 + n)
   {
        m = 7;
   }
   else if(day < 244 + n && day > 212 + n)
   {
        m = 8;
   }
   else if(day < 274 + n && day > 243 + n)
   {
        m = 9;
   }
   else if(day < 305 + n && day > 273 + n)
   {
        m = 10;
   }
   else if(day < 335 + n && day > 304 + n)
   {
        m = 11;
   }
   else
   {
        m = 12;
   }

   return m;
}

/*****+---*-*----**-*-*-*-------****--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: day_month
 *
 *  Function Return Type: int 
 *
 *  Parameters:
 *    1.int day - current day of year
 *    2.int n - value of 1 if leap year value of 0 if not
 *
 *  Function Description: Function calculates how many days are left in the current month of the year and returns value to main function. 
 *
 ******+---*-*----**-*-*-*-------****--***-*--*-*--*************************/

int day_month(int day, int n)
{
   int day_month; // will hold value for day of month

   if((day - (334 + n)) > 0)
   {
        day_month = (day - (334 + n));
   }
   else if((day - (304 + n)) > 0)
   {
        day_month = (day - (304 + n));
   }
   else if((day - (273 + n)) > 0)
   {
        day_month = (day - (273 + n));
   }
   else if((day - (243 + n)) > 0)
   {
        day_month = (day - (243 + n));
   }
   else if((day - (212 + n)) > 0)
   {
        day_month = (day - (212 + n));
   }
   else if((day - (181 + n)) > 0)
   {
        day_month = (day - (181 + n));
   }
   else if((day - (151 + n)) > 0)
   {
        day_month = (day - (151 + n));
   }
   else if((day - (120 + n)) > 0)
   {
        day_month = (day - (120 + n)); // ...
    }
    else if((day - (90 + n)) > 0)
    {
        day_month = (day - (90 + n)); // May
    }
    else if((day - (59 + n)) > 0)
    {
        day_month = (day - (59 + n)); // March
        if(n == 1) // if leap year
        {
            day_month = day_month + 2;
        }
    }
    else if((day - 31) > 0)
    {
        day_month = (day - 31); // February
    }
    else 
    {
        day_month = day; // January
    }

    return day_month;
}

/*****+---*-*----**-*-*-*-------****--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: dates
 *
 *  Function Return Type: void 
 *
 *  Parameters:
 *    1.int day_m - day of the month
 *    2.int year - current year
 *    3.int leap - value of 1 if leap year value of 0 if not 
 *    4.int days - current day of the year
 *    5.int total - total days passed
 *    5.int c_month - current month of year
 *
 *  Function Description: determines and print all dates that fall on the same day of the week through the end month given by the user
 *
 ******+---*-*----**-*-*-*-------****--***-*--*-*--*************************/
void dates(int day_m, int year, int leap, int days, int total_days, int c_month, int display_month)
{
    int i = day_m + 7; // days in month starting the week after current day in month
    int current_month = c_month; // current month of year
    int days_in_month = day_current_month(current_month, leap); // get total days in the current month

    printf("\n");
    day_week(year, days);
    printf(" dates after ");
    month_print(c_month);
    printf(" %d through ", day_m);
    month_print(display_month);
    printf(": ");

    if((total_days - days) % 7 == 0 && display_month == c_month) // if there could be no incrementation, display None.
    { 
        printf("None.");
    } 
    else 
    {
        while(current_month <= display_month)
        {
            days_in_month = day_current_month(current_month, leap);
            if (i <= days_in_month) 
            {
                while (i <= days_in_month) 
                {
                    month_print(current_month);
                    printf("-%d", i);
                    if(i + 7 <= days_in_month || current_month < display_month)
                    {
                        printf(", ");
                    }
                    i = i + 7; 
                }
            }
            else // if current day is bigger day the days in month
            {
                i = i - days_in_month; // reset day in the new month
                current_month++; // increment the month 
            }
        }
    }

    printf("\n");
}

/*****+---*-*----**-*-*-*-------****--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: month_print
 *
 *  Function Return Type: void 
 *
 *  Parameters:
 *    1.int month - current month in integer form
 *
 *  Function Description: prints the month in string form
 *
 ******+---*-*----**-*-*-*-------****--***-*--*-*--*************************/

void month_print(int month) 
{
    switch(month) 
    {
      case 1: printf("January");
              break;
      case 2: printf("February");
              break;
      case 3: printf("March");
              break;
      case 4: printf("April");
              break;
      case 5: printf("May");
              break;
      case 6: printf("June");
              break;
      case 7: printf("July");
              break;
      case 8: printf("August");
              break;
      case 9: printf("September");
              break;
      case 10: printf("October");
               break;
      case 11: printf("November");
               break;
      case 12: printf("December");
               break;
    }
}

/*****+---*-*----**-*-*-*-------****--***-*--*-*--**************************
 *
 *  Function Information
 *
 *  Name of Function: day_current_month
 *
 *  Function Return Type: int 
 *
 *  Parameters:
 *    1.int month - current month in integer form
 *    2.int leap - value of 1 if leap year value of 0 if not 
 *
 *  Function Description: returns the integer form of the number of days in month
 *
 ******+---*-*----**-*-*-*-------****--***-*--*-*--*************************/

int day_current_month(int month, int leap) 
{
    int day; // variable to be returned as the number of days in month

    switch (month) 
    {
        case 1:  
            day = 31; 
            break;
        case 2:  
            day = (leap == 1) ? 29 : 28; // if leap year then February is 29 else 28
            break;
        case 3:     
            day = 31;
            break;
        case 4:  
            day = 30;
            break;
        case 5:  
            day = 31;
            break;
        case 6:  
            day = 30;
            break;
        case 7:     
            day = 31;
            break;
        case 8:  
            day = 31;
            break;
        case 9:  
            day = 30;
            break;
        case 10: 
            day = 31;
            break;
        case 11:
            day = 30;
            break;
        case 12: 
            day = 31;
            break;
    }

    return day;
}