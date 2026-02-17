import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testRegisterAndRound() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 80);
        Player player2 = new Player(2, "Bob", 70);

        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round("Alice", "Bob"));
    }

    @Test
    void testDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 70);
        Player player2 = new Player(2, "Bob", 70);

        game.register(player1);
        game.register(player2);

        assertEquals(0, game.round("Alice", "Bob"));
    }

    @Test
    void testSecondPlayerWins() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 60);
        Player player2 = new Player(2, "Bob", 90);

        game.register(player1);
        game.register(player2);

        assertEquals(2, game.round("Alice", "Bob"));
    }

    @Test
    void testNotRegisteredException() {
        Game game = new Game();
        Player player = new Player(1, "Alice", 80);
        game.register(player);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Alice", "Unknown");
        });
    }

    @Test
    void testBothPlayersNotRegistered() {
        Game game = new Game();

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Unknown1", "Unknown2");
        });
    }
}
