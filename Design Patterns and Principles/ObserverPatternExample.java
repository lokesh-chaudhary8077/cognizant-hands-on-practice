import java.util.ArrayList;
import java.util.List;

// The Observer Interface
interface Observer {
    void update(double temperature, double humidity);
}

// The Subject Interface
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private double temperature;
    private double humidity;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    // Call this when measurements change
    public void setMeasurements(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers(); // Automatically trigger notifications
    }
}

// Concrete Observer A
class PhoneDisplay implements Observer {
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Phone Display -> Temp: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

// Concrete Observer B
class WindowDisplay implements Observer {
    @Override
    public void update(double temperature, double humidity) {
        System.out.println("Window Display -> Current Room Target: " + (temperature - 2) + "°C");
    }
}

// Client Code
public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        PhoneDisplay phone = new PhoneDisplay();
        WindowDisplay window = new WindowDisplay();

        // Registering subscribers
        station.registerObserver(phone);
        station.registerObserver(window);

        System.out.println("--- First Weather Update ---");
        station.setMeasurements(32.5, 65.0);

        System.out.println("\n--- Second Weather Update (Phone unsubscribed) ---");
        station.removeObserver(phone);
        station.setMeasurements(28.0, 70.0);
    }
}