package netty.selfActionHandlers;

import actions.Action;
import logic.CharacterCache;

public class SelfActionHandler {

    public static void selfExecute(Action action) {
        action.executeAction();
        CharacterCache.getInstance().listPlayers();
    }
}
