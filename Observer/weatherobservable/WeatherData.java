import java.util.Observable;

public class WeatherData extends Observable{
	private float temperature;
	private float humidity;
	private float pressure;
							//we don't need to keep track of our observers anymore, or manage their registration and removal (we inherit that behavior from the superclass)
							//so we've removed register/remove/notify observer() methods

	public WeatherData(){} //our constructor no longer needs to create a data structure to hold Observers

	public void measurementsChanged(){
		setChanged(); //we now first call setChanged() to indicate the state has changed before calling notifyObserver()
		notifyObservers(); //notice we aren't sending a data object with this call. That means we're using the PULL method (as opposed to PUSH)
	}

	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged(); 
	}

	public float getTemperature(){  //the Observers will use these methods to get at the WeatherData object's state
		return temperature;
	}

	public float getHumidity(){
		return humidity;
	}

	public float getPressure(){
		return pressure;
	}
}