package dl.logic;

import actions.ActionWrapper;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ActionQueue {
    private static ActionQueue instance = new ActionQueue();
    private Set<ActionWrapper> actions;

    private ActionQueue() {
        actions = Collections.newSetFromMap(new ConcurrentHashMap<ActionWrapper, Boolean>());
    }

    public static ActionQueue getInstance() {
        return instance;
    }

    public synchronized void addAction(ActionWrapper actionWrapper) {
        actions.add(actionWrapper);
    }

    public synchronized Set<ActionWrapper> getActionsToExecute() {
        Set<ActionWrapper> returnSet = new HashSet<ActionWrapper>();
        for (ActionWrapper action : actions) {
            returnSet.add(action);
            actions.remove(action);
        }
        return returnSet;
    }

}
