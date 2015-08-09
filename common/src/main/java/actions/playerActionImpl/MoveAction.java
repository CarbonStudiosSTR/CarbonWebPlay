package actions.playerActionImpl;

import actions.PlayerAction;
import entities.Player;
import logic.CharacterCache;
import util.MoveEnum;

public class MoveAction extends PlayerAction {

    private MoveEnum move;

    public MoveAction(Integer id, MoveEnum move) {
        this.id = id;
        this.move = move;
    }

    @Override
    public void executeAction() {
        Player p = CharacterCache.getInstance().getPlayer(id);
        if (move== MoveEnum.UP_START) {
            p.setPosY(p.getPosY() + 1);
        } else if (move== MoveEnum.DOWN_START) {
            p.setPosY(p.getPosY() - 1);
        } else if (move== MoveEnum.LEFT_START) {
            p.setPosX(p.getPosX() - 1);
        } else if (move== MoveEnum.RIGHT_START) {
            p.setPosX(p.getPosX() + 1);
        }
    }

    public MoveEnum getMove() {
        return move;
    }

    public Integer getId() {
        return id;
    }
}
