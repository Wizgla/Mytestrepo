import java.util.Arrays;

// Класс Employee реализует интерфейс Cloneable
public class Employee implements Cloneable {
    // Имя сотрудника
    private String name;
    // Массив зарплат за каждый месяц
    private double[] salaries;

    // Конструктор для инициализации полей
    public Employee(String name, double[] salaries) {
        this.name = name;
        // Создаем копию массива, чтобы избежать изменений через ссылку
        this.salaries = Arrays.copyOf(salaries, salaries.length);
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Геттер для массива зарплат
    public double[] getSalaries() {
        return salaries;
    }

    // Сеттер для изменения зарплаты в конкретном месяце
    public void setSalary(int month, double salary) {
        if (month < 0 || month >= 12) {
            throw new IllegalArgumentException("Месяц должен быть в диапазоне от 0 до 11.");
        }
        this.salaries[month] = salary;
    }

    // Переопределение метода clone() для глубокого копирования
    @Override
    protected Employee clone() {
        try {
            // Выполняем поверхностное клонирование объекта
            Employee cloned = (Employee) super.clone();
            // Выполняем глубокое копирование массива salaries
            cloned.salaries = Arrays.copyOf(this.salaries, this.salaries.length);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Ошибка клонирования объекта Employee", e);
        }
    }

    // Переопределение метода toString() для удобного отображения
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salaries=" + Arrays.toString(salaries) +
                '}';
    }
}
//////////////////////////////////////////////////////////
// Тестирование работы класса Employee
public class TestEmployee {
    public static void main(String[] args) {
        // Создаем массив зарплат за 12 месяцев
        double[] salaries = {3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100};

        // Создаем оригинальный объект Employee
        Employee originalEmployee = new Employee("John Doe", salaries);

        // Клонируем оригинального сотрудника
        Employee clonedEmployee = originalEmployee.clone();

        // Изменяем зарплату на июнь (индекс 5) у оригинального сотрудника
        originalEmployee.setSalary(5, 5000);

        // Выводим зарплаты для оригинального и клонированного сотрудника
        System.out.println("Оригинальный сотрудник: " + originalEmployee);
        System.out.println("Клонированный сотрудник: " + clonedEmployee);
    }
}


