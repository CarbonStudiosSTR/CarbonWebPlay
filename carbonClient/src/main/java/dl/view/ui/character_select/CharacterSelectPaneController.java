package dl.view.ui.character_select;

import dl.view.ui.DLContext;
import dl.view.ui.NodeController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static dl.view.ui.DLState.SIGN_IN;

@Component
public class CharacterSelectPaneController implements NodeController {

   @FXML
   private StackPane characterSelectPane;

   @Autowired
   private DLContext dlContext;

   @NotNull
   @Override
   public Node getNode() {

      return characterSelectPane;
   }

   @FXML
   public void onBackButtonClicked() {

      dlContext.stateProperty().setValue(SIGN_IN);
   }
}
