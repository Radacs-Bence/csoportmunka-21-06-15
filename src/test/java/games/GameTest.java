package games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void winnerTest() {
        Game game = new Game("a", "b", 1, 2);
        assertEquals("b", game.winner());
    }

    @Test
    void drawTest() {
        Game game = new Game("a", "b", 1, 1);
        assertEquals("Draw", game.winner());
    }

    @Test
    void createGameFromLine() {
        Game game = Game.createGameFromLine("French;Germany;2;2");
        assertEquals("Germany", game.getSecondCountry());
    }
}