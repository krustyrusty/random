public class CurrentConditionsDisplay implements Observer, DisplayElement{ //This display implements Observer so it can get changes from the WeatherData object
																			//Also implements DisplayElement b/c our API is going to require all display elements to implement this interface
	private float temperature;
	private float humidity;
	private Subject weatherData; //reference to subject is currently unused, but in the future we may want to unregister ourselves as an observer and it would be 
								// handy to already have a reference to the subject (?! ZOMBIE CODE??)

	public CurrentConditionsDisplay(Subject weatherData){ //this constructor is pass the weatherData object (the Subject) 
															//and we use it to register the display as an observer
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temperature, float humidity, float pressure){
		this.temperature = temperature; 
		this.humidity = humidity; 
		display();	// ! THERE ARE BETTER WAYS TO DESIGN THE WAY DATA GETS DISPLAYED !
	}

	public void display(){
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity"); //prints out the most recent temp and humidity
	}
}