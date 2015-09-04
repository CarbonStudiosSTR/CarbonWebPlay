package dl.controller.controllers;

import actions.ActionWrapper;
import actions.playerActionImpl.MoveAction;
import dl.logic.cache.CharacterCache;
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
            float posX =  CharacterCache.getInstance().getPlayer(Connection.CONNECTION_ID).getPosX();
            float posY =  CharacterCache.getInstance().getPlayer(Connection.CONNECTION_ID).getPosY();

            if (keyEvent.getCode() == KeyCode.UP) {
                actionWrapper.setAction(new MoveAction(MoveEnum.UP_STOP,posX,posY));
            } else if (keyEvent.getCode() == KeyCode.DOWN) {
                actionWrapper.setAction(new MoveAction(MoveEnum.DOWN_STOP,posX,posY));
            } else if (keyEvent.getCode() == KeyCode.LEFT) {
                actionWrapper.setAction(new MoveAction(MoveEnum.LEFT_STOP,posX,posY));
            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                actionWrapper.setAction(new MoveAction(MoveEnum.RIGHT_STOP,posX,posY));
            }
            Client.getInstance().writeAction(actionWrapper);

        }
    }
}
