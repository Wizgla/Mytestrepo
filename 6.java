import java.util.Date;

// Класс Smartphone реализует интерфейс Cloneable
public class Smartphone implements Cloneable {
    // Поля класса
    private String brand; // Бренд смартфона
    private String model; // Модель смартфона
    private Date productionDate; // Дата производства

    // Конструктор для инициализации полей
    public Smartphone(String brand, String model, Date productionDate) {
        this.brand = brand;
        this.model = model;
        this.productionDate = new Date(productionDate.getTime()); // Копируем дату
    }

    // Геттеры для полей
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    // Сеттер для изменения даты производства
    public void setProductionDate(Date productionDate) {
        this.productionDate = new Date(productionDate.getTime()); // Копируем дату
    }

    // Переопределение метода clone()
    @Override
    protected Smartphone clone() {
        try {
            // Выполняем поверхностное клонирование
            Smartphone cloned = (Smartphone) super.clone();
            // Глубокое копирование поля productionDate
            cloned.productionDate = new Date(this.productionDate.getTime());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Ошибка клонирования объекта Smartphone", e);
        }
    }

    // Переопределение метода toString() для удобного отображения
    @Override
    public String toString() {
        return "Smartphone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }
}
//////////////////////////////////
import java.util.Date;

// Класс для тестирования работы Smartphone
public class TestSmartphone {
    public static void main(String[] args) {
        // Создаем оригинальный объект Smartphone
        Smartphone originalSmartphone = new Smartphone("Samsung", "Galaxy S21", new Date());

        // Клонируем оригинальный объект
        Smartphone clonedSmartphone = originalSmartphone.clone();

        // Изменяем дату производства у оригинального объекта
        originalSmartphone.setProductionDate(new Date(System.currentTimeMillis() + 86400000L)); // Завтрашний день

        // Выводим дату производства обоих объектов
        System.out.println("Оригинальный смартфон: " + originalSmartphone);
        System.out.println("Клонированный смартфон: " + clonedSmartphone);
    }
}

