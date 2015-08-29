package dl.controller.controllers;

import actions.ActionWrapper;
import actions.playerActionImpl.MoveAction;
import dl.netty.Client;
import dl.utils.Connection;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import util.ActionEnum;
import util.MoveEnum;

public class OnKeyReleasedController implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.DOWN ||
                keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.RIGHT) {

            ActionWrapper<MoveAction> actionWrapper = new ActionWrapper<>();
            actionWrapper.setId(Connection.CONNECTION_ID);
            actionWrapper.setActionType(ActionEnum.Move);
            actionWrapper.setTimestamp(System.nanoTime());

            if (keyEvent.getCode() == KeyCode.UP) {
                actionWrapper.setAction(new MoveAction(MoveEnum.UP_STOP));
            } else if (keyEvent.getCode() == KeyCode.DOWN) {
                actionWrapper.setAction(new MoveAction(MoveEnum.DOWN_STOP));
            } else if (keyEvent.getCode() == KeyCode.LEFT) {
                actionWrapper.setAction(new MoveAction(MoveEnum.LEFT_STOP));
            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                actionWrapper.setAction(new MoveAction(MoveEnum.RIGHT_STOP));
            }
            Client.getInstance().writeAction(actionWrapper);

        }
    }
}
