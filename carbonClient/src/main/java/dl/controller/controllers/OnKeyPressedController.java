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

public class OnKeyPressedController implements EventHandler<KeyEvent> {
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
            float speedX = CharacterCache.getInstance().getPlayer(Connection.CONNECTION_ID).getSpeedX();
            float speedY = CharacterCache.getInstance().getPlayer(Connection.CONNECTION_ID).getSpeedY();

            if (keyEvent.getCode() == KeyCode.UP) {
                actionWrapper.setAction(new MoveAction(MoveEnum.UP_START,posY,speedY));
            } else if (keyEvent.getCode() == KeyCode.DOWN) {
                actionWrapper.setAction(new MoveAction(MoveEnum.DOWN_START,posY,speedY));
            } else if (keyEvent.getCode() == KeyCode.LEFT) {
                actionWrapper.setAction(new MoveAction(MoveEnum.LEFT_START,posX,speedX));
            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                actionWrapper.setAction(new MoveAction(MoveEnum.RIGHT_START,posX,speedX));
            }
            Client.getInstance().writeAction(actionWrapper);

        }
    }
}
