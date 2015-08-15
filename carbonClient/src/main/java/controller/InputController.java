package controller;


import controller.controllers.OnKeyPressedController;
import controller.controllers.OnKeyReleasedController;
import controller.controllers.OnMousePressedController;
import controller.controllers.OnMouseReleasedController;
import javafx.scene.image.ImageView;

public class InputController {
    public static void initInputController(ImageView imageView) {
        imageView.setOnKeyPressed(new OnKeyPressedController());
        imageView.setOnKeyReleased(new OnKeyReleasedController());
        imageView.setOnMousePressed(new OnMousePressedController());
        imageView.setOnMouseReleased(new OnMouseReleasedController());
    }
}
