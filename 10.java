// Интерфейс Printer
public interface Printer {
    // Метод для печати текста
    void drukuj(String tekst);
}
//////////////////////
// Класс StandardowyPrinter реализует интерфейс Printer
public class StandardowyPrinter implements Printer {
    @Override
    public void drukuj(String tekst) {
        // Wyświetlenie tekstu na konsoli
        System.out.println("Drukuję: " + tekst);
    }
}
///////////////////////
// Класс Biuro
public class Biuro {
    // Приватное поле для объекта типа Printer
    private Printer printer;

    // Конструктор принимает объект Printer и сохраняет его в поле
    public Biuro(Printer printer) {
        this.printer = printer;
    }

    // Метод для печати документа
    public void drukujDokument(String tekst) {
        // Делегируем задачу печати объекту Printer
        printer.drukuj(tekst);
    }
}
//////////////////
// Класс для тестирования работы Biuro и Printer
public class TestBiuro {
    public static void main(String[] args) {
        // Tworzymy instancję StandardowyPrinter
        Printer standardowyPrinter = new StandardowyPrinter();

        // Tworzymy instancję Biuro, przekazując StandardowyPrinter
        Biuro biuro = new Biuro(standardowyPrinter);

        // Wywołujemy metodę drukujDokument
        biuro.drukujDokument("To jest testowy dokument.");
    }
}
//////////////////////
