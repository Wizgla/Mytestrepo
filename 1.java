// Абстрактный класс ElectronicDevice
abstract class ElectronicDevice {
    // Поле для хранения производителя устройства
    protected String manufacturer;
    // Поле для хранения модели устройства
    protected String model;
    // Поле для хранения года производства устройства
    protected int productionYear;

    // Конструктор для инициализации базовых полей устройства
    public ElectronicDevice(String manufacturer, String model, int productionYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
    }

    // Абстрактный метод для включения устройства
    public abstract void turnOn();

    // Абстрактный метод для выключения устройства
    public abstract void turnOff();
}

// Класс Smartphone, наследующий ElectronicDevice
class Smartphone extends ElectronicDevice {

    // Конструктор для инициализации смартфона
    public Smartphone(String manufacturer, String model, int productionYear) {
        super(manufacturer, model, productionYear);
    }

    // Реализация метода включения смартфона
    @Override
    public void turnOn() {
        System.out.println("Smartphone " + model + " is now ON.");
    }

    // Реализация метода выключения смартфона
    @Override
    public void turnOff() {
        System.out.println("Smartphone " + model + " is now OFF.");
    }
}

// Класс Television, наследующий ElectronicDevice
class Television extends ElectronicDevice {

    // Конструктор для инициализации телевизора
    public Television(String manufacturer, String model, int productionYear) {
        super(manufacturer, model, productionYear);
    }

    // Реализация метода включения телевизора
    @Override
    public void turnOn() {
        System.out.println("Television " + model + " is now ON.");
    }

    // Реализация метода выключения телевизора
    @Override
    public void turnOff() {
        System.out.println("Television " + model + " is now OFF.");
    }
}

// Класс Laptop, наследующий ElectronicDevice
class Laptop extends ElectronicDevice {

    // Конструктор для инициализации ноутбука
    public Laptop(String manufacturer, String model, int productionYear) {
        super(manufacturer, model, productionYear);
    }

    // Реализация метода включения ноутбука
    @Override
    public void turnOn() {
        System.out.println("Laptop " + model + " is now ON.");
    }

    // Реализация метода выключения ноутбука
    @Override
    public void turnOff() {
        System.out.println("Laptop " + model + " is now OFF.");
    }
}

// Основной класс с методом main для проверки
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем список объектов ElectronicDevice
        List<ElectronicDevice> devices = new ArrayList<>();

        // Добавляем 5 устройств в список
        devices.add(new Smartphone("Apple", "iPhone 14", 2023));
        devices.add(new Smartphone("Samsung", "Galaxy S23", 2023));
        devices.add(new Television("Sony", "Bravia X90J", 2021));
        devices.add(new Laptop("Dell", "XPS 15", 2022));
        devices.add(new Laptop("Lenovo", "ThinkPad X1", 2023));

        // Перебираем список и вызываем методы turnOn и turnOff для каждого устройства
        for (ElectronicDevice device : devices) {
            device.turnOn(); // Включение устройства
            device.turnOff(); // Выключение устройства
        }
    }
}
