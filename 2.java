package store;

// Абстрактный класс Product
public abstract class Product {
    // Абстрактный метод для получения цены продукта
    public abstract double getPrice();
}


package store;

// Класс Book, наследующий от Product
public class Book extends Product {
    // Реализация метода getPrice для книг
    @Override
    public double getPrice() {
        // Цена книги фиксированная - 29.99
        return 29.99;
    }
}

// Класс Clothing, наследующий от Product
public class Clothing extends Product {
    // Реализация метода getPrice для одежды
    @Override
    public double getPrice() {
        // Цена одежды фиксированная - 59.99
        return 59.99;
    }
}


package store;

// Импортируем классы
public class TestProduct {
    public static void main(String[] args) {
        // Создаем массив типа Product
        Product[] products = new Product[5];

        // Инициализируем массив объектами Book и Clothing
        products[0] = new Book();    // Первая книга
        products[1] = new Clothing(); // Первая одежда
        products[2] = new Book();    // Вторая книга
        products[3] = new Clothing(); // Вторая одежда
        products[4] = new Book();    // Третья книга

        // Итерация по массиву и вызов метода getPrice
        for (Product product : products) {
            // Вывод цены на стандартный вывод
            System.out.println("Цена продукта: " + product.getPrice());
        }
    }
}

