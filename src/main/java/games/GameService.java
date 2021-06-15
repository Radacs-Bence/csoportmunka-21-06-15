package games;

import java.util.Comparator;
import java.util.stream.Stream;

public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game largestGoalDiff() {
        return gameRepository.getGames().stream()
                .max(Comparator.comparing(game -> Math.abs(game.getFirstCountryScore() - game.getSecondCountryScore()))).get();
    }

    public int allGoalsOfCountry(String country) {
        int result = 0;

        for (Game game : gameRepository.getGames()) {
            if (game.getFirstCountry().equals(country)) {
                result += game.getFirstCountryScore();
            }
            if (game.getSecondCountry().equals(country)) {
                result += game.getSecondCountryScore();
            }
        }

        return result;
    }

    public String mostGoalsCountry(){
        return gameRepository.getGames().stream()
                .flatMap(game -> Stream.of(game.getFirstCountry(), game.getSecondCountry()))
                .max(Comparator.comparing(this::allGoalsOfCountry)).get();
        }
}
