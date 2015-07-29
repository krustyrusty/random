import java.util.*;

public class WeatherData implements Subject { 	//WeatherData now implements the Subject interface
	private ArrayList<Observer> observers; 	//added an ArrayList to hold the Observers, and create it in the constructor below
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData(){
		observers = new ArrayList<Observer>();	
	}

	public void registerObserver(Observer o){ //Here we implement the Subject interface
		observers.add(o);	//when an observer registers, add it to the end of the list
	}

	public void removeObserver(Observer o){ //Here we implement the Subject interface
		int i = observers.indexOf(o);
		if (i>=0) {
		observers.remove(i); //when an observer want to un-register, take it off the list
		}
	}

	public void notifyObservers(){ //Here we implement the Subject interface
		for (Observer observer : observers){
		observer.update(temperature, humidity, pressure);
		}
	}

	public void measurementsChanged(){
		notifyObservers(); //we notify the Observers when we get updated measurements from the Weather Station
	}

	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	//other WeatherData methods here

	public float getTemperature(){
		return temperature;
	}

	public float getHumidity(){
		return humidity;
	}

	public float getPressure(){
		return pressure;
	}

}