public class WeatherStation { //run this file to have output (not including the heat index). otherwise, run WeatherStationHeatIndex.java to have output include that display
	
	public static void main(String[] args){
		WeatherData weatherData = new WeatherData();	//First, create the WeatherData object

		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData); //create the three displays & pass them the WeatherData object.
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
	
		weatherData.setMeasurements(80, 65, 30.4f); //simulate new weather measurements
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}