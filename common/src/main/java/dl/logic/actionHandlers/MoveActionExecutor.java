package dl.logic.actionHandlers;

import actions.ActionWrapper;
import actions.playerActionImpl.MoveAction;
import dl.logic.cache.CharacterCache;
import entities.Player;
import org.springframework.stereotype.Component;
import util.MoveEnum;

@Component
public class MoveActionExecutor extends ActionExecutor<MoveAction> {

    @Override
    public void executeAction(ActionWrapper<MoveAction> actionWrapper) {

        Player p = CharacterCache.getInstance().getPlayer(actionWrapper.getId());
        MoveEnum move = actionWrapper.getAction().getMove();
        if (move == MoveEnum.UP_START) {
            p.setGoUp(true);
        } else if (move == MoveEnum.DOWN_START) {
            p.setGoDown(true);
        } else if (move == MoveEnum.LEFT_START) {
            p.setGoLeft(true);
        } else if (move == MoveEnum.RIGHT_START) {
            p.setGoRight(true);
        } else if (move == MoveEnum.UP_STOP) {
            p.setGoUp(false);
        } else if (move == MoveEnum.DOWN_STOP) {
            p.setGoDown(false);
        } else if (move == MoveEnum.LEFT_STOP) {
            p.setGoLeft(false);
        } else if (move == MoveEnum.RIGHT_STOP) {
            p.setGoRight(false);
        }
    }
}
