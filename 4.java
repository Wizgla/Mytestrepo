import java.time.LocalDate;

// Класс CreditCard реализует интерфейс Cloneable
public class CreditCard implements Cloneable {
    // Номер карты
    private String cardNumber;
    // Имя владельца
    private String holderName;
    // Дата истечения срока действия карты
    private LocalDate expiryDate;

    // Конструктор для инициализации полей
    public CreditCard(String cardNumber, String holderName, LocalDate expiryDate) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    // Метод для получения даты истечения срока действия
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    // Метод для изменения даты истечения срока действия
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Переопределение метода clone() для создания копии объекта
    @Override
    protected CreditCard clone() {
        try {
            // Вызов метода clone() родительского класса Object
            return (CreditCard) super.clone();
        } catch (CloneNotSupportedException e) {
            // Если ошибка, выбрасываем RuntimeException
            throw new RuntimeException("Ошибка клонирования объекта CreditCard", e);
        }
    }

    // Переопределение метода toString() для удобного вывода
    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}



/////////////////////////////////////
import java.time.LocalDate;

// Тестирование работы класса CreditCard
public class TestCreditCard {
    public static void main(String[] args) {
        // Создаем оригинальный объект CreditCard
        CreditCard originalCard = new CreditCard("1234-5678-9012-3456", "John Doe", LocalDate.of(2025, 12, 31));

        // Клонируем оригинальный объект
        CreditCard clonedCard = originalCard.clone();

        // Изменяем дату истечения срока действия оригинальной карты
        originalCard.setExpiryDate(LocalDate.of(2026, 12, 31));

        // Выводим информацию об обеих картах для проверки
        System.out.println("Оригинальная карта: " + originalCard);
        System.out.println("Клонированная карта: " + clonedCard);
    }
}
