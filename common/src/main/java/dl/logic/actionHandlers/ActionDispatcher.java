package dl.logic.actionHandlers;

import actions.ActionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.ActionEnum;

@Component
public class ActionDispatcher {

    @Autowired
    MoveActionExecutor moveActionExecutor = new MoveActionExecutor();

    public ActionDispatcher() {
    }

    public void dispatchAction(ActionWrapper actionWrapper) {
        ActionEnum actionType = actionWrapper.getActionType();
        switch (actionType) {
            case Move: {
                moveActionExecutor.executeAction(actionWrapper);
                break;
            }
        }
    }

}
