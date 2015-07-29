#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>

int main()
{
	close( 1 );
	int rc = open( "j.txt", O_WRONLY | O_CREAT | O_TRUNC, 0660 );
	pid_t pid = fork(); 
	printf( "[? %d]", pid );

	if ( pid == 0 )
	{
		fprintf( stderr, "[?!]" );
		rc = dup2( 1, 2 );
		fprintf( stderr, "[&& %d]", rc );
	}
	else if ( pid > 0 )
	{
		wait( NULL );
		fprintf( stderr, "[$$ %d]", pid );
	}
	return EXIT_SUCCESS;
}

#if 0
Assume the parent process id is 128 w any child processes
numbered 256, 257, 258, etc.

Write the exact terminal output(s).
[?!][$$ 256]

Write the exact contents of the j.txt file.
[&& 2][? 0][? 256] OR [&& 2][? 256][? 0]

(fd1: buffered; fd2: unbuffered)

If the wait() sys call is removed, write the possible terminal output(s).
[$$ 256][?!]  OR [?!][$$ 256] 

(Parent doesn't wait for child to terminate)

#endif