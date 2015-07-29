#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{

	int p[2];
	int rc = pipe( p );

	printf( " %d-%d-%d\n", getpid(), p[0], p[1] );

	rc = fork();

	if ( rc == 0 )
	{
		rc = write( p[1], "DOIREALLYLOOKLIKEAGUYWITHAPLAN?", 31 );

	}
	if ( rc > 0 )
	{
		int n = p[0] * p[0] - p[1];
		char * buffer = (char *)calloc( n + 1, sizeof( char ) );

		rc = read( p[0], buffer, n);
		printf( "%d-%s\n", getpid(), buffer );


		free( buffer );
	}
	return EXIT_SUCCESS;
}

#if 0
Assume the parent process id is 256 w any child processes 
numbered 512, 513, 514, etc.

Write the exact terminal output(s).
256-3-4		OR	256-3-4	 	OR  256-3-4
256-DOIRE		512-ALLYL		256-ALLYL
512-ALLYL		256-DOIRE		512-DOIRE

Why is the first arg of the calloc() call n + 1 (instead of just n)?
BC you have to terminate the buffer with a '\0'
#endif
