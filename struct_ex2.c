#include <stdio.h>
#include <stdbool.h>
#include <string.h>

struct CDDatabaseEntry
{
    char    artist[40];
    char    composer[40];
    char    albumName[40];
    int     trackCount;
    bool    isSampler;
};

int main()
{
    bool keepRunning = true;
    char userInput[11];

    while( keepRunning == true )
    {
        printf( "Type NEW , LIST, or QUIT:\n> " );
        scanf( "%10s", userInput );
        fpurge( stdin );

        if( strcmp( userInput, "NEW" ) == 0 )
            printf( "I'll write the code for NEW later...\n\n" );
        else if( strcmp( userInput, "LIST" ) == 0 )
            printf( "I'll write the code for LIST later...\n\n" );
        else if( strcmp( userInput, "QUIT" ) == 0 )
            keepRunning = false; // We're finished.
        else
            printf( "ERROR: Unknown command \"%s\"!\n\n", userInput );
    }

    return 0;
}

/*
userInput is an array to hold some text characters. Programmers typically call this a string. When you write text in double quotes in C, it also gives you a string. A string is simply an array of characters. After the last character C always puts the Zero-Character (i.e. the character whose ASCII number is 0 — ‘A’ for example has the ASCII number 65). That way C knows when the string ends, even if, like in our case, the variable in which scanf places the text is 10 characters in length. So, “NEW” is almost the same as writing:

char  myNewString[4];
myNewString[0] = 'N';
myNewString[1] = 'E';
myNewString[2] = 'W';
myNewString[3] = 0;
The %10s-part in our call to scanf is the same as %s. However, the number 10 between the % and the s limits the number of characters it will write to userInput. Since userInput is 11 characters large and (as mentioned above) there has to be a 0-character at the end of the text string, we only let it give us 10 characters (10 + 1 zero-char = 11) so our call to scanf doesn’t run off the end of userInput. And again, we don’t specify an &-operator before userInput on the scanf-line because userInput is an array. And as you know, an array is simply a pointer to a whole chunk of bytes. So, it already is a pointer.

Since both a constant string (e.g. “NEW”) and a string variable (i.e. userInput) are pointers, It doesn’t make much sense to compare them using the == operator. After all, the ==-operator would simply compare the two pointer addresses, and userInput has a completely different memory address than the string constant “NEW”, even if they basically contain the same characters.

You also can’t dereference two strings using the *-operator to compare their characters, because a string is simply a pointer to data of type char, and C wouldn’t know how many chars that pointer points to. In addition, there is a limit on the == operator that essentially means you can’t use it to compare anything but the “short” atomic data types like char, int and bool (as well as pointers, because they’re basically the same as an int). So, you can’t compare two structs, for example.
*/