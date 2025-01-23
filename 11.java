// Интерфейс Silnik
public interface Silnik {
    // Метод для запуска двигателя
    void uruchom();

    // Метод для остановки двигателя
    void zatrzymaj();
}
/////////////////////
// Класс BenzynowySilnik реализует интерфейс Silnik
public class BenzynowySilnik implements Silnik {
    @Override
    public void uruchom() {
        // Symulacja uruchamiania silnika benzynowego
        System.out.println("Silnik benzynowy został uruchomiony.");
    }

    @Override
    public void zatrzymaj() {
        // Symulacja zatrzymywania silnika benzynowego
        System.out.println("Silnik benzynowy został zatrzymany.");
    }
}
////////////////////////
// Класс Samochód
public class Samochód {
    // Приватное поле для объекта типа Silnik
    private Silnik silnik;

    // Конструктор принимает объект Silnik и сохраняет его в поле
    public Samochód(Silnik silnik) {
        this.silnik = silnik;
    }

    // Метод для запуска двигателя
    public void start() {
        // Делегируем задачу запуска двигателю
        silnik.uruchom();
    }

    // Метод для остановки двигателя
    public void stop() {
        // Делегируем задачу остановки двигателю
        silnik.zatrzymaj();
    }
}
/////////////////////////////////////
// Класс для тестирования работы Samochód и Silnik
public class TestSamochód {
    public static void main(String[] args) {
        // Tworzymy instancję BenzynowySilnik
        Silnik benzynowySilnik = new BenzynowySilnik();

        // Tworzymy instancję Samochód, przekazując BenzynowySilnik
        Samochód samochód = new Samochód(benzynowySilnik);

        // Wywołujemy metody start i stop
        samochód.start();
        samochód.stop();
    }
}
