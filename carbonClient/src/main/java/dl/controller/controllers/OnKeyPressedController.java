package dl.controller.controllers;

import actions.playerActionImpl.MoveAction;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import dl.netty.Client;
import util.MoveEnum;
import dl.utils.Connection;

public class OnKeyPressedController implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.UP){
            Client.getInstance().writeAction(new MoveAction(Connection.CONNECTION_ID, MoveEnum.UP_START));
        }else if(keyEvent.getCode()== KeyCode.DOWN){
            Client.getInstance().writeAction(new MoveAction(Connection.CONNECTION_ID, MoveEnum.DOWN_START));
        }else if(keyEvent.getCode()== KeyCode.LEFT){
            Client.getInstance().writeAction(new MoveAction(Connection.CONNECTION_ID, MoveEnum.LEFT_START));
        }else if(keyEvent.getCode()== KeyCode.RIGHT){
            Client.getInstance().writeAction(new MoveAction(Connection.CONNECTION_ID, MoveEnum.RIGHT_START));
        }
    }
}
