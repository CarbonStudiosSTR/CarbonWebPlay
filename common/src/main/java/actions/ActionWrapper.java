package actions;

import util.ActionEnum;

import java.io.Serializable;

public class ActionWrapper<T> implements Serializable {
    private int id;
    private T action;
    private long timestamp;
    private ActionEnum actionType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getAction() {
        return action;
    }

    public void setAction(T action) {
        this.action = action;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ActionEnum getActionType() {
        return actionType;
    }

    public void setActionType(ActionEnum actionType) {
        this.actionType = actionType;
    }
}
