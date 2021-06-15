package games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void winnerTest() {
        Game game = new Game("a", "b", 1, 2);
        assertEquals("b", game.winner());
    }
}