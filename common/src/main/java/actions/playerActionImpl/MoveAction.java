package actions.playerActionImpl;

import actions.Action;
import util.MoveEnum;

public class MoveAction extends Action {

    private MoveEnum move;
    private float position;
    private float speed;

    public MoveAction(MoveEnum move, float position, float speed) {
        this.move = move;
        this.position = position;
        this.speed = speed;
    }

    public MoveEnum getMove() {
        return move;
    }

    public void setMove(MoveEnum move) {
        this.move = move;
    }

    public float getPosition() {
        return position;
    }

    public void setPosition(float position) {
        this.position = position;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
