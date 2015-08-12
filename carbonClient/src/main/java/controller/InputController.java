package controller;


import controller.controllers.OnKeyPressedController;
import javafx.scene.image.ImageView;

public class InputController {

    public static void initInputController(ImageView imageView) {

        imageView.setOnKeyPressed(new OnKeyPressedController());


    }
}
