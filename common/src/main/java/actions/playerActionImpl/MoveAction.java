package actions.playerActionImpl;

import actions.Action;
import util.MoveEnum;

public class MoveAction extends Action {

    private MoveEnum move;

    public MoveAction(MoveEnum move) {
        this.move = move;
    }

    public MoveEnum getMove() {
        return move;
    }
    public void setMove(MoveEnum move) {
        this.move = move;
    }

}
