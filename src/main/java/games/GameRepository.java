package games;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private List<Game> games = new ArrayList<>();

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void addGameFromCsv(String file) {
        Path path = Path.of(file);
        String line;

        try (BufferedReader br = Files.newBufferedReader(path)) {
            while ((line = br.readLine()) != null) {
                Game game = Game.createGameFromLine(line);
                games.add(game);
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }
}
