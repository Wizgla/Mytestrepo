// Интерфейс Sensor
public interface Sensor {
    // Метод для чтения значения сенсора
    double readValue();

    // Метод для получения статуса сенсора
    String getStatus();

    // Метод для сброса сенсора
    void reset();
}
/////////////////////////////
import java.util.Random;

// Класс TemperatureSensor реализует интерфейс Sensor
public class TemperatureSensor implements Sensor {
    private double currentTemperature;

    public TemperatureSensor() {
        this.currentTemperature = generateRandomTemperature();
    }

    // Генерация случайной температуры в диапазоне -20 до 50 градусов
    private double generateRandomTemperature() {
        Random random = new Random();
        return -20 + (70 * random.nextDouble()); // Диапазон от -20 до 50
    }

    @Override
    public double readValue() {
        return currentTemperature;
    }

    @Override
    public String getStatus() {
        if (currentTemperature < -10 || currentTemperature > 40) {
            return "Warning: Temperature is out of range!";
        }
        return "Temperature is normal.";
    }

    @Override
    public void reset() {
        this.currentTemperature = generateRandomTemperature();
    }
}
///////////////////////////////////////////
import java.util.Random;

// Класс PressureSensor реализует интерфейс Sensor
public class PressureSensor implements Sensor {
    private double currentPressure;

    public PressureSensor() {
        this.currentPressure = generateRandomPressure();
    }

    // Генерация случайного давления в диапазоне 900 до 1100 гПа
    private double generateRandomPressure() {
        Random random = new Random();
        return 900 + (200 * random.nextDouble()); // Диапазон от 900 до 1100
    }

    @Override
    public double readValue() {
        return currentPressure;
    }

    @Override
    public String getStatus() {
        if (currentPressure < 950 || currentPressure > 1050) {
            return "Warning: Pressure is out of range!";
        }
        return "Pressure is normal.";
    }

    @Override
    public void reset() {
        this.currentPressure = generateRandomPressure();
    }
}
/////////////////////////////////////////////////
// Класс для тестирования работы сенсоров
public class SensorTest {
    public static void main(String[] args) {
        // Создаем экземпляры TemperatureSensor и PressureSensor
        Sensor tempSensor = new TemperatureSensor();
        Sensor pressureSensor = new PressureSensor();

        // Тестирование TemperatureSensor
        System.out.println("Temperature Sensor:");
        System.out.println("Value: " + tempSensor.readValue());
        System.out.println("Status: " + tempSensor.getStatus());
        tempSensor.reset();
        System.out.println("Value after reset: " + tempSensor.readValue());

        System.out.println();

        // Тестирование PressureSensor
        System.out.println("Pressure Sensor:");
        System.out.println("Value: " + pressureSensor.readValue());
        System.out.println("Status: " + pressureSensor.getStatus());
        pressureSensor.reset();
        System.out.println("Value after reset: " + pressureSensor.readValue());
    }
}
