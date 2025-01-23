#include <stdio.h>
#include <string.h>

typedef struct
{
    char name[50];
    char number[50];
}
Person;

int main() {
    Person people[3] = {
        {"Charter", "+1-617-555-45-35"},
        {"John", "+1-554-765-88-68"},
        {"\0", "\0"} // making it an empty string
    };

    // Get user input
    char query[50];
    printf("Enter a name to search: ");
    scanf("%49s", query);

    for(int i = 0; i < 3; i++) {
        if (strcmp(people[i].name, query) == 0) {
            printf("Found %s's number: %s\n", people[i].name, people[i].number);
            return 0;
        }
    }
    printf("Name not found.\n");
    return -1;
}