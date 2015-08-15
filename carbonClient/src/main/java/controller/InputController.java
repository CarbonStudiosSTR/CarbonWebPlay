package controller;


import controller.controllers.OnKeyPressedController;
import controller.controllers.onKeyReleasedController;
import controller.controllers.onMusePressedController;
import controller.controllers.OnMouseReleasedController;
import javafx.scene.image.ImageView;

public class InputController {
    public static void initInputController(ImageView imageView) {
        imageView.setOnKeyPressed(new OnKeyPressedController());
        imageView.setOnKeyReleased(new onKeyReleasedController());
        imageView.setOnMousePressed(new onMusePressedController());
        imageView.setOnMouseReleased(new OnMouseReleasedController());
    }
}
