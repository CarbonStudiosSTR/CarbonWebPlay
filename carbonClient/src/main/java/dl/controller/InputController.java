package dl.controller;


import dl.controller.controllers.OnKeyPressedController;
import dl.controller.controllers.OnKeyReleasedController;
import dl.controller.controllers.OnMousePressedController;
import dl.controller.controllers.OnMouseReleasedController;
import javafx.scene.layout.Pane;

public class InputController {
    public static void initInputController(Pane pane) {
        pane.setOnKeyPressed(new OnKeyPressedController());
        pane.setOnKeyReleased(new OnKeyReleasedController());
        pane.setOnMousePressed(new OnMousePressedController());
        pane.setOnMouseReleased(new OnMouseReleasedController());
    }
}
