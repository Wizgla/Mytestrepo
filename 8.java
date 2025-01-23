import java.util.InputMismatchException;
import java.util.Scanner;

// Главный класс
public class DivisionProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0;
        int num2 = 0;
        boolean validInput = false;

        // Pobieranie pierwszej liczby od użytkownika
        while (!validInput) {
            try {
                System.out.print("Wpisz pierwszą liczbę: ");
                num1 = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Błąd: Wprowadź liczbę całkowitą!");
                scanner.next(); // Czyszczenie błędnego wejścia
            }
        }

        validInput = false; // Reset flagi dla drugiej liczby

        // Pobieranie drugiej liczby od użytkownika
        while (!validInput) {
            try {
                System.out.print("Wpisz drugą liczbę: ");
                num2 = scanner.nextInt();

                // Sprawdzanie, czy druga liczba to zero
                if (num2 == 0) {
                    throw new ArithmeticException("Nie można dzielić przez zero!");
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Błąd: Wprowadź liczbę całkowitą!");
                scanner.next(); // Czyszczenie błędnego wejścia
            } catch (ArithmeticException e) {
                System.out.println("Błąd: " + e.getMessage());
            }
        }

        // Obliczanie i wyświetlanie wyniku
        int result = num1 / num2;
        System.out.println("Wynik: " + num1 + " / " + num2 + " = " + result);

        scanner.close();
    }
}
