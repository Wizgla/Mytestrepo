// Klasa wyjątku, która rozszerza Exception
public class NiepoprawnyFormatDanychException extends Exception {
    // Konstruktor przyjmujący komunikat błędu
    public NiepoprawnyFormatDanychException(String message) {
        super(message);
    }
}
////////////////////////
import java.util.regex.Pattern;

// Klasa zawierająca metodę do sprawdzania formatu danych
public class Validator {
    // Metoda sprawdzająca, czy podany ciąg jest poprawnym adresem e-mail
    public static void sprawdzFormatDanych(String dane) throws NiepoprawnyFormatDanychException {
        // Wzorzec regex dla adresu e-mail
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Sprawdzanie, czy dane pasują do wzorca
        if (!Pattern.matches(emailRegex, dane)) {
            throw new NiepoprawnyFormatDanychException("Niepoprawny format danych: \"" + dane + "\" nie jest poprawnym adresem e-mail.");
        }
    }
}
//////////////////////////////////
import java.util.Scanner;

public class TestValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prosimy użytkownika o podanie ciągu znaków
        System.out.print("Podaj adres e-mail: ");
        String dane = scanner.nextLine();

        try {
            // Sprawdzamy format danych
            Validator.sprawdzFormatDanych(dane);
            System.out.println("Podany adres e-mail jest poprawny.");
        } catch (NiepoprawnyFormatDanychException e) {
            // Obsługa wyjątku
            System.out.println("Błąd: " + e.getMessage());
        }

        scanner.close();
    }
}
////////////////////
