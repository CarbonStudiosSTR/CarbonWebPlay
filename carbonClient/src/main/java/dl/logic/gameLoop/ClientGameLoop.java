package dl.logic.gameLoop;

import dl.logic.cache.CharacterCache;
import entities.Player;

public class ClientGameLoop extends GameLoop{
    @Override
    protected void render() {
        for (Player player : CharacterCache.getInstance().getPlayers()) {
            System.out.println(player.getPosX() + " " + player.getPosY());
        }
    }
}
