package dl.view.ui.sign_in;

import dl.view.ui.NodeController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class SignInPaneController implements NodeController {

   @FXML
   private StackPane signInPane;

   @NotNull
   @Override
   public Node getNode() {

      return signInPane;
   }
}
