
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);

        if (player1.getStrength() == player2.getStrength()) {
            return 0; // Ничья
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1; // Победа первого игрока
        } else {
            return 2; // Победа второго игрока
        }
    }

    private Player findPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new NotRegisteredException("Player " + name + " is not registered");
    }
}
