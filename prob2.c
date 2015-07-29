#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
	pid_t pid; 
	pid_t * x = ( pid_t * )malloc( sizeof( pid_t ) );

	printf( "PARENT: %d\n", getpid() );
	pid = fork();
	printf( "PARENT: %d\n", pid );

	*x = pid * 10;

	if ( pid == 0 )
	{
		printf( "CHILD: !\n" );
		*x *= 5;
		printf( "CHILD: %d\n", *x );
	}
	else if ( pid > 0 )
	{
		printf( "PARENT: %d\n", *x );
	}

	*x -= 10;
	printf( "PARENT: (-: %d\n", *x );
	free ( x );
	return 0;
}

#if 0
Assume the parent process id is 64 w any child 
processes numbered 128, 129, 130, etc.

Write the exact terminal output(s).

			PARENT: 64
		  /		   \
(CHILD)				(PARENT)
		/			\		  
PARENT: 0			PARENT: 128
CHILD: !			PARENT: 1280
CHILD: 0			PARENT: (-: 1270
PARENT: (-: -10

PARENT: 64		OR PARENT: 64    OR PARENT: 64
(PARENT stuff)	   (CHILD stuff)	P & C interleaved
(CHILD stuff)	   (PARENT stuff)   in relative orders shown


If processes in this code were dispatched
using FCFS, write the terminal output(s).

PARENT: 64		 PARENT: 64
P            OR  C   			(no interleaving)
C      			 P
#endif