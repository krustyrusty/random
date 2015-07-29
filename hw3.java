
/*  d_i denotes a distance 
    s_i denotes a star, which is represented as (x,y,z), corresponding to the x, y, and z coordinates of the star. 

d1  // minimal pairwise distance
s1 s2
...

d2  // maximal pairwise distance
s1 s2
s3 s2
...

d3 // minimum maximal distance
s3 s1 
...

d4 // maximum minimal distance
s4 
s5 
... 

d5 // minimal average distance
s1
...


    */

String closestNeighbors(){ /* Compute the pair of stars that minimize pairwise distance. */
	return "d1";
} 

closestNeighbors() @ standardOutput <- println(token);

farthestNeighbors /*Compute the pair of stars that maximize pairwise distance.*/
idealHubStar /*Compute the star which minimizes the maximal distance to any other star.*/
idealJailStar /*Compute the star which maximizes the minimal distance to any other star.*/
idealCapitalStar /*Compute the star which minimizes the average distance to all other stars.*/


/* Write an actor-based solution to the space colonization problem. */

Searcher[] actors = {searcher0, searcher1, searcher 2}; /* pg 195 */
join{
	for( int i=0. i < actors.length; i++ ){
		actors[i] <-find( phrase );
	}

} @ customer <- output( token ); 

behavior Star {
	Object contents;

	Star( Object initialContents){
		contents = initialContents;
	}

	Object get(){
		return contents;
	}

	void set( Object newContents){
		contents = newContents;
	}

	void act( String[] arguments){
	}
}

myRef = new Star();


module examples;
behavior HelloWorld{
	void act( String[] arguments){
		standardOutput <- print("Hello")@
		standardOutput <- print( "World!");
	}
}

HelloWorld helloWorld = new HelloWorld() at (new UAN*"uan://nameserver/id")), new UAL("rmsp://host1:4040/id"));

/* to get its own UAN or UAL: */

UAL selfUAL = this.getUAL();
UAN selfUAN = this.getUAN();

/* Write a distributed space colonization solution. Note that in this case, the actors must communicate over a network although you do not necessarily have to run each actor on a separate machine. 
If you are using SALSA, your solution will be distributed if you make use of universal actors. */