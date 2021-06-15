package games;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameDynamicTest {

    Object[][] values = {
            {0, "Spain"},
            {5, "Italy"},
            {1, "Russia"}
    };

    GameService gameService;

    @BeforeEach
    void init() {
        GameRepository gameRepository = new GameRepository();
        gameRepository.addGameFromCsv("src/main/resources/results.csv");
        gameService = new GameService(gameRepository);
    }

    @TestFactory
    Stream<DynamicTest> testAllGoals() {
        return Arrays.stream(values)
                .map(pair -> DynamicTest.dynamicTest("Test all goals" +
                                pair[0],
                        () -> assertEquals(pair[0], gameService.allGoalsOfCountry((String) pair[1]))
                ));
    }
}
