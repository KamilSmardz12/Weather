package WeatherProject.Service;

import static WeatherProject.Service.IWeatherService.OPEN_WEATHER_MAP;

public class WeatherServiceFacatory {


    public static IWeatherService getWeatherDataService(String servie) {
        if (servie.equals(OPEN_WEATHER_MAP)) {
            return OpenWeatherApk.getInstance();
        }

        return null;
    }

}
