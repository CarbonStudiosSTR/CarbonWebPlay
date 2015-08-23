package dl.view.ui.character_management;

import dl.view.ui.DLContext;
import dl.view.ui.NodeController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static dl.view.ui.DLState.IN_GAME;
import static dl.view.ui.DLState.SIGN_IN;

@Component
public class CharacterManagementPaneController implements NodeController {

   @FXML
   private StackPane characterManagementPane;

   @Autowired
   private DLContext dlContext;

   @NotNull
   @Override
   public Node getNode() {

      return characterManagementPane;
   }

   @FXML
   public void onBackButtonClicked() {

      dlContext.stateProperty().setValue(SIGN_IN);
   }

   @FXML
   public void onEnterWorldClicked() {

      dlContext.stateProperty().setValue(IN_GAME);
   }
}
