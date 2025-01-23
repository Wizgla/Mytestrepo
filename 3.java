package entertainment;

// Абстрактный класс Game
public abstract class Game {
    // Абстрактный метод для получения рейтинга игры
    public abstract double getRating();
}


package entertainment;

// Класс StrategyGame, наследующий от Game
public class StrategyGame extends Game {
    // Реализация метода getRating для стратегической игры
    @Override
    public double getRating() {
        // Рейтинг стратегической игры фиксированный - 8.5
        return 8.5;
    }
}

// Класс AdventureGame, наследующий от Game
public class AdventureGame extends Game {
    // Реализация метода getRating для приключенческой игры
    @Override
    public double getRating() {
        // Рейтинг приключенческой игры фиксированный - 7.3
        return 7.3;
    }
}


package entertainment;

import java.util.ArrayList;
import java.util.List;

// Класс для тестирования работы с играми
public class TestGame {
    public static void main(String[] args) {
        // Создаем список типа Game
        List<Game> games = new ArrayList<>();

        // Добавляем экземпляры StrategyGame и AdventureGame в список
        games.add(new StrategyGame());  // Первая стратегическая игра
        games.add(new AdventureGame()); // Первая приключенческая игра
        games.add(new StrategyGame());  // Вторая стратегическая игра
        games.add(new AdventureGame()); // Вторая приключенческая игра
        games.add(new StrategyGame());  // Третья стратегическая игра

        // Итерация по списку и вызов метода getRating
        for (Game game : games) {
            // Вывод рейтинга на стандартный вывод
            System.out.println("Рейтинг игры: " + game.getRating());
        }
    }
}
