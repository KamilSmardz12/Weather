package WeatherProject.Service;

public interface IWeatherService {

    String OPEN_WEATHER_MAP = "OPEN";

    WeatherData getWeatherData(Location location);
}
