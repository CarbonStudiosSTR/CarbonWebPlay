package dl.logic.gameLoop;

import dl.logic.cache.CharacterCache;
import entities.Player;

public class GameRenderer implements Runnable {
    @Override
    public void run() {
        for (Player player : CharacterCache.getInstance().getPlayers()) {
            System.out.println(player.getPosX() + " " + player.getPosY());
        }

    }
}
