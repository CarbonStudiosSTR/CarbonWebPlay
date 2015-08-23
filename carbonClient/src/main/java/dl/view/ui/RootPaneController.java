package dl.view.ui;

import dl.view.ui.character_select.CharacterSelectPaneController;
import dl.view.ui.sign_in.SignInPaneController;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static dl.view.ui.DLState.SIGN_IN;

@Component
public class RootPaneController {

   @Autowired
   private SignInPaneController signInPaneController;

   @Autowired
   private CharacterSelectPaneController characterSelectPaneController;

   @Autowired
   private Anim8Service anim8Service;

   @Autowired
   private DLContext dlContext;

   @PostConstruct
   private void init() {

      dlContext.stateProperty().addListener((observable, currentState, newState) -> {

         NodeController currentNodeController = stateController(currentState);
         NodeController newNodeController = stateController(newState);

         currentNodeController.getNode().setVisible(false);
         newNodeController.getNode().setVisible(true);

//         anim8Service.fadeChainSwap(currentNodeController.getNode(), newNodeController.getNode());
      });
   }

   @NotNull
   private NodeController stateController(@NotNull final DLState state) {

      return state == SIGN_IN ? signInPaneController : characterSelectPaneController;
   }
}
