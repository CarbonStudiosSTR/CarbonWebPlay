package dl.view.ui;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import static dl.view.ui.DLState.*;

@Component
public class DLContext {

    @NotNull
    private final ObjectProperty<DLState> state;

    public DLContext() {

        state = new SimpleObjectProperty<>(SIGN_IN);
    }

    @NotNull
    public ObjectProperty<DLState> stateProperty() {

        return state;
    }
}
