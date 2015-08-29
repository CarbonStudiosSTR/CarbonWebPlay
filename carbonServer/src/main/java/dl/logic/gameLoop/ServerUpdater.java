package dl.logic.gameLoop;

import actions.ActionWrapper;
import dl.logic.ActionQueue;
import dl.logic.actionHandlers.ActionDispatcher;
import dl.logic.cache.CharacterCache;
import entities.Player;

public class ServerUpdater {

    ActionDispatcher actionDispatcher = new ActionDispatcher();

    public void update(long now) {
        changeStates(now);
        updateCaches();

        for (Player player : CharacterCache.getInstance().getPlayers()) {
            System.out.println(player.getPosX() + " " + player.getPosY());
        }

    }

    private void changeStates(long now) {
        for (ActionWrapper actionWrapper : ActionQueue.getInstance().getActionsToExecute()) {
            actionDispatcher.dispatchAction(actionWrapper);
            updateOldAction(actionWrapper,now);
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
