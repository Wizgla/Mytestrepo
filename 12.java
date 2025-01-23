// Интерфейс Powiadomienie
public interface Powiadomienie {
    // Метод для отправки уведомления
    void wyślij(String wiadomość);
}
/////////////////////
// Класс Email реализует интерфейс Powiadomienie
public class Email implements Powiadomienie {
    @Override
    public void wyślij(String wiadomość) {
        // Symulacja wysyłania wiadomości e-mail
        System.out.println("Wysyłam e-mail: " + wiadomość);
    }
}
////////////////////
// Класс Użytkownik
public class Użytkownik {
    // Приватное поле для объекта типа Powiadomienie
    private Powiadomienie powiadomienie;

    // Конструктор принимает объект Powiadomienie и сохраняет его в поле
    public Użytkownik(Powiadomienie powiadomienie) {
        this.powiadomienie = powiadomienie;
    }

    // Метод для отправки уведомления о модернизации
    public void powiadomOModernizacji(String informacja) {
        // Делегируем задачу отправки уведомления объекту powiadomienie
        powiadomienie.wyślij(informacja);
    }
}
///////////////////////////
// Класс для тестирования работы Użytkownik и Powiadomienie
public class TestPowiadomienie {
    public static void main(String[] args) {
        // Tworzymy instancję Email
        Powiadomienie emailPowiadomienie = new Email();

        // Tworzymy instancję Użytkownik, przekazując obiekt Email
        Użytkownik użytkownik = new Użytkownik(emailPowiadomienie);

        // Wywołujemy metodę powiadomOModernizacji
        użytkownik.powiadomOModernizacji("System został zmodernizowany do wersji 2.0.");
    }
}
