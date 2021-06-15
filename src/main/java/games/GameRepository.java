package games;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private List<Game> games = new ArrayList<>();

    public List<Game> getGames() {
        return new ArrayList<>(games);
    }

    public void addGame(Game game){
        games.add(game);
    }
}
