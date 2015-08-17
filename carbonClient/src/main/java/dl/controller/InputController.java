package dl.controller;


import dl.controller.controllers.OnKeyPressedController;
import dl.controller.controllers.OnKeyReleasedController;
import dl.controller.controllers.OnMousePressedController;
import dl.controller.controllers.OnMouseReleasedController;
import javafx.scene.image.ImageView;

public class InputController {
    public static void initInputController(ImageView imageView) {
        imageView.setOnKeyPressed(new OnKeyPressedController());
        imageView.setOnKeyReleased(new OnKeyReleasedController());
        imageView.setOnMousePressed(new OnMousePressedController());
        imageView.setOnMouseReleased(new OnMouseReleasedController());
    }
}
