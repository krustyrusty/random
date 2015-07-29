#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
	char b[20];
	int p[2];
	int rc = pipe( p );


	int pid = fork();

	if ( pid > 0 )
	{
		close( p[0] );
		rc = dup2( p[1], 1 );
	}

	printf( "0987654321" );
	fflush( NULL );

	if ( pid == 0 )
	{
		close( p[1] );
		rc = read( p[0], b, 6 );
		b[rc] = '\0';
		printf( "%d-%s\n", getpid(), b );
	}
	return EXIT_SUCCESS;
}

#if 0
Assume the parent process id is 512 w any child processes 
numbered 1024, 1025, 1026, etc.

Write the exact terminal output(s).
#endif