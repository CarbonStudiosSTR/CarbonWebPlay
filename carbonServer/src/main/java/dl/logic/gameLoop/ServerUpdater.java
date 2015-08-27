package dl.logic.gameLoop;

import actions.ActionWrapper;
import dl.logic.ActionQueue;
import dl.logic.actionHandlers.ActionDispatcher;
import dl.logic.cache.CharacterCache;
import entities.Player;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerUpdater {

    @Autowired
    ActionDispatcher actionDispatcher;

    public void update(long now) {
        changeStates(now);
        updateCaches();
    }

    private void changeStates(long now) {
        for (ActionWrapper actionWrapper : ActionQueue.getInstance().getActions()) {
            actionDispatcher.dispatchAction(actionWrapper);
            updateOldAction(actionWrapper, now);
        }
    }

    private void updateOldAction(ActionWrapper actionWrapper, long now) {
        float timestamp = actionWrapper.getTimestamp();
        while (now - timestamp > 0.0166f) {
            CharacterCache.getInstance().getPlayer(actionWrapper.getId()).update();
            timestamp = +0.0166f;
        }
    }

    private void updateCaches() {
        for (Player player : CharacterCache.getInstance().getPlayers()) {
            player.update();
        }

    }
}
