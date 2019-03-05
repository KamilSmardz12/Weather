package WeatherProject.Service;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherApk implements IWeatherService {

    private WeatherData weatherData = new WeatherData();
    private static OpenWeatherApk weatherMap;


    public static OpenWeatherApk getInstance() {
        if (weatherMap == null) {
            weatherMap = new OpenWeatherApk();
        }
        return weatherMap;
    }


    @Override
    public WeatherData getWeatherData(Location location) {
        String city = location.getCity();
        String country = location.getCountry();

        try {
            URL url;
            String appId = "5fa7571c03889c663963c41593c4124d";
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&units="
                    + location.getUnit() + "&mode=xml&APPID=" + appId);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.connect();
            InputStream in = con.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(in);

            weatherData.setAllWeatherDataByTagNames(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherData;
    }
}
