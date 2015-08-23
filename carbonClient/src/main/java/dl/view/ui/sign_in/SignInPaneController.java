package dl.view.ui.sign_in;

import dl.view.ui.DLContext;
import dl.view.ui.DLState;
import dl.view.ui.NodeController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static dl.view.ui.DLState.*;

@Component
public class SignInPaneController implements NodeController {

   private static final Logger LOG = LoggerFactory.getLogger(SignInPaneController.class);

   @Autowired
   private DLContext dlContext;

   @FXML
   private StackPane signInPane;

   @NotNull
   @Override
   public Node getNode() {

      return signInPane;
   }

   @FXML
   public void onSignInButtonClicked() {

      dlContext.stateProperty().setValue(CHARACTER_MANAGEMENT);
   }

   @FXML
   public void onQuitButtonCLicked() {

      LOG.debug("quitButton clicked");
      System.exit(0);
   }
}
