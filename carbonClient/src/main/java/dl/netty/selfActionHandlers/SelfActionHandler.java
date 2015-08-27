package dl.netty.selfActionHandlers;

import actions.Action;
import dl.logic.cache.CharacterCache;

public class SelfActionHandler {

    public static void selfExecute(Action action) {
      //  action.executeAction();
        CharacterCache.getInstance().listPlayers();
    }
}
