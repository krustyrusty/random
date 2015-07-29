import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement{ //we are now implementing the Observer interface from java.util
	Observable observable;
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(Observable observable){ //our constructor now takes an Observable and we use this to add the current conditions object as an Observer
		this.observable = observable;
		observable.add(this);
	}

	public void update(Observable obs, Object arg){  //takes the Observable and the optional data argument
		if(obs instanceof WeatherData){	//make sure the Observable is of type WeatherData
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();//then use its getter methods to obtain the temp and humidity measurements
			this.humidity = weatherData.getHumidity();
			display(); //last, display it
		}
	}

	public void display(){
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}


