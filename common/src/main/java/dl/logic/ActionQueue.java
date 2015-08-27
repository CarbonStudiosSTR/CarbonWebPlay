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

    public void addAction(ActionWrapper actionWrapper){
        actions.add(actionWrapper);
    }

    public Set<ActionWrapper> getActions() {
        return actions;
    }
}
