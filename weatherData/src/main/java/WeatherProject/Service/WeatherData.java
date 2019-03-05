package WeatherProject.Service;

import WeatherProject.Model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherData {

    private City city;
    private Humidity humidity;
    private LastUpdate lastUpdate;
    private Pressure pressure;
    private Temperature temperature;

    private void setAttribute(String name, Element addElement) {
        NodeList listOfElements = addElement.getElementsByTagName(name);
        Node node = listOfElements.item(0);
        Element currentElement = (Element) node;

        switch (name) {
            case "city":
                city = new City(currentElement.getAttribute("id"), currentElement.getAttribute("name"));
                break;
            case "country":
                city.setCountry(currentElement.getTextContent());
                break;
            case "temperature":
                temperature = new Temperature(currentElement.getAttribute("value"), currentElement.getAttribute("unit"));
                break;
            case "humidity":
                humidity = new Humidity(currentElement.getAttribute("value"), currentElement.getAttribute("unit"));
                break;
            case "pressure":
                pressure = new Pressure(currentElement.getAttribute("value"), currentElement.getAttribute("unit"));
                break;
            case "lastupdate":
                lastUpdate = new LastUpdate(currentElement.getAttribute("value"));
                break;
        }
    }

    public void setAllWeatherDataByTagNames(Document doc) {
        NodeList list = doc.getElementsByTagName("current");
        Node node = list.item(0);
        Element rootElement = (Element) node;

        setAttribute("city", rootElement);
        setAttribute("country", rootElement);
        setAttribute("temperature", rootElement);
        setAttribute("humidity", rootElement);
        setAttribute("pressure", rootElement);
        setAttribute("lastupdate", rootElement);
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public LastUpdate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LastUpdate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
