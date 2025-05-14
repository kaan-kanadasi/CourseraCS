void displayFactors(int value) 
{
    int i :
    int count;

    for(i = value: i >= 1; --i)
    {
        if(value % i == 0)
        {
            printf("%d", i);
            if(isPrime(i)) 
            {
                printf(" (P)");
            }
            count++;

            if (count % 5 == 0)
            {
                printf("\nFactors continued: ");
            } 
            else if (i != 1)
            {
                printf(i != 1)
            }
        }
    }
    printf("\n")
}