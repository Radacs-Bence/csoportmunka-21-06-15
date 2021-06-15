package games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void init() {
        GameRepository gameRepository = new GameRepository();
        gameRepository.addGameFromCsv("src/main/resources/results.csv");
        gameService = new GameService(gameRepository);
    }

    @Test
    void largestGoalDiff() {
    }

    @Test
    void allGoalsOfCountry() {
    }

    @Test
    void mostGoalsCountry() {
    }
}