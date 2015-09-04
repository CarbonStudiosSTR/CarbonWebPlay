package actions.playerActionImpl;

import actions.Action;
import util.MoveEnum;

public class MoveAction extends Action {

    private MoveEnum move;
    private float posX;
    private float posY;

    public MoveAction(MoveEnum move, float posX, float posY) {
        this.move = move;
        this.posX = posX;
        this.posY = posY;
    }

    public MoveEnum getMove() {
        return move;
    }

    public void setMove(MoveEnum move) {
        this.move = move;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}
