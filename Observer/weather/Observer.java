public interface Observer { //the Observer interface is implemented by all observers so they all have to implement the update() method.
	public void update(float temp, float humidity, float pressure); //the state values the Observers get from the Subject when a weather measurement changes
													// ! THIS METHOD OF PASSING MEASUREMENTS TO THE OBSERVERS AS PARAMETERS IS NOT WELL ENCAPSULATED AND WOULD REQUIRE
													// CHANGES IN PARTS OF THE CODE TO EXTEND OR ALTER THE FUNCTIONALITY !!
}