package dl.logic;

import actions.ActionWrapper;

import java.util.HashSet;
import java.util.Set;

public class ActionQueue {
    private static ActionQueue instance = new ActionQueue();
    private Set<ActionWrapper> actions;

    private ActionQueue() {
        actions = new HashSet<ActionWrapper>();
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
