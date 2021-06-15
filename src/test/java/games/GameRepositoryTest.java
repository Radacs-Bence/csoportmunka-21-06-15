package games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    GameRepository gameRepository;

    @BeforeEach
    void init() {
        gameRepository = new GameRepository();
    }

    @Test
    void addGame() {
        Game game1 = new Game("Hungary", "Portugal", 4, 1);
        Game game2 = new Game("Hungary", "France", 2, 2);

        gameRepository.addGame(game1);
        gameRepository.addGame(game2);

        assertEquals(2, gameRepository.getGames().size());
        assertEquals("Portugal", gameRepository.getGames().get(0).getSecondCountry());
    }

    @Test
    void addGameFromCsvTest() {
        gameRepository.addGameFromCsv("src/main/resources/results.csv");
    }
}