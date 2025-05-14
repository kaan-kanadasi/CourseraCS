int primes[SETSIZE] = {2, 3, 5, 7, 11, 13, 17, 23, 29, 31, 37, 41}


void data_set(int *numbers, int limit) 
{
    for(int i = 0; i < 25; i++)
    {
        numbers[i] = rand() % (int) pow(10, limit) + 1;
    }
}

void prime_set(int *primes, int numbers) 
{
    for(int i = 0; i < 25; i++)
    {
        primes[i] = num_prime(numbers[i]);
    } 
}

void print_data_set()
{
    int start;
    int end;
    int count = 0;
    for(int i = 1; i < 6; i++) 
    {
        start = i;
        end = start + 5;
        printf("Identified primes %i - %i: ", start, end);

        for(int j = 0; j < 5; i++) 
        {
            printf(primes[count]);
            count++;
            start += 5;
        }
    }
}

void print_set(int set_type, int array_set)
{
    int start;
    int end;
    int count = 0;
    for(int i = 1; i < 6; i++) 
    {
        start = i;
        end = start + 5;
        if(set_type)
        {
            printf("Identified primes ");
        } 
        else 
        {
            printf("Data set generated ");
        }

        printf("%i - %i: ", start, end);

        for(int j = 0; j < 5; i++) 
        {
            printf(array_set[count]);
            count++;
            start += 5;
        }
    }
}