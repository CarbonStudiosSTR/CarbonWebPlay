package dl.view.ui.in_game;

import dl.view.ui.DLContext;
import dl.view.ui.NodeController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static dl.view.ui.DLState.CHARACTER_MANAGEMENT;

@Component
public class InGamePaneController implements NodeController {

    @FXML
    private StackPane inGamePane;

    @Autowired
    private DLContext dlContext;

    @NotNull
    @Override
    public Node getNode() {

        return inGamePane;
    }

    @FXML
    public void onBackClicked() {

        dlContext.stateProperty().setValue(CHARACTER_MANAGEMENT);
    }
}
