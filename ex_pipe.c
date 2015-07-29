#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main()
{
	int p[2];
	int rc = pipe( p );

	printf( " %d-%d-%d\n", getpid(), p[0], p[1] );

	return EXIT_SUCCESS;
}