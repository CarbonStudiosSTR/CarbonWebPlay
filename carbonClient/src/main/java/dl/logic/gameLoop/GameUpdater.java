package dl.logic.gameLoop;

import actions.ActionWrapper;
import dl.logic.ActionQueue;
import dl.logic.actionHandlers.ActionDispatcher;
import dl.logic.cache.CharacterCache;
import entities.Player;

public class GameUpdater {

    ActionDispatcher actionDispatcher = new ActionDispatcher();

    public void update(long now) {
        changeStates(now);
        updateCaches();
    }

    private void changeStates(long now) {
        for (ActionWrapper actionWrapper : ActionQueue.getInstance().getActionsToExecute()) {
            actionDispatcher.dispatchAction(actionWrapper);
            updateOldAction(actionWrapper,now);
        }
    }

    private void updateOldAction(ActionWrapper actionWrapper, long now) {
        float timestamp = actionWrapper.getTimestamp();
        while (now - timestamp > 0.0166f * 1e9) {
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
