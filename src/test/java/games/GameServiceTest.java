package games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    GameService gameService;

    @BeforeEach
    void init() {
        GameRepository gameRepository = new GameRepository();
        gameRepository.addGameFromCsv("src/main/resources/results.csv");
        gameRepository.addGame(new Game("Antigua", "Barbados", 4, 0));
        gameRepository.addGame(new Game("Belgium", "Barbados", 4, 3));
        gameService = new GameService(gameRepository);
    }

    @Test
    void largestGoalDiff() {
        Game game = gameService.largestGoalDiff();
        assertEquals("Antigua", game.getFirstCountry());
        assertEquals(0,game.getSecondCountryScore());
    }

    @Test
    void allGoalsOfCountryTest() {
        int result = gameService.allGoalsOfCountry("Italy");
        assertEquals(5, result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Italy", "Wales", "Poland"})
    void allGoalsOfCountryParametrizedTestWithValueSource(String country) {
        assertTrue(gameService.allGoalsOfCountry(country) > 0);
    }

    @ParameterizedTest
    @MethodSource("createAllGoals")
    void allGoalsOfCountryParametrizedTestWithMethodSource(int goals, String country) {
        assertEquals(goals, gameService.allGoalsOfCountry(country));
    }

    private static Stream<Arguments> createAllGoals() {
        return Stream.of(
                Arguments.arguments(5, "Italy"),
                Arguments.arguments(2, "Wales"),
                Arguments.arguments(1, "Poland")
        );
    }

    @Test
    void mostGoalsCountry() {
        assertEquals("Belgium", gameService.mostGoalsCountry());
    }
}