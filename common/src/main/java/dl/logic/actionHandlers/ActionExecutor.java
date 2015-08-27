package dl.logic.actionHandlers;

import actions.ActionWrapper;

public abstract class ActionExecutor<T> {
    public abstract void executeAction(ActionWrapper<T> actionWrapper);
}
