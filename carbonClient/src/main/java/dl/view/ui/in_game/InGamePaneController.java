package dl.view.ui.in_game;

import dl.controller.InputController;
import dl.logic.gameLoop.GameLoop;
import dl.logic.gameLoop.GameRenderer;
import dl.logic.gameLoop.GameUpdater;
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

    private GameLoop gameLoop = new GameLoop(new GameUpdater(),new GameRenderer());

    @FXML
    private StackPane inGamePane;

    @Autowired
    private DLContext dlContext;

    @NotNull
    @Override
    public Node getNode() {
        inGamePane.setFocusTraversable(true);
        InputController.initInputController(inGamePane);
        gameLoop.start();
        return inGamePane;
    }

    @FXML
    public void onBackClicked() {
        inGamePane.setFocusTraversable(false);
        gameLoop.stop();
        dlContext.stateProperty().setValue(CHARACTER_MANAGEMENT);
    }
}
